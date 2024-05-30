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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties applicable to all KMIP object resources.
 */
public class KMIPObject extends GenericModel {

  protected String id;
  @SerializedName("kmip_object_type")
  protected Long kmipObjectType;
  protected Long state;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_kmip_client_cert_id")
  protected String createdByKmipClientCertId;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("updated_by_kmip_client_cert_id")
  protected String updatedByKmipClientCertId;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("destroyed_at")
  protected Date destroyedAt;
  @SerializedName("destroyed_by_kmip_client_cert_id")
  protected String destroyedByKmipClientCertId;
  @SerializedName("destroyed_by")
  protected String destroyedBy;

  protected KMIPObject() { }

  /**
   * Gets the id.
   *
   * The v4 UUID that uniquely identifies this KMIP object.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the kmipObjectType.
   *
   * The object type of the kmip object according to the KMIP specification. Currently, only kmip_object_type
   * 2(Symmetric Key) is supported. For more info on the KMIP specification and object types, read
   * https://docs.oasis-open.org/kmip/spec/v1.4/os/kmip-spec-v1.4-os.html#_Toc490660932.
   *
   * @return the kmipObjectType
   */
  public Long getKmipObjectType() {
    return kmipObjectType;
  }

  /**
   * Gets the state.
   *
   * States are integers and correspond to Pre-Active = 1, Active = 2, Deactivated = 3, Compromised = 4, Destroyed = 5,
   * Destroyed Compromised = 6. For more info on the KMIP specification, read
   * https://docs.oasis-open.org/kmip/spec/v1.4/os/kmip-spec-v1.4-os.html.
   *
   * @return the state
   */
  public Long getState() {
    return state;
  }

  /**
   * Gets the createdAt.
   *
   * The date the KMIP object was created. The date format follows RFC 3339.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdByKmipClientCertId.
   *
   * The v4 UUID that uniquely identifies the certificate used to create this KMIP object.
   *
   * @return the createdByKmipClientCertId
   */
  public String getCreatedByKmipClientCertId() {
    return createdByKmipClientCertId;
  }

  /**
   * Gets the createdBy.
   *
   * The IAM id that created the certificate resource used to create this KMIP object.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * The date the KMIP object was last modified. The date format follows RFC 3339.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedByKmipClientCertId.
   *
   * The v4 UUID that uniquely identifies the certificate used to update this KMIP object.
   *
   * @return the updatedByKmipClientCertId
   */
  public String getUpdatedByKmipClientCertId() {
    return updatedByKmipClientCertId;
  }

  /**
   * Gets the updatedBy.
   *
   * The IAM id that created the certificate resource used to update this KMIP object.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the destroyedAt.
   *
   * The date the KMIP object was destroyed. The date format follows RFC 3339.
   *
   * @return the destroyedAt
   */
  public Date getDestroyedAt() {
    return destroyedAt;
  }

  /**
   * Gets the destroyedByKmipClientCertId.
   *
   * The v4 UUID that uniquely identifies the certificate used to destroy this KMIP object.
   *
   * @return the destroyedByKmipClientCertId
   */
  public String getDestroyedByKmipClientCertId() {
    return destroyedByKmipClientCertId;
  }

  /**
   * Gets the destroyedBy.
   *
   * The IAM id that created the certificate resource used to destroy this KMIP object.
   *
   * @return the destroyedBy
   */
  public String getDestroyedBy() {
    return destroyedBy;
  }
}

