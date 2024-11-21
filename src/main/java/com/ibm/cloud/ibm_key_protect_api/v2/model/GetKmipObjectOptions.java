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
 * The getKmipObject options.
 */
public class GetKmipObjectOptions extends GenericModel {

  protected String adapterId;
  protected String bluemixInstance;
  protected String id;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String adapterId;
    private String bluemixInstance;
    private String id;
    private String correlationId;

    /**
     * Instantiates a new Builder from an existing GetKmipObjectOptions instance.
     *
     * @param getKmipObjectOptions the instance to initialize the Builder with
     */
    private Builder(GetKmipObjectOptions getKmipObjectOptions) {
      this.adapterId = getKmipObjectOptions.adapterId;
      this.bluemixInstance = getKmipObjectOptions.bluemixInstance;
      this.id = getKmipObjectOptions.id;
      this.correlationId = getKmipObjectOptions.correlationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param adapterId the adapterId
     * @param bluemixInstance the bluemixInstance
     * @param id the id
     */
    public Builder(String adapterId, String bluemixInstance, String id) {
      this.adapterId = adapterId;
      this.bluemixInstance = bluemixInstance;
      this.id = id;
    }

    /**
     * Builds a GetKmipObjectOptions.
     *
     * @return the new GetKmipObjectOptions instance
     */
    public GetKmipObjectOptions build() {
      return new GetKmipObjectOptions(this);
    }

    /**
     * Set the adapterId.
     *
     * @param adapterId the adapterId
     * @return the GetKmipObjectOptions builder
     */
    public Builder adapterId(String adapterId) {
      this.adapterId = adapterId;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetKmipObjectOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetKmipObjectOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKmipObjectOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }
  }

  protected GetKmipObjectOptions() { }

  protected GetKmipObjectOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.adapterId,
      "adapterId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    adapterId = builder.adapterId;
    bluemixInstance = builder.bluemixInstance;
    id = builder.id;
    correlationId = builder.correlationId;
  }

  /**
   * New builder.
   *
   * @return a GetKmipObjectOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the id.
   *
   * The v4 UUID of the kmip object that uniquely identifies it.
   *
   * @return the id
   */
  public String id() {
    return id;
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

