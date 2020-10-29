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
 * The metadata that describes the resource array.
 */
public class CollectionMetadata extends GenericModel {

  /**
   * The type of resources in the resource array.
   */
  public interface CollectionType {
    /** application/vnd.ibm.kms.crn+json. */
    String APPLICATION_VND_IBM_KMS_CRN_JSON = "application/vnd.ibm.kms.crn+json";
    /** application/vnd.ibm.kms.error+json. */
    String APPLICATION_VND_IBM_KMS_ERROR_JSON = "application/vnd.ibm.kms.error+json";
    /** application/vnd.ibm.kms.event_acknowledge+json. */
    String APPLICATION_VND_IBM_KMS_EVENT_ACKNOWLEDGE_JSON = "application/vnd.ibm.kms.event_acknowledge+json";
    /** application/vnd.ibm.kms.import_token+json. */
    String APPLICATION_VND_IBM_KMS_IMPORT_TOKEN_JSON = "application/vnd.ibm.kms.import_token+json";
    /** application/vnd.ibm.kms.key_action+json. */
    String APPLICATION_VND_IBM_KMS_KEY_ACTION_JSON = "application/vnd.ibm.kms.key_action+json";
    /** application/vnd.ibm.kms.key+json. */
    String APPLICATION_VND_IBM_KMS_KEY_JSON = "application/vnd.ibm.kms.key+json";
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
    /** application/vnd.ibm.kms.registration_input+json. */
    String APPLICATION_VND_IBM_KMS_REGISTRATION_INPUT_JSON = "application/vnd.ibm.kms.registration_input+json";
    /** application/vnd.ibm.kms.registration+json. */
    String APPLICATION_VND_IBM_KMS_REGISTRATION_JSON = "application/vnd.ibm.kms.registration+json";
    /** application/vnd.ibm.kms.resource_crn+json. */
    String APPLICATION_VND_IBM_KMS_RESOURCE_CRN_JSON = "application/vnd.ibm.kms.resource_crn+json";
  }

  protected String collectionType;
  protected Long collectionTotal;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionType;
    private Long collectionTotal;

    private Builder(CollectionMetadata collectionMetadata) {
      this.collectionType = collectionMetadata.collectionType;
      this.collectionTotal = collectionMetadata.collectionTotal;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionType the collectionType
     * @param collectionTotal the collectionTotal
     */
    public Builder(String collectionType, Long collectionTotal) {
      this.collectionType = collectionType;
      this.collectionTotal = collectionTotal;
    }

    /**
     * Builds a CollectionMetadata.
     *
     * @return the new CollectionMetadata instance
     */
    public CollectionMetadata build() {
      return new CollectionMetadata(this);
    }

    /**
     * Set the collectionType.
     *
     * @param collectionType the collectionType
     * @return the CollectionMetadata builder
     */
    public Builder collectionType(String collectionType) {
      this.collectionType = collectionType;
      return this;
    }

    /**
     * Set the collectionTotal.
     *
     * @param collectionTotal the collectionTotal
     * @return the CollectionMetadata builder
     */
    public Builder collectionTotal(long collectionTotal) {
      this.collectionTotal = collectionTotal;
      return this;
    }
  }

  protected CollectionMetadata(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.collectionType,
      "collectionType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.collectionTotal,
      "collectionTotal cannot be null");
    collectionType = builder.collectionType;
    collectionTotal = builder.collectionTotal;
  }

  /**
   * New builder.
   *
   * @return a CollectionMetadata builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionType.
   *
   * The type of resources in the resource array.
   *
   * @return the collectionType
   */
  public String collectionType() {
    return collectionType;
  }

  /**
   * Gets the collectionTotal.
   *
   * The number of elements in the resource array.
   *
   * @return the collectionTotal
   */
  public Long collectionTotal() {
    return collectionTotal;
  }
}

