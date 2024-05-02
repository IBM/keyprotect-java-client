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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addKmipClientCertificate options.
 */
public class AddKmipClientCertificateOptions extends GenericModel {

  protected String bluemixInstance;
  protected String adapterId;
  protected CollectionMetadata metadata;
  protected List<CreateKMIPClientCertificateObject> resources;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String adapterId;
    private CollectionMetadata metadata;
    private List<CreateKMIPClientCertificateObject> resources;
    private String correlationId;

    /**
     * Instantiates a new Builder from an existing AddKmipClientCertificateOptions instance.
     *
     * @param addKmipClientCertificateOptions the instance to initialize the Builder with
     */
    private Builder(AddKmipClientCertificateOptions addKmipClientCertificateOptions) {
      this.bluemixInstance = addKmipClientCertificateOptions.bluemixInstance;
      this.adapterId = addKmipClientCertificateOptions.adapterId;
      this.metadata = addKmipClientCertificateOptions.metadata;
      this.resources = addKmipClientCertificateOptions.resources;
      this.correlationId = addKmipClientCertificateOptions.correlationId;
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
     * @param metadata the metadata
     * @param resources the resources
     */
    public Builder(String bluemixInstance, String adapterId, CollectionMetadata metadata, List<CreateKMIPClientCertificateObject> resources) {
      this.bluemixInstance = bluemixInstance;
      this.adapterId = adapterId;
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a AddKmipClientCertificateOptions.
     *
     * @return the new AddKmipClientCertificateOptions instance
     */
    public AddKmipClientCertificateOptions build() {
      return new AddKmipClientCertificateOptions(this);
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the AddKmipClientCertificateOptions builder
     */
    public Builder addResources(CreateKMIPClientCertificateObject resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<CreateKMIPClientCertificateObject>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the AddKmipClientCertificateOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the adapterId.
     *
     * @param adapterId the adapterId
     * @return the AddKmipClientCertificateOptions builder
     */
    public Builder adapterId(String adapterId) {
      this.adapterId = adapterId;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the AddKmipClientCertificateOptions builder
     */
    public Builder metadata(CollectionMetadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the AddKmipClientCertificateOptions builder
     */
    public Builder resources(List<CreateKMIPClientCertificateObject> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the AddKmipClientCertificateOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }
  }

  protected AddKmipClientCertificateOptions() { }

  protected AddKmipClientCertificateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.adapterId,
      "adapterId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.metadata,
      "metadata cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    bluemixInstance = builder.bluemixInstance;
    adapterId = builder.adapterId;
    metadata = builder.metadata;
    resources = builder.resources;
    correlationId = builder.correlationId;
  }

  /**
   * New builder.
   *
   * @return a AddKmipClientCertificateOptions builder
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
   * Gets the metadata.
   *
   * The metadata that describes the resource array.
   *
   * @return the metadata
   */
  public CollectionMetadata metadata() {
    return metadata;
  }

  /**
   * Gets the resources.
   *
   * A collection of resources.
   *
   * @return the resources
   */
  public List<CreateKMIPClientCertificateObject> resources() {
    return resources;
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

