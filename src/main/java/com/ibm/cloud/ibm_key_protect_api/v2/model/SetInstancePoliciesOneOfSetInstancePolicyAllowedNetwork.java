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
 * Properties that are associated with setting an instance level allowed network policy.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork extends SetInstancePoliciesOneOf {


  /**
   * Builder.
   */
  public static class Builder {
    private CollectionMetadata metadata;
    private List<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem> resources;

    /**
     * Instantiates a new Builder from an existing SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork instance.
     *
     * @param setInstancePoliciesOneOfSetInstancePolicyAllowedNetwork the instance to initialize the Builder with
     */
    public Builder(SetInstancePoliciesOneOf setInstancePoliciesOneOfSetInstancePolicyAllowedNetwork) {
      this.metadata = setInstancePoliciesOneOfSetInstancePolicyAllowedNetwork.metadata;
      this.resources = setInstancePoliciesOneOfSetInstancePolicyAllowedNetwork.resources;
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
    public Builder(CollectionMetadata metadata, List<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem> resources) {
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork.
     *
     * @return the new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork instance
     */
    public SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork build() {
      return new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork builder
     */
    public Builder addResources(SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork builder
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
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork builder
     */
    public Builder resources(List<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork() { }

  protected SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork(Builder builder) {
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
   * @return a SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

