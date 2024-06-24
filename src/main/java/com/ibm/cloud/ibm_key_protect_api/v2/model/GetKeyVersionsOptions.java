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
 * The getKeyVersions options.
 */
public class GetKeyVersionsOptions extends GenericModel {

  protected String id;
  protected String bluemixInstance;
  protected String correlationId;
  protected String xKmsKeyRing;
  protected Long limit;
  protected Long offset;
  protected Boolean totalCount;
  protected Boolean allKeyStates;

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
    private Boolean totalCount;
    private Boolean allKeyStates;

    /**
     * Instantiates a new Builder from an existing GetKeyVersionsOptions instance.
     *
     * @param getKeyVersionsOptions the instance to initialize the Builder with
     */
    private Builder(GetKeyVersionsOptions getKeyVersionsOptions) {
      this.id = getKeyVersionsOptions.id;
      this.bluemixInstance = getKeyVersionsOptions.bluemixInstance;
      this.correlationId = getKeyVersionsOptions.correlationId;
      this.xKmsKeyRing = getKeyVersionsOptions.xKmsKeyRing;
      this.limit = getKeyVersionsOptions.limit;
      this.offset = getKeyVersionsOptions.offset;
      this.totalCount = getKeyVersionsOptions.totalCount;
      this.allKeyStates = getKeyVersionsOptions.allKeyStates;
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
     * Builds a GetKeyVersionsOptions.
     *
     * @return the new GetKeyVersionsOptions instance
     */
    public GetKeyVersionsOptions build() {
      return new GetKeyVersionsOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetKeyVersionsOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetKeyVersionsOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKeyVersionsOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the GetKeyVersionsOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetKeyVersionsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetKeyVersionsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the GetKeyVersionsOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    /**
     * Set the allKeyStates.
     *
     * @param allKeyStates the allKeyStates
     * @return the GetKeyVersionsOptions builder
     */
    public Builder allKeyStates(Boolean allKeyStates) {
      this.allKeyStates = allKeyStates;
      return this;
    }
  }

  protected GetKeyVersionsOptions() { }

  protected GetKeyVersionsOptions(Builder builder) {
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
    totalCount = builder.totalCount;
    allKeyStates = builder.allKeyStates;
  }

  /**
   * New builder.
   *
   * @return a GetKeyVersionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The v4 UUID or alias that uniquely identifies the key.
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
   * The number of key versions to retrieve. By default, `GET /versions` returns the first 200 key versions. To retrieve
   * a different set of key versions, use `limit` with `offset` to page through your available resources. The maximum
   * value for `limit` is 5,000.
   * **Usage:** If you have a key with 20 versions in your instance, and you want to retrieve only the first 5 versions,
   * use `../versions?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of key versions to skip. By specifying `offset`, you retrieve a subset of key versions that starts with
   * the `offset` value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have a key with 100 versions in your instance, and you want to retrieve versions 26 through 50,
   * use `../versions?offset=25&amp;limit=25`.
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
   * returned specifies the total number of key versions that match the request, disregarding limit and offset. The
   * default is set to false.
   * **Usage:** To return the `totalCount` value for use with pagination, use `../versions?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
  }

  /**
   * Gets the allKeyStates.
   *
   * If set to `true`, returns the key versions of a key in any state. **Usage:** If you have deleted a key and still
   * want to retrieve its key versions use `../versions?allKeyStates=true`.
   *
   * @return the allKeyStates
   */
  public Boolean allKeyStates() {
    return allKeyStates;
  }
}

