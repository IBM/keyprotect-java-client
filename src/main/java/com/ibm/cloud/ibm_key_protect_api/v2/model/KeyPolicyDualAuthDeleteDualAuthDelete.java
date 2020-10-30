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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Data associated with the dual authorization delete policy.
 */
public class KeyPolicyDualAuthDeleteDualAuthDelete extends GenericModel {

  protected Boolean enabled;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;

    private Builder(KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDelete) {
      this.enabled = keyPolicyDualAuthDeleteDualAuthDelete.enabled;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enabled the enabled
     */
    public Builder(Boolean enabled) {
      this.enabled = enabled;
    }

    /**
     * Builds a KeyPolicyDualAuthDeleteDualAuthDelete.
     *
     * @return the new KeyPolicyDualAuthDeleteDualAuthDelete instance
     */
    public KeyPolicyDualAuthDeleteDualAuthDelete build() {
      return new KeyPolicyDualAuthDeleteDualAuthDelete(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the KeyPolicyDualAuthDeleteDualAuthDelete builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }
  }

  protected KeyPolicyDualAuthDeleteDualAuthDelete(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
  }

  /**
   * New builder.
   *
   * @return a KeyPolicyDualAuthDeleteDualAuthDelete builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect enables a dual authorization policy on a single key.
   *    After you enable the policy, Key Protect requires an authorization from two users to delete this key.  For
   * example, you can authorize the deletion first by using the [SetKeyForDeletion](#invoke-an-action-on-a-key)  action.
   * Then, a different user provides a second authorization implicitly by calling `DELETE /keys` to  delete the key.
   * **Note:** Once the dual authorization policy is set on the key, it cannot be reverted.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }
}

