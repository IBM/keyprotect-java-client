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

/**
 * Properties that must be specified to profile_data when it is of native_1.0 KMIP adapter resource.
 */
public class KMIPProfileDataBodyKMIPProfileDataNative extends KMIPProfileDataBody {


  /**
   * Builder.
   */
  public static class Builder {
    private String crkId;
    private String targetKeyRingId;

    /**
     * Instantiates a new Builder from an existing KMIPProfileDataBodyKMIPProfileDataNative instance.
     *
     * @param kmipProfileDataBodyKmipProfileDataNative the instance to initialize the Builder with
     */
    public Builder(KMIPProfileDataBody kmipProfileDataBodyKmipProfileDataNative) {
      this.crkId = kmipProfileDataBodyKmipProfileDataNative.crkId;
      this.targetKeyRingId = kmipProfileDataBodyKmipProfileDataNative.targetKeyRingId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param crkId the crkId
     */
    public Builder(String crkId) {
      this.crkId = crkId;
    }

    /**
     * Builds a KMIPProfileDataBodyKMIPProfileDataNative.
     *
     * @return the new KMIPProfileDataBodyKMIPProfileDataNative instance
     */
    public KMIPProfileDataBodyKMIPProfileDataNative build() {
      return new KMIPProfileDataBodyKMIPProfileDataNative(this);
    }

    /**
     * Set the crkId.
     *
     * @param crkId the crkId
     * @return the KMIPProfileDataBodyKMIPProfileDataNative builder
     */
    public Builder crkId(String crkId) {
      this.crkId = crkId;
      return this;
    }

    /**
     * Set the targetKeyRingId.
     *
     * @param targetKeyRingId the targetKeyRingId
     * @return the KMIPProfileDataBodyKMIPProfileDataNative builder
     */
    public Builder targetKeyRingId(String targetKeyRingId) {
      this.targetKeyRingId = targetKeyRingId;
      return this;
    }
  }

  protected KMIPProfileDataBodyKMIPProfileDataNative() { }

  protected KMIPProfileDataBodyKMIPProfileDataNative(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.crkId,
      "crkId cannot be null");
    crkId = builder.crkId;
    targetKeyRingId = builder.targetKeyRingId;
  }

  /**
   * New builder.
   *
   * @return a KMIPProfileDataBodyKMIPProfileDataNative builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

