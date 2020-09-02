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

import java.util.Date;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties that are associated with import tokens.
 */
public class ImportToken extends GenericModel {

  protected Double expiration;
  protected Double maxAllowedRetrievals;
  protected Date creationDate;
  protected Date expirationDate;
  protected Double remainingRetrievals;

  /**
   * Builder.
   */
  public static class Builder {
    private Double expiration;
    private Double maxAllowedRetrievals;

    private Builder(ImportToken importToken) {
      this.expiration = importToken.expiration;
      this.maxAllowedRetrievals = importToken.maxAllowedRetrievals;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ImportToken.
     *
     * @return the new ImportToken instance
     */
    public ImportToken build() {
      return new ImportToken(this);
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the ImportToken builder
     */
    public Builder expiration(Double expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the maxAllowedRetrievals.
     *
     * @param maxAllowedRetrievals the maxAllowedRetrievals
     * @return the ImportToken builder
     */
    public Builder maxAllowedRetrievals(Double maxAllowedRetrievals) {
      this.maxAllowedRetrievals = maxAllowedRetrievals;
      return this;
    }
  }

  protected ImportToken(Builder builder) {
    expiration = builder.expiration;
    maxAllowedRetrievals = builder.maxAllowedRetrievals;
  }

  /**
   * New builder.
   *
   * @return a ImportToken builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the expiration.
   *
   * The time in seconds from the creation of an import token that determines how long its associated public key
   * remains valid.
   *     The minimum value is `300` seconds (5 minutes), and the maximum value is `86400` (24 hours). The default value
   * is `600` (10 minutes).
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
   * Gets the creationDate.
   *
   * The date the import token was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date creationDate() {
    return creationDate;
  }

  /**
   * Gets the expirationDate.
   *
   * The date the import token expires. The date format follows RFC 3339.
   *
   * @return the expirationDate
   */
  public Date expirationDate() {
    return expirationDate;
  }

  /**
   * Gets the remainingRetrievals.
   *
   * The number of retrievals that are available for the import token before it is no longer accessible.
   *
   * @return the remainingRetrievals
   */
  public Double remainingRetrievals() {
    return remainingRetrievals;
  }
}

