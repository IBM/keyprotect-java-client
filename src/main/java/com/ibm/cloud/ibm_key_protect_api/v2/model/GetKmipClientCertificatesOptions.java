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
 * The getKmipClientCertificates options.
 */
public class GetKmipClientCertificatesOptions extends GenericModel {

  protected String bluemixInstance;
  protected String adapterId;
  protected String correlationId;
  protected Long limit;
  protected Long offset;
  protected Boolean totalCount;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String adapterId;
    private String correlationId;
    private Long limit;
    private Long offset;
    private Boolean totalCount;

    /**
     * Instantiates a new Builder from an existing GetKmipClientCertificatesOptions instance.
     *
     * @param getKmipClientCertificatesOptions the instance to initialize the Builder with
     */
    private Builder(GetKmipClientCertificatesOptions getKmipClientCertificatesOptions) {
      this.bluemixInstance = getKmipClientCertificatesOptions.bluemixInstance;
      this.adapterId = getKmipClientCertificatesOptions.adapterId;
      this.correlationId = getKmipClientCertificatesOptions.correlationId;
      this.limit = getKmipClientCertificatesOptions.limit;
      this.offset = getKmipClientCertificatesOptions.offset;
      this.totalCount = getKmipClientCertificatesOptions.totalCount;
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
     * @param adapterId the adapterId
     */
    public Builder(String bluemixInstance, String adapterId) {
      this.bluemixInstance = bluemixInstance;
      this.adapterId = adapterId;
    }

    /**
     * Builds a GetKmipClientCertificatesOptions.
     *
     * @return the new GetKmipClientCertificatesOptions instance
     */
    public GetKmipClientCertificatesOptions build() {
      return new GetKmipClientCertificatesOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetKmipClientCertificatesOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the adapterId.
     *
     * @param adapterId the adapterId
     * @return the GetKmipClientCertificatesOptions builder
     */
    public Builder adapterId(String adapterId) {
      this.adapterId = adapterId;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKmipClientCertificatesOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetKmipClientCertificatesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetKmipClientCertificatesOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the GetKmipClientCertificatesOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }
  }

  protected GetKmipClientCertificatesOptions() { }

  protected GetKmipClientCertificatesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.adapterId,
      "adapterId cannot be empty");
    bluemixInstance = builder.bluemixInstance;
    adapterId = builder.adapterId;
    correlationId = builder.correlationId;
    limit = builder.limit;
    offset = builder.offset;
    totalCount = builder.totalCount;
  }

  /**
   * New builder.
   *
   * @return a GetKmipClientCertificatesOptions builder
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
   * Gets the adapterId.
   *
   * The name or v4 UUID of the KMIP Adapter that uniquely identifies it.
   *
   * @return the adapterId
   */
  public String adapterId() {
    return adapterId;
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
   * The number of KMIP Certificates to retrieve. By default, `GET /kmip_adapters/{id}/certificates` returns the first
   * 100 KMIP Certificates. To retrieve a different set of certificates, use `limit` with `offset` to page through your
   * available resources. The maximum value for `limit` is 200.
   * **Usage:** If you have 20 KMIP certificates associated with your KMIP adapter, and you want to retrieve only the
   * first 5 certificates, use `../kmip_adapters/{id}/certificates?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of KMIP Adapters to skip. By specifying `offset`, you retrieve a subset of certificates that starts with
   * the `offset` value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have 20 certificates associated with your KMIP adapter, and you want to retrieve certificates 11
   * through 15, use `../kmip_adapters/{id}/certificates?offset=10&amp;limit=5`.
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
   * default is set to false.
   * **Usage:** To return the `totalCount` value for use with pagination, use
   * `../kmip_adapters/{id}/certificates?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
  }
}

