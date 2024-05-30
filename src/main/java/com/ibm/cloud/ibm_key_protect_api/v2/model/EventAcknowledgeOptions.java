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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The eventAcknowledge options.
 */
public class EventAcknowledgeOptions extends GenericModel {

  protected String bluemixInstance;
  protected InputStream eventAcknowledge;
  protected String correlationId;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private InputStream eventAcknowledge;
    private String correlationId;
    private String xKmsKeyRing;

    /**
     * Instantiates a new Builder from an existing EventAcknowledgeOptions instance.
     *
     * @param eventAcknowledgeOptions the instance to initialize the Builder with
     */
    private Builder(EventAcknowledgeOptions eventAcknowledgeOptions) {
      this.bluemixInstance = eventAcknowledgeOptions.bluemixInstance;
      this.eventAcknowledge = eventAcknowledgeOptions.eventAcknowledge;
      this.correlationId = eventAcknowledgeOptions.correlationId;
      this.xKmsKeyRing = eventAcknowledgeOptions.xKmsKeyRing;
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
     * @param eventAcknowledge the eventAcknowledge
     */
    public Builder(String bluemixInstance, InputStream eventAcknowledge) {
      this.bluemixInstance = bluemixInstance;
      this.eventAcknowledge = eventAcknowledge;
    }

    /**
     * Builds a EventAcknowledgeOptions.
     *
     * @return the new EventAcknowledgeOptions instance
     */
    public EventAcknowledgeOptions build() {
      return new EventAcknowledgeOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the EventAcknowledgeOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the eventAcknowledge.
     *
     * @param eventAcknowledge the eventAcknowledge
     * @return the EventAcknowledgeOptions builder
     */
    public Builder eventAcknowledge(InputStream eventAcknowledge) {
      this.eventAcknowledge = eventAcknowledge;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the EventAcknowledgeOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the EventAcknowledgeOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the eventAcknowledge.
     *
     * @param eventAcknowledge the eventAcknowledge
     * @return the EventAcknowledgeOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder eventAcknowledge(File eventAcknowledge) throws FileNotFoundException {
      this.eventAcknowledge = new FileInputStream(eventAcknowledge);
      return this;
    }
  }

  protected EventAcknowledgeOptions() { }

  protected EventAcknowledgeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.eventAcknowledge,
      "eventAcknowledge cannot be null");
    bluemixInstance = builder.bluemixInstance;
    eventAcknowledge = builder.eventAcknowledge;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
  }

  /**
   * New builder.
   *
   * @return a EventAcknowledgeOptions builder
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
   * Gets the eventAcknowledge.
   *
   * The base request for acknowledging a key action events.
   *
   * @return the eventAcknowledge
   */
  public InputStream eventAcknowledge() {
    return eventAcknowledge;
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
   * The ID of the key ring that the specified key belongs to. When the header is not specified,  Key Protect will
   * perform a key ring lookup. For a more optimized request,  specify the key ring on every call. The key ring ID of
   * keys that are created without an  `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
  }
}

