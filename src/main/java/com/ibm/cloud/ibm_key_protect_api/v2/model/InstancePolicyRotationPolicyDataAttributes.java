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
 * Attributes of a `rotation` instance policy. Must be provided if the `enabled` field is `true`. Cannot be provided if
 * the `enabled` field is `false`.
 */
public class InstancePolicyRotationPolicyDataAttributes extends GenericModel {

  @SerializedName("interval_month")
  protected Long intervalMonth;

  /**
   * Builder.
   */
  public static class Builder {
    private Long intervalMonth;

    /**
     * Instantiates a new Builder from an existing InstancePolicyRotationPolicyDataAttributes instance.
     *
     * @param instancePolicyRotationPolicyDataAttributes the instance to initialize the Builder with
     */
    private Builder(InstancePolicyRotationPolicyDataAttributes instancePolicyRotationPolicyDataAttributes) {
      this.intervalMonth = instancePolicyRotationPolicyDataAttributes.intervalMonth;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a InstancePolicyRotationPolicyDataAttributes.
     *
     * @return the new InstancePolicyRotationPolicyDataAttributes instance
     */
    public InstancePolicyRotationPolicyDataAttributes build() {
      return new InstancePolicyRotationPolicyDataAttributes(this);
    }

    /**
     * Set the intervalMonth.
     *
     * @param intervalMonth the intervalMonth
     * @return the InstancePolicyRotationPolicyDataAttributes builder
     */
    public Builder intervalMonth(long intervalMonth) {
      this.intervalMonth = intervalMonth;
      return this;
    }
  }

  protected InstancePolicyRotationPolicyDataAttributes() { }

  protected InstancePolicyRotationPolicyDataAttributes(Builder builder) {
    intervalMonth = builder.intervalMonth;
  }

  /**
   * New builder.
   *
   * @return a InstancePolicyRotationPolicyDataAttributes builder
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

