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

import java.util.ArrayList;
import java.util.List;

/**
 * Base schema for request of create/update of key level dual authorization delete policy.
 */
public class SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete extends SetKeyPoliciesOneOf {


  /**
   * Builder.
   */
  public static class Builder {
    private CollectionMetadata metadata;
    private List<KeyPolicyDualAuthDelete> resources;

    public Builder(SetKeyPoliciesOneOf setKeyPoliciesOneOfSetKeyPolicyDualAuthDelete) {
      this.metadata = setKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.metadata;
      this.resources = setKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.resources;
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
    public Builder(CollectionMetadata metadata, List<KeyPolicyDualAuthDelete> resources) {
      this.metadata = metadata;
      this.resources = resources;
    }

    /**
     * Builds a SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.
     *
     * @return the new SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete instance
     */
    public SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete build() {
      return new SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete(this);
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete builder
     */
    public Builder addResources(KeyPolicyDualAuthDelete resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<KeyPolicyDualAuthDelete>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete builder
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
     * @return the SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete builder
     */
    public Builder resources(List<KeyPolicyDualAuthDelete> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete(Builder builder) {
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
   * @return a SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

