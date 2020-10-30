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
 * The getKeyCollectionMetadata options.
 */
public class GetKeyCollectionMetadataOptions extends GenericModel {

  protected String bluemixInstance;
  protected String correlationId;
  protected List<Long> state;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private List<Long> state;

    private Builder(GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptions) {
      this.bluemixInstance = getKeyCollectionMetadataOptions.bluemixInstance;
      this.correlationId = getKeyCollectionMetadataOptions.correlationId;
      this.state = getKeyCollectionMetadataOptions.state;
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
     * Builds a GetKeyCollectionMetadataOptions.
     *
     * @return the new GetKeyCollectionMetadataOptions instance
     */
    public GetKeyCollectionMetadataOptions build() {
      return new GetKeyCollectionMetadataOptions(this);
    }

    /**
     * Adds an state to state.
     *
     * @param state the new state
     * @return the GetKeyCollectionMetadataOptions builder
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
     * @return the GetKeyCollectionMetadataOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the GetKeyCollectionMetadataOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the state.
     * Existing state will be replaced.
     *
     * @param state the state
     * @return the GetKeyCollectionMetadataOptions builder
     */
    public Builder state(List<Long> state) {
      this.state = state;
      return this;
    }
  }

  protected GetKeyCollectionMetadataOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a GetKeyCollectionMetadataOptions builder
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

