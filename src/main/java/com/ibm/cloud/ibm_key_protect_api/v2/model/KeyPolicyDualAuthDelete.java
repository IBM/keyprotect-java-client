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
public class KeyPolicyDualAuthDelete extends GenericModel {

  /**
   * Specifies the MIME type that represents the policy resource. Currently, only the default is supported.
   */
  public interface Type {
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
  }

  protected String type;
  protected KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete;

    /**
     * Instantiates a new Builder from an existing KeyPolicyDualAuthDelete instance.
     *
     * @param keyPolicyDualAuthDelete the instance to initialize the Builder with
     */
    private Builder(KeyPolicyDualAuthDelete keyPolicyDualAuthDelete) {
      this.type = keyPolicyDualAuthDelete.type;
      this.dualAuthDelete = keyPolicyDualAuthDelete.dualAuthDelete;
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
     */
    public Builder(String type, KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete) {
      this.type = type;
      this.dualAuthDelete = dualAuthDelete;
    }

    /**
     * Builds a KeyPolicyDualAuthDelete.
     *
     * @return the new KeyPolicyDualAuthDelete instance
     */
    public KeyPolicyDualAuthDelete build() {
      return new KeyPolicyDualAuthDelete(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the KeyPolicyDualAuthDelete builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the dualAuthDelete.
     *
     * @param dualAuthDelete the dualAuthDelete
     * @return the KeyPolicyDualAuthDelete builder
     */
    public Builder dualAuthDelete(KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete) {
      this.dualAuthDelete = dualAuthDelete;
      return this;
    }
  }

  protected KeyPolicyDualAuthDelete() { }

  protected KeyPolicyDualAuthDelete(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.dualAuthDelete,
      "dualAuthDelete cannot be null");
    type = builder.type;
    dualAuthDelete = builder.dualAuthDelete;
  }

  /**
   * New builder.
   *
   * @return a KeyPolicyDualAuthDelete builder
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
}

