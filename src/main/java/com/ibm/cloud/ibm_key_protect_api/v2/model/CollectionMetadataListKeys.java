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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The metadata that describes the list keys response.
 */
public class CollectionMetadataListKeys extends GenericModel {

  /**
   * The type of resources in the resource array.
   */
  public interface CollectionType {
    /** application/vnd.ibm.kms.crn+json. */
    String APPLICATION_VND_IBM_KMS_CRN_JSON = "application/vnd.ibm.kms.crn+json";
    /** application/vnd.ibm.kms.error+json. */
    String APPLICATION_VND_IBM_KMS_ERROR_JSON = "application/vnd.ibm.kms.error+json";
    /** application/vnd.ibm.kms.event_acknowledge+json. */
    String APPLICATION_VND_IBM_KMS_EVENT_ACKNOWLEDGE_JSON = "application/vnd.ibm.kms.event_acknowledge+json";
    /** application/vnd.ibm.kms.import_token+json. */
    String APPLICATION_VND_IBM_KMS_IMPORT_TOKEN_JSON = "application/vnd.ibm.kms.import_token+json";
    /** application/vnd.ibm.kms.key_action+json. */
    String APPLICATION_VND_IBM_KMS_KEY_ACTION_JSON = "application/vnd.ibm.kms.key_action+json";
    /** application/vnd.ibm.kms.key+json. */
    String APPLICATION_VND_IBM_KMS_KEY_JSON = "application/vnd.ibm.kms.key+json";
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
    /** application/vnd.ibm.kms.registration_input+json. */
    String APPLICATION_VND_IBM_KMS_REGISTRATION_INPUT_JSON = "application/vnd.ibm.kms.registration_input+json";
    /** application/vnd.ibm.kms.registration+json. */
    String APPLICATION_VND_IBM_KMS_REGISTRATION_JSON = "application/vnd.ibm.kms.registration+json";
    /** application/vnd.ibm.kms.resource_crn+json. */
    String APPLICATION_VND_IBM_KMS_RESOURCE_CRN_JSON = "application/vnd.ibm.kms.resource_crn+json";
    /** application/vnd.ibm.kms.migration_intent+json. */
    String APPLICATION_VND_IBM_KMS_MIGRATION_INTENT_JSON = "application/vnd.ibm.kms.migration_intent+json";
    /** application/vnd.ibm.kms.kmip_adapter+json. */
    String APPLICATION_VND_IBM_KMS_KMIP_ADAPTER_JSON = "application/vnd.ibm.kms.kmip_adapter+json";
    /** application/vnd.ibm.kms.kmip_adapter_certificate+json. */
    String APPLICATION_VND_IBM_KMS_KMIP_ADAPTER_CERTIFICATE_JSON = "application/vnd.ibm.kms.kmip_adapter_certificate+json";
  }

  protected String collectionType;
  protected Long collectionTotal;
  protected Boolean incompleteSearch;
  protected ListKeysMetadataPropertiesSearchQuery searchQuery;

  protected CollectionMetadataListKeys() { }

  /**
   * Gets the collectionType.
   *
   * The type of resources in the resource array.
   *
   * @return the collectionType
   */
  public String getCollectionType() {
    return collectionType;
  }

  /**
   * Gets the collectionTotal.
   *
   * The number of elements in the resource array.
   *
   * @return the collectionTotal
   */
  public Long getCollectionTotal() {
    return collectionTotal;
  }

  /**
   * Gets the incompleteSearch.
   *
   * If present, indicates the search did not complete due to the searchable set of keys being too large.  Please retry
   * your request with additional or more specific filters (i.e. extractable, state, etc.). To determine the size of the
   * searchable set of keys, please use `HEAD /api/v2/keys` with the desired search filters. For a search to be
   * performmed, the resulting set contain at most 5000 keys.
   *
   * @return the incompleteSearch
   */
  public Boolean isIncompleteSearch() {
    return incompleteSearch;
  }

  /**
   * Gets the searchQuery.
   *
   * Represents the parsed search query used for matching logic. Only returned when a search is requested.
   *
   * @return the searchQuery
   */
  public ListKeysMetadataPropertiesSearchQuery getSearchQuery() {
    return searchQuery;
  }
}

