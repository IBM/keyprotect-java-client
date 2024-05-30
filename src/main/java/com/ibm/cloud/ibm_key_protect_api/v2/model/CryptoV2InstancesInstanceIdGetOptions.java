/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The cryptoV2InstancesInstanceIdGet options.
 */
public class CryptoV2InstancesInstanceIdGetOptions extends GenericModel {

  protected String instanceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;

    /**
     * Instantiates a new Builder from an existing CryptoV2InstancesInstanceIdGetOptions instance.
     *
     * @param cryptoV2InstancesInstanceIdGetOptions the instance to initialize the Builder with
     */
    private Builder(CryptoV2InstancesInstanceIdGetOptions cryptoV2InstancesInstanceIdGetOptions) {
      this.instanceId = cryptoV2InstancesInstanceIdGetOptions.instanceId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a CryptoV2InstancesInstanceIdGetOptions.
     *
     * @return the new CryptoV2InstancesInstanceIdGetOptions instance
     */
    public CryptoV2InstancesInstanceIdGetOptions build() {
      return new CryptoV2InstancesInstanceIdGetOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CryptoV2InstancesInstanceIdGetOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }
  }

  protected CryptoV2InstancesInstanceIdGetOptions() { }

  protected CryptoV2InstancesInstanceIdGetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
  }

  /**
   * New builder.
   *
   * @return a CryptoV2InstancesInstanceIdGetOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The v4 UUID that uniquely identifies the instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }
}

