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
 * User defined metadata that is associated with the `allowedNetwork` instance policy type.
 */
public class InstancePolicyAllowedNetworkPolicyData extends GenericModel {

  protected Boolean enabled;
  protected InstancePolicyAllowedNetworkPolicyDataAttributes attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private InstancePolicyAllowedNetworkPolicyDataAttributes attributes;

    /**
     * Instantiates a new Builder from an existing InstancePolicyAllowedNetworkPolicyData instance.
     *
     * @param instancePolicyAllowedNetworkPolicyData the instance to initialize the Builder with
     */
    private Builder(InstancePolicyAllowedNetworkPolicyData instancePolicyAllowedNetworkPolicyData) {
      this.enabled = instancePolicyAllowedNetworkPolicyData.enabled;
      this.attributes = instancePolicyAllowedNetworkPolicyData.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enabled the enabled
     */
    public Builder(Boolean enabled) {
      this.enabled = enabled;
    }

    /**
     * Builds a InstancePolicyAllowedNetworkPolicyData.
     *
     * @return the new InstancePolicyAllowedNetworkPolicyData instance
     */
    public InstancePolicyAllowedNetworkPolicyData build() {
      return new InstancePolicyAllowedNetworkPolicyData(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the InstancePolicyAllowedNetworkPolicyData builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the attributes.
     *
     * @param attributes the attributes
     * @return the InstancePolicyAllowedNetworkPolicyData builder
     */
    public Builder attributes(InstancePolicyAllowedNetworkPolicyDataAttributes attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected InstancePolicyAllowedNetworkPolicyData() { }

  protected InstancePolicyAllowedNetworkPolicyData(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a InstancePolicyAllowedNetworkPolicyData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect enables the specified policy for your service instance. If set to `false`, Key
   * Protect disables the specified policy for your service instance, and the policy will no longer affect Key Protect
   * actions.
   * **Note:** If a policy with attributes is disabled, all attributes are reset and are not retained.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the attributes.
   *
   * Attributes of an `allowedNetwork` instance policy. Must be provided if the `enabled` field is `true`. Cannot be
   * provided if the `enabled` field is `false`.
   *
   * @return the attributes
   */
  public InstancePolicyAllowedNetworkPolicyDataAttributes attributes() {
    return attributes;
  }
}

