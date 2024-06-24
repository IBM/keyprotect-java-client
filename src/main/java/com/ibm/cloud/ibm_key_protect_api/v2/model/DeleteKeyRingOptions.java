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
 * The deleteKeyRing options.
 */
public class DeleteKeyRingOptions extends GenericModel {

  protected String keyRingId;
  protected String bluemixInstance;
  protected String correlationId;
  protected Boolean force;

  /**
   * Builder.
   */
  public static class Builder {
    private String keyRingId;
    private String bluemixInstance;
    private String correlationId;
    private Boolean force;

    /**
     * Instantiates a new Builder from an existing DeleteKeyRingOptions instance.
     *
     * @param deleteKeyRingOptions the instance to initialize the Builder with
     */
    private Builder(DeleteKeyRingOptions deleteKeyRingOptions) {
      this.keyRingId = deleteKeyRingOptions.keyRingId;
      this.bluemixInstance = deleteKeyRingOptions.bluemixInstance;
      this.correlationId = deleteKeyRingOptions.correlationId;
      this.force = deleteKeyRingOptions.force;
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
     * Builds a DeleteKeyRingOptions.
     *
     * @return the new DeleteKeyRingOptions instance
     */
    public DeleteKeyRingOptions build() {
      return new DeleteKeyRingOptions(this);
    }

    /**
     * Set the keyRingId.
     *
     * @param keyRingId the keyRingId
     * @return the DeleteKeyRingOptions builder
     */
    public Builder keyRingId(String keyRingId) {
      this.keyRingId = keyRingId;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the DeleteKeyRingOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the DeleteKeyRingOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the DeleteKeyRingOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected DeleteKeyRingOptions() { }

  protected DeleteKeyRingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.keyRingId,
      "keyRingId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    keyRingId = builder.keyRingId;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a DeleteKeyRingOptions builder
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

  /**
   * Gets the force.
   *
   * Force delete the key ring. All keys in the key ring are required to be deleted (in state `5`) before this action
   * can be performed.  If the key ring to be deleted contains keys, they will be moved to the `default` key ring which
   * requires the `kms.secrets.patch` IAM action.
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}

