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
 * The schema for the resources object in the body of a create Migration Intent.
 */
public class CreateMigrationIntentObject extends GenericModel {

  @SerializedName("targetCRK")
  protected String targetCrk;

  /**
   * Builder.
   */
  public static class Builder {
    private String targetCrk;

    /**
     * Instantiates a new Builder from an existing CreateMigrationIntentObject instance.
     *
     * @param createMigrationIntentObject the instance to initialize the Builder with
     */
    private Builder(CreateMigrationIntentObject createMigrationIntentObject) {
      this.targetCrk = createMigrationIntentObject.targetCrk;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param targetCrk the targetCrk
     */
    public Builder(String targetCrk) {
      this.targetCrk = targetCrk;
    }

    /**
     * Builds a CreateMigrationIntentObject.
     *
     * @return the new CreateMigrationIntentObject instance
     */
    public CreateMigrationIntentObject build() {
      return new CreateMigrationIntentObject(this);
    }

    /**
     * Set the targetCrk.
     *
     * @param targetCrk the targetCrk
     * @return the CreateMigrationIntentObject builder
     */
    public Builder targetCrk(String targetCrk) {
      this.targetCrk = targetCrk;
      return this;
    }
  }

  protected CreateMigrationIntentObject() { }

  protected CreateMigrationIntentObject(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.targetCrk,
      "targetCrk cannot be null");
    targetCrk = builder.targetCrk;
  }

  /**
   * New builder.
   *
   * @return a CreateMigrationIntentObject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the targetCrk.
   *
   * The CRN of the Customer Root Key (CRK) which is the target of the migration.
   *
   * @return the targetCrk
   */
  public String targetCrk() {
    return targetCrk;
  }
}

