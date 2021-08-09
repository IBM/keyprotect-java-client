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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * KeyActionOneOfResponse.
 *
 * Classes which extend this class:
 * - KeyActionOneOfResponseWrapKeyResponseBody
 * - KeyActionOneOfResponseUnwrapKeyResponseBody
 * - KeyActionOneOfResponseRewrapKeyResponseBody
 */
public class KeyActionOneOfResponse extends GenericModel {

  protected String plaintext;
  protected String ciphertext;
  protected KeyVersion keyVersion;
  protected KeyVersion rewrappedKeyVersion;

  protected KeyActionOneOfResponse() {
  }

  /**
   * Gets the plaintext.
   *
   * The data encryption key (DEK) used in wrap actions when the query parameter is set to `wrap`. The system returns a
   * base64 encoded plaintext in the response entity-body when you perform an `unwrap` action on a key.
   *
   * To wrap an existing DEK, provide a base64 encoded plaintext during a
   * `wrap` action. To generate a new DEK, omit the `plaintext` property. Key Protect generates a random plaintext (32
   * bytes) that is rooted in an HSM and then wraps that value.
   *
   * **Note:** When you unwrap a wrapped data encryption key (WDEK) by using a rotated root key, the service returns a
   * new ciphertext in the response entity-body. Each ciphertext remains available for
   * `unwrap` actions. If you unwrap a DEK with a previous ciphertext, the service also returns the latest ciphertext in
   * the response. Use the latest ciphertext for future unwrap operations.
   *
   * @return the plaintext
   */
  public String getPlaintext() {
    return plaintext;
  }

  /**
   * Gets the ciphertext.
   *
   * The wrapped data encryption key (WDEK) that you can export to your app or service. The value is base64 encoded.
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
  public KeyVersion getKeyVersion() {
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
  public KeyVersion getRewrappedKeyVersion() {
    return rewrappedKeyVersion;
  }
}

