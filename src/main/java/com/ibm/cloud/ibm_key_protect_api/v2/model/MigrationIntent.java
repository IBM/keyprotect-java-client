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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Migration intent.
 */
public class MigrationIntent extends GenericModel {

  @SerializedName("sourceCRK")
  protected String sourceCrk;
  @SerializedName("targetCRK")
  protected String targetCrk;
  protected Date creationDate;
  protected String createdBy;
  protected String id;

  protected MigrationIntent() { }

  /**
   * Gets the sourceCrk.
   *
   * The full CRN of the CRK which is the source of this Migration Intent.
   *
   * @return the sourceCrk
   */
  public String getSourceCrk() {
    return sourceCrk;
  }

  /**
   * Gets the targetCrk.
   *
   * The full CRN of the CRK which is the target of this Migration Intent.
   *
   * @return the targetCrk
   */
  public String getTargetCrk() {
    return targetCrk;
  }

  /**
   * Gets the creationDate.
   *
   * The date the Migration Intent was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the user that created the Migration Intent.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the id.
   *
   * Internal v4 UUID of the Migration Intent.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}

