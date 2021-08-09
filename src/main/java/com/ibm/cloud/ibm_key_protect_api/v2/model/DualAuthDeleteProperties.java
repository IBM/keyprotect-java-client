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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * User defined metadata that is associated with the `dualAuthDelete` instance policy type.
 */
public class DualAuthDeleteProperties extends GenericModel {

  protected Boolean enabled;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;

    private Builder(DualAuthDeleteProperties dualAuthDeleteProperties) {
      this.enabled = dualAuthDeleteProperties.enabled;
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
     * Builds a DualAuthDeleteProperties.
     *
     * @return the new DualAuthDeleteProperties instance
     */
    public DualAuthDeleteProperties build() {
      return new DualAuthDeleteProperties(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the DualAuthDeleteProperties builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }
  }

  protected DualAuthDeleteProperties(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
  }

  /**
   * New builder.
   *
   * @return a DualAuthDeleteProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect enables a dual authorization deletion policy for your service instance.
   *
   * By default, Key Protect requires only one authorization to delete a key. After you enable a dual authorization
   * policy, any new key that you create or add to the instance will require an authorization from two users to delete
   * keys.
   *
   * **Note:** This change does not affect existing keys in your instance.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }
}

