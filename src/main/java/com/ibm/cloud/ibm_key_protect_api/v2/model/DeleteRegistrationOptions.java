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
 * The deleteRegistration options.
 */
public class DeleteRegistrationOptions extends GenericModel {

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
  protected String urlEncodedResourceCrn;
  protected String bluemixInstance;
  protected String correlationId;
  protected String xKmsKeyRing;
  protected String prefer;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String urlEncodedResourceCrn;
    private String bluemixInstance;
    private String correlationId;
    private String xKmsKeyRing;
    private String prefer;

    /**
     * Instantiates a new Builder from an existing DeleteRegistrationOptions instance.
     *
     * @param deleteRegistrationOptions the instance to initialize the Builder with
     */
    private Builder(DeleteRegistrationOptions deleteRegistrationOptions) {
      this.id = deleteRegistrationOptions.id;
      this.urlEncodedResourceCrn = deleteRegistrationOptions.urlEncodedResourceCrn;
      this.bluemixInstance = deleteRegistrationOptions.bluemixInstance;
      this.correlationId = deleteRegistrationOptions.correlationId;
      this.xKmsKeyRing = deleteRegistrationOptions.xKmsKeyRing;
      this.prefer = deleteRegistrationOptions.prefer;
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
     * @param urlEncodedResourceCrn the urlEncodedResourceCrn
     * @param bluemixInstance the bluemixInstance
     */
    public Builder(String id, String urlEncodedResourceCrn, String bluemixInstance) {
      this.id = id;
      this.urlEncodedResourceCrn = urlEncodedResourceCrn;
      this.bluemixInstance = bluemixInstance;
    }

    /**
     * Builds a DeleteRegistrationOptions.
     *
     * @return the new DeleteRegistrationOptions instance
     */
    public DeleteRegistrationOptions build() {
      return new DeleteRegistrationOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteRegistrationOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the urlEncodedResourceCrn.
     *
     * @param urlEncodedResourceCrn the urlEncodedResourceCrn
     * @return the DeleteRegistrationOptions builder
     */
    public Builder urlEncodedResourceCrn(String urlEncodedResourceCrn) {
      this.urlEncodedResourceCrn = urlEncodedResourceCrn;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the DeleteRegistrationOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the DeleteRegistrationOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the DeleteRegistrationOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the prefer.
     *
     * @param prefer the prefer
     * @return the DeleteRegistrationOptions builder
     */
    public Builder prefer(String prefer) {
      this.prefer = prefer;
      return this;
    }
  }

  protected DeleteRegistrationOptions() { }

  protected DeleteRegistrationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.urlEncodedResourceCrn,
      "urlEncodedResourceCrn cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    id = builder.id;
    urlEncodedResourceCrn = builder.urlEncodedResourceCrn;
    bluemixInstance = builder.bluemixInstance;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
    prefer = builder.prefer;
  }

  /**
   * New builder.
   *
   * @return a DeleteRegistrationOptions builder
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
   * Gets the urlEncodedResourceCrn.
   *
   * The URL encoded [Cloud Resource Name](/docs/account?topic=account-crn) (CRN) that uniquely identifies the cloud
   * resource. At minimum, provide a CRN that includes the `service-instance` segment.
   *
   * @return the urlEncodedResourceCrn
   */
  public String urlEncodedResourceCrn() {
    return urlEncodedResourceCrn;
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
}

