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

/**
 * The base schema for the request body of deactivate registration.
 */
public class RegistrationActionOneOfDeactivateRegistration extends RegistrationActionOneOf {


  /**
   * Builder.
   */
  public static class Builder {
    private CollectionMetadata metadata;
    private List<CloudResourceName> resources;

    /**
     * Instantiates a new Builder from an existing RegistrationActionOneOfDeactivateRegistration instance.
     *
     * @param registrationActionOneOfDeactivateRegistration the instance to initialize the Builder with
     */
    public Builder(RegistrationActionOneOf registrationActionOneOfDeactivateRegistration) {
      this.metadata = registrationActionOneOfDeactivateRegistration.metadata;
      this.resources = registrationActionOneOfDeactivateRegistration.resources;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RegistrationActionOneOfDeactivateRegistration.
     *
     * @return the new RegistrationActionOneOfDeactivateRegistration instance
     */
    public RegistrationActionOneOfDeactivateRegistration build() {
      return new RegistrationActionOneOfDeactivateRegistration(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the RegistrationActionOneOfDeactivateRegistration builder
     */
    public Builder addResources(CloudResourceName resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<CloudResourceName>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the RegistrationActionOneOfDeactivateRegistration builder
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
     * @return the RegistrationActionOneOfDeactivateRegistration builder
     */
    public Builder resources(List<CloudResourceName> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected RegistrationActionOneOfDeactivateRegistration() { }

  protected RegistrationActionOneOfDeactivateRegistration(Builder builder) {
    metadata = builder.metadata;
    resources = builder.resources;
  }

  /**
   * New builder.
   *
   * @return a RegistrationActionOneOfDeactivateRegistration builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

