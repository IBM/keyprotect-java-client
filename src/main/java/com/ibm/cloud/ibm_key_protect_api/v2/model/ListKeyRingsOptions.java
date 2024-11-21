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
 * The listKeyRings options.
 */
public class ListKeyRingsOptions extends GenericModel {

  protected String bluemixInstance;
  protected Long limit;
  protected Long offset;
  protected Boolean totalCount;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private Long limit;
    private Long offset;
    private Boolean totalCount;
    private String correlationId;

    /**
     * Instantiates a new Builder from an existing ListKeyRingsOptions instance.
     *
     * @param listKeyRingsOptions the instance to initialize the Builder with
     */
    private Builder(ListKeyRingsOptions listKeyRingsOptions) {
      this.bluemixInstance = listKeyRingsOptions.bluemixInstance;
      this.limit = listKeyRingsOptions.limit;
      this.offset = listKeyRingsOptions.offset;
      this.totalCount = listKeyRingsOptions.totalCount;
      this.correlationId = listKeyRingsOptions.correlationId;
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
     * Builds a ListKeyRingsOptions.
     *
     * @return the new ListKeyRingsOptions instance
     */
    public ListKeyRingsOptions build() {
      return new ListKeyRingsOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the ListKeyRingsOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListKeyRingsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListKeyRingsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the ListKeyRingsOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the ListKeyRingsOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }
  }

  protected ListKeyRingsOptions() { }

  protected ListKeyRingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    limit = builder.limit;
    offset = builder.offset;
    totalCount = builder.totalCount;
    correlationId = builder.correlationId;
  }

  /**
   * New builder.
   *
   * @return a ListKeyRingsOptions builder
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
   * Gets the limit.
   *
   * The number of key rings to retrieve. By default, `GET /key_rings` returns  100 key rings including the default key
   * ring. To retrieve a different set of key rings, use `limit` with `offset` to page through your available resources.
   * The maximum value for `limit` is 5,000.
   * **Usage:** If you have 20 key rings in your instance, and you want to retrieve only the first 5 key rings, use
   * `../key_rings?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of key rings to skip. By specifying `offset`, you retrieve a subset of key rings that starts with the
   * `offset` value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have 20 key rings in your instance, and you want to retrieve keys 10 through 20, use
   * `../keys?offset=10&amp;limit=10`.
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
   * returned specifies the total number of key rings that match the request, disregarding limit and offset. The default
   * is set to false.
   * **Usage:** To return the `totalCount` value for use with pagination, use `../key_rings?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
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
}

