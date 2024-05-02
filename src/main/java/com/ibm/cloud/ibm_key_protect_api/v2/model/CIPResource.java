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
 * Resource config information for the purpose of config monitoring.
 */
public class CIPResource extends GenericModel {

  /**
   * Key Protect's service name.
   */
  public interface ServiceName {
    /** kms. */
    String KMS = "kms";
  }

  /**
   * The resource kind matching the resource request.
   */
  public interface ResourceKind {
    /** instance. */
    String INSTANCE = "instance";
    /** key. */
    String KEY = "key";
  }

  protected CIPResourceNext next;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("resource_kind")
  protected String resourceKind;
  @SerializedName("config_request_id")
  protected String configRequestId;
  protected String timestamp;
  @SerializedName("config_state")
  protected List<CIPResourceConfigStateItem> configState;

  protected CIPResource() { }

  /**
   * Gets the next.
   *
   * URL to obtain the next set of data during pagination, given further resources matching the query can be found.
   *
   * @return the next
   */
  public CIPResourceNext getNext() {
    return next;
  }

  /**
   * Gets the accountId.
   *
   * ID of account that requested instance belongs to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the serviceName.
   *
   * Key Protect's service name.
   *
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * Gets the resourceKind.
   *
   * The resource kind matching the resource request.
   *
   * @return the resourceKind
   */
  public String getResourceKind() {
    return resourceKind;
  }

  /**
   * Gets the configRequestId.
   *
   * Unique identifier for this request and any related pagination requests.
   *
   * @return the configRequestId
   */
  public String getConfigRequestId() {
    return configRequestId;
  }

  /**
   * Gets the timestamp.
   *
   * Time the resource state was collected. Timestamps are in UTC.
   *
   * @return the timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Gets the configState.
   *
   * Container array for one or more resources and associated state.
   *
   * @return the configState
   */
  public List<CIPResourceConfigStateItem> getConfigState() {
    return configState;
  }
}

