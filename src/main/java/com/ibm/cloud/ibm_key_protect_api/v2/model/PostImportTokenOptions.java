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
 * The postImportToken options.
 */
public class PostImportTokenOptions extends GenericModel {

  protected String bluemixInstance;
  protected Double expiration;
  protected Double maxAllowedRetrievals;
  protected String correlationId;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private Double expiration;
    private Double maxAllowedRetrievals;
    private String correlationId;
    private String xKmsKeyRing;

    private Builder(PostImportTokenOptions postImportTokenOptions) {
      this.bluemixInstance = postImportTokenOptions.bluemixInstance;
      this.expiration = postImportTokenOptions.expiration;
      this.maxAllowedRetrievals = postImportTokenOptions.maxAllowedRetrievals;
      this.correlationId = postImportTokenOptions.correlationId;
      this.xKmsKeyRing = postImportTokenOptions.xKmsKeyRing;
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
     * Builds a PostImportTokenOptions.
     *
     * @return the new PostImportTokenOptions instance
     */
    public PostImportTokenOptions build() {
      return new PostImportTokenOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the PostImportTokenOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the PostImportTokenOptions builder
     */
    public Builder expiration(Double expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the maxAllowedRetrievals.
     *
     * @param maxAllowedRetrievals the maxAllowedRetrievals
     * @return the PostImportTokenOptions builder
     */
    public Builder maxAllowedRetrievals(Double maxAllowedRetrievals) {
      this.maxAllowedRetrievals = maxAllowedRetrievals;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the PostImportTokenOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the PostImportTokenOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the importToken.
     *
     * @param importToken the importToken
     * @return the PostImportTokenOptions builder
     */
    public Builder importToken(ImportToken importToken) {
      this.expiration = importToken.expiration();
      this.maxAllowedRetrievals = importToken.maxAllowedRetrievals();
      return this;
    }
  }

  protected PostImportTokenOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    expiration = builder.expiration;
    maxAllowedRetrievals = builder.maxAllowedRetrievals;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
  }

  /**
   * New builder.
   *
   * @return a PostImportTokenOptions builder
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
   * Gets the expiration.
   *
   * The time in seconds from the creation of an import token that determines how long its associated public key remains
   * valid.
   *
   * The minimum value is `300` seconds (5 minutes), and the maximum value is `86400` (24 hours). The default value is
   * `600`
   * (10 minutes).
   *
   * @return the expiration
   */
  public Double expiration() {
    return expiration;
  }

  /**
   * Gets the maxAllowedRetrievals.
   *
   * The number of times that an import token can be retrieved within its expiration time before it is no longer
   * accessible.
   *
   * @return the maxAllowedRetrievals
   */
  public Double maxAllowedRetrievals() {
    return maxAllowedRetrievals;
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
   * The ID of the key ring that the specified key belongs to. When the header is not specified,  Key Protect will
   * perform a key ring lookup. For a more optimized request,  specify the key ring on every call. The key ring ID of
   * keys that are created without an  `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
  }
}

