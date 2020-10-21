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

  /**
   * Gets the allowedNetwork.
   *
   * If set to `public-and-private`, Key Protect allows the instance to be accessible through public and private
   * endpoints. If set to `private-only`, Key Protect restricts the instance to only be accessible through a private
   * endpoint.
   *
   * @return the allowedNetwork
   */
  public String getAllowedNetwork() {
    return allowedNetwork;
  }

  /**
   * Gets the allowedIP.
   *
   * @return the allowedNetwork
   */
  public ArrayList<String> getAllowedIP() {
    return allowedIP;
  }

}

