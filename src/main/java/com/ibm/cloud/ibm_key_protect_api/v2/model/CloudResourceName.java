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
 * The object that contains information about the Cloud Resource Name.
 */
public class CloudResourceName extends GenericModel {

  protected String resourceCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String resourceCrn;

    private Builder(CloudResourceName cloudResourceName) {
      this.resourceCrn = cloudResourceName.resourceCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CloudResourceName.
     *
     * @return the new CloudResourceName instance
     */
    public CloudResourceName build() {
      return new CloudResourceName(this);
    }

    /**
     * Set the resourceCrn.
     *
     * @param resourceCrn the resourceCrn
     * @return the CloudResourceName builder
     */
    public Builder resourceCrn(String resourceCrn) {
      this.resourceCrn = resourceCrn;
      return this;
    }
  }

  protected CloudResourceName(Builder builder) {
    resourceCrn = builder.resourceCrn;
  }

  /**
   * New builder.
   *
   * @return a CloudResourceName builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resourceCrn.
   *
   * The [Cloud Resource Name](https://cloud.ibm.com/docs/overview?topic=overview-crn) (CRN) that uniquely identifies
   * your cloud resources.
   *
   * @return the resourceCrn
   */
  public String resourceCrn() {
    return resourceCrn;
  }
}

