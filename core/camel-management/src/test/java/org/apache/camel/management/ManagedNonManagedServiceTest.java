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
package org.apache.camel.management;

import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.camel.NonManagedService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.LifecycleStrategy;
import org.apache.camel.support.service.ServiceSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisabledOnOs(OS.AIX)
public class ManagedNonManagedServiceTest extends ManagementTestSupport {

    private static final int SERVICES = 17;

    @Test
    public void testService() throws Exception {
        template.sendBody("direct:start", "Hello World");

        // must enable always as CamelContext has been started
        // and we add the service manually below
        context.getManagementStrategy().getManagementAgent().setRegisterAlways(true);

        MyService service = new MyService();
        for (LifecycleStrategy strategy : context.getLifecycleStrategies()) {
            strategy.onServiceAdd(context, service, null);
        }

        MBeanServer mbeanServer = getMBeanServer();

        Set<ObjectName> set = mbeanServer.queryNames(new ObjectName("*:type=services,*"), null);
        assertEquals(SERVICES + 1, set.size());
    }

    @Test
    public void testNonManagedService() throws Exception {
        // must enable always as CamelContext has been started
        // and we add the service manually below
        context.getManagementStrategy().getManagementAgent().setRegisterAlways(true);

        MyNonService service = new MyNonService();
        for (LifecycleStrategy strategy : context.getLifecycleStrategies()) {
            strategy.onServiceAdd(context, service, null);
        }

        MBeanServer mbeanServer = getMBeanServer();

        Set<ObjectName> set = mbeanServer.queryNames(new ObjectName("*:type=services,*"), null);
        assertEquals(SERVICES, set.size());
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start")
                        .to("mock:result");
            }
        };
    }

    private static final class MyService extends ServiceSupport {

    }

    private static final class MyNonService extends ServiceSupport implements NonManagedService {

    }

}
