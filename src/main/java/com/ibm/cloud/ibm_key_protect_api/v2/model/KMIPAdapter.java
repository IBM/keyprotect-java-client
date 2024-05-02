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
 * Properties applicable to all KMIP adapter resources.
 */
public class KMIPAdapter extends GenericModel {

  /**
   * The profile of KMIP adapter to be created.
   */
  public interface Profile {
    /** native_1.0. */
    String NATIVE_1_0 = "native_1.0";
  }

  protected String id;
  protected String name;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("updated_by")
  protected String updatedBy;
  protected String profile;
  protected String description;
  @SerializedName("profile_data")
  protected KMIPProfileDataNative profileData;

  protected KMIPAdapter() { }

  /**
   * Gets the id.
   *
   * The v4 UUID that uniquely identifies this KMIP adapter.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * A human-readable name of the KMIP adapter unique within the kms instance. If one is not specified, one will be
   * autogenerated of the format `kmip_adapter_&lt;timestamp&gt;_&lt;random_string&gt;`. To protect your privacy do not
   * use personal data, such as your name or location, as a name for your KMIP adapter. The name must be  alphanumeric
   * and cannot contain spaces or special characters other than `-` or `_`. The name cannot be a UUID and must not be a
   * Key Protect reserved name: `allowed_ip`, `certificate`, `certificates`,`key`,`keys`, `metadata`, `policy`,
   * `policies`, `registration`, `registrations`, `ring`, `rings`, `rotate`, `wrap`, `unwrap`, `rewrap`, `version`,
   * `versions`.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the createdAt.
   *
   * The date the KMIP adapter was created. The date format follows RFC 3339.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier of the user that created the KMIP adapter.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * The date the KMIP adapter was last modified, either by creation or by modification  of adapter subresources. The
   * date format follows RFC 3339.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * The unique identifier of the user that updated the KMIP adapter.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the profile.
   *
   * The profile of KMIP adapter to be created.
   *
   * @return the profile
   */
  public String getProfile() {
    return profile;
  }

  /**
   * Gets the description.
   *
   * The optional description of the KMIP adapter. The maximum length is 240 characters. To protect your privacy, do not
   * use personal data, such as your name or location, as a description for your KMIP adapter.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the profileData.
   *
   * Properties that must be specified to profile_data when it is of native_1.0 KMIP adapter resource.
   *
   * @return the profileData
   */
  public KMIPProfileDataNative getProfileData() {
    return profileData;
  }
}

