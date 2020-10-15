/*
 * (C) Copyright IBM Corp. 2020.
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
 * Properties that are associated with the policy type `allowedNetwork`.
 */
public class NetworkPolicyProperties extends GenericModel {

  protected Boolean enabled;
  protected NetworkPolicyAttribute attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private NetworkPolicyAttribute attributes;

    private Builder(NetworkPolicyProperties networkPolicyProperties) {
      this.enabled = networkPolicyProperties.enabled;
      this.attributes = networkPolicyProperties.attributes;
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
     * Builds a NetworkPolicyProperties.
     *
     * @return the new NetworkPolicyProperties instance
     */
    public NetworkPolicyProperties build() {
      return new NetworkPolicyProperties(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the NetworkPolicyProperties builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the attributes.
     *
     * @param attributes the attributes
     * @return the NetworkPolicyProperties builder
     */
    public Builder attributes(NetworkPolicyAttribute attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected NetworkPolicyProperties(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a NetworkPolicyProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect enables the specified policy for your service instance. If set to `false`, Key
   * Protect disables the specified policy for your service instance, and the policy will no longer  affect Key Protect
   * actions.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the attributes.
   *
   * Properties that are associated with the policy type `allowedNetwork`.
   *
   * @return the attributes
   */
  public NetworkPolicyAttribute attributes() {
    return attributes;
  }
}

