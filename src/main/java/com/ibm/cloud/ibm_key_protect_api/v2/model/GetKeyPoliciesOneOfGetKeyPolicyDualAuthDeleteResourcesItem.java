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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties that are associated with key level dual authorization delete policy.
 */
public class GetKeyPoliciesOneOfGetKeyPolicyDualAuthDeleteResourcesItem extends GenericModel {

  /**
   * Specifies the MIME type that represents the policy resource. Currently, only the default is supported.
   */
  public interface Type {
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
  }

  protected String id;
  protected String crn;
  protected Date creationDate;
  protected String createdBy;
  protected Date lastUpdateDate;
  protected String updatedBy;
  protected String type;
  protected KeyPolicyDualAuthDeleteDualAuthDelete dualAuthDelete;

  protected GetKeyPoliciesOneOfGetKeyPolicyDualAuthDeleteResourcesItem() { }

  /**
   * Gets the id.
   *
   * The v4 UUID used to uniquely identify the policy resource, as specified by RFC 4122.
   *
   * @return the id
   */
  public String getId() {
    return id;
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
   * Gets the lastUpdateDate.
   *
   * Updates when the policy is replaced or modified. The date format follows RFC 3339.
   *
   * @return the lastUpdateDate
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
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
   * Gets the type.
   *
   * Specifies the MIME type that represents the policy resource. Currently, only the default is supported.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the dualAuthDelete.
   *
   * Data associated with the dual authorization delete policy.
   *
   * @return the dualAuthDelete
   */
  public KeyPolicyDualAuthDeleteDualAuthDelete getDualAuthDelete() {
    return dualAuthDelete;
  }
}

