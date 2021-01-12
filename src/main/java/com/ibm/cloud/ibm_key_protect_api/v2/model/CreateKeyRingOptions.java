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
 * The createKeyRing options.
 */
public class CreateKeyRingOptions extends GenericModel {

  protected String keyRingId;
  protected String bluemixInstance;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String keyRingId;
    private String bluemixInstance;
    private String correlationId;

    private Builder(CreateKeyRingOptions createKeyRingOptions) {
      this.keyRingId = createKeyRingOptions.keyRingId;
      this.bluemixInstance = createKeyRingOptions.bluemixInstance;
      this.correlationId = createKeyRingOptions.correlationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param keyRingId the keyRingId
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String keyRingId, String bluemixInstance) {
      this.keyRingId = keyRingId;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a CreateKeyRingOptions.
     *
     * @return the new CreateKeyRingOptions instance
     */
    public CreateKeyRingOptions build() {
      return new CreateKeyRingOptions(this);
    }

    /**
     * Set the keyRingId.
     *
     * @param keyRingId the keyRingId
     * @return the CreateKeyRingOptions builder
     */
    public Builder keyRingId(String keyRingId) {
      this.keyRingId = keyRingId;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the CreateKeyRingOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the CreateKeyRingOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }
  }

  protected CreateKeyRingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.keyRingId,
            "keyRingId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
            "bluemixInstance cannot be null");
    keyRingId = builder.keyRingId;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
  }

  /**
   * New builder.
   *
   * @return a CreateKeyRingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the keyRingId.
   *
   * The ID that identifies the key ring. Each ID is unique only within the given instance and is not reserved across
   * the Key Protect service.
   *
   * @return the keyRingId
   */
  public String keyRingId() {
    return keyRingId;
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

