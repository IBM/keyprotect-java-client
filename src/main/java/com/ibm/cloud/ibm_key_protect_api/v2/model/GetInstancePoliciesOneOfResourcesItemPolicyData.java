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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * User defined metadata that is associated with the `allowedNetwork` instance policy type.
 */
public class GetInstancePoliciesOneOfResourcesItemPolicyData extends GenericModel {

  protected Boolean enabled;
  protected GetInstancePoliciesOneOfResourcesItemPolicyDataAttributes attributes;

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect enables the specified policy for your service instance. If set to `false`, Key
   * Protect disables the specified policy for your service instance, and the policy will no longer affect Key Protect
   * actions.
   *
   * **Note:** If a policy with attributes is disabled, all attributes are reset and are not retained.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the attributes.
   *
   * Data associated with the policy type `allowed_network`.
   *
   * @return the attributes
   */
  public GetInstancePoliciesOneOfResourcesItemPolicyDataAttributes getAttributes() {
    return attributes;
  }
}

