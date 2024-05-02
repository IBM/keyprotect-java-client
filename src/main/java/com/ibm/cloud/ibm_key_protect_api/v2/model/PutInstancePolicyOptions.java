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
 * The putInstancePolicy options.
 */
public class PutInstancePolicyOptions extends GenericModel {

  /**
   * The type of policy that is associated with the specified instance.
   */
  public interface Policy {
    /** allowedNetwork. */
    String ALLOWEDNETWORK = "allowedNetwork";
    /** dualAuthDelete. */
    String DUALAUTHDELETE = "dualAuthDelete";
    /** allowedIP. */
    String ALLOWEDIP = "allowedIP";
    /** keyCreateImportAccess. */
    String KEYCREATEIMPORTACCESS = "keyCreateImportAccess";
    /** metrics. */
    String METRICS = "metrics";
    /** rotation. */
    String ROTATION = "rotation";
  }

  protected String bluemixInstance;
  protected SetInstancePoliciesOneOf setInstancePoliciesOneOf;
  protected String correlationId;
  protected String policy;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private SetInstancePoliciesOneOf setInstancePoliciesOneOf;
    private String correlationId;
    private String policy;

    /**
     * Instantiates a new Builder from an existing PutInstancePolicyOptions instance.
     *
     * @param putInstancePolicyOptions the instance to initialize the Builder with
     */
    private Builder(PutInstancePolicyOptions putInstancePolicyOptions) {
      this.bluemixInstance = putInstancePolicyOptions.bluemixInstance;
      this.setInstancePoliciesOneOf = putInstancePolicyOptions.setInstancePoliciesOneOf;
      this.correlationId = putInstancePolicyOptions.correlationId;
      this.policy = putInstancePolicyOptions.policy;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param bluemixInstance the bluemixInstance
     * @param setInstancePoliciesOneOf the setInstancePoliciesOneOf
     */
    public Builder(String bluemixInstance, SetInstancePoliciesOneOf setInstancePoliciesOneOf) {
      this.bluemixInstance = bluemixInstance;
      this.setInstancePoliciesOneOf = setInstancePoliciesOneOf;
    }

    /**
     * Builds a PutInstancePolicyOptions.
     *
     * @return the new PutInstancePolicyOptions instance
     */
    public PutInstancePolicyOptions build() {
      return new PutInstancePolicyOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the PutInstancePolicyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the setInstancePoliciesOneOf.
     *
     * @param setInstancePoliciesOneOf the setInstancePoliciesOneOf
     * @return the PutInstancePolicyOptions builder
     */
    public Builder setInstancePoliciesOneOf(SetInstancePoliciesOneOf setInstancePoliciesOneOf) {
      this.setInstancePoliciesOneOf = setInstancePoliciesOneOf;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the PutInstancePolicyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the policy.
     *
     * @param policy the policy
     * @return the PutInstancePolicyOptions builder
     */
    public Builder policy(String policy) {
      this.policy = policy;
      return this;
    }
  }

  protected PutInstancePolicyOptions() { }

  protected PutInstancePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.setInstancePoliciesOneOf,
      "setInstancePoliciesOneOf cannot be null");
    bluemixInstance = builder.bluemixInstance;
    setInstancePoliciesOneOf = builder.setInstancePoliciesOneOf;
    correlationId = builder.correlationId;
    policy = builder.policy;
  }

  /**
   * New builder.
   *
   * @return a PutInstancePolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bluemixInstance.
   *
   * The IBM Cloud instance ID that identifies your Key Protect service instance.
   *
   * @return the bluemixInstance
   */
  public String bluemixInstance() {
    return bluemixInstance;
  }

  /**
   * Gets the setInstancePoliciesOneOf.
   *
   * The base request for the create or update of instance level policies.
   *
   * @return the setInstancePoliciesOneOf
   */
  public SetInstancePoliciesOneOf setInstancePoliciesOneOf() {
    return setInstancePoliciesOneOf;
  }

  /**
   * Gets the correlationId.
   *
   * The v4 UUID used to correlate and track transactions.
   *
   * @return the correlationId
   */
  public String correlationId() {
    return correlationId;
  }

  /**
   * Gets the policy.
   *
   * The type of policy that is associated with the specified instance.
   *
   * @return the policy
   */
  public String policy() {
    return policy;
  }
}

