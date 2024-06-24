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
 * The getRegistrationsAllKeys options.
 */
public class GetRegistrationsAllKeysOptions extends GenericModel {

  protected String bluemixInstance;
  protected String correlationId;
  protected String xKmsKeyRing;
  protected String urlEncodedResourceCrnQuery;
  protected Long limit;
  protected Long offset;
  protected Boolean preventKeyDeletion;
  protected Boolean totalCount;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private String xKmsKeyRing;
    private String urlEncodedResourceCrnQuery;
    private Long limit;
    private Long offset;
    private Boolean preventKeyDeletion;
    private Boolean totalCount;

    /**
     * Instantiates a new Builder from an existing GetRegistrationsAllKeysOptions instance.
     *
     * @param getRegistrationsAllKeysOptions the instance to initialize the Builder with
     */
    private Builder(GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptions) {
      this.bluemixInstance = getRegistrationsAllKeysOptions.bluemixInstance;
      this.correlationId = getRegistrationsAllKeysOptions.correlationId;
      this.xKmsKeyRing = getRegistrationsAllKeysOptions.xKmsKeyRing;
      this.urlEncodedResourceCrnQuery = getRegistrationsAllKeysOptions.urlEncodedResourceCrnQuery;
      this.limit = getRegistrationsAllKeysOptions.limit;
      this.offset = getRegistrationsAllKeysOptions.offset;
      this.preventKeyDeletion = getRegistrationsAllKeysOptions.preventKeyDeletion;
      this.totalCount = getRegistrationsAllKeysOptions.totalCount;
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
     * Builds a GetRegistrationsAllKeysOptions.
     *
     * @return the new GetRegistrationsAllKeysOptions instance
     */
    public GetRegistrationsAllKeysOptions build() {
      return new GetRegistrationsAllKeysOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the urlEncodedResourceCrnQuery.
     *
     * @param urlEncodedResourceCrnQuery the urlEncodedResourceCrnQuery
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder urlEncodedResourceCrnQuery(String urlEncodedResourceCrnQuery) {
      this.urlEncodedResourceCrnQuery = urlEncodedResourceCrnQuery;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the preventKeyDeletion.
     *
     * @param preventKeyDeletion the preventKeyDeletion
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder preventKeyDeletion(Boolean preventKeyDeletion) {
      this.preventKeyDeletion = preventKeyDeletion;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the GetRegistrationsAllKeysOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }
  }

  protected GetRegistrationsAllKeysOptions() { }

  protected GetRegistrationsAllKeysOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
    urlEncodedResourceCrnQuery = builder.urlEncodedResourceCrnQuery;
    limit = builder.limit;
    offset = builder.offset;
    preventKeyDeletion = builder.preventKeyDeletion;
    totalCount = builder.totalCount;
  }

  /**
   * New builder.
   *
   * @return a GetRegistrationsAllKeysOptions builder
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
   * Gets the xKmsKeyRing.
   *
   * The ID of the target key ring. If unspecified, all resources in the instance that the caller has access to will be
   * returned. When the header  is specified, only resources within the specified key ring, that the caller has access
   * to,  will be returned. The key ring ID of keys that are created without an `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
  }

  /**
   * Gets the urlEncodedResourceCrnQuery.
   *
   * Filters for resources that are associated with a specified [Cloud Resource Name](/docs/account?topic=account-crn)
   * (CRN) by using URL encoded wildcard characters (`*`). The parameter should contain all CRN segments and must be URL
   * encoded. If provided, the parameter should not contain (`*`) in the first eight segments. If this parameter is not
   * provided, registrations for all keys in the requested Key Protect instance are returned.
   *
   * @return the urlEncodedResourceCrnQuery
   */
  public String urlEncodedResourceCrnQuery() {
    return urlEncodedResourceCrnQuery;
  }

  /**
   * Gets the limit.
   *
   * The number of registrations to retrieve. By default returns the first 200 registrations. To retrieve a different
   * set of registrations, use `limit` with `offset` to page through your available resources. The maximum value for
   * `limit` is 5,000.
   * **Usage:** If you have 20 registrations that are associated with a key, and you want to retrieve only the first 5
   * registrations, use `../registrations?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of registrations to skip. By specifying `offset`, you retrieve a subset of registrations that starts
   * with the `offset` value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have 100 registrations that are associated with a key, and you want to retrieve registrations 26
   * through 50, use `../registrations?offset=25&amp;limit=25`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the preventKeyDeletion.
   *
   * Filters registrations based on the `preventKeyDeletion` property. You can use this query parameter to search for
   * registered cloud resources that are non-erasable due to a retention policy. This policy should only be set if a
   * WORM policy
   * (https://www.ibm.com/docs/en/spectrum-scale/5.0.1?topic=ics-how-write-once-read-many-worm-storage-works) must be
   * satisfied.  Do not set this policy by default.
   * **Usage:** To search for registered cloud resources that have a retention policy, use
   * `../registrations?preventKeyDeletion=true`.
   *
   * @return the preventKeyDeletion
   */
  public Boolean preventKeyDeletion() {
    return preventKeyDeletion;
  }

  /**
   * Gets the totalCount.
   *
   * If set to `true`, returns `totalCount` in the response metadata for use with pagination. The `totalCount` value
   * returned specifies the total number of registrations that match the request, disregarding limit and offset.
   * **Usage:** To return the `totalCount` value for use with pagination, use `../registrations?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
  }
}

