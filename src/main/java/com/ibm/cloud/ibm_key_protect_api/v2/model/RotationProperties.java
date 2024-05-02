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
 * Data associated with the policy type `rotation`.
 */
public class RotationProperties extends GenericModel {

  @SerializedName("interval_month")
  protected Long intervalMonth;

  /**
   * Builder.
   */
  public static class Builder {
    private Long intervalMonth;

    /**
     * Instantiates a new Builder from an existing RotationProperties instance.
     *
     * @param rotationProperties the instance to initialize the Builder with
     */
    private Builder(RotationProperties rotationProperties) {
      this.intervalMonth = rotationProperties.intervalMonth;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RotationProperties.
     *
     * @return the new RotationProperties instance
     */
    public RotationProperties build() {
      return new RotationProperties(this);
    }

    /**
     * Set the intervalMonth.
     *
     * @param intervalMonth the intervalMonth
     * @return the RotationProperties builder
     */
    public Builder intervalMonth(long intervalMonth) {
      this.intervalMonth = intervalMonth;
      return this;
    }
  }

  protected RotationProperties() { }

  protected RotationProperties(Builder builder) {
    intervalMonth = builder.intervalMonth;
  }

  /**
   * New builder.
   *
   * @return a RotationProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the intervalMonth.
   *
   * Specifies the key rotation time interval in approximate months, where a month is equivalent to 30 days. A minimum
   * of 1 and a maximum of 12 can be set.
   *
   * @return the intervalMonth
   */
  public Long intervalMonth() {
    return intervalMonth;
  }
}

