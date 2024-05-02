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
 * The base schema for the resource in the body of a create registration.
 */
public class ReplaceRegistrationResourceBody extends GenericModel {

  protected Boolean preventKeyDeletion;
  protected String description;
  protected String registrationMetadata;
  protected String keyVersionId;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean preventKeyDeletion;
    private String description;
    private String registrationMetadata;
    private String keyVersionId;

    /**
     * Instantiates a new Builder from an existing ReplaceRegistrationResourceBody instance.
     *
     * @param replaceRegistrationResourceBody the instance to initialize the Builder with
     */
    private Builder(ReplaceRegistrationResourceBody replaceRegistrationResourceBody) {
      this.preventKeyDeletion = replaceRegistrationResourceBody.preventKeyDeletion;
      this.description = replaceRegistrationResourceBody.description;
      this.registrationMetadata = replaceRegistrationResourceBody.registrationMetadata;
      this.keyVersionId = replaceRegistrationResourceBody.keyVersionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param preventKeyDeletion the preventKeyDeletion
     * @param description the description
     * @param registrationMetadata the registrationMetadata
     * @param keyVersionId the keyVersionId
     */
    public Builder(Boolean preventKeyDeletion, String description, String registrationMetadata, String keyVersionId) {
      this.preventKeyDeletion = preventKeyDeletion;
      this.description = description;
      this.registrationMetadata = registrationMetadata;
      this.keyVersionId = keyVersionId;
    }

    /**
     * Builds a ReplaceRegistrationResourceBody.
     *
     * @return the new ReplaceRegistrationResourceBody instance
     */
    public ReplaceRegistrationResourceBody build() {
      return new ReplaceRegistrationResourceBody(this);
    }

    /**
     * Set the preventKeyDeletion.
     *
     * @param preventKeyDeletion the preventKeyDeletion
     * @return the ReplaceRegistrationResourceBody builder
     */
    public Builder preventKeyDeletion(Boolean preventKeyDeletion) {
      this.preventKeyDeletion = preventKeyDeletion;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceRegistrationResourceBody builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the registrationMetadata.
     *
     * @param registrationMetadata the registrationMetadata
     * @return the ReplaceRegistrationResourceBody builder
     */
    public Builder registrationMetadata(String registrationMetadata) {
      this.registrationMetadata = registrationMetadata;
      return this;
    }

    /**
     * Set the keyVersionId.
     *
     * @param keyVersionId the keyVersionId
     * @return the ReplaceRegistrationResourceBody builder
     */
    public Builder keyVersionId(String keyVersionId) {
      this.keyVersionId = keyVersionId;
      return this;
    }
  }

  protected ReplaceRegistrationResourceBody() { }

  protected ReplaceRegistrationResourceBody(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.preventKeyDeletion,
      "preventKeyDeletion cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.registrationMetadata,
      "registrationMetadata cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.keyVersionId,
      "keyVersionId cannot be null");
    preventKeyDeletion = builder.preventKeyDeletion;
    description = builder.description;
    registrationMetadata = builder.registrationMetadata;
    keyVersionId = builder.keyVersionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceRegistrationResourceBody builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the preventKeyDeletion.
   *
   * A boolean that determines whether Key Protect must prevent deletion of a root key. This policy should only be set
   * if a WORM policy must be satisfied. If set to `true`, Key Protect prevents deletion of the specified root key and
   * its associated protected resources. The system prevents the deletion of any key that has at least one registration
   * where `preventKeyDeletion` is `true`.
   *
   * @return the preventKeyDeletion
   */
  public Boolean preventKeyDeletion() {
    return preventKeyDeletion;
  }

  /**
   * Gets the description.
   *
   * A text field that cloud services can use to store external metadata about the registration. This field is exposed
   * to customers when they review registered resources using GET /registrations.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the registrationMetadata.
   *
   * A text field that cloud services can use to store internal metadata about the registration. This field is not
   * exposed to customers and is visible only with IBM Cloud service to service calls.
   *
   * @return the registrationMetadata
   */
  public String registrationMetadata() {
    return registrationMetadata;
  }

  /**
   * Gets the keyVersionId.
   *
   * The ID of the key version that you want to register. This must be a version that is newer than the registered key
   * version.
   *
   * @return the keyVersionId
   */
  public String keyVersionId() {
    return keyVersionId;
  }
}

