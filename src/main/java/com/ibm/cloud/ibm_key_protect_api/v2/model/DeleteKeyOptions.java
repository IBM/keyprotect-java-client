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
 * The deleteKey options.
 */
public class DeleteKeyOptions extends GenericModel {

  /**
   * Alters server behavior for POST or DELETE operations. A header with `return=minimal` causes the service to return
   * only the key identifier as metadata. A header containing `return=representation` returns both the key material and
   * metadata in the response entity-body. If the key has been designated as a root key, the system cannot return the
   * key material.
   * **Note:** During POST operations, Key Protect may not immediately return the key material due to key generation
   * time. To retrieve the key material, you can perform a subsequent `GET /keys/{id}` request.
   */
  public interface Prefer {
    /** return=representation. */
    String RETURN_REPRESENTATION = "return=representation";
    /** return=minimal. */
    String RETURN_MINIMAL = "return=minimal";
  }

  protected String id;
  protected String bluemixInstance;
  protected String correlationId;
  protected String xKmsKeyRing;
  protected String prefer;
  protected Boolean force;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String bluemixInstance;
    private String correlationId;
    private String xKmsKeyRing;
    private String prefer;
    private Boolean force;

    /**
     * Instantiates a new Builder from an existing DeleteKeyOptions instance.
     *
     * @param deleteKeyOptions the instance to initialize the Builder with
     */
    private Builder(DeleteKeyOptions deleteKeyOptions) {
      this.id = deleteKeyOptions.id;
      this.bluemixInstance = deleteKeyOptions.bluemixInstance;
      this.correlationId = deleteKeyOptions.correlationId;
      this.xKmsKeyRing = deleteKeyOptions.xKmsKeyRing;
      this.prefer = deleteKeyOptions.prefer;
      this.force = deleteKeyOptions.force;
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
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String id, String bluemixInstance) {
      this.id = id;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a DeleteKeyOptions.
     *
     * @return the new DeleteKeyOptions instance
     */
    public DeleteKeyOptions build() {
      return new DeleteKeyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteKeyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the DeleteKeyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the DeleteKeyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the DeleteKeyOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the prefer.
     *
     * @param prefer the prefer
     * @return the DeleteKeyOptions builder
     */
    public Builder prefer(String prefer) {
      this.prefer = prefer;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the DeleteKeyOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected DeleteKeyOptions() { }

  protected DeleteKeyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    id = builder.id;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
    prefer = builder.prefer;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a DeleteKeyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The v4 UUID that uniquely identifies the key.
   *
   * @return the id
   */
  public String id() {
    return id;
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

  /**
   * Gets the prefer.
   *
   * Alters server behavior for POST or DELETE operations. A header with `return=minimal` causes the service to return
   * only the key identifier as metadata. A header containing `return=representation` returns both the key material and
   * metadata in the response entity-body. If the key has been designated as a root key, the system cannot return the
   * key material.
   * **Note:** During POST operations, Key Protect may not immediately return the key material due to key generation
   * time. To retrieve the key material, you can perform a subsequent `GET /keys/{id}` request.
   *
   * @return the prefer
   */
  public String prefer() {
    return prefer;
  }

  /**
   * Gets the force.
   *
   * If set to `true`, Key Protect forces deletion on a key that is protecting a cloud resource, such as a Cloud Object
   * Storage bucket. The action removes any registrations that are associated with the key.
   * **Note:** If a key is protecting a cloud resource that has a retention policy, Key Protect cannot delete the key.
   * Use `GET keys/{id}/registrations` to review registrations between the key and its associated cloud resources. To
   * enable deletion, contact an account owner to remove the retention policy on each resource that is associated with
   * this key.
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}

