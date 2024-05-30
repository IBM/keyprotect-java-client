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
 * Properties that are associated with setting an instance level allowed IP policy.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyAllowedIP extends SetInstancePoliciesOneOf {


  /**
   * Builder.
   */
  public static class Builder {
    private CollectionMetadata metadata;
    private List<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem> resources;

    /**
     * Instantiates a new Builder from an existing SetInstancePoliciesOneOfSetInstancePolicyAllowedIP instance.
     *
     * @param setInstancePoliciesOneOfSetInstancePolicyAllowedIp the instance to initialize the Builder with
     */
    public Builder(SetInstancePoliciesOneOf setInstancePoliciesOneOfSetInstancePolicyAllowedIp) {
      this.metadata = setInstancePoliciesOneOfSetInstancePolicyAllowedIp.metadata;
      this.resources = setInstancePoliciesOneOfSetInstancePolicyAllowedIp.resources;
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
    public Builder(CollectionMetadata metadata, List<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem> resources) {
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a SetInstancePoliciesOneOfSetInstancePolicyAllowedIP.
     *
     * @return the new SetInstancePoliciesOneOfSetInstancePolicyAllowedIP instance
     */
    public SetInstancePoliciesOneOfSetInstancePolicyAllowedIP build() {
      return new SetInstancePoliciesOneOfSetInstancePolicyAllowedIP(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedIP builder
     */
    public Builder addResources(SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedIP builder
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
     * @return the SetInstancePoliciesOneOfSetInstancePolicyAllowedIP builder
     */
    public Builder resources(List<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected SetInstancePoliciesOneOfSetInstancePolicyAllowedIP() { }

  protected SetInstancePoliciesOneOfSetInstancePolicyAllowedIP(Builder builder) {
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
   * @return a SetInstancePoliciesOneOfSetInstancePolicyAllowedIP builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

