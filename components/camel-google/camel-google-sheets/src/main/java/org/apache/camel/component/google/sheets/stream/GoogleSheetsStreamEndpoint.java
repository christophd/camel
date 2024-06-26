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
package org.apache.camel.component.google.sheets.stream;

import com.google.api.services.sheets.v4.Sheets;
import org.apache.camel.Category;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.component.google.sheets.GoogleSheetsClientFactory;
import org.apache.camel.spi.EndpointServiceLocation;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ScheduledPollEndpoint;
import org.apache.camel.util.ObjectHelper;

/**
 * Poll for changes in Google Sheets.
 */
@UriEndpoint(firstVersion = "2.23.0",
             scheme = "google-sheets-stream",
             title = "Google Sheets Stream",
             syntax = "google-sheets-stream:spreadsheetId",
             consumerOnly = true,
             category = { Category.CLOUD, Category.DOCUMENT }, headersClass = GoogleSheetsStreamConstants.class)
public class GoogleSheetsStreamEndpoint extends ScheduledPollEndpoint implements EndpointServiceLocation {

    @UriParam
    private GoogleSheetsStreamConfiguration configuration;

    public GoogleSheetsStreamEndpoint(String uri, GoogleSheetsStreamComponent component,
                                      GoogleSheetsStreamConfiguration endpointConfiguration) {
        super(uri, component);
        this.configuration = endpointConfiguration;
    }

    @Override
    public Producer createProducer() throws Exception {
        throw new UnsupportedOperationException("The camel google sheets stream component doesn't support producer");
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        final GoogleSheetsStreamConsumer consumer = new GoogleSheetsStreamConsumer(this, processor);
        configureConsumer(consumer);
        return consumer;
    }

    public Sheets getClient() {
        return ((GoogleSheetsStreamComponent) getComponent()).getClient(configuration);
    }

    public GoogleSheetsClientFactory getClientFactory() {
        return ((GoogleSheetsStreamComponent) getComponent()).getClientFactory();
    }

    public void setClientFactory(GoogleSheetsClientFactory clientFactory) {
        ((GoogleSheetsStreamComponent) getComponent()).setClientFactory(clientFactory);
    }

    public GoogleSheetsStreamConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public String getServiceUrl() {
        if (ObjectHelper.isNotEmpty(ObjectHelper.isNotEmpty(configuration.getApplicationName())
                && ObjectHelper.isNotEmpty(configuration.getSpreadsheetId()))) {
            return getServiceProtocol() + ":" + configuration.getApplicationName() + ":" + configuration.getSpreadsheetId();
        }
        return null;
    }

    @Override
    public String getServiceProtocol() {
        return "sheets-stream";
    }

}
