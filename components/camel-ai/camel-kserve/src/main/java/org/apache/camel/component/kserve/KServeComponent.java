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
package org.apache.camel.component.kserve;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.annotations.Component;
import org.apache.camel.support.HealthCheckComponent;

@Component("kserve")
public class KServeComponent extends HealthCheckComponent {

    @Metadata
    private KServeConfiguration configuration = new KServeConfiguration();

    public KServeComponent() {
        super();
    }

    public KServeComponent(CamelContext context) {
        super(context);
    }

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        KServeConfiguration configuration
                = this.configuration != null ? this.configuration.copy() : new KServeConfiguration();
        Endpoint endpoint = new KServeEndpoint(uri, this, remaining, configuration);
        setProperties(endpoint, parameters);
        return endpoint;
    }

    public KServeConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * The configuration.
     */
    public void setConfiguration(KServeConfiguration configuration) {
        this.configuration = configuration;
    }
}
