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
 * The listKeyRings options.
 */
public class ListKeyRingsOptions extends GenericModel {

  protected String bluemixInstance;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;

    private Builder(ListKeyRingsOptions listKeyRingsOptions) {
      this.bluemixInstance = listKeyRingsOptions.bluemixInstance;
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

  protected ListKeyRingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
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

