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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The base schema for retrieving key metadata.
 */
public class GetKeyMetadata extends GenericModel {

  protected CollectionMetadata metadata;
  protected List<KeyFullRepresentation> resources;

  /**
   * Gets the metadata.
   *
   * The metadata that describes the resource array.
   *
   * @return the metadata
   */
  public CollectionMetadata getMetadata() {
    return metadata;
  }

  /**
   * Gets the resources.
   *
   * A collection of resources.
   *
   * @return the resources
   */
  public List<KeyFullRepresentation> getResources() {
    return resources;
  }
}

