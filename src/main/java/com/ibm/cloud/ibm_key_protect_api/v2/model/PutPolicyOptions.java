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
 * The putPolicy options.
 */
public class PutPolicyOptions extends GenericModel {

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
  protected SetKeyPoliciesOneOf setKeyPoliciesOneOf;
  protected String correlationId;
  protected String xKmsKeyRing;
  protected String policy;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String bluemixInstance;
    private SetKeyPoliciesOneOf setKeyPoliciesOneOf;
    private String correlationId;
    private String xKmsKeyRing;
    private String policy;

    /**
     * Instantiates a new Builder from an existing PutPolicyOptions instance.
     *
     * @param putPolicyOptions the instance to initialize the Builder with
     */
    private Builder(PutPolicyOptions putPolicyOptions) {
      this.id = putPolicyOptions.id;
      this.bluemixInstance = putPolicyOptions.bluemixInstance;
      this.setKeyPoliciesOneOf = putPolicyOptions.setKeyPoliciesOneOf;
      this.correlationId = putPolicyOptions.correlationId;
      this.xKmsKeyRing = putPolicyOptions.xKmsKeyRing;
      this.policy = putPolicyOptions.policy;
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
     * @param setKeyPoliciesOneOf the setKeyPoliciesOneOf
     */
    public Builder(String id, String bluemixInstance, SetKeyPoliciesOneOf setKeyPoliciesOneOf) {
      this.id = id;
      this.bluemixInstance = bluemixInstance;
      this.setKeyPoliciesOneOf = setKeyPoliciesOneOf;
    }

    /**
     * Builds a PutPolicyOptions.
     *
     * @return the new PutPolicyOptions instance
     */
    public PutPolicyOptions build() {
      return new PutPolicyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the PutPolicyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the PutPolicyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the setKeyPoliciesOneOf.
     *
     * @param setKeyPoliciesOneOf the setKeyPoliciesOneOf
     * @return the PutPolicyOptions builder
     */
    public Builder setKeyPoliciesOneOf(SetKeyPoliciesOneOf setKeyPoliciesOneOf) {
      this.setKeyPoliciesOneOf = setKeyPoliciesOneOf;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the PutPolicyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the PutPolicyOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the policy.
     *
     * @param policy the policy
     * @return the PutPolicyOptions builder
     */
    public Builder policy(String policy) {
      this.policy = policy;
      return this;
    }
  }

  protected PutPolicyOptions() { }

  protected PutPolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.setKeyPoliciesOneOf,
      "setKeyPoliciesOneOf cannot be null");
    id = builder.id;
    bluemixInstance = builder.bluemixInstance;
    setKeyPoliciesOneOf = builder.setKeyPoliciesOneOf;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
    policy = builder.policy;
  }

  /**
   * New builder.
   *
   * @return a PutPolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The v4 UUID or alias that uniquely identifies the key.
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
   * Gets the setKeyPoliciesOneOf.
   *
   * The base request for key policy create or update.
   *
   * @return the setKeyPoliciesOneOf
   */
  public SetKeyPoliciesOneOf setKeyPoliciesOneOf() {
    return setKeyPoliciesOneOf;
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
   * Gets the xKmsKeyRing.
   *
   * The ID of the key ring that the specified key is a part of. When the  header is not specified, Key Protect will
   * perform a key ring lookup. For  a more optimized request, specify the key ring on every call. The key ring ID of
   * keys that are created without an `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
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

