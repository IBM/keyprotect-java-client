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
 * The createKeyAlias options.
 */
public class CreateKeyAliasOptions extends GenericModel {

  protected String id;
  protected String alias;
  protected String bluemixInstance;
  protected String correlationId;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String alias;
    private String bluemixInstance;
    private String correlationId;
    private String xKmsKeyRing;

    /**
     * Instantiates a new Builder from an existing CreateKeyAliasOptions instance.
     *
     * @param createKeyAliasOptions the instance to initialize the Builder with
     */
    private Builder(CreateKeyAliasOptions createKeyAliasOptions) {
      this.id = createKeyAliasOptions.id;
      this.alias = createKeyAliasOptions.alias;
      this.bluemixInstance = createKeyAliasOptions.bluemixInstance;
      this.correlationId = createKeyAliasOptions.correlationId;
      this.xKmsKeyRing = createKeyAliasOptions.xKmsKeyRing;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     * @param alias the alias
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String id, String alias, String bluemixInstance) {
      this.id = id;
      this.alias = alias;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a CreateKeyAliasOptions.
     *
     * @return the new CreateKeyAliasOptions instance
     */
    public CreateKeyAliasOptions build() {
      return new CreateKeyAliasOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateKeyAliasOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the alias.
     *
     * @param alias the alias
     * @return the CreateKeyAliasOptions builder
     */
    public Builder alias(String alias) {
      this.alias = alias;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the CreateKeyAliasOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the CreateKeyAliasOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the CreateKeyAliasOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }
  }

  protected CreateKeyAliasOptions() { }

  protected CreateKeyAliasOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.alias,
      "alias cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    id = builder.id;
    alias = builder.alias;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
  }

  /**
   * New builder.
   *
   * @return a CreateKeyAliasOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The v4 UUID or alias that uniquely identifies the key.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the alias.
   *
   * A human-readable alias that uniquely identifies a key. Each alias is unique  only within the given instance and is
   * not reserved across the Key Protect service.  Each key can have up to five aliases. There is no limit to the number
   * of aliases  per instance. The length of the alias can be between 2 - 90 characters, inclusive.  An alias must be
   * alphanumeric and cannot contain spaces or special characters other  than '-' or '_'. Also, the alias cannot be a
   * version 4 UUID and must not be  a Key Protect reserved name: `allowed_ip`, `key`, `keys`, `metadata`, `policy`,
   * `policies`, `registration`, `registrations`, `ring`, `rings`, `rotate`, `wrap`, `unwrap`, `rewrap`, `version`,
   * `versions`.
   *
   * @return the alias
   */
  public String alias() {
    return alias;
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
   * Gets the xKmsKeyRing.
   *
   * The ID of the key ring that the specified key is a part of. When the  header is not specified, Key Protect will
   * perform a key ring lookup. For  a more optimized request, specify the key ring on every call. The key ring ID of
   * keys that are created without an `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
  }
}

