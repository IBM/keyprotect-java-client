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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem extends GenericModel {

  /**
   * The type of policy to be set.
   */
  public interface PolicyType {
    /** allowedIP. */
    String ALLOWEDIP = "allowedIP";
  }

  @SerializedName("policy_type")
  protected String policyType;
  @SerializedName("policy_data")
  protected InstancePolicyAllowedIPPolicyData policyData;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyType;
    private InstancePolicyAllowedIPPolicyData policyData;

    private Builder(SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItem) {
      this.policyType = setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItem.policyType;
      this.policyData = setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItem.policyData;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyType the policyType
     * @param policyData the policyData
     */
    public Builder(String policyType, InstancePolicyAllowedIPPolicyData policyData) {
      this.policyType = policyType;
      this.policyData = policyData;
    }

    /**
     * Builds a SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem.
     *
     * @return the new SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem instance
     */
    public SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem build() {
      return new SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem(this);
    }

    /**
     * Set the policyType.
     *
     * @param policyType the policyType
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem builder
     */
    public Builder policyType(String policyType) {
      this.policyType = policyType;
      return this;
    }

    /**
     * Set the policyData.
     *
     * @param policyData the policyData
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem builder
     */
    public Builder policyData(InstancePolicyAllowedIPPolicyData policyData) {
      this.policyData = policyData;
      return this;
    }
  }

  protected SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.policyType,
      "policyType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.policyData,
      "policyData cannot be null");
    policyType = builder.policyType;
    policyData = builder.policyData;
  }

  /**
   * New builder.
   *
   * @return a SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyType.
   *
   * The type of policy to be set.
   *
   * @return the policyType
   */
  public String policyType() {
    return policyType;
  }

  /**
   * Gets the policyData.
   *
   * User defined metadata that is associated with the `allowedIP` instance policy type.
   *
   * @return the policyData
   */
  public InstancePolicyAllowedIPPolicyData policyData() {
    return policyData;
  }
}

