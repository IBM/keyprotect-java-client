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
 * Properties that are associated with setting an instance level rotation policy.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyRotation extends SetInstancePoliciesOneOf {


  /**
   * Builder.
   */
  public static class Builder {
    private CollectionMetadata metadata;
    private List<SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem> resources;

    /**
     * Instantiates a new Builder from an existing SetInstancePoliciesOneOfSetInstancePolicyRotation instance.
     *
     * @param setInstancePoliciesOneOfSetInstancePolicyRotation the instance to initialize the Builder with
     */
    public Builder(SetInstancePoliciesOneOf setInstancePoliciesOneOfSetInstancePolicyRotation) {
      this.metadata = setInstancePoliciesOneOfSetInstancePolicyRotation.metadata;
      this.resources = setInstancePoliciesOneOfSetInstancePolicyRotation.resources;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param metadata the metadata
     * @param resources the resources
     */
    public Builder(CollectionMetadata metadata, List<SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem> resources) {
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a SetInstancePoliciesOneOfSetInstancePolicyRotation.
     *
     * @return the new SetInstancePoliciesOneOfSetInstancePolicyRotation instance
     */
    public SetInstancePoliciesOneOfSetInstancePolicyRotation build() {
      return new SetInstancePoliciesOneOfSetInstancePolicyRotation(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the SetInstancePoliciesOneOfSetInstancePolicyRotation builder
     */
    public Builder addResources(SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SetInstancePoliciesOneOfSetInstancePolicyRotation builder
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
     * @return the SetInstancePoliciesOneOfSetInstancePolicyRotation builder
     */
    public Builder resources(List<SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected SetInstancePoliciesOneOfSetInstancePolicyRotation() { }

  protected SetInstancePoliciesOneOfSetInstancePolicyRotation(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.metadata,
      "metadata cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    metadata = builder.metadata;
    resources = builder.resources;
  }

  /**
   * New builder.
   *
   * @return a SetInstancePoliciesOneOfSetInstancePolicyRotation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

