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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * KeyPolicyRotation.
 */
public class KeyPolicyRotation extends GenericModel {

  /**
   * Specifies the MIME type that represents the policy resource. Currently, only the default is supported.
   */
  public interface Type {
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
  }

  protected String type;
  protected KeyPolicyRotationRotation rotation;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private KeyPolicyRotationRotation rotation;

    private Builder(KeyPolicyRotation keyPolicyRotation) {
      this.type = keyPolicyRotation.type;
      this.rotation = keyPolicyRotation.rotation;
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
     * @param rotation the rotation
     */
    public Builder(String type, KeyPolicyRotationRotation rotation) {
      this.type = type;
      this.rotation = rotation;
    }

    /**
     * Builds a KeyPolicyRotation.
     *
     * @return the new KeyPolicyRotation instance
     */
    public KeyPolicyRotation build() {
      return new KeyPolicyRotation(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the KeyPolicyRotation builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the rotation.
     *
     * @param rotation the rotation
     * @return the KeyPolicyRotation builder
     */
    public Builder rotation(KeyPolicyRotationRotation rotation) {
      this.rotation = rotation;
      return this;
    }
  }

  protected KeyPolicyRotation(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rotation,
      "rotation cannot be null");
    type = builder.type;
    rotation = builder.rotation;
  }

  /**
   * New builder.
   *
   * @return a KeyPolicyRotation builder
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
   * Gets the rotation.
   *
   * Specifies the key rotation time interval in months, with a minimum of 1, and a maximum of 12.
   *
   * @return the rotation
   */
  public KeyPolicyRotationRotation rotation() {
    return rotation;
  }
}

