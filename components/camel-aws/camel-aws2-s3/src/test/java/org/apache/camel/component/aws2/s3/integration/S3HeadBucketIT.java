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
package org.apache.camel.component.aws2.s3.integration;

import java.util.UUID;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.apache.camel.component.aws2.s3.AWS2S3Operations;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

public class S3HeadBucketIT extends Aws2S3Base {

    @EndpointInject
    private ProducerTemplate template;

    @EndpointInject("mock:exists")
    private MockEndpoint exists;

    @EndpointInject("mock:result")
    private MockEndpoint result;

    @Test
    public void sendInHeadBucket() throws Exception {
        exists.expectedMessageCount(0);
        result.expectedBodiesReceived("Hello World");
        result.expectedHeaderReceived(AWS2S3Constants.BUCKET_EXISTS, false);

        Exchange res = template.send("direct:headBucket", exchange -> {
            exchange.getIn().setBody("Hello World");
            exchange.getIn().setHeader(AWS2S3Constants.S3_OPERATION, AWS2S3Operations.headBucket);
            exchange.getIn().setHeader(AWS2S3Constants.OVERRIDE_BUCKET_NAME, "doesnotexist" + UUID.randomUUID().toString());
        });
        if (res.getException() != null) {
            throw res.getException();
        }

        MockEndpoint.assertIsSatisfied(context);
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                String awsEndpoint = "aws2-s3://test-ss3-s3?ignoreBody=true";

                from("direct:headBucket")
                    .to(awsEndpoint)
                    .filter(header(AWS2S3Constants.BUCKET_EXISTS))
                        .to("mock:exists")
                    .end()
                    .to("mock:result");
            }
        };
    }
}
