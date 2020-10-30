/*
 * (C) Copyright IBM Corp. 2020.
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
 * Properties that are associated with setting any type of instance level policy.
 */
public class SetInstancePoliciesOneOfSetMultipleInstancePolicies extends SetInstancePoliciesOneOf {


  /**
   * Builder.
   */
  public static class Builder {
    private CollectionMetadata metadata;
    private List<SetMultipleInstancePoliciesResourcesItem> resources;

    public Builder(SetInstancePoliciesOneOf setInstancePoliciesOneOfSetMultipleInstancePolicies) {
      this.metadata = setInstancePoliciesOneOfSetMultipleInstancePolicies.metadata;
      this.resources = setInstancePoliciesOneOfSetMultipleInstancePolicies.resources;
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
    public Builder(CollectionMetadata metadata, List<SetMultipleInstancePoliciesResourcesItem> resources) {
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a SetInstancePoliciesOneOfSetMultipleInstancePolicies.
     *
     * @return the new SetInstancePoliciesOneOfSetMultipleInstancePolicies instance
     */
    public SetInstancePoliciesOneOfSetMultipleInstancePolicies build() {
      return new SetInstancePoliciesOneOfSetMultipleInstancePolicies(this);
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the SetInstancePoliciesOneOfSetMultipleInstancePolicies builder
     */
    public Builder addResources(SetMultipleInstancePoliciesResourcesItem resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<SetMultipleInstancePoliciesResourcesItem>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SetInstancePoliciesOneOfSetMultipleInstancePolicies builder
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
     * @return the SetInstancePoliciesOneOfSetMultipleInstancePolicies builder
     */
    public Builder resources(List<SetMultipleInstancePoliciesResourcesItem> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected SetInstancePoliciesOneOfSetMultipleInstancePolicies(Builder builder) {
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
   * @return a SetInstancePoliciesOneOfSetMultipleInstancePolicies builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

