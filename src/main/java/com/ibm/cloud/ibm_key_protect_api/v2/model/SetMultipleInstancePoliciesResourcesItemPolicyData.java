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
 * User defined metadata that is associated with any instance policy.
 */
public class SetMultipleInstancePoliciesResourcesItemPolicyData extends GenericModel {

  protected Boolean enabled;
  protected SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes attributes;

    private Builder(SetMultipleInstancePoliciesResourcesItemPolicyData setMultipleInstancePoliciesResourcesItemPolicyData) {
      this.enabled = setMultipleInstancePoliciesResourcesItemPolicyData.enabled;
      this.attributes = setMultipleInstancePoliciesResourcesItemPolicyData.attributes;
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
     * Builds a SetMultipleInstancePoliciesResourcesItemPolicyData.
     *
     * @return the new SetMultipleInstancePoliciesResourcesItemPolicyData instance
     */
    public SetMultipleInstancePoliciesResourcesItemPolicyData build() {
      return new SetMultipleInstancePoliciesResourcesItemPolicyData(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyData builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the attributes.
     *
     * @param attributes the attributes
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyData builder
     */
    public Builder attributes(SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected SetMultipleInstancePoliciesResourcesItemPolicyData(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a SetMultipleInstancePoliciesResourcesItemPolicyData builder
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
   * Attributes associated with any instance policy type. Must be provided if the `enabled` field is `true`. Cannot be
   * provided if the `enabled` field is `false`. Only attributes corresponding to the `policy_type` can be provided.
   *
   * @return the attributes
   */
  public SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes attributes() {
    return attributes;
  }
}

