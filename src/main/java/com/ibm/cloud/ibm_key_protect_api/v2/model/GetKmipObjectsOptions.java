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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getKmipObjects options.
 */
public class GetKmipObjectsOptions extends GenericModel {

  protected String adapterId;
  protected String bluemixInstance;
  protected Long limit;
  protected Long offset;
  protected Boolean totalCount;
  protected List<Long> state;
  protected String correlationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String adapterId;
    private String bluemixInstance;
    private Long limit;
    private Long offset;
    private Boolean totalCount;
    private List<Long> state;
    private String correlationId;

    /**
     * Instantiates a new Builder from an existing GetKmipObjectsOptions instance.
     *
     * @param getKmipObjectsOptions the instance to initialize the Builder with
     */
    private Builder(GetKmipObjectsOptions getKmipObjectsOptions) {
      this.adapterId = getKmipObjectsOptions.adapterId;
      this.bluemixInstance = getKmipObjectsOptions.bluemixInstance;
      this.limit = getKmipObjectsOptions.limit;
      this.offset = getKmipObjectsOptions.offset;
      this.totalCount = getKmipObjectsOptions.totalCount;
      this.state = getKmipObjectsOptions.state;
      this.correlationId = getKmipObjectsOptions.correlationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param adapterId the adapterId
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String adapterId, String bluemixInstance) {
      this.adapterId = adapterId;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a GetKmipObjectsOptions.
     *
     * @return the new GetKmipObjectsOptions instance
     */
    public GetKmipObjectsOptions build() {
      return new GetKmipObjectsOptions(this);
    }

    /**
     * Adds a new element to state.
     *
     * @param state the new element to be added
     * @return the GetKmipObjectsOptions builder
     */
    public Builder addState(Long state) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(state,
        "state cannot be null");
      if (this.state == null) {
        this.state = new ArrayList<Long>();
      }
      this.state.add(state);
      return this;
    }

    /**
     * Set the adapterId.
     *
     * @param adapterId the adapterId
     * @return the GetKmipObjectsOptions builder
     */
    public Builder adapterId(String adapterId) {
      this.adapterId = adapterId;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetKmipObjectsOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetKmipObjectsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetKmipObjectsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the GetKmipObjectsOptions builder
     */
    public Builder totalCount(Boolean totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    /**
     * Set the state.
     * Existing state will be replaced.
     *
     * @param state the state
     * @return the GetKmipObjectsOptions builder
     */
    public Builder state(List<Long> state) {
      this.state = state;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKmipObjectsOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }
  }

  protected GetKmipObjectsOptions() { }

  protected GetKmipObjectsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.adapterId,
      "adapterId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    adapterId = builder.adapterId;
    bluemixInstance = builder.bluemixInstance;
    limit = builder.limit;
    offset = builder.offset;
    totalCount = builder.totalCount;
    state = builder.state;
    correlationId = builder.correlationId;
  }

  /**
   * New builder.
   *
   * @return a GetKmipObjectsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the adapterId.
   *
   * The name or v4 UUID of the KMIP Adapter that uniquely identifies it.
   *
   * @return the adapterId
   */
  public String adapterId() {
    return adapterId;
  }

  /**
   * Gets the bluemixInstance.
   *
   * The IBM Cloud instance ID that identifies your Key Protect service instance.
   *
   * @return the bluemixInstance
   */
  public String bluemixInstance() {
    return bluemixInstance;
  }

  /**
   * Gets the limit.
   *
   * The number of kmip objects to retrieve. By default, `GET /kmip_adapters/{id}/kmip_objects` returns the first 100
   * kmip_objects. To retrieve a different set of kmip objects, use `limit` with `offset` to page through your available
   * resources. The maximum value for `limit` is 5000.
   * **Usage:** If you have 20 kmip objects associated with your KMIP adapter, and you want to retrieve only the first 5
   * kmip objects, use `../kmip_adapters/{id}/kmip_objects?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of kmip objects to skip. By specifying `offset`, you retrieve a subset of kmip objects that starts with
   * the `offset` value. Use `offset` with `limit` to page through your available resources.
   * **Usage:** If you have 20 kmip objects associated with your KMIP adapter, and you want to retrieve kmip objects 11
   * through 15, use `../kmip_adapters/{id}/kmip_objects?offset=10&amp;limit=5`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the totalCount.
   *
   * If set to `true`, returns `totalCount` in the response metadata for use with pagination. The `totalCount` value
   * returned specifies the total number of kmip objects that match the request, disregarding limit and offset. The
   * default is set to false. **Usage:** To return the `totalCount` value for use with pagination, use
   * `../kmip_adapters/{id}/kmip_objects?totalCount=true`.
   *
   * @return the totalCount
   */
  public Boolean totalCount() {
    return totalCount;
  }

  /**
   * Gets the state.
   *
   * List of states to filter the KMIP objects on. The `default` is set to `[1,2,3,4]`. States are integers and
   * correspond to Pre-Active = 1, Active = 2, Deactivated = 3, Compromised = 4, Destroyed = 5, Destroyed Compromised =
   * 6. **Usage:** To filter on multiples `state` values, use `../kmip_adapters/{id}/kmip_objects?state=2,3`.
   *
   * @return the state
   */
  public List<Long> state() {
    return state;
  }

  /**
   * Gets the correlationId.
   *
   * The v4 UUID used to correlate and track transactions.
   *
   * @return the correlationId
   */
  public String correlationId() {
    return correlationId;
  }
}

