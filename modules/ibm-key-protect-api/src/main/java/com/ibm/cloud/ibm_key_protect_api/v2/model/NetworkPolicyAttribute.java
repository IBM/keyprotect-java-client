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

/**
 * Properties that are associated with the policy type `allowedNetwork`.
 */
public class NetworkPolicyAttribute extends GenericModel {

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

  /**
   * Builder.
   */
  public static class Builder {
    private String allowedNetwork;

    private Builder(NetworkPolicyAttribute networkPolicyAttribute) {
      this.allowedNetwork = networkPolicyAttribute.allowedNetwork;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param allowedNetwork the allowedNetwork
     */
    public Builder(String allowedNetwork) {
      this.allowedNetwork = allowedNetwork;
    }

    /**
     * Builds a NetworkPolicyAttribute.
     *
     * @return the new NetworkPolicyAttribute instance
     */
    public NetworkPolicyAttribute build() {
      return new NetworkPolicyAttribute(this);
    }

    /**
     * Set the allowedNetwork.
     *
     * @param allowedNetwork the allowedNetwork
     * @return the NetworkPolicyAttribute builder
     */
    public Builder allowedNetwork(String allowedNetwork) {
      this.allowedNetwork = allowedNetwork;
      return this;
    }
  }

  protected NetworkPolicyAttribute(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.allowedNetwork,
      "allowedNetwork cannot be null");
    allowedNetwork = builder.allowedNetwork;
  }

  /**
   * New builder.
   *
   * @return a NetworkPolicyAttribute builder
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
}

