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
 * Data associated with the policy type `allowedIP`.
 */
public class AllowedIPProperties extends GenericModel {

  @SerializedName("allowed_ip")
  protected List<String> allowedIp;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> allowedIp;

    /**
     * Instantiates a new Builder from an existing AllowedIPProperties instance.
     *
     * @param allowedIpProperties the instance to initialize the Builder with
     */
    private Builder(AllowedIPProperties allowedIpProperties) {
      this.allowedIp = allowedIpProperties.allowedIp;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AllowedIPProperties.
     *
     * @return the new AllowedIPProperties instance
     */
    public AllowedIPProperties build() {
      return new AllowedIPProperties(this);
    }

    /**
     * Adds an allowedIp to allowedIp.
     *
     * @param allowedIp the new allowedIp
     * @return the AllowedIPProperties builder
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
     * Set the allowedIp.
     * Existing allowedIp will be replaced.
     *
     * @param allowedIp the allowedIp
     * @return the AllowedIPProperties builder
     */
    public Builder allowedIp(List<String> allowedIp) {
      this.allowedIp = allowedIp;
      return this;
    }
  }

  protected AllowedIPProperties() { }

  protected AllowedIPProperties(Builder builder) {
    allowedIp = builder.allowedIp;
  }

  /**
   * New builder.
   *
   * @return a AllowedIPProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
}

