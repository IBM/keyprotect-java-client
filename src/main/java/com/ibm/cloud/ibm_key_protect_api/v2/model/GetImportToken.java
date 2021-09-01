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
 * The base schema for retrieving an import token.
 */
public class GetImportToken extends GenericModel {

  protected Double expiration;
  protected Double maxAllowedRetrievals;
  protected Date creationDate;
  protected Date expirationDate;
  protected Double remainingRetrievals;
  protected byte[] payload;
  protected byte[] nonce;

  /**
   * Gets the expiration.
   *
   * The time in seconds from the creation of an import token that determines how long its associated public key remains
   * valid.
   *
   * The minimum value is `300` seconds (5 minutes), and the maximum value is `86400` (24 hours). The default value is
   * `600`
   * (10 minutes).
   *
   * @return the expiration
   */
  public Double getExpiration() {
    return expiration;
  }

  /**
   * Gets the maxAllowedRetrievals.
   *
   * The number of times that an import token can be retrieved within its expiration time before it is no longer
   * accessible.
   *
   * @return the maxAllowedRetrievals
   */
  public Double getMaxAllowedRetrievals() {
    return maxAllowedRetrievals;
  }

  /**
   * Gets the creationDate.
   *
   * The date the import token was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the expirationDate.
   *
   * The date the import token expires. The date format follows RFC 3339.
   *
   * @return the expirationDate
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  /**
   * Gets the remainingRetrievals.
   *
   * The number of retrievals that are available for the import token before it is no longer accessible.
   *
   * @return the remainingRetrievals
   */
  public Double getRemainingRetrievals() {
    return remainingRetrievals;
  }

  /**
   * Gets the payload.
   *
   * The public encryption key that you can use to encrypt key material before you import it into the service.
   *
   * This value is a PEM-encoded public key in PKIX format. Because PEM encoding is a byte format, the value is base64
   * encoded.
   *
   * @return the payload
   */
  public byte[] getPayload() {
    return payload;
  }

  /**
   * Gets the nonce.
   *
   * The nonce value that is used to verify a key import request. Encrypt and provide the encrypted nonce value when you
   * use `POST /keys` to securely import a key to the service.
   *
   * @return the nonce
   */
  public byte[] getNonce() {
    return nonce;
  }
}

