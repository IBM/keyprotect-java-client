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
 * Properties associated with a registration.
 */
public class RegistrationResource extends GenericModel {

  protected String keyId;
  protected String keyName;
  protected String resourceCrn;
  protected String createdBy;
  protected Date creationDate;
  protected String updatedBy;
  protected Date lastUpdated;
  protected String description;
  protected String registrationMetadata;
  protected Boolean preventKeyDeletion;
  protected KeyVersion keyVersion;

  /**
   * Gets the keyId.
   *
   * The ID that identifies the root key that is associated with the specified cloud resource.
   *
   * @return the keyId
   */
  public String getKeyId() {
    return keyId;
  }

  /**
   * Gets the keyName.
   *
   * The unique, human-readable alias assigned to the root key that is associated with the specified cloud resource.
   *
   * @return the keyName
   */
  public String getKeyName() {
    return keyName;
  }

  /**
   * Gets the resourceCrn.
   *
   * The [Cloud Resource Name](https://cloud.ibm.com/docs/overview?topic=overview-crn) (CRN) that represents the  cloud
   * resource, such as a Cloud Object Storage bucket, that is associated with the key.
   *
   * @return the resourceCrn
   */
  public String getResourceCrn() {
    return resourceCrn;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the resource that created the registration.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the creationDate.
   *
   * The date the registration was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the updatedBy.
   *
   * The unique identifier for the resource that updated the registration.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the lastUpdated.
   *
   * Updates when the registration is modified. The date format follows RFC 3339.
   *
   * @return the lastUpdated
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * Gets the description.
   *
   * Description of the purpose of the registration.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the registrationMetadata.
   *
   * Additional information about the registration. This field is not exposed to  customers and is visible only with IBM
   * Cloud service to service calls.
   *
   * @return the registrationMetadata
   */
  public String getRegistrationMetadata() {
    return registrationMetadata;
  }

  /**
   * Gets the preventKeyDeletion.
   *
   * A boolean that determines whether Key Protect must prevent deletion of a root key.
   *
   * @return the preventKeyDeletion
   */
  public Boolean isPreventKeyDeletion() {
    return preventKeyDeletion;
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
}

