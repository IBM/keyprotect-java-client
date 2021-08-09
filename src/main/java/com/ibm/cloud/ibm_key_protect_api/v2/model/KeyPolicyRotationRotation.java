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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Specifies the key rotation time interval in months, with a minimum of 1, and a maximum of 12.
 */
public class KeyPolicyRotationRotation extends GenericModel {

  @SerializedName("interval_month")
  protected Long intervalMonth;

  /**
   * Builder.
   */
  public static class Builder {
    private Long intervalMonth;

    private Builder(KeyPolicyRotationRotation keyPolicyRotationRotation) {
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
     * @param intervalMonth the intervalMonth
     */
    public Builder(Long intervalMonth) {
      this.intervalMonth = intervalMonth;
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

  protected KeyPolicyRotationRotation(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.intervalMonth,
      "intervalMonth cannot be null");
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
   * Gets the intervalMonth.
   *
   * Specifies the key rotation time interval in months.
   *
   * @return the intervalMonth
   */
  public Long intervalMonth() {
    return intervalMonth;
  }
}

