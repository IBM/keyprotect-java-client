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
 * CIPResourceConfigStateItem.
 */
public class CIPResourceConfigStateItem extends GenericModel {

  @SerializedName("resource_crn")
  protected String resourceCrn;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("additional_target_attributes")
  protected CIPResourceConfigStateItemAdditionalTargetAttributes additionalTargetAttributes;
  @SerializedName("current_config")
  protected List<CurrentConfig> currentConfig;

  protected CIPResourceConfigStateItem() { }

  /**
   * Gets the resourceCrn.
   *
   * CRN of resource.
   *
   * @return the resourceCrn
   */
  public String getResourceCrn() {
    return resourceCrn;
  }

  /**
   * Gets the resourceGroupId.
   *
   * ID of resource group in which service instance or resource resides.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the additionalTargetAttributes.
   *
   * Container for one or more custom target attributes.
   *
   * @return the additionalTargetAttributes
   */
  public CIPResourceConfigStateItemAdditionalTargetAttributes getAdditionalTargetAttributes() {
    return additionalTargetAttributes;
  }

  /**
   * Gets the currentConfig.
   *
   * Container for one or more resources.
   *
   * @return the currentConfig
   */
  public List<CurrentConfig> getCurrentConfig() {
    return currentConfig;
  }
}

