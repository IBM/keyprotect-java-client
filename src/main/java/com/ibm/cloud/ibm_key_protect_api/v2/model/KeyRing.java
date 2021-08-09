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

import java.util.Date;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Base properties of an instance key ring.
 */
public class KeyRing extends GenericModel {

  protected String id;
  protected Date creationDate;
  protected String createdBy;

  /**
   * Gets the id.
   *
   * An ID that identifies the key ring. Each ID is unique only within the given instance and is not reserved across the
   * Key Protect service.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the creationDate.
   *
   * The date the key ring was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the user that created the key ring.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }
}

