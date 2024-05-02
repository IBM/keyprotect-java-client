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
 * CurrentConfig.
 *
 * Classes which extend this class:
 * - CurrentConfigSimpleProperty
 * - CurrentConfigNestedProperty
 */
public class CurrentConfig extends GenericModel {

  protected String property;
  protected String value;
  @SerializedName("properties")
  protected List<SimpleProperty> xProperties;

  protected CurrentConfig() { }

  /**
   * Gets the property.
   *
   * @return the property
   */
  public String getProperty() {
    return property;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the xProperties.
   *
   * @return the xProperties
   */
  public List<SimpleProperty> getXProperties() {
    return xProperties;
  }
}

