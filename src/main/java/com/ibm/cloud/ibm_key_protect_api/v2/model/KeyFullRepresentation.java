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
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties returned only for DELETE.
 */
public class KeyFullRepresentation extends GenericModel {

  /**
   * The algorithm type used to generate the key. Currently, AES is supported.
   */
  public interface AlgorithmType {
    /** AES. */
    String AES = "AES";
  }

  /**
   * The encryption scheme used to generate the key. Currently, `CBC_PAD` is supported.
   */
  public interface AlgorithmMode {
    /** CBC_PAD. */
    String CBC_PAD = "CBC_PAD";
  }

  protected String type;
  protected String id;
  protected String name;
  protected String description;
  protected List<String> tags;
  protected Long state;
  protected Date expirationDate;
  protected Boolean extractable;
  protected String crn;
  protected Boolean imported;
  protected Date creationDate;
  protected String createdBy;
  protected String algorithmType;
  protected KeyFullRepresentationAlgorithmMetadata algorithmMetadata;
  protected Long algorithmBitSize;
  protected String algorithmMode;
  protected Long nonactiveStateReason;
  protected Date lastUpdateDate;
  protected Date lastRotateDate;
  protected KeyVersion keyVersion;
  protected DualAuthKeyMetadata dualAuthDelete;
  protected Boolean deleted;
  protected Date deletionDate;
  protected String deletedBy;

  /**
   * Gets the type.
   *
   * Specifies the MIME type that represents the key resource. Currently, only the default is supported.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the id.
   *
   * The v4 UUID used to uniquely identify the resource, as specified by RFC 4122.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * A unique, human-readable alias to assign to your key.
   *    To protect your privacy, do not use personal data, such as your name or location, as an alias for your key.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * A text field used to provide a more detailed description of the key. The maximum length is 240 characters.
   *    To protect your privacy, do not use personal data, such as your name or location, as a description for your
   * key.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the tags.
   *
   * Up to 30 tags can be created. Tags can be between 2-30 characters, including spaces. Special characters not
   * permitted include the angled bracket, comma, colon, ampersand, and vertical pipe character (|).
   *    To protect your privacy, do not use personal data, such as your name or location, as a tag for your key.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Gets the state.
   *
   * The key state based on NIST SP 800-57. States are integers and correspond to the Pre-activation = 0, Active = 1,
   * Suspended = 2, Deactivated = 3, and Destroyed = 5 values.
   *
   * @return the state
   */
  public Long getState() {
    return state;
  }

  /**
   * Gets the expirationDate.
   *
   * The date the key material expires. The date format follows RFC 3339. You can set an expiration date on any  key on
   * its creation. If you create a key without specifying an expiration date, the key does not expire.
   *
   * @return the expirationDate
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  /**
   * Gets the extractable.
   *
   * A boolean that determines whether the key material can leave the service.
   *      If set to `false`, Key Protect designates the key as a nonextractable root key used for `wrap` and `unwrap`
   * actions. If set to `true`, Key Protect designates the key as a standard key that you can store in your apps and
   * services. Once set to `false` it cannot be changed to `true`.
   *
   * @return the extractable
   */
  public Boolean isExtractable() {
    return extractable;
  }

  /**
   * Gets the crn.
   *
   * The Cloud Resource Name (CRN) that uniquely identifies your cloud resources.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the imported.
   *
   * A boolean that shows whether your key was originally imported or generated in Key Protect. The value is set  by Key
   * Protect based on how the key material is initially added to the service.
   *    A value of `true` indicates that you must provide new key material when it's time to rotate the key. A value  of
   * `false` indicates that Key Protect will generate the new key material on a `rotate` operation, as it did in key
   * creation.
   *
   * @return the imported
   */
  public Boolean isImported() {
    return imported;
  }

  /**
   * Gets the creationDate.
   *
   * The date the key material was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the resource that created the key.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the algorithmType.
   *
   * The algorithm type used to generate the key. Currently, AES is supported.
   *
   * @return the algorithmType
   */
  public String getAlgorithmType() {
    return algorithmType;
  }

  /**
   * Gets the algorithmMetadata.
   *
   * The metadata for the key algorithm.
   *
   * @return the algorithmMetadata
   */
  public KeyFullRepresentationAlgorithmMetadata getAlgorithmMetadata() {
    return algorithmMetadata;
  }

  /**
   * Gets the algorithmBitSize.
   *
   * The algorithm bit size used for key encryption.
   *
   * @return the algorithmBitSize
   */
  public Long getAlgorithmBitSize() {
    return algorithmBitSize;
  }

  /**
   * Gets the algorithmMode.
   *
   * The encryption scheme used to generate the key. Currently, `CBC_PAD` is supported.
   *
   * @return the algorithmMode
   */
  public String getAlgorithmMode() {
    return algorithmMode;
  }

  /**
   * Gets the nonactiveStateReason.
   *
   * A code indicating the reason the key is not in the activation state.
   *
   * @return the nonactiveStateReason
   */
  public Long getNonactiveStateReason() {
    return nonactiveStateReason;
  }

  /**
   * Gets the lastUpdateDate.
   *
   * Updates when any part of the key metadata is modified. The date format follows RFC 3339.
   *
   * @return the lastUpdateDate
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  /**
   * Gets the lastRotateDate.
   *
   * Updates to show when the key was last rotated. The date format follows RFC 3339.
   *
   * @return the lastRotateDate
   */
  public Date getLastRotateDate() {
    return lastRotateDate;
  }

  /**
   * Gets the keyVersion.
   *
   * Properties associated with a specific key version.
   *
   * @return the keyVersion
   */
  public KeyVersion getKeyVersion() {
    return keyVersion;
  }

  /**
   * Gets the dualAuthDelete.
   *
   * Metadata that indicates the status of a dual authorization policy on the key.
   *
   * @return the dualAuthDelete
   */
  public DualAuthKeyMetadata getDualAuthDelete() {
    return dualAuthDelete;
  }

  /**
   * Gets the deleted.
   *
   * A boolean that determines whether the key has been deleted.
   *
   * @return the deleted
   */
  public Boolean isDeleted() {
    return deleted;
  }

  /**
   * Gets the deletionDate.
   *
   * The date the key material was destroyed. The date format follows RFC 3339.
   *
   * @return the deletionDate
   */
  public Date getDeletionDate() {
    return deletionDate;
  }

  /**
   * Gets the deletedBy.
   *
   * The unique identifier for the resource that deleted the key.
   *
   * @return the deletedBy
   */
  public String getDeletedBy() {
    return deletedBy;
  }
}

