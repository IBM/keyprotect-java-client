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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Attributes associated with any instance policy type.
 */
public class InstancePolicyPropertiesAttributes extends GenericModel {

  /**
   * If set to `public-and-private`, Key Protect allows the instance to be accessible through public and private
   * endpoints. If set to `private-only`, Key Protect restricts the instance to only be accessible through a private
   * endpoint.
   */
  public interface AllowedNetwork {
    /** public-and-private. */
    String PUBLIC_AND_PRIVATE = "public-and-private";
    /** private-only. */
    String PRIVATE_ONLY = "private-only";
  }

  @SerializedName("allowed_network")
  protected String allowedNetwork;
  @SerializedName("allowed_ip")
  protected List<String> allowedIp;
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
  @SerializedName("interval_month")
  protected Long intervalMonth;

  protected InstancePolicyPropertiesAttributes() { }

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
   * Gets the allowedIp.
   *
   * A string array of IPv4 or IPv6 CIDR notated subnets that are authorized to interact with the instance. If both
   * `allowedNetwork` and `allowedIP` policies are set, only traffic aligning with both the `allowed_network` allowed
   * network policy attribute and the `allowed_ip` allowed IP policy attribute will be allowed. IPv4 and iIP6 addresses
   * are accepted for public endpoints. Only the IPv4 private network gateway addresses from the array will be
   * authorized to access your instance via private endpoint.
   * **Important:** Once set, accessing your instance may require additional steps. For more information, see [Accessing
   * an instance via public
   * endpoint](/docs/key-protect?topic=key-protect-manage-allowed-ip#access-allowed-ip-public-endpoint) and [Accessing
   * an instance via private
   * endpoint](/docs/key-protect?topic=key-protect-manage-allowed-ip#access-allowed-ip-private-endpoint) for more
   * details.
   * **Note:** An allowed IP policy does not affect requests from other IBM Cloud services.
   *
   * @return the allowedIp
   */
  public List<String> getAllowedIp() {
    return allowedIp;
  }

  /**
   * Gets the createRootKey.
   *
   * If set to `false`, the service prevents you or any authorized users from using Key Protect to create root keys in
   * the specified service instance. If set to `true`, Key Protect allows you or any authorized users to create root
   * keys in the instance.
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
   * **Note:** If omitted, `POST /instance/policies` will set this attribute to the default value (`false`).
   *
   * @return the enforceToken
   */
  public Boolean isEnforceToken() {
    return enforceToken;
  }

  /**
   * Gets the intervalMonth.
   *
   * Specifies the key rotation time interval in approximate months, where a month is equivalent to 30 days. A minimum
   * of 1 and a maximum of 12 can be set.
   *
   * @return the intervalMonth
   */
  public Long getIntervalMonth() {
    return intervalMonth;
  }
}

