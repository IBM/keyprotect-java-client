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
 * GetInstancePolicyAllowedIPResourcesItem.
 */
public class GetInstancePolicyAllowedIPResourcesItem extends GenericModel {

  protected Date creationDate;
  protected String createdBy;
  protected String updatedBy;
  protected Date lastUpdated;
  @SerializedName("policy_type")
  protected String policyType;
  @SerializedName("policy_data")
  protected GetInstancePolicyAllowedIPResourcesItemPolicyData policyData;

  protected GetInstancePolicyAllowedIPResourcesItem() { }

  /**
   * Gets the creationDate.
   *
   * The date the policy was created. The date format follows RFC 3339.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the resource that created the policy.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedBy.
   *
   * The unique identifier for the resource that updated the policy.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the lastUpdated.
   *
   * Updates when the policy is replaced or modified. The date format follows RFC 3339.
   *
   * @return the lastUpdated
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * Gets the policyType.
   *
   * The type of policy to be retrieved.
   *
   * @return the policyType
   */
  public String getPolicyType() {
    return policyType;
  }

  /**
   * Gets the policyData.
   *
   * User defined metadata that is associated with the `allowedIP` instance policy type.
   *
   * @return the policyData
   */
  public GetInstancePolicyAllowedIPResourcesItemPolicyData getPolicyData() {
    return policyData;
  }
}

