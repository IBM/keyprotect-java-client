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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getKeys options.
 */
public class GetKeysOptions extends GenericModel {

  protected String bluemixInstance;
  protected String correlationId;
  protected Long limit;
  protected Long offset;
  protected List<Long> state;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private Long limit;
    private Long offset;
    private List<Long> state;

    private Builder(GetKeysOptions getKeysOptions) {
      this.bluemixInstance = getKeysOptions.bluemixInstance;
      this.correlationId = getKeysOptions.correlationId;
      this.limit = getKeysOptions.limit;
      this.offset = getKeysOptions.offset;
      this.state = getKeysOptions.state;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a GetKeysOptions.
     *
     * @return the new GetKeysOptions instance
     */
    public GetKeysOptions build() {
      return new GetKeysOptions(this);
    }

    /**
     * Adds an state to state.
     *
     * @param state the new state
     * @return the GetKeysOptions builder
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
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the GetKeysOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKeysOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetKeysOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetKeysOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the state.
     * Existing state will be replaced.
     *
     * @param state the state
     * @return the GetKeysOptions builder
     */
    public Builder state(List<Long> state) {
      this.state = state;
      return this;
    }
  }

  protected GetKeysOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    limit = builder.limit;
    offset = builder.offset;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a GetKeysOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the correlationId.
   *
   * The v4 UUID used to correlate and track transactions.
   *
   * @return the correlationId
   */
  public String correlationId() {
    return correlationId;
  }

  /**
   * Gets the limit.
   *
   * The number of keys to retrieve. By default, `GET /keys` returns the first 200 keys. To retrieve a different set of
   * keys, use `limit` with `offset` to page through your available resources. The maximum value for `limit` is 5000.
   *
   * **Usage:** If you have 20 keys in your instance, and you want to retrieve only the first 5 keys, use
   * `../keys?limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of keys to skip. By specifying `offset`, you retrieve a subset of keys that starts with the `offset`
   * value. Use `offset` with `limit` to page through your available resources.
   *
   * **Usage:** If you have 100 keys in your instance, and you want to retrieve keys 26 through 50, use
   * `../keys?offset=25&amp;limit=25`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the state.
   *
   * The state of the keys to be retrieved. States must be a list of integers from 0 to 5 delimited by commas with no
   * whitespace or trailing commas. Valid states are based on NIST SP 800-57. States are integers and correspond to the
   * Pre-activation = 0, Active = 1, Suspended = 2, Deactivated = 3, and Destroyed = 5 values.
   *
   * **Usage:** If you want to retrieve active and deleted keys, use `../keys?state=1,5`.
   *
   * @return the state
   */
  public List<Long> state() {
    return state;
  }
}

