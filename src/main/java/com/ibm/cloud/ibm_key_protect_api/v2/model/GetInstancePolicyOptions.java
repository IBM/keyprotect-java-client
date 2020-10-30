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
 * The getInstancePolicy options.
 */
public class GetInstancePolicyOptions extends GenericModel {

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
  }

  protected String bluemixInstance;
  protected String correlationId;
  protected String policy;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private String policy;

    private Builder(GetInstancePolicyOptions getInstancePolicyOptions) {
      this.bluemixInstance = getInstancePolicyOptions.bluemixInstance;
      this.correlationId = getInstancePolicyOptions.correlationId;
      this.policy = getInstancePolicyOptions.policy;
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
     */
    public Builder(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a GetInstancePolicyOptions.
     *
     * @return the new GetInstancePolicyOptions instance
     */
    public GetInstancePolicyOptions build() {
      return new GetInstancePolicyOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetInstancePolicyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetInstancePolicyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the policy.
     *
     * @param policy the policy
     * @return the GetInstancePolicyOptions builder
     */
    public Builder policy(String policy) {
      this.policy = policy;
      return this;
    }
  }

  protected GetInstancePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    policy = builder.policy;
  }

  /**
   * New builder.
   *
   * @return a GetInstancePolicyOptions builder
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

