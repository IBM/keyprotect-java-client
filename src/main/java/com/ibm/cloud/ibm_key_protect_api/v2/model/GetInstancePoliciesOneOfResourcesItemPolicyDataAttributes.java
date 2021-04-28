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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.ArrayList;

/**
 * Data associated with the policy type `allowed_network` or 'allow_ip'.
 */
public class GetInstancePoliciesOneOfResourcesItemPolicyDataAttributes extends GenericModel {

  @SerializedName("allowed_network")
  protected String allowedNetwork;

  @SerializedName("allowed_ip")
  protected ArrayList<String> allowedIP;

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

}

