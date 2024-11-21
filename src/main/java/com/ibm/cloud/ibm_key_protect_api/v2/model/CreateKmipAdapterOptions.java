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
 * The createKmipAdapter options.
 */
public class CreateKmipAdapterOptions extends GenericModel {

  protected String bluemixInstance;
  protected CollectionMetadata metadata;
  protected List<CreateKMIPAdapterRequestBodyResources> resources;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private CollectionMetadata metadata;
    private List<CreateKMIPAdapterRequestBodyResources> resources;
    private String correlationId;

    /**
     * Instantiates a new Builder from an existing CreateKmipAdapterOptions instance.
     *
     * @param createKmipAdapterOptions the instance to initialize the Builder with
     */
    private Builder(CreateKmipAdapterOptions createKmipAdapterOptions) {
      this.bluemixInstance = createKmipAdapterOptions.bluemixInstance;
      this.metadata = createKmipAdapterOptions.metadata;
      this.resources = createKmipAdapterOptions.resources;
      this.correlationId = createKmipAdapterOptions.correlationId;
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
     * @param metadata the metadata
     * @param resources the resources
     */
    public Builder(String bluemixInstance, CollectionMetadata metadata, List<CreateKMIPAdapterRequestBodyResources> resources) {
      this.bluemixInstance = bluemixInstance;
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a CreateKmipAdapterOptions.
     *
     * @return the new CreateKmipAdapterOptions instance
     */
    public CreateKmipAdapterOptions build() {
      return new CreateKmipAdapterOptions(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the CreateKmipAdapterOptions builder
     */
    public Builder addResources(CreateKMIPAdapterRequestBodyResources resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<CreateKMIPAdapterRequestBodyResources>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the CreateKmipAdapterOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateKmipAdapterOptions builder
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
     * @return the CreateKmipAdapterOptions builder
     */
    public Builder resources(List<CreateKMIPAdapterRequestBodyResources> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the CreateKmipAdapterOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }
  }

  protected CreateKmipAdapterOptions() { }

  protected CreateKmipAdapterOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.metadata,
      "metadata cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    bluemixInstance = builder.bluemixInstance;
    metadata = builder.metadata;
    resources = builder.resources;
    correlationId = builder.correlationId;
  }

  /**
   * New builder.
   *
   * @return a CreateKmipAdapterOptions builder
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
  public List<CreateKMIPAdapterRequestBodyResources> resources() {
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

