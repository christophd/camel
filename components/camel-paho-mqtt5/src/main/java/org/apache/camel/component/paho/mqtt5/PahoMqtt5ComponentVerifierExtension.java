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
package org.apache.camel.component.paho.mqtt5;

import java.util.Map;

import org.apache.camel.component.extension.verifier.DefaultComponentVerifierExtension;
import org.apache.camel.component.extension.verifier.ResultBuilder;
import org.apache.camel.component.extension.verifier.ResultErrorBuilder;
import org.apache.camel.component.extension.verifier.ResultErrorHelper;
import org.apache.camel.util.ObjectHelper;
import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.eclipse.paho.mqttv5.common.MqttException;

public class PahoMqtt5ComponentVerifierExtension extends DefaultComponentVerifierExtension {

    public PahoMqtt5ComponentVerifierExtension() {
        this("paho-mqtt5");
    }

    public PahoMqtt5ComponentVerifierExtension(String scheme) {
        super(scheme);
    }

    // *********************************
    // Parameters validation
    // *********************************

    @Override
    protected Result verifyParameters(Map<String, Object> parameters) {
        return ResultBuilder.withStatusAndScope(Result.Status.OK, Scope.PARAMETERS)
                .error(ResultErrorHelper.requiresOption(parameters, "brokerUrl"))
                .build();
    }

    // *********************************
    // Connectivity validation
    // *********************************

    @Override
    protected Result verifyConnectivity(Map<String, Object> parameters) {
        return ResultBuilder.withStatusAndScope(Result.Status.OK, Scope.CONNECTIVITY)
                .error(parameters, this::verifyCredentials)
                .build();
    }

    private void verifyCredentials(ResultBuilder builder, Map<String, Object> parameters) {
        String brokerUrl = (String) parameters.get("brokerUrl");
        String username = (String) parameters.get("userName");
        String password = (String) parameters.get("password");

        if (ObjectHelper.isNotEmpty(brokerUrl)) {
            try {
                // Create MQTT client
                if (ObjectHelper.isEmpty(username) && ObjectHelper.isEmpty(password)) {
                    MqttClient client = new MqttClient(brokerUrl, PahoMqtt5Endpoint.generateClientId());
                    client.connect();
                    client.disconnect();
                } else {
                    MqttClient client = new MqttClient(brokerUrl, PahoMqtt5Endpoint.generateClientId());
                    MqttConnectionOptions connOpts = new MqttConnectionOptions();
                    connOpts.setUserName(username);
                    connOpts.setPassword(password.getBytes());
                    client.connect(connOpts);
                    client.disconnect();
                }
            } catch (MqttException e) {
                builder.error(
                        ResultErrorBuilder
                                .withCodeAndDescription(VerificationError.StandardCode.ILLEGAL_PARAMETER_VALUE,
                                        "Unable to connect to MQTT broker")
                                .parameterKey("brokerUrl")
                                .build());
            }
        } else {
            builder.error(
                    ResultErrorBuilder
                            .withCodeAndDescription(VerificationError.StandardCode.ILLEGAL_PARAMETER_VALUE,
                                    "Invalid blank MQTT brokerUrl ")
                            .parameterKey("brokerUrl")
                            .build());
        }
    }
}
