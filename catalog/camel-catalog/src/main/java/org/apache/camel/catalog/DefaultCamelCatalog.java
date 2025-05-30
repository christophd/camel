/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.catalog;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Stream;

import org.apache.camel.catalog.impl.AbstractCachingCamelCatalog;
import org.apache.camel.catalog.impl.CatalogHelper;
import org.apache.camel.tooling.model.ArtifactModel;
import org.apache.camel.tooling.model.BaseModel;
import org.apache.camel.tooling.model.ComponentModel;
import org.apache.camel.tooling.model.DataFormatModel;
import org.apache.camel.tooling.model.DevConsoleModel;
import org.apache.camel.tooling.model.EipModel;
import org.apache.camel.tooling.model.JsonMapper;
import org.apache.camel.tooling.model.LanguageModel;
import org.apache.camel.tooling.model.MainModel;
import org.apache.camel.tooling.model.OtherModel;
import org.apache.camel.tooling.model.PojoBeanModel;
import org.apache.camel.tooling.model.ReleaseModel;
import org.apache.camel.tooling.model.TransformerModel;
import org.apache.camel.util.json.JsonArray;
import org.apache.camel.util.json.JsonObject;
import org.apache.camel.util.json.Jsoner;

/**
 * Default {@link CamelCatalog}.
 */
public class DefaultCamelCatalog extends AbstractCachingCamelCatalog implements CamelCatalog {

    private static final String MODELS_CATALOG = "org/apache/camel/catalog/models.properties";
    private static final String SCHEMAS_XML = "org/apache/camel/catalog/schemas";
    private static final String MAIN_DIR = "org/apache/camel/catalog/main";
    private static final String BASE_RESOURCE_DIR = "org/apache/camel/catalog";

    public static final String FIND_COMPONENT_NAMES = "findComponentNames";
    public static final String FIND_COMPONENT_LABELS = "findComponentLabels";
    public static final String LIST_COMPONENTS_AS_JSON = "listComponentsAsJson";

    public static final String FIND_DATA_FORMAT_NAMES = "findDataFormatNames";
    public static final String FIND_DATA_FORMAT_LABELS = "findDataFormatLabels";
    public static final String LIST_DATA_FORMATS_AS_JSON = "listDataFormatsAsJson";

    public static final String FIND_LANGUAGE_NAMES = "findLanguageNames";
    public static final String FIND_LANGUAGE_LABELS = "findLanguageLabels";
    public static final String LIST_LANGUAGES_AS_JSON = "listLanguagesAsJson";

    public static final String FIND_TRANSFORMER_NAMES = "findTransformerNames";
    public static final String LIST_TRANSFORMERS_AS_JSON = "listTransformersAsJson";

    public static final String FIND_CONSOLE_NAMES = "findConsoleNames";
    public static final String LIST_CONSOLES_AS_JSON = "listConsolesAsJson";

    public static final String FIND_MODEL_NAMES = "findModelNames";
    public static final String FIND_MODEL_LABELS = "findModelLabels";
    public static final String LIST_MODELS_AS_JSON = "listModelsAsJson";

    public static final String FIND_OTHER_NAMES = "findOtherNames";
    public static final String FIND_OTHER_LABELS = "findOtherLabels";
    public static final String LIST_OTHERS_AS_JSON = "listOthersAsJson";

    public static final String FIND_BEAN_NAMES = "findBeanNames";
    public static final String LIST_BEANS_AS_JSON = "listBeansAsJson";

    public static final String SUMMARY_AS_JSON = "summaryAsJson";

    private final VersionHelper version = new VersionHelper();

    // 3rd party components/data-formats
    private final Map<String, String> extraComponents = new HashMap<>();
    private final Map<String, String> extraComponentsJSonSchema = new HashMap<>();
    private final Map<String, String> extraDataFormats = new HashMap<>();
    private final Map<String, String> extraDataFormatsJSonSchema = new HashMap<>();

    private VersionManager versionManager = new DefaultVersionManager(this);
    private RuntimeProvider runtimeProvider = new DefaultRuntimeProvider(this);

    /**
     * Creates the {@link CamelCatalog} without caching enabled.
     */
    public DefaultCamelCatalog() {
        this(false);
    }

    /**
     * Creates the {@link CamelCatalog}
     *
     * @param caching whether to use cache
     */
    public DefaultCamelCatalog(boolean caching) {
        super(caching);

        setJSonSchemaResolver(new CamelCatalogJSonSchemaResolver(
                this, extraComponents, extraComponentsJSonSchema, extraDataFormats, extraDataFormatsJSonSchema));
    }

    @Override
    public RuntimeProvider getRuntimeProvider() {
        return runtimeProvider;
    }

    @Override
    public void setRuntimeProvider(RuntimeProvider runtimeProvider) {
        this.runtimeProvider = runtimeProvider;
        // inject CamelCatalog to the provider
        this.runtimeProvider.setCamelCatalog(this);

        // invalidate the cache
        super.clearCache();
    }

    @Override
    public void enableCache() {
        super.setCaching(true);
    }

    @Override
    public boolean isCaching() {
        return super.isCaching();
    }

    @Override
    public void setVersionManager(VersionManager versionManager) {
        this.versionManager = versionManager;
    }

    @Override
    public VersionManager getVersionManager() {
        return versionManager;
    }

    @Override
    public void addComponent(String name, String className) {
        extraComponents.put(name, className);
        // invalidate the cache
        getCache().remove(FIND_COMPONENT_NAMES);
        getCache().remove(FIND_COMPONENT_LABELS);
        getCache().remove(LIST_COMPONENTS_AS_JSON);

        getCache().remove(SUMMARY_AS_JSON);
    }

    @Override
    public void addComponent(String name, String className, String jsonSchema) {
        addComponent(name, className);
        if (jsonSchema != null) {
            extraComponentsJSonSchema.put(name, jsonSchema);
        }
    }

    @Override
    public void addDataFormat(String name, String className) {
        extraDataFormats.put(name, className);
        // invalidate the cache
        getCache().remove(FIND_DATA_FORMAT_NAMES);
        getCache().remove(FIND_DATA_FORMAT_LABELS);
        getCache().remove(LIST_DATA_FORMATS_AS_JSON);

        getCache().remove(SUMMARY_AS_JSON);
    }

    @Override
    public void addDataFormat(String name, String className, String jsonSchema) {
        addDataFormat(name, className);
        if (jsonSchema != null) {
            extraDataFormatsJSonSchema.put(name, jsonSchema);
        }
    }

    @Override
    public String getCatalogVersion() {
        return version.getVersion();
    }

    @Override
    public boolean loadVersion(String version) {
        if (version.equals(versionManager.getLoadedVersion())) {
            return true;
        } else if (versionManager.loadVersion(version)) {
            // invalidate existing cache if we loaded a new version
            super.clearCache();
            return true;
        }
        return false;
    }

    @Override
    public String getLoadedVersion() {
        return versionManager.getLoadedVersion();
    }

    @Override
    public String getRuntimeProviderLoadedVersion() {
        return versionManager.getRuntimeProviderLoadedVersion();
    }

    @Override
    public boolean loadRuntimeProviderVersion(String groupId, String artifactId, String version) {
        return versionManager.loadRuntimeProviderVersion(groupId, artifactId, version);
    }

    @Override
    public List<String> findComponentNames() {
        return cache(FIND_COMPONENT_NAMES, () -> Stream.of(runtimeProvider.findComponentNames(), extraComponents.keySet())
                .flatMap(Collection::stream)
                .sorted()
                .toList());
    }

    @Override
    public List<String> findDataFormatNames() {
        return cache(FIND_DATA_FORMAT_NAMES, () -> Stream.of(runtimeProvider.findDataFormatNames(), extraDataFormats.keySet())
                .flatMap(Collection::stream)
                .sorted()
                .toList());
    }

    @Override
    public List<String> findLanguageNames() {
        return cache(FIND_LANGUAGE_NAMES, runtimeProvider::findLanguageNames);
    }

    @Override
    public List<String> findTransformerNames() {
        return cache(FIND_TRANSFORMER_NAMES, runtimeProvider::findTransformerNames);
    }

    @Override
    public List<String> findDevConsoleNames() {
        return cache(FIND_CONSOLE_NAMES, runtimeProvider::findDevConsoleNames);
    }

    @Override
    public List<String> findModelNames() {
        return cache(FIND_MODEL_NAMES, () -> {
            try (InputStream is = versionManager.getResourceAsStream(MODELS_CATALOG)) {
                return CatalogHelper.loadLines(is);
            } catch (IOException e) {
                return Collections.emptyList();
            }
        });
    }

    @Override
    public List<String> findOtherNames() {
        return cache(FIND_OTHER_NAMES, runtimeProvider::findOtherNames);
    }

    @Override
    public List<String> findBeansNames() {
        return cache(FIND_BEAN_NAMES, runtimeProvider::findBeansNames);
    }

    @Override
    public List<String> findModelNames(String filter) {
        // should not cache when filter parameter can by any kind of value
        return findNames(filter, this::findModelNames, this::eipModel);
    }

    @Override
    public List<String> findComponentNames(String filter) {
        // should not cache when filter parameter can by any kind of value
        return findNames(filter, this::findComponentNames, this::componentModel);
    }

    @Override
    public List<String> findDataFormatNames(String filter) {
        // should not cache when filter parameter can by any kind of value
        return findNames(filter, this::findDataFormatNames, this::dataFormatModel);
    }

    @Override
    public List<String> findLanguageNames(String filter) {
        // should not cache when filter parameter can by any kind of value
        return findNames(filter, this::findLanguageNames, this::languageModel);
    }

    @Override
    public List<String> findOtherNames(String filter) {
        // should not cache when filter parameter can by any kind of value
        return findNames(filter, this::findOtherNames, this::otherModel);
    }

    private List<String> findNames(
            String filter, Supplier<List<String>> findNames, Function<String, ? extends BaseModel<?>> modelLoader) {
        List<String> answer = new ArrayList<>();
        List<String> names = findNames.get();
        for (String name : names) {
            BaseModel<?> model = modelLoader.apply(name);
            if (model != null) {
                String label = model.getLabel();
                String[] parts = label.split(",");
                for (String part : parts) {
                    try {
                        if (part.equalsIgnoreCase(filter) || CatalogHelper.matchWildcard(part, filter)
                                || part.matches(filter)) {
                            answer.add(name);
                        }
                    } catch (PatternSyntaxException e) {
                        // ignore as filter is maybe not a pattern
                    }
                }
            }
        }
        return answer;
    }

    @Override
    public String modelJSonSchema(String name) {
        return cache("eip-" + name, name, super::modelJSonSchema);
    }

    @Override
    public EipModel eipModel(String name) {
        return cache("eip-model-" + name, name, super::eipModel);
    }

    @Override
    public PojoBeanModel pojoBeanModel(String name) {
        return cache("pojo-bean-model-" + name, name, super::pojoBeanModel);
    }

    @Override
    public String componentJSonSchema(String name) {
        return cache("component-" + name, name, super::componentJSonSchema);
    }

    @Override
    public ComponentModel componentModel(String name) {
        return cache("component-model-" + name, name, super::componentModel);
    }

    @Override
    public String dataFormatJSonSchema(String name) {
        return cache("dataformat-" + name, name, super::dataFormatJSonSchema);
    }

    @Override
    public DataFormatModel dataFormatModel(String name) {
        return cache("dataformat-model-" + name, name, super::dataFormatModel);
    }

    @Override
    public String languageJSonSchema(String name) {
        return cache("language-" + name, name, super::languageJSonSchema);
    }

    @Override
    public String transformerJSonSchema(String name) {
        return cache("transformer-" + name, name, super::transformerJSonSchema);
    }

    @Override
    public String devConsoleJSonSchema(String name) {
        return cache("dev-console-" + name, name, super::devConsoleJSonSchema);
    }

    @Override
    public LanguageModel languageModel(String name) {
        return cache("language-model-" + name, name, super::languageModel);
    }

    @Override
    public TransformerModel transformerModel(String name) {
        return cache("transformer-model-" + name, name, super::transformerModel);
    }

    @Override
    public DevConsoleModel devConsoleModel(String name) {
        return cache("dev-console-model-" + name, name, super::devConsoleModel);
    }

    @Override
    public String otherJSonSchema(String name) {
        return cache("other-" + name, name, super::otherJSonSchema);
    }

    @Override
    public OtherModel otherModel(String name) {
        return cache("other-model-" + name, name, super::otherModel);
    }

    @Override
    public String mainJSonSchema() {
        return cache("main", "main", k -> super.mainJSonSchema());
    }

    @Override
    public MainModel mainModel() {
        return cache("main-model", "main-model", k -> super.mainModel());
    }

    @Override
    public Set<String> findModelLabels() {
        return cache(FIND_MODEL_LABELS, () -> findLabels(this::findModelNames, this::eipModel));
    }

    @Override
    public Set<String> findComponentLabels() {
        return cache(FIND_COMPONENT_LABELS, () -> findLabels(this::findComponentNames, this::componentModel));
    }

    @Override
    public Set<String> findDataFormatLabels() {
        return cache(FIND_DATA_FORMAT_LABELS, () -> findLabels(this::findDataFormatNames, this::dataFormatModel));
    }

    @Override
    public Set<String> findLanguageLabels() {
        return cache(FIND_LANGUAGE_LABELS, () -> findLabels(this::findLanguageNames, this::languageModel));
    }

    @Override
    public Set<String> findOtherLabels() {
        return cache(FIND_OTHER_LABELS, () -> findLabels(this::findOtherNames, this::otherModel));
    }

    private SortedSet<String> findLabels(Supplier<List<String>> findNames, Function<String, ? extends BaseModel<?>> loadModel) {
        TreeSet<String> answer = new TreeSet<>();
        List<String> names = findNames.get();
        for (String name : names) {
            BaseModel<?> model = loadModel.apply(name);
            if (model != null) {
                String label = model.getLabel();
                String[] parts = label.split(",");
                Collections.addAll(answer, parts);
            }
        }
        return answer;
    }

    @Override
    public String springSchemaAsXml() {
        return cache(SCHEMAS_XML + "/camel-spring.xsd", this::loadResource);
    }

    @Override
    public String xmlIoSchemaAsXml() {
        return cache(SCHEMAS_XML + "/camel-xml-io.xsd", this::loadResource);
    }

    @Override
    public String mainJsonSchema() {
        return cache(MAIN_DIR + "/camel-main-configuration-metadata.json", this::loadResource);
    }

    @Override
    public String listComponentsAsJson() {
        return cache(LIST_COMPONENTS_AS_JSON, () -> JsonMapper.serialize(findComponentNames().stream()
                .map(this::componentJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("component"))
                .toList()));
    }

    @Override
    public String listDataFormatsAsJson() {
        return cache(LIST_DATA_FORMATS_AS_JSON, () -> JsonMapper.serialize(findDataFormatNames().stream()
                .map(this::dataFormatJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("dataformat"))
                .toList()));
    }

    @Override
    public String listLanguagesAsJson() {
        return cache(LIST_LANGUAGES_AS_JSON, () -> JsonMapper.serialize(findLanguageNames().stream()
                .map(this::languageJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("language"))
                .toList()));
    }

    @Override
    public String listTransformersAsJson() {
        return cache(LIST_TRANSFORMERS_AS_JSON, () -> JsonMapper.serialize(findTransformerNames().stream()
                .map(this::transformerJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("transformer"))
                .toList()));
    }

    @Override
    public String listDevConsolesAsJson() {
        return cache(LIST_CONSOLES_AS_JSON, () -> JsonMapper.serialize(findDevConsoleNames().stream()
                .map(this::devConsoleJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("console"))
                .toList()));
    }

    @Override
    public String listModelsAsJson() {
        return cache(LIST_MODELS_AS_JSON, () -> JsonMapper.serialize(findModelNames().stream()
                .map(this::modelJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("model"))
                .toList()));
    }

    @Override
    public String listOthersAsJson() {
        return cache(LIST_OTHERS_AS_JSON, () -> JsonMapper.serialize(findOtherNames().stream()
                .map(this::otherJSonSchema)
                .map(JsonMapper::deserialize)
                .map(o -> o.get("other"))
                .toList()));
    }

    @Override
    public String summaryAsJson() {
        return cache(SUMMARY_AS_JSON, () -> {
            Map<String, Object> obj = new JsonObject();
            obj.put("version", getLoadedVersion());
            obj.put("models", findModelNames().size());
            obj.put("components", findComponentNames().size());
            obj.put("dataformats", findDataFormatNames().size());
            obj.put("languages", findLanguageNames().size());
            obj.put("others", findOtherNames().size());
            obj.put("beans", findBeansNames().size());
            obj.put("dev-consoles", findDevConsoleNames().size());
            obj.put("transformers", findTransformerNames().size());
            return JsonMapper.serialize(obj);
        });
    }

    @Override
    public ArtifactModel<?> modelFromMavenGAV(String groupId, String artifactId, String version) {
        try {
            for (String name : findComponentNames()) {
                ArtifactModel<?> am = componentModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        try {
            for (String name : findDataFormatNames()) {
                ArtifactModel<?> am = dataFormatModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        try {
            for (String name : findLanguageNames()) {
                ArtifactModel<?> am = languageModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        try {
            for (String name : findOtherNames()) {
                ArtifactModel<?> am = otherModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        try {
            for (String name : findTransformerNames()) {
                ArtifactModel<?> am = transformerModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        try {
            for (String name : findDevConsoleNames()) {
                ArtifactModel<?> am = devConsoleModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        try {
            for (String name : findBeansNames()) {
                ArtifactModel<?> am = pojoBeanModel(name);
                if (matchArtifact(am, groupId, artifactId, version)) {
                    return am;
                }
            }
        } catch (Throwable e) {
            // ignore as catalog can be dynamic changed and older releases may not have newer apis
        }
        return null;
    }

    @Override
    public InputStream loadResource(String kind, String name) {
        return versionManager.getResourceAsStream(BASE_RESOURCE_DIR + "/" + kind + "/" + name);
    }

    @Override
    public List<ReleaseModel> camelReleases() {
        return camelReleases("camel-releases.json");
    }

    @Override
    public List<ReleaseModel> camelQuarkusReleases() {
        return camelReleases("camel-quarkus-releases.json");
    }

    private List<ReleaseModel> camelReleases(String file) {
        return cache(file, () -> {
            try {
                List<ReleaseModel> answer = new ArrayList<>();
                InputStream is = loadResource("releases", file);
                String json = CatalogHelper.loadText(is);
                JsonArray arr = (JsonArray) Jsoner.deserialize(json);
                for (Object o : arr) {
                    JsonObject jo = (JsonObject) o;
                    answer.add(JsonMapper.generateReleaseModel(jo));
                }
                return answer;
            } catch (Exception e) {
                return Collections.emptyList();
            }
        });
    }

    private static boolean matchArtifact(ArtifactModel<?> am, String groupId, String artifactId, String version) {
        if (am == null) {
            return false;
        }
        return groupId.equals(am.getGroupId()) && artifactId.equals(am.getArtifactId())
                && (version == null || version.isBlank() || version.equals(am.getVersion()));
    }

    private String loadResource(String file) {
        try (InputStream is = versionManager.getResourceAsStream(file)) {
            return is != null ? CatalogHelper.loadText(is) : null;
        } catch (IOException e) {
            return null;
        }
    }

}
