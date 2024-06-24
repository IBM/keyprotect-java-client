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
 * Properties that are associated with key level dual authorization delete policy.
 */
public class SetMultipleKeyPoliciesResource extends GenericModel {

  /**
   * Specifies the MIME type that represents the policy resource. Currently, only the default is supported.
   */
  public interface Type {
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
  }

  protected String type;
  protected KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete;
  protected KeyPolicyRotationRotation rotation;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete;
    private KeyPolicyRotationRotation rotation;

    /**
     * Instantiates a new Builder from an existing SetMultipleKeyPoliciesResource instance.
     *
     * @param setMultipleKeyPoliciesResource the instance to initialize the Builder with
     */
    private Builder(SetMultipleKeyPoliciesResource setMultipleKeyPoliciesResource) {
      this.type = setMultipleKeyPoliciesResource.type;
      this.dualAuthDelete = setMultipleKeyPoliciesResource.dualAuthDelete;
      this.rotation = setMultipleKeyPoliciesResource.rotation;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param dualAuthDelete the dualAuthDelete
     * @param rotation the rotation
     */
    public Builder(String type, KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete, KeyPolicyRotationRotation rotation) {
      this.type = type;
      this.dualAuthDelete = dualAuthDelete;
      this.rotation = rotation;
    }

    /**
     * Builds a SetMultipleKeyPoliciesResource.
     *
     * @return the new SetMultipleKeyPoliciesResource instance
     */
    public SetMultipleKeyPoliciesResource build() {
      return new SetMultipleKeyPoliciesResource(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the SetMultipleKeyPoliciesResource builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the dualAuthDelete.
     *
     * @param dualAuthDelete the dualAuthDelete
     * @return the SetMultipleKeyPoliciesResource builder
     */
    public Builder dualAuthDelete(KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete) {
      this.dualAuthDelete = dualAuthDelete;
      return this;
    }

    /**
     * Set the rotation.
     *
     * @param rotation the rotation
     * @return the SetMultipleKeyPoliciesResource builder
     */
    public Builder rotation(KeyPolicyRotationRotation rotation) {
      this.rotation = rotation;
      return this;
    }
  }

  protected SetMultipleKeyPoliciesResource() { }

  protected SetMultipleKeyPoliciesResource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.dualAuthDelete,
      "dualAuthDelete cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rotation,
      "rotation cannot be null");
    type = builder.type;
    dualAuthDelete = builder.dualAuthDelete;
    rotation = builder.rotation;
  }

  /**
   * New builder.
   *
   * @return a SetMultipleKeyPoliciesResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Specifies the MIME type that represents the policy resource. Currently, only the default is supported.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the dualAuthDelete.
   *
   * Data associated with the dual authorization delete policy.
   *
   * @return the dualAuthDelete
   */
  public KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete() {
    return dualAuthDelete;
  }

  /**
   * Gets the rotation.
   *
   * Data associated with the automatic key rotation policy.
   *
   * @return the rotation
   */
  public KeyPolicyRotationRotation rotation() {
    return rotation;
  }
}

