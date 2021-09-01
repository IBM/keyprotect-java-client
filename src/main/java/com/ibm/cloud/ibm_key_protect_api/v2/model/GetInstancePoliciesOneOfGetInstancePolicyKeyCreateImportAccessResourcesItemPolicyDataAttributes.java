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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Data associated with the policy type `keyCreateImportAccess`.
 */
public class GetInstancePoliciesOneOfGetInstancePolicyKeyCreateImportAccessResourcesItemPolicyDataAttributes extends GenericModel {

  @SerializedName("create_root_key")
  protected Boolean createRootKey;
  @SerializedName("create_standard_key")
  protected Boolean createStandardKey;
  @SerializedName("import_root_key")
  protected Boolean importRootKey;
  @SerializedName("import_standard_key")
  protected Boolean importStandardKey;
  @SerializedName("enforce_token")
  protected Boolean enforceToken;

  /**
   * Gets the createRootKey.
   *
   * If set to `false`, the service prevents you or any authorized users from using Key Protect to create root keys in
   * the specified service instance. If set to `true`, Key Protect allows you or any authorized users to create root
   * keys in the instance.
   *
   * **Note:** If omitted, `POST /instance/policies` will set this attribute to the default value (`true`).
   *
   * @return the createRootKey
   */
  public Boolean isCreateRootKey() {
    return createRootKey;
  }

  /**
   * Gets the createStandardKey.
   *
   * If set to `false`, the service prevents you or any authorized users from using Key Protect to create standard keys
   * in the specified service instance. If set to `true`, Key Protect allows you or any authorized users to create
   * standard keys in the instance.
   *
   * **Note:** If omitted, `POST /instance/policies` will set this attribute to the default value (`true`).
   *
   * @return the createStandardKey
   */
  public Boolean isCreateStandardKey() {
    return createStandardKey;
  }

  /**
   * Gets the importRootKey.
   *
   * If set to `false`, the service prevents you or any authorized users from importing root keys into the specified
   * service instance. If set to `true`, Key Protect allows you or any authorized users to import root keys into the
   * instance.
   *
   * **Note:** If omitted, `POST /instance/policies` will set this attribute to the default value (`true`).
   *
   * @return the importRootKey
   */
  public Boolean isImportRootKey() {
    return importRootKey;
  }

  /**
   * Gets the importStandardKey.
   *
   * If set to `false`, the service prevents you or any authorized users from importing standard keys into the specified
   * service instance. If set to `true`, Key Protect allows you or any authorized users to import standard keys into the
   * instance.
   *
   * **Note:** If omitted, `POST /instance/policies` will set this attribute to the default value (`true`).
   *
   * @return the importStandardKey
   */
  public Boolean isImportStandardKey() {
    return importStandardKey;
  }

  /**
   * Gets the enforceToken.
   *
   * If set to `true`, the service prevents you or any authorized users from importing key material into the specified
   * service instance without using an import token. If set to `false`, Key Protect allows you or any authorized users
   * to import key material into the instance without the use of an import token.
   *
   * **Note:** If omitted, `POST /instance/policies` will set this attribute to the default value (`false`).
   *
   * @return the enforceToken
   */
  public Boolean isEnforceToken() {
    return enforceToken;
  }
}

