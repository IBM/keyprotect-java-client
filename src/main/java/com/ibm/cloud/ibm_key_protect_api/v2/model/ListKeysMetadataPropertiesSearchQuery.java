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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Represents the parsed search query used for matching logic. Only returned when a search is requested.
 */
public class ListKeysMetadataPropertiesSearchQuery extends GenericModel {

  public interface Scopes {
    /** name. */
    String NAME = "name";
    /** alias. */
    String ALIAS = "alias";
  }

  protected String query;
  protected List<String> scopes;
  protected Boolean not;
  protected Boolean exact;

  protected ListKeysMetadataPropertiesSearchQuery() { }

  /**
   * Gets the query.
   *
   * final string to use for matching logic.
   *
   * @return the query
   */
  public String getQuery() {
    return query;
  }

  /**
   * Gets the scopes.
   *
   * list of scopes to search in.
   *
   * @return the scopes
   */
  public List<String> getScopes() {
    return scopes;
  }

  /**
   * Gets the not.
   *
   * invert matching logic.
   *
   * @return the not
   */
  public Boolean isNot() {
    return not;
  }

  /**
   * Gets the exact.
   *
   * only match query strings that are fully identical (case insensitive).
   *
   * @return the exact
   */
  public Boolean isExact() {
    return exact;
  }
}

