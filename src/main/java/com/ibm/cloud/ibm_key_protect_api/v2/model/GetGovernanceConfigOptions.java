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
 * The getGovernanceConfig options.
 */
public class GetGovernanceConfigOptions extends GenericModel {

  /**
   * The resource kind matching the resource request.
   */
  public interface ResourceKind {
    /** instance. */
    String INSTANCE = "instance";
    /** key. */
    String KEY = "key";
  }

  protected String configRequestId;
  protected String accountId;
  protected String resourceKind;
  protected String serviceInstanceCrn;
  protected String resourceGroupId;
  protected String transactionId;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String configRequestId;
    private String accountId;
    private String resourceKind;
    private String serviceInstanceCrn;
    private String resourceGroupId;
    private String transactionId;
    private Long limit;
    private Long offset;

    /**
     * Instantiates a new Builder from an existing GetGovernanceConfigOptions instance.
     *
     * @param getGovernanceConfigOptions the instance to initialize the Builder with
     */
    private Builder(GetGovernanceConfigOptions getGovernanceConfigOptions) {
      this.configRequestId = getGovernanceConfigOptions.configRequestId;
      this.accountId = getGovernanceConfigOptions.accountId;
      this.resourceKind = getGovernanceConfigOptions.resourceKind;
      this.serviceInstanceCrn = getGovernanceConfigOptions.serviceInstanceCrn;
      this.resourceGroupId = getGovernanceConfigOptions.resourceGroupId;
      this.transactionId = getGovernanceConfigOptions.transactionId;
      this.limit = getGovernanceConfigOptions.limit;
      this.offset = getGovernanceConfigOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param configRequestId the configRequestId
     * @param accountId the accountId
     * @param resourceKind the resourceKind
     * @param serviceInstanceCrn the serviceInstanceCrn
     * @param resourceGroupId the resourceGroupId
     */
    public Builder(String configRequestId, String accountId, String resourceKind, String serviceInstanceCrn, String resourceGroupId) {
      this.configRequestId = configRequestId;
      this.accountId = accountId;
      this.resourceKind = resourceKind;
      this.serviceInstanceCrn = serviceInstanceCrn;
      this.resourceGroupId = resourceGroupId;
    }

    /**
     * Builds a GetGovernanceConfigOptions.
     *
     * @return the new GetGovernanceConfigOptions instance
     */
    public GetGovernanceConfigOptions build() {
      return new GetGovernanceConfigOptions(this);
    }

    /**
     * Set the configRequestId.
     *
     * @param configRequestId the configRequestId
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder configRequestId(String configRequestId) {
      this.configRequestId = configRequestId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the resourceKind.
     *
     * @param resourceKind the resourceKind
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder resourceKind(String resourceKind) {
      this.resourceKind = resourceKind;
      return this;
    }

    /**
     * Set the serviceInstanceCrn.
     *
     * @param serviceInstanceCrn the serviceInstanceCrn
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder serviceInstanceCrn(String serviceInstanceCrn) {
      this.serviceInstanceCrn = serviceInstanceCrn;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetGovernanceConfigOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected GetGovernanceConfigOptions() { }

  protected GetGovernanceConfigOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.configRequestId,
      "configRequestId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceKind,
      "resourceKind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceInstanceCrn,
      "serviceInstanceCrn cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceGroupId,
      "resourceGroupId cannot be null");
    configRequestId = builder.configRequestId;
    accountId = builder.accountId;
    resourceKind = builder.resourceKind;
    serviceInstanceCrn = builder.serviceInstanceCrn;
    resourceGroupId = builder.resourceGroupId;
    transactionId = builder.transactionId;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a GetGovernanceConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the configRequestId.
   *
   * Unique identifier for this request and any related pagination. requests.
   *
   * @return the configRequestId
   */
  public String configRequestId() {
    return configRequestId;
  }

  /**
   * Gets the accountId.
   *
   * ID of account that requested instance belongs to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the resourceKind.
   *
   * The resource kind matching the resource request.
   *
   * @return the resourceKind
   */
  public String resourceKind() {
    return resourceKind;
  }

  /**
   * Gets the serviceInstanceCrn.
   *
   * CRN of service instance in which the requested configurations reside.
   *
   * @return the serviceInstanceCrn
   */
  public String serviceInstanceCrn() {
    return serviceInstanceCrn;
  }

  /**
   * Gets the resourceGroupId.
   *
   * ID of resource group in which service instance resides. Key Protect will not validate this value.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the transactionId.
   *
   * Unique v4 UUID identifier for each REST request. Allows service provider to trace incoming requests. Equivalent to
   * `Correlation-Id`.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the limit.
   *
   * The number of keys to retrieve. By default, `GET /keys` returns the first 200 keys. To retrieve a different set of
   * keys, use `limit` with `offset` to page through your available resources. The maximum value for `limit` is 5,000.
   * **Usage:** If you have 20 keys in your instance, and you want to retrieve only the first 5 keys, use
   * `../keys?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of keys to skip. By specifying `offset`, you retrieve a subset of keys that starts with the `offset`
   * value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have 100 keys in your instance, and you want to retrieve keys 26 through 50, use
   * `../keys?offset=25&amp;limit=25`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }
}

