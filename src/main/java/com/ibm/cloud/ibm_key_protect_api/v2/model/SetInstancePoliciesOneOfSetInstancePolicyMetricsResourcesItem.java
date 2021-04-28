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
 * SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem extends GenericModel {

  /**
   * The type of policy to be set.
   */
  public interface PolicyType {
    /** metrics. */
    String METRICS = "metrics";
  }

  @SerializedName("policy_type")
  protected String policyType;
  @SerializedName("policy_data")
  protected MetricsProperties policyData;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyType;
    private MetricsProperties policyData;

    private Builder(SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem) {
      this.policyType = setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem.policyType;
      this.policyData = setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem.policyData;
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
    public Builder(String policyType, MetricsProperties policyData) {
      this.policyType = policyType;
      this.policyData = policyData;
    }

    /**
     * Builds a SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem.
     *
     * @return the new SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem instance
     */
    public SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem build() {
      return new SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem(this);
    }

    /**
     * Set the policyType.
     *
     * @param policyType the policyType
     * @return the SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem builder
     */
    public Builder policyType(String policyType) {
      this.policyType = policyType;
      return this;
    }

    /**
     * Set the policyData.
     *
     * @param policyData the policyData
     * @return the SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem builder
     */
    public Builder policyData(MetricsProperties policyData) {
      this.policyData = policyData;
      return this;
    }
  }

  protected SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem(Builder builder) {
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
   * @return a SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem builder
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
   * User defined metadata that is associated with the `metrics` instance policy type.
   *
   * @return the policyData
   */
  public MetricsProperties policyData() {
    return policyData;
  }
}

