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
 * The getKmipAdapters options.
 */
public class GetKmipAdaptersOptions extends GenericModel {

  protected String bluemixInstance;
  protected String correlationId;
  protected Long limit;
  protected Long offset;
  protected Boolean totalCount;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private Long limit;
    private Long offset;
    private Boolean totalCount;

    /**
     * Instantiates a new Builder from an existing GetKmipAdaptersOptions instance.
     *
     * @param getKmipAdaptersOptions the instance to initialize the Builder with
     */
    private Builder(GetKmipAdaptersOptions getKmipAdaptersOptions) {
      this.bluemixInstance = getKmipAdaptersOptions.bluemixInstance;
      this.correlationId = getKmipAdaptersOptions.correlationId;
      this.limit = getKmipAdaptersOptions.limit;
      this.offset = getKmipAdaptersOptions.offset;
      this.totalCount = getKmipAdaptersOptions.totalCount;
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
     * Builds a GetKmipAdaptersOptions.
     *
     * @return the new GetKmipAdaptersOptions instance
     */
    public GetKmipAdaptersOptions build() {
      return new GetKmipAdaptersOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetKmipAdaptersOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKmipAdaptersOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetKmipAdaptersOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetKmipAdaptersOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the GetKmipAdaptersOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }
  }

  protected GetKmipAdaptersOptions() { }

  protected GetKmipAdaptersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    limit = builder.limit;
    offset = builder.offset;
    totalCount = builder.totalCount;
  }

  /**
   * New builder.
   *
   * @return a GetKmipAdaptersOptions builder
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
   * Gets the limit.
   *
   * The number of KMIP Adapters to retrieve. By default, `GET /kmip_adapters` returns the first 100 KMIP Adapters. To
   * retrieve a different set of KMIP adapters, use `limit` with `offset` to page through your available resources. The
   * maximum value for `limit` is 200.
   * **Usage:** If you have 20 KMIP Adapters, and you want to retrieve only the first 5 adapters, use
   * `../kmip_adapters?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of KMIP adapters to skip. By specifying `offset`, you retrieve a subset of KMIP adapters that starts
   * with the `offset` value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have 20 KMIP Adapters, and you want to retrieve adapters 11 through 15, use
   * `../kmip_adapters?offset=10&amp;limit=5`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the totalCount.
   *
   * If set to `true`, returns `totalCount` in the response metadata for use with pagination. The `totalCount` value
   * returned specifies the total number of kmip adapters that match the request, disregarding limit and offset. The
   * default is set to false. **Usage:** To return the `totalCount` value for use with pagination, use
   * `../kmip_adapters?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
  }
}

