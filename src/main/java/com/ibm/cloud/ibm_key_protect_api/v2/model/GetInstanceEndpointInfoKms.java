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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * GetInstanceEndpointInfoKms.
 */
public class GetInstanceEndpointInfoKms extends GenericModel {

  @SerializedName("public")
  protected String xPublic;
  @SerializedName("private")
  protected String xPrivate;

  protected GetInstanceEndpointInfoKms() { }

  /**
   * Gets the xPublic.
   *
   * The endpoint that is accessible from the public network.
   *
   * @return the xPublic
   */
  public String getXPublic() {
    return xPublic;
  }

  /**
   * Gets the xPrivate.
   *
   * The endpoint that is accessible from the private network.
   *
   * @return the xPrivate
   */
  public String getXPrivate() {
    return xPrivate;
  }
}

