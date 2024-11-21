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

/**
 * The metadata that describes the resource array.
 */
public class CollectionMetadataOneOfCollectionMetadata extends CollectionMetadataOneOf {

  /**
   * The type of resources in the resource array.
   */
  public interface CollectionType {
    /** application/vnd.ibm.kms.allowed_ip_metadata+json. */
    String APPLICATION_VND_IBM_KMS_ALLOWED_IP_METADATA_JSON = "application/vnd.ibm.kms.allowed_ip_metadata+json";
    /** application/vnd.ibm.kms.crn+json. */
    String APPLICATION_VND_IBM_KMS_CRN_JSON = "application/vnd.ibm.kms.crn+json";
    /** application/vnd.ibm.kms.error+json. */
    String APPLICATION_VND_IBM_KMS_ERROR_JSON = "application/vnd.ibm.kms.error+json";
    /** application/vnd.ibm.kms.event_acknowledge+json. */
    String APPLICATION_VND_IBM_KMS_EVENT_ACKNOWLEDGE_JSON = "application/vnd.ibm.kms.event_acknowledge+json";
    /** application/vnd.ibm.kms.import_token+json. */
    String APPLICATION_VND_IBM_KMS_IMPORT_TOKEN_JSON = "application/vnd.ibm.kms.import_token+json";
    /** application/vnd.ibm.kms.key+json. */
    String APPLICATION_VND_IBM_KMS_KEY_JSON = "application/vnd.ibm.kms.key+json";
    /** application/vnd.ibm.kms.key_action+json. */
    String APPLICATION_VND_IBM_KMS_KEY_ACTION_JSON = "application/vnd.ibm.kms.key_action+json";
    /** application/vnd.ibm.kms.alias+json. */
    String APPLICATION_VND_IBM_KMS_ALIAS_JSON = "application/vnd.ibm.kms.alias+json";
    /** application/vnd.ibm.kms.key_ring+json. */
    String APPLICATION_VND_IBM_KMS_KEY_RING_JSON = "application/vnd.ibm.kms.key_ring+json";
    /** application/vnd.ibm.kms.policy+json. */
    String APPLICATION_VND_IBM_KMS_POLICY_JSON = "application/vnd.ibm.kms.policy+json";
    /** application/vnd.ibm.kms.registration_input+json. */
    String APPLICATION_VND_IBM_KMS_REGISTRATION_INPUT_JSON = "application/vnd.ibm.kms.registration_input+json";
    /** application/vnd.ibm.kms.registration+json. */
    String APPLICATION_VND_IBM_KMS_REGISTRATION_JSON = "application/vnd.ibm.kms.registration+json";
    /** application/vnd.ibm.kms.resource_crn+json. */
    String APPLICATION_VND_IBM_KMS_RESOURCE_CRN_JSON = "application/vnd.ibm.kms.resource_crn+json";
    /** application/vnd.ibm.kms.kmip_adapter+json. */
    String APPLICATION_VND_IBM_KMS_KMIP_ADAPTER_JSON = "application/vnd.ibm.kms.kmip_adapter+json";
    /** application/vnd.ibm.kms.kmip_client_certificate+json. */
    String APPLICATION_VND_IBM_KMS_KMIP_CLIENT_CERTIFICATE_JSON = "application/vnd.ibm.kms.kmip_client_certificate+json";
    /** application/vnd.ibm.kms.kmip_object+json. */
    String APPLICATION_VND_IBM_KMS_KMIP_OBJECT_JSON = "application/vnd.ibm.kms.kmip_object+json";
  }


  protected CollectionMetadataOneOfCollectionMetadata() { }
}

