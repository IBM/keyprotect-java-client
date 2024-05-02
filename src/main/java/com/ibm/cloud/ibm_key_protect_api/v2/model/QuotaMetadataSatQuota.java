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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties relating to current usage with respect to a quota in a satellite location.
 */
public class QuotaMetadataSatQuota extends GenericModel {

  protected Long globalKeyQuota;
  protected Long globalKeyCount;

  protected QuotaMetadataSatQuota() { }

  /**
   * Gets the globalKeyQuota.
   *
   * The max number of keys that can be created in a satellite location.
   *
   * @return the globalKeyQuota
   */
  public Long getGlobalKeyQuota() {
    return globalKeyQuota;
  }

  /**
   * Gets the globalKeyCount.
   *
   * The current number of keys in a satellite location.
   *
   * @return the globalKeyCount
   */
  public Long getGlobalKeyCount() {
    return globalKeyCount;
  }
}

