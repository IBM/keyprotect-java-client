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
 * Properties that are associated with the response body of an rewrap action.
 */
public class RewrapKeyResponseBody extends GenericModel {

  protected String ciphertext;
  protected WrappedKeyVersionKeyVersion keyVersion;
  protected RewrappedKeyVersionRewrappedKeyVersion rewrappedKeyVersion;

  protected RewrapKeyResponseBody() { }

  /**
   * Gets the ciphertext.
   *
   * The wrapped data encryption key (WDEK) that you can export to your app or service. The ciphertext contains the DEK
   * wrapped by the latest version  of the key (WDEK). It is recommended to store and use  this WDEK in future calls to
   * Key Protect. The value is base64 encoded.
   *
   * @return the ciphertext
   */
  public String getCiphertext() {
    return ciphertext;
  }

  /**
   * Gets the keyVersion.
   *
   * The key version that was used to wrap the DEK. This key version is associated with the `ciphertext` value that was
   * used in the request.
   *
   * @return the keyVersion
   */
  public WrappedKeyVersionKeyVersion getKeyVersion() {
    return keyVersion;
  }

  /**
   * Gets the rewrappedKeyVersion.
   *
   * The latest key version that was used to rewrap the DEK. This key version is associated with the `ciphertext` value
   * that's returned in the response.
   *
   * @return the rewrappedKeyVersion
   */
  public RewrappedKeyVersionRewrappedKeyVersion getRewrappedKeyVersion() {
    return rewrappedKeyVersion;
  }
}

