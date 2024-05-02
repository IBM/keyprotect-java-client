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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties returned only for DELETE.
 */
public class KeyFullRepresentation extends GenericModel {

  /**
   * Deprecated.
   */
  public interface AlgorithmType {
    /** AES. */
    String AES = "AES";
  }

  /**
   * Deprecated.
   */
  public interface AlgorithmMode {
    /** CBC_PAD. */
    String CBC_PAD = "CBC_PAD";
  }

  protected String type;
  protected String id;
  protected String name;
  protected List<String> aliases;
  protected String description;
  protected List<String> tags;
  protected Long state;
  protected Date expirationDate;
  protected Boolean extractable;
  protected String crn;
  protected Boolean imported;
  @SerializedName("keyRingID")
  protected String keyRingId;
  protected MigrationIntent migrationIntent;
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
  protected RotationKeyMetadata rotation;
  protected Boolean deleted;
  protected Date deletionDate;
  protected String deletedBy;
  protected Date restoreExpirationDate;
  protected Boolean restoreAllowed;
  protected Boolean purgeAllowed;
  protected Date purgeAllowedFrom;
  protected Date purgeScheduledOn;

  protected KeyFullRepresentation() { }

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
   * A human-readable name assigned to your key for convenience. To protect your privacy do not use personal data, such
   * as your name or location, as the name for your key.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the aliases.
   *
   * One or more, up to a total of five, human-readable unique aliases assigned  to your key. To protect your privacy do
   * not use personal data, such as your name or location, as an alias for your key. Each alias must be alphanumeric and
   * cannot contain spaces or special characters other than `-` or `_`. The alias cannot be a UUID and must not be a Key
   * Protect reserved name: `allowed_ip`, `key`, `keys`, `metadata`, `policy`, `policies`, `registration`,
   * `registrations`, `ring`, `rings`, `rotate`, `wrap`, `unwrap`, `rewrap`, `version`, `versions`.
   *
   * @return the aliases
   */
  public List<String> getAliases() {
    return aliases;
  }

  /**
   * Gets the description.
   *
   * A text field used to provide a more detailed description of the key. The maximum length is 240 characters. To
   * protect your privacy, do not use personal data, such as your name or location, as a description for your key.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the tags.
   *
   * Up to 30 tags can be created. Tags can be between 0-30 characters, including spaces. Special characters not
   * permitted include angled  brackets, comma, colon, ampersand, and vertical pipe character (|). To protect your
   * privacy, do not use personal data, such as your name or location, as a tag for your key.
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
   * The date the key material expires. The date format follows RFC 3339. You can set an expiration date on any key on
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
   * A boolean that determines whether the key material can leave the service. If set to `false`, Key Protect designates
   * the key as a nonextractable root key used for `wrap` and `unwrap` actions. If set to `true`, Key Protect designates
   * the key as a standard key that you can store in your apps and services. Once set to `false` it cannot be changed to
   * `true`.
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
   * A boolean that shows whether your key was originally imported or generated in Key Protect. The value is set by Key
   * Protect based on how the key material is initially added to the service. A value of `true` indicates that you must
   * provide new key material when it's time to rotate the key. A value of `false` indicates that Key Protect will
   * generate the new key material on a `rotate` operation, as it did in key creation.
   *
   * @return the imported
   */
  public Boolean isImported() {
    return imported;
  }

  /**
   * Gets the keyRingId.
   *
   * An ID that identifies the key ring. Each ID is unique only within the given instance and is not reserved across the
   * Key Protect service.
   *
   * @return the keyRingId
   */
  public String getKeyRingId() {
    return keyRingId;
  }

  /**
   * Gets the migrationIntent.
   *
   * Migration intent.
   *
   * @return the migrationIntent
   */
  public MigrationIntent getMigrationIntent() {
    return migrationIntent;
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
   * Deprecated.
   *
   * @return the algorithmType
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String getAlgorithmType() {
    return algorithmType;
  }

  /**
   * Gets the algorithmMetadata.
   *
   * Deprecated.
   *
   * @return the algorithmMetadata
   */
  public KeyFullRepresentationAlgorithmMetadata getAlgorithmMetadata() {
    return algorithmMetadata;
  }

  /**
   * Gets the algorithmBitSize.
   *
   * Deprecated.
   *
   * @return the algorithmBitSize
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Long getAlgorithmBitSize() {
    return algorithmBitSize;
  }

  /**
   * Gets the algorithmMode.
   *
   * Deprecated.
   *
   * @return the algorithmMode
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
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
   * Gets the rotation.
   *
   * Metadata that indicates the status of a rotation policy on the key.
   *
   * @return the rotation
   */
  public RotationKeyMetadata getRotation() {
    return rotation;
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

  /**
   * Gets the restoreExpirationDate.
   *
   * The date the key will no longer have the ability to be restored.
   *
   * @return the restoreExpirationDate
   */
  public Date getRestoreExpirationDate() {
    return restoreExpirationDate;
  }

  /**
   * Gets the restoreAllowed.
   *
   * A boolean that specifies if your key has the ability to be restored. A value of `true` indicates that the key can
   * be restored. A value of `false` indicates that the key is unable to be restored.
   *
   * @return the restoreAllowed
   */
  public Boolean isRestoreAllowed() {
    return restoreAllowed;
  }

  /**
   * Gets the purgeAllowed.
   *
   * A boolean that specifies if the key can be purged. A value of `true` indicates that the key can be purged. A value
   * of `false` indicates that the key is within the purge wait period and is not ready to be purged.
   *
   * @return the purgeAllowed
   */
  public Boolean isPurgeAllowed() {
    return purgeAllowed;
  }

  /**
   * Gets the purgeAllowedFrom.
   *
   * The date the key will be ready to be purged.
   *
   * @return the purgeAllowedFrom
   */
  public Date getPurgeAllowedFrom() {
    return purgeAllowedFrom;
  }

  /**
   * Gets the purgeScheduledOn.
   *
   * The date the deleted key will be automatically purged from Key Protect system.
   *
   * @return the purgeScheduledOn
   */
  public Date getPurgeScheduledOn() {
    return purgeScheduledOn;
  }
}

