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
 * The getPolicy options.
 */
public class GetPolicyOptions extends GenericModel {

  /**
   * The type of policy that is associated with the specified key.
   */
  public interface Policy {
    /** dualAuthDelete. */
    String DUALAUTHDELETE = "dualAuthDelete";
    /** rotation. */
    String ROTATION = "rotation";
  }

  protected String id;
  protected String bluemixInstance;
  protected String correlationId;
  protected String policy;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String bluemixInstance;
    private String correlationId;
    private String policy;

    private Builder(GetPolicyOptions getPolicyOptions) {
      this.id = getPolicyOptions.id;
      this.bluemixInstance = getPolicyOptions.bluemixInstance;
      this.correlationId = getPolicyOptions.correlationId;
      this.policy = getPolicyOptions.policy;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String id, String bluemixInstance) {
      this.id = id;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a GetPolicyOptions.
     *
     * @return the new GetPolicyOptions instance
     */
    public GetPolicyOptions build() {
      return new GetPolicyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetPolicyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetPolicyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetPolicyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the policy.
     *
     * @param policy the policy
     * @return the GetPolicyOptions builder
     */
    public Builder policy(String policy) {
      this.policy = policy;
      return this;
    }
  }

  protected GetPolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    id = builder.id;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    policy = builder.policy;
  }

  /**
   * New builder.
   *
   * @return a GetPolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The v4 UUID that uniquely identifies the key.
   *
   * @return the id
   */
  public String id() {
    return id;
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
   * The type of policy that is associated with the specified key.
   *
   * @return the policy
   */
  public String policy() {
    return policy;
  }
}

