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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Data associated with the automatic key rotation policy.
 */
public class KeyPolicyRotationRotation extends GenericModel {

  protected Boolean enabled;
  @SerializedName("interval_month")
  protected Long intervalMonth;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private Long intervalMonth;

    /**
     * Instantiates a new Builder from an existing KeyPolicyRotationRotation instance.
     *
     * @param keyPolicyRotationRotation the instance to initialize the Builder with
     */
    private Builder(KeyPolicyRotationRotation keyPolicyRotationRotation) {
      this.enabled = keyPolicyRotationRotation.enabled;
      this.intervalMonth = keyPolicyRotationRotation.intervalMonth;
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
     * Builds a KeyPolicyRotationRotation.
     *
     * @return the new KeyPolicyRotationRotation instance
     */
    public KeyPolicyRotationRotation build() {
      return new KeyPolicyRotationRotation(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the KeyPolicyRotationRotation builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the intervalMonth.
     *
     * @param intervalMonth the intervalMonth
     * @return the KeyPolicyRotationRotation builder
     */
    public Builder intervalMonth(long intervalMonth) {
      this.intervalMonth = intervalMonth;
      return this;
    }
  }

  protected KeyPolicyRotationRotation() { }

  protected KeyPolicyRotationRotation(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
    intervalMonth = builder.intervalMonth;
  }

  /**
   * New builder.
   *
   * @return a KeyPolicyRotationRotation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect enables a rotation policy on a single key.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the intervalMonth.
   *
   * Specifies the key rotation time interval in approximate months standardized to 30 days each. A minimum of 1 and a
   * maximum of 12 can be set.
   *
   * @return the intervalMonth
   */
  public Long intervalMonth() {
    return intervalMonth;
  }
}

