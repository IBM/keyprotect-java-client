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

import java.util.Date;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Metadata that indicates the status of a dual authorization policy on the key.
 */
public class DualAuthKeyMetadata extends GenericModel {

  protected Boolean enabled;
  protected Boolean keySetForDeletion;
  protected Date authExpiration;

  /**
   * Gets the enabled.
   *
   * The status of a dual authorization policy on the key.
   *    If `true`, dual authorization is required to delete the key. If `false`, no prior authorization is required  to
   * delete the key.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the keySetForDeletion.
   *
   * Indicates if a delete authorization has been issued for a key.
   *    If `true`, an authorization to delete this key has been issued by the first user, and a second user with  a
   * Manager access policy can safely delete the key. If the `enabled` property is `false`, this field is  omitted in
   * the response body.
   *
   * @return the keySetForDeletion
   */
  public Boolean isKeySetForDeletion() {
    return keySetForDeletion;
  }

  /**
   * Gets the authExpiration.
   *
   * The date that an authorization for deletion expires for the key. If this date has passed, the  authorization is no
   * longer valid. If the `enabled` or `keySetForDeletion` properties are `false`, this  field is omitted in the
   * response body.
   *
   * @return the authExpiration
   */
  public Date getAuthExpiration() {
    return authExpiration;
  }
}

