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

import java.util.Date;

/**
 * Properties associated with an alias.
 */
public class KeyAliasResource extends GenericModel {

  protected String keyId;
  protected String alias;
  protected String createdBy;
  protected Date creationDate;

  /**
   * Gets the keyId.
   *
   * The ID that identifies the key that is associated with the alias.
   *
   * @return the keyId
   */
  public String getKeyId() {
    return keyId;
  }

  /**
   * Gets the alias.
   *
   * The unique, human-readable alias assigned to the key.
   *
   * @return the alias
   */
  public String getAlias() {
    return alias;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the user that created the alias.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the creationDate.
   *
   * The date the alias was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }
}

