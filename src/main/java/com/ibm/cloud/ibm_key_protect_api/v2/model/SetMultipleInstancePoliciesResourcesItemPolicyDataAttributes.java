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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Attributes associated with any instance policy type. Must be provided if the `enabled` field is `true`. Cannot be
 * provided if the `enabled` field is `false`. Only attributes corresponding to the `policy_type` can be provided.
 */
public class SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes extends GenericModel {

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

  /**
   * Builder.
   */
  public static class Builder {
    private String allowedNetwork;
    private List<String> allowedIp;
    private Boolean createRootKey;
    private Boolean createStandardKey;
    private Boolean importRootKey;
    private Boolean importStandardKey;
    private Boolean enforceToken;
    private Long intervalMonth;

    /**
     * Instantiates a new Builder from an existing SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes instance.
     *
     * @param setMultipleInstancePoliciesResourcesItemPolicyDataAttributes the instance to initialize the Builder with
     */
    private Builder(SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes setMultipleInstancePoliciesResourcesItemPolicyDataAttributes) {
      this.allowedNetwork = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.allowedNetwork;
      this.allowedIp = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.allowedIp;
      this.createRootKey = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.createRootKey;
      this.createStandardKey = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.createStandardKey;
      this.importRootKey = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.importRootKey;
      this.importStandardKey = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.importStandardKey;
      this.enforceToken = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.enforceToken;
      this.intervalMonth = setMultipleInstancePoliciesResourcesItemPolicyDataAttributes.intervalMonth;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes.
     *
     * @return the new SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes instance
     */
    public SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes build() {
      return new SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes(this);
    }

    /**
     * Adds a new element to allowedIp.
     *
     * @param allowedIp the new element to be added
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder addAllowedIp(String allowedIp) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(allowedIp,
        "allowedIp cannot be null");
      if (this.allowedIp == null) {
        this.allowedIp = new ArrayList<String>();
      }
      this.allowedIp.add(allowedIp);
      return this;
    }

    /**
     * Set the allowedNetwork.
     *
     * @param allowedNetwork the allowedNetwork
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder allowedNetwork(String allowedNetwork) {
      this.allowedNetwork = allowedNetwork;
      return this;
    }

    /**
     * Set the allowedIp.
     * Existing allowedIp will be replaced.
     *
     * @param allowedIp the allowedIp
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder allowedIp(List<String> allowedIp) {
      this.allowedIp = allowedIp;
      return this;
    }

    /**
     * Set the createRootKey.
     *
     * @param createRootKey the createRootKey
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder createRootKey(Boolean createRootKey) {
      this.createRootKey = createRootKey;
      return this;
    }

    /**
     * Set the createStandardKey.
     *
     * @param createStandardKey the createStandardKey
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder createStandardKey(Boolean createStandardKey) {
      this.createStandardKey = createStandardKey;
      return this;
    }

    /**
     * Set the importRootKey.
     *
     * @param importRootKey the importRootKey
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder importRootKey(Boolean importRootKey) {
      this.importRootKey = importRootKey;
      return this;
    }

    /**
     * Set the importStandardKey.
     *
     * @param importStandardKey the importStandardKey
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder importStandardKey(Boolean importStandardKey) {
      this.importStandardKey = importStandardKey;
      return this;
    }

    /**
     * Set the enforceToken.
     *
     * @param enforceToken the enforceToken
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder enforceToken(Boolean enforceToken) {
      this.enforceToken = enforceToken;
      return this;
    }

    /**
     * Set the intervalMonth.
     *
     * @param intervalMonth the intervalMonth
     * @return the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
     */
    public Builder intervalMonth(long intervalMonth) {
      this.intervalMonth = intervalMonth;
      return this;
    }
  }

  protected SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes() { }

  protected SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes(Builder builder) {
    allowedNetwork = builder.allowedNetwork;
    allowedIp = builder.allowedIp;
    createRootKey = builder.createRootKey;
    createStandardKey = builder.createStandardKey;
    importRootKey = builder.importRootKey;
    importStandardKey = builder.importStandardKey;
    enforceToken = builder.enforceToken;
    intervalMonth = builder.intervalMonth;
  }

  /**
   * New builder.
   *
   * @return a SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the allowedNetwork.
   *
   * If set to `public-and-private`, Key Protect allows the instance to be accessible through public and private
   * endpoints. If set to `private-only`, Key Protect restricts the instance to only be accessible through a private
   * endpoint.
   *
   * @return the allowedNetwork
   */
  public String allowedNetwork() {
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
  public List<String> allowedIp() {
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
  public Boolean createRootKey() {
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
  public Boolean createStandardKey() {
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
  public Boolean importRootKey() {
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
  public Boolean importStandardKey() {
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
  public Boolean enforceToken() {
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
  public Long intervalMonth() {
    return intervalMonth;
  }
}

