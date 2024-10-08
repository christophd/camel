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
package org.apache.camel.component.torchserve.client.model;

import org.apache.camel.component.torchserve.client.management.model.ListModels200ResponseModelsInner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Model {

    private static final Logger LOG = LoggerFactory.getLogger(Model.class);

    protected String modelName = null;
    protected String modelUrl = null;

    public Model() {
    }

    public static Model from(ListModels200ResponseModelsInner src) {
        Model model = new Model();
        model.setModelName(src.getModelName());
        model.setModelUrl(src.getModelUrl());
        return model;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
               " modelName: " + modelName + "," +
               " modelUrl: " + modelUrl + " " +
               "}";
    }
}
