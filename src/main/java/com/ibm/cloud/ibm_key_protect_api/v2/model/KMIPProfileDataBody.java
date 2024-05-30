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
 * The data specific to the KMIP Adapter profile. This is a required field for profile `native_1.0`.
 *
 * Classes which extend this class:
 * - KMIPProfileDataBodyKMIPProfileDataNative
 */
public class KMIPProfileDataBody extends GenericModel {

  @SerializedName("crk_id")
  protected String crkId;

  protected KMIPProfileDataBody() { }

  /**
   * Gets the crkId.
   *
   * An ID that identifies the Customer Root Key(CRK) to be used. This CRK must exist in the same kms instance as the
   * adapter.
   *
   * @return the crkId
   */
  public String crkId() {
    return crkId;
  }
}

