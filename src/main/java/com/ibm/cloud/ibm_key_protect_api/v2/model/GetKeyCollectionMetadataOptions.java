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
 * The getKeyCollectionMetadata options.
 */
public class GetKeyCollectionMetadataOptions extends GenericModel {

  protected String bluemixInstance;
  protected String correlationId;
  protected List<Long> state;
  protected Boolean extractable;
  protected String filter;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private List<Long> state;
    private Boolean extractable;
    private String filter;
    private String xKmsKeyRing;

    /**
     * Instantiates a new Builder from an existing GetKeyCollectionMetadataOptions instance.
     *
     * @param getKeyCollectionMetadataOptions the instance to initialize the Builder with
     */
    private Builder(GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptions) {
      this.bluemixInstance = getKeyCollectionMetadataOptions.bluemixInstance;
      this.correlationId = getKeyCollectionMetadataOptions.correlationId;
      this.state = getKeyCollectionMetadataOptions.state;
      this.extractable = getKeyCollectionMetadataOptions.extractable;
      this.filter = getKeyCollectionMetadataOptions.filter;
      this.xKmsKeyRing = getKeyCollectionMetadataOptions.xKmsKeyRing;
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

    /**
     * Set the extractable.
     *
     * @param extractable the extractable
     * @return the GetKeyCollectionMetadataOptions builder
     */
    public Builder extractable(Boolean extractable) {
      this.extractable = extractable;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the GetKeyCollectionMetadataOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the GetKeyCollectionMetadataOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }
  }

  protected GetKeyCollectionMetadataOptions() { }

  protected GetKeyCollectionMetadataOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    state = builder.state;
    extractable = builder.extractable;
    filter = builder.filter;
    xKmsKeyRing = builder.xKmsKeyRing;
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
   * **Usage:** If you want to retrieve active and deleted keys, use `../keys?state=1,5`.
   *
   * @return the state
   */
  public List<Long> state() {
    return state;
  }

  /**
   * Gets the extractable.
   *
   * The type of keys to be retrieved. Filters keys based on the `extractable` property. You can use this query
   * parameter to search for keys whose material can leave the service. If set to `true`, standard keys will be
   * retrieved. If set to `false`, root keys will be retrieved. If omitted, both root and standard keys will be
   * retrieved.
   * **Usage:** If you want to retrieve standard keys, use `../keys?extractable=true`.
   *
   * @return the extractable
   */
  public Boolean extractable() {
    return extractable;
  }

  /**
   * Gets the filter.
   *
   * When provided, returns the list of keys that match the queried properties. Each key property to be filtered on is
   * specified as the property name itself, followed by an “=“ symbol,  and then the value to filter on, followed by a
   * space if there are more properties to filter only. Note: Anything between `&lt;` and `&gt;` in the examples or
   * descriptions represent placeholder to specify the value
   * *Basic format*: &lt;propertyA&gt;=&lt;valueB&gt; &lt;propertyB&gt;=&lt;valueB&gt; - The value to filter on may
   * contain a value related to the property itself, or an operator followed by a value accepted by the operator - Only
   * one operator and value, or one value is accepted per property at a time
   * *Format with operator/value pair*: &lt;propertyA&gt;=&lt;operatorA&gt;:&lt;valueA&gt; Up to three of the same
   * property may be specified at a time. The key properties that can be filtered at this time are:
   * - `creationDate`
   *   * Date in RFC 3339 format in double-quotes: “YYYY-MM-DDTHH:mm:SSZ”
   * - `deletionDate`
   *   * Date in RFC 3339 format in double-quotes: “YYYY-MM-DDTHH:mm:SSZ”
   * - `expirationDate`
   *   * Date in RFC 3339 format in double-quotes: “YYYY-MM-DDTHH:mm:SSZ”
   * - `extractable`
   *   * Boolean true or false without quotes, case-insensitive
   * - `lastRotateDate`
   *   * Date in RFC 3339 format in double-quotes: “YYYY-MM-DDTHH:mm:SSZ”
   * - `lastUpdateDate`
   *   * Date in RFC 3339 format in double-quotes: “YYYY-MM-DDTHH:mm:SSZ”
   * - `state`
   *   * A list of comma-separated integers with no space in between: 0,1,2,3,5
   * - `hasMigrationIntent`
   *   * Boolean true or false without quotes, case-insensitive
   *
   * Comparison operations (operators) that can be performed on date values are:
   * - `lte:&lt;value&gt;` Less than or equal to - `lt:&lt;value&gt;` Less than - `gte:&lt;value&gt;` Greater than or
   * equal to - `gt:&lt;value&gt;` Greater than A special keyword for date, `none` (case-insensitive), may be used to
   * retreive keys that do not have that property. This is useful for `lastRotateDate`, where only keys that have never
   * been rotated can be  retreived.
   * *Examples*:
   * - `lastRotateDate="2022-02-15T00:00:00Z"` Filter keys that were last rotated on February 15, 2022 -
   * `lastRotateDate=gte:"2022-02-15T00:00:00Z"` Filter keys that were last rotated after or on February 15, 2022 -
   * `lastRotateDate=gte:"2022-02-15T00:00:00Z" lastRotateDate=lt:"2022-03-15T00:00:00Z"` Filter keys that were last
   * rotated after or on February 15, 2022 but before (not including) March 15, 2022 -
   * `lastRotateDate="2022-02-15T00:00:00Z" state=0,1,2,3,5 extractable=false` Filter root keys that were last rotated
   * on February 15, 2022, with any state
   * *Note*: When you filter by `state` or `extractable` in this query parameter, you will not be able to use the
   * deprecated `state` or `extractable` independent query parameter. You will get a 400 response code if you specify a
   * value for one of the two properties in both this filter query parameter and the deprecated independent query of the
   * same name (the same applies vice versa).
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the xKmsKeyRing.
   *
   * The ID of the target key ring. If unspecified, all resources in the instance that the caller has access to will be
   * returned. When the header  is specified, only resources within the specified key ring, that the caller has access
   * to,  will be returned. The key ring ID of keys that are created without an `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
  }
}

