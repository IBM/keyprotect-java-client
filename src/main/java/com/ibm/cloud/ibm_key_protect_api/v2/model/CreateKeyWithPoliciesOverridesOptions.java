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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createKeyWithPoliciesOverrides options.
 */
public class CreateKeyWithPoliciesOverridesOptions extends GenericModel {

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

  protected String bluemixInstance;
  protected InputStream keyWithPolicyOverridesCreateBody;
  protected String correlationId;
  protected String prefer;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String bluemixInstance;
    private InputStream keyWithPolicyOverridesCreateBody;
    private String correlationId;
    private String prefer;
    private String xKmsKeyRing;

    /**
     * Instantiates a new Builder from an existing CreateKeyWithPoliciesOverridesOptions instance.
     *
     * @param createKeyWithPoliciesOverridesOptions the instance to initialize the Builder with
     */
    private Builder(CreateKeyWithPoliciesOverridesOptions createKeyWithPoliciesOverridesOptions) {
      this.bluemixInstance = createKeyWithPoliciesOverridesOptions.bluemixInstance;
      this.keyWithPolicyOverridesCreateBody = createKeyWithPoliciesOverridesOptions.keyWithPolicyOverridesCreateBody;
      this.correlationId = createKeyWithPoliciesOverridesOptions.correlationId;
      this.prefer = createKeyWithPoliciesOverridesOptions.prefer;
      this.xKmsKeyRing = createKeyWithPoliciesOverridesOptions.xKmsKeyRing;
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
     * @param keyWithPolicyOverridesCreateBody the keyWithPolicyOverridesCreateBody
     */
    public Builder(String bluemixInstance, InputStream keyWithPolicyOverridesCreateBody) {
      this.bluemixInstance = bluemixInstance;
      this.keyWithPolicyOverridesCreateBody = keyWithPolicyOverridesCreateBody;
    }

    /**
     * Builds a CreateKeyWithPoliciesOverridesOptions.
     *
     * @return the new CreateKeyWithPoliciesOverridesOptions instance
     */
    public CreateKeyWithPoliciesOverridesOptions build() {
      return new CreateKeyWithPoliciesOverridesOptions(this);
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the CreateKeyWithPoliciesOverridesOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the keyWithPolicyOverridesCreateBody.
     *
     * @param keyWithPolicyOverridesCreateBody the keyWithPolicyOverridesCreateBody
     * @return the CreateKeyWithPoliciesOverridesOptions builder
     */
    public Builder keyWithPolicyOverridesCreateBody(InputStream keyWithPolicyOverridesCreateBody) {
      this.keyWithPolicyOverridesCreateBody = keyWithPolicyOverridesCreateBody;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the CreateKeyWithPoliciesOverridesOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the prefer.
     *
     * @param prefer the prefer
     * @return the CreateKeyWithPoliciesOverridesOptions builder
     */
    public Builder prefer(String prefer) {
      this.prefer = prefer;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the CreateKeyWithPoliciesOverridesOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the keyWithPolicyOverridesCreateBody.
     *
     * @param keyWithPolicyOverridesCreateBody the keyWithPolicyOverridesCreateBody
     * @return the CreateKeyWithPoliciesOverridesOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder keyWithPolicyOverridesCreateBody(File keyWithPolicyOverridesCreateBody) throws FileNotFoundException {
      this.keyWithPolicyOverridesCreateBody = new FileInputStream(keyWithPolicyOverridesCreateBody);
      return this;
    }
  }

  protected CreateKeyWithPoliciesOverridesOptions() { }

  protected CreateKeyWithPoliciesOverridesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.keyWithPolicyOverridesCreateBody,
      "keyWithPolicyOverridesCreateBody cannot be null");
    bluemixInstance = builder.bluemixInstance;
    keyWithPolicyOverridesCreateBody = builder.keyWithPolicyOverridesCreateBody;
    correlationId = builder.correlationId;
    prefer = builder.prefer;
    xKmsKeyRing = builder.xKmsKeyRing;
  }

  /**
   * New builder.
   *
   * @return a CreateKeyWithPoliciesOverridesOptions builder
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
   * Gets the keyWithPolicyOverridesCreateBody.
   *
   * The base request for creating a new key with policies.
   *
   * @return the keyWithPolicyOverridesCreateBody
   */
  public InputStream keyWithPolicyOverridesCreateBody() {
    return keyWithPolicyOverridesCreateBody;
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
   * Gets the xKmsKeyRing.
   *
   * The ID of the key ring that the specified key belongs to. When the header is not specified,  Key Protect will
   * perform a key ring lookup. For a more optimized request,  specify the key ring on every call. The key ring ID of
   * keys that are created without an  `X-Kms-Key-Ring` header is: `default`.
   *
   * @return the xKmsKeyRing
   */
  public String xKmsKeyRing() {
    return xKmsKeyRing;
  }
}

