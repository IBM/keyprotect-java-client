/*
 * (C) Copyright IBM Corp. 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.ibm_key_protect_api.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Metadata of the port associated with an instance with an allowed IP policy.
 */
public class AllowedIPPortResource extends GenericModel {

  @SerializedName("private_endpoint_port")
  protected Long privateEndpointPort;

  /**
   * Gets the privateEndpointPort.
   *
   * The port required to access an instance with an allowed IP policy via the Key Protect private service endpoint.
   * Cannot be used with the Key Protect public service endpoint.
   *
   * Please visit
   * [Accessing an instance via private
   * endpoint](/docs/key-protect?topic=key-protect-manage-allowed-ip#access-allowed-ip-private-endpoint) for
   * instructions on how to use the `private_endpoint_port` value.
   *
   * @return the privateEndpointPort
   */
  public Long getPrivateEndpointPort() {
    return privateEndpointPort;
  }
}

