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
 * The getKeys options.
 */
public class GetKeysOptions extends GenericModel {

  /**
   * When provided, sorts the list of keys returned based on one or more key properties. To sort on a property in
   * descending order, prefix the term with "-". To sort on multiple key properties, use a comma to separate each
   * properties. The first property in the comma-separated list will be evaluated before the next. The key properties
   * that can be sorted at this time are:
   *   - `id`
   *   - `state`
   *   - `extractable`
   *   - `imported`
   *   - `creationDate`
   *   - `lastUpdateDate`
   *   - `lastRotateDate`
   *   - `deletionDate`
   *   - `expirationDate`
   *
   * The list of keys returned is sorted on id by default, if this parameter is not provided.
   */
  public interface Sort {
    /** id. */
    String ID = "id";
    /** state. */
    String STATE = "state";
    /** extractable. */
    String EXTRACTABLE = "extractable";
    /** imported. */
    String IMPORTED = "imported";
    /** creationDate. */
    String CREATIONDATE = "creationDate";
    /** lastUpdateDate. */
    String LASTUPDATEDATE = "lastUpdateDate";
    /** lastRotateDate. */
    String LASTROTATEDATE = "lastRotateDate";
    /** deletionDate. */
    String DELETIONDATE = "deletionDate";
    /** expirationDate. */
    String EXPIRATIONDATE = "expirationDate";
  }

  protected String bluemixInstance;
  protected String correlationId;
  protected Long limit;
  protected Long offset;
  protected List<Long> state;
  protected Boolean extractable;
  protected String search;
  protected String sort;
  protected String filter;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private String correlationId;
    private Long limit;
    private Long offset;
    private List<Long> state;
    private Boolean extractable;
    private String search;
    private String sort;
    private String filter;
    private String xKmsKeyRing;

    /**
     * Instantiates a new Builder from an existing GetKeysOptions instance.
     *
     * @param getKeysOptions the instance to initialize the Builder with
     */
    private Builder(GetKeysOptions getKeysOptions) {
      this.bluemixInstance = getKeysOptions.bluemixInstance;
      this.correlationId = getKeysOptions.correlationId;
      this.limit = getKeysOptions.limit;
      this.offset = getKeysOptions.offset;
      this.state = getKeysOptions.state;
      this.extractable = getKeysOptions.extractable;
      this.search = getKeysOptions.search;
      this.sort = getKeysOptions.sort;
      this.filter = getKeysOptions.filter;
      this.xKmsKeyRing = getKeysOptions.xKmsKeyRing;
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
     * Adds a new element to state.
     *
     * @param state the new element to be added
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

    /**
     * Set the extractable.
     *
     * @param extractable the extractable
     * @return the GetKeysOptions builder
     */
    public Builder extractable(Boolean extractable) {
      this.extractable = extractable;
      return this;
    }

    /**
     * Set the search.
     *
     * @param search the search
     * @return the GetKeysOptions builder
     */
    public Builder search(String search) {
      this.search = search;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the GetKeysOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the GetKeysOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the GetKeysOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }
  }

  protected GetKeysOptions() { }

  protected GetKeysOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    limit = builder.limit;
    offset = builder.offset;
    state = builder.state;
    extractable = builder.extractable;
    search = builder.search;
    sort = builder.sort;
    filter = builder.filter;
    xKmsKeyRing = builder.xKmsKeyRing;
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
   * keys, use `limit` with `offset` to page through your available resources. The maximum value for `limit` is 5,000.
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
   * Gets the search.
   *
   * When provided, performs a search, possibly limiting the number of keys returned.
   * *Examples*:
   *
   *   - `foobar` - find keys where the name or any of its aliases contain `foobar`, case insentive (i.e. matches
   * `xfoobar`, `Foobar`).
   *   - `fadedbee-0000-0000-0000-1234567890ab` (a valid key id) - find keys where the id the key is
   * `fadedbee-0000-0000-0000-1234567890ab`, or the name or any of its aliases contain
   * `fadedbee-0000-0000-0000-1234567890ab`, case insentive.
   *
   * May prepend with options:
   *
   *   - `not:` = when specified, inverts matching logic (example: `not:foo` will search for keys that have aliases or
   * names that do not contain `foo`)
   *   - `escape:` = everything after this option is take as plaintext (example: `escape:not:` will search for keys that
   * have an alias or name containing the substring `not:`)
   *   - `exact:` = only looks for exact matches
   *
   * May prepend with search scopes:
   *
   *   - `alias:` = search in key aliases for search query
   *   - `name:` = search in key names for search query
   *
   * *Examples*:
   *
   *   - `not:exact:foobar`/`exact:not:foobar` - find keys where the name nor any of its aliases are *not* exactly
   * `foobar` (i.e. matches `xfoobar`, `bar`, `foo`)
   *   - `exact:escape:not:foobar` - find keys where the name or any of its aliases are exactly `not:foobar`
   *   - `not:alias:foobar`/`alias:not:foobar` - find keys where any of its aliases do *not* contain `foobar`
   *   - `name:exact:foobar`/`exact:name:foobar` - find keys where the name is exactly `foobar`
   *
   * *Note*:
   *
   *   By default, if no scopes are provided, search will be performed in both `name` and `alias` scopes.
   *
   *   Search is only possible on a intial searchable space of at most 5000 keys. If the initial seachable space is
   * greater than 5000 keys, the API returns HTTP 400 with the property resouces[0].reasons[0].code equals to
   * 'KEY_SEARCH_TOO_BROAD'.
   *   Use the following filters to reduce the initial searchable space:
   *
   *   - `state` (query parameter)
   *   - `extractable` (query parameter)
   *   - `X-Kms-Key-Ring` (HTTP header)
   *
   *   If the total intial searchable space exceeds the 5000 keys limit and when providing a fully specified key id or
   * when searching within the `alias` scope, a lookup
   *   will  be performed and if a key is found, the key will be returned as the only resource and in the response
   * metadata the property `incompleteSearch` will
   *   be `true`.
   *
   *   When providing a fully specified key id or when searching within the `alias` scope, a key lookup is performed in
   * addition to the search.
   *   This means search will try to lookup a single key that is uniquely identified by the key id or provided alias,
   * this key will be included in the response
   *   as the first resource, before other matches.
   *
   *   Search scopes are disjunctive, behaving in an *OR* manner. When using more than one search scope,
   *   a match in at least one of the scopes will result in the key being returned.
   *
   * @return the search
   */
  public String search() {
    return search;
  }

  /**
   * Gets the sort.
   *
   * When provided, sorts the list of keys returned based on one or more key properties. To sort on a property in
   * descending order, prefix the term with "-". To sort on multiple key properties, use a comma to separate each
   * properties. The first property in the comma-separated list will be evaluated before the next. The key properties
   * that can be sorted at this time are:
   *   - `id`
   *   - `state`
   *   - `extractable`
   *   - `imported`
   *   - `creationDate`
   *   - `lastUpdateDate`
   *   - `lastRotateDate`
   *   - `deletionDate`
   *   - `expirationDate`
   *
   * The list of keys returned is sorted on id by default, if this parameter is not provided.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
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
   *   * A list of comma-separated integers with no space in between: 0,1,2,3,5 Comparison operations (operators) that
   * can be performed on date values are:
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

