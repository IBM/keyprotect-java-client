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
 * The getRegistrations options.
 */
public class GetRegistrationsOptions extends GenericModel {

  protected String id;
  protected String bluemixInstance;
  protected String correlationId;
  protected String xKmsKeyRing;
  protected Long limit;
  protected Long offset;
  protected String urlEncodedResourceCrnQuery;
  protected Boolean preventKeyDeletion;
  protected Boolean totalCount;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String bluemixInstance;
    private String correlationId;
    private String xKmsKeyRing;
    private Long limit;
    private Long offset;
    private String urlEncodedResourceCrnQuery;
    private Boolean preventKeyDeletion;
    private Boolean totalCount;

    private Builder(GetRegistrationsOptions getRegistrationsOptions) {
      this.id = getRegistrationsOptions.id;
      this.bluemixInstance = getRegistrationsOptions.bluemixInstance;
      this.correlationId = getRegistrationsOptions.correlationId;
      this.xKmsKeyRing = getRegistrationsOptions.xKmsKeyRing;
      this.limit = getRegistrationsOptions.limit;
      this.offset = getRegistrationsOptions.offset;
      this.urlEncodedResourceCrnQuery = getRegistrationsOptions.urlEncodedResourceCrnQuery;
      this.preventKeyDeletion = getRegistrationsOptions.preventKeyDeletion;
      this.totalCount = getRegistrationsOptions.totalCount;
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
     */
    public Builder(String id, String bluemixInstance) {
      this.id = id;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a GetRegistrationsOptions.
     *
     * @return the new GetRegistrationsOptions instance
     */
    public GetRegistrationsOptions build() {
      return new GetRegistrationsOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetRegistrationsOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetRegistrationsOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetRegistrationsOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the GetRegistrationsOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetRegistrationsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetRegistrationsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the urlEncodedResourceCrnQuery.
     *
     * @param urlEncodedResourceCrnQuery the urlEncodedResourceCrnQuery
     * @return the GetRegistrationsOptions builder
     */
    public Builder urlEncodedResourceCrnQuery(String urlEncodedResourceCrnQuery) {
      this.urlEncodedResourceCrnQuery = urlEncodedResourceCrnQuery;
      return this;
    }

    /**
     * Set the preventKeyDeletion.
     *
     * @param preventKeyDeletion the preventKeyDeletion
     * @return the GetRegistrationsOptions builder
     */
    public Builder preventKeyDeletion(Boolean preventKeyDeletion) {
      this.preventKeyDeletion = preventKeyDeletion;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the GetRegistrationsOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }
  }

  protected GetRegistrationsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    id = builder.id;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
    limit = builder.limit;
    offset = builder.offset;
    urlEncodedResourceCrnQuery = builder.urlEncodedResourceCrnQuery;
    preventKeyDeletion = builder.preventKeyDeletion;
    totalCount = builder.totalCount;
  }

  /**
   * New builder.
   *
   * @return a GetRegistrationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The v4 UUID that uniquely identifies the key.
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
   * Gets the limit.
   *
   * The number of registrations to retrieve. By default returns the first 200 registrations. To retrieve a different
   * set of registrations, use
   * `limit` with `offset` to page through your available resources. The maximum value for `limit` is 5,000.
   *
   * **Usage:** If you have 20 registrations that are associated with a key, and you want to retrieve only the first 5
   * registrations, use
   * `../registrations?limit=5`.
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
   *
   * **Usage:** If you have 100 registrations that are associated with a key, and you want to retrieve registrations 26
   * through 50, use
   * `../registrations?offset=25&amp;limit=25`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the urlEncodedResourceCrnQuery.
   *
   * Filters for resources that are associated with a specified
   * [Cloud Resource Name](/docs/account?topic=account-crn)
   * (CRN) by using URL encoded wildcard characters (`*`). The parameter should contain all CRN segments and must be URL
   * encoded. Supports a prefix search when you specify `*` on the last CRN segment.
   *
   * **Usage:** To list registrations that are associated with all resources in `&lt;service-instance&gt;`, use a URL
   * encoded version of the following string:
   * `crn:v1:bluemix:public:&lt;service-name&gt;:&lt;location&gt;:a/&lt;account&gt;:&lt;service-instance&gt;:*:*`. To
   * search for subresources, use the following CRN format:
   * `crn:v1:bluemix:public:&lt;service-name&gt;:&lt;location&gt;:a/&lt;account&gt;:&lt;service-instance&gt;:&lt;resource-type&gt;:&lt;resource&gt;/&lt;subresource&gt;`.
   *
   * For more examples, see
   * [CRN query examples](/docs/key-protect?topic=key-protect-view-protected-resources#crn-query-examples).
   *
   * @return the urlEncodedResourceCrnQuery
   */
  public String urlEncodedResourceCrnQuery() {
    return urlEncodedResourceCrnQuery;
  }

  /**
   * Gets the preventKeyDeletion.
   *
   * Filters registrations based on the `preventKeyDeletion` property. You can use this query parameter to search for
   * registered cloud resources that are non-erasable due to a retention policy.
   *
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
   *
   * **Usage:** To return the `totalCount` value for use with pagination, use
   * `../registrations?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
  }
}

