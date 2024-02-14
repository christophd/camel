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
package org.apache.camel.kotlin.components

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import org.apache.camel.kotlin.CamelDslMarker
import org.apache.camel.kotlin.UriDsl

public fun UriDsl.`aws2-timestream`(i: Aws2TimestreamUriDsl.() -> Unit) {
  Aws2TimestreamUriDsl(this).apply(i)
}

@CamelDslMarker
public class Aws2TimestreamUriDsl(
  it: UriDsl,
) {
  private val it: UriDsl

  init {
    this.it = it
    this.it.component("aws2-timestream")
  }

  private var clientType: String = ""

  private var label: String = ""

  public fun clientType(clientType: String) {
    this.clientType = clientType
    it.url("$clientType:$label")
  }

  public fun label(label: String) {
    this.label = label
    it.url("$clientType:$label")
  }

  public fun operation(operation: String) {
    it.property("operation", operation)
  }

  public fun overrideEndpoint(overrideEndpoint: String) {
    it.property("overrideEndpoint", overrideEndpoint)
  }

  public fun overrideEndpoint(overrideEndpoint: Boolean) {
    it.property("overrideEndpoint", overrideEndpoint.toString())
  }

  public fun pojoRequest(pojoRequest: String) {
    it.property("pojoRequest", pojoRequest)
  }

  public fun pojoRequest(pojoRequest: Boolean) {
    it.property("pojoRequest", pojoRequest.toString())
  }

  public fun profileCredentialsName(profileCredentialsName: String) {
    it.property("profileCredentialsName", profileCredentialsName)
  }

  public fun region(region: String) {
    it.property("region", region)
  }

  public fun trustAllCertificates(trustAllCertificates: String) {
    it.property("trustAllCertificates", trustAllCertificates)
  }

  public fun trustAllCertificates(trustAllCertificates: Boolean) {
    it.property("trustAllCertificates", trustAllCertificates.toString())
  }

  public fun uriEndpointOverride(uriEndpointOverride: String) {
    it.property("uriEndpointOverride", uriEndpointOverride)
  }

  public fun useDefaultCredentialsProvider(useDefaultCredentialsProvider: String) {
    it.property("useDefaultCredentialsProvider", useDefaultCredentialsProvider)
  }

  public fun useDefaultCredentialsProvider(useDefaultCredentialsProvider: Boolean) {
    it.property("useDefaultCredentialsProvider", useDefaultCredentialsProvider.toString())
  }

  public fun useProfileCredentialsProvider(useProfileCredentialsProvider: String) {
    it.property("useProfileCredentialsProvider", useProfileCredentialsProvider)
  }

  public fun useProfileCredentialsProvider(useProfileCredentialsProvider: Boolean) {
    it.property("useProfileCredentialsProvider", useProfileCredentialsProvider.toString())
  }

  public fun lazyStartProducer(lazyStartProducer: String) {
    it.property("lazyStartProducer", lazyStartProducer)
  }

  public fun lazyStartProducer(lazyStartProducer: Boolean) {
    it.property("lazyStartProducer", lazyStartProducer.toString())
  }

  public fun awsTimestreamQueryClient(awsTimestreamQueryClient: String) {
    it.property("awsTimestreamQueryClient", awsTimestreamQueryClient)
  }

  public fun awsTimestreamWriteClient(awsTimestreamWriteClient: String) {
    it.property("awsTimestreamWriteClient", awsTimestreamWriteClient)
  }

  public fun proxyHost(proxyHost: String) {
    it.property("proxyHost", proxyHost)
  }

  public fun proxyPort(proxyPort: String) {
    it.property("proxyPort", proxyPort)
  }

  public fun proxyPort(proxyPort: Int) {
    it.property("proxyPort", proxyPort.toString())
  }

  public fun proxyProtocol(proxyProtocol: String) {
    it.property("proxyProtocol", proxyProtocol)
  }

  public fun accessKey(accessKey: String) {
    it.property("accessKey", accessKey)
  }

  public fun secretKey(secretKey: String) {
    it.property("secretKey", secretKey)
  }
}