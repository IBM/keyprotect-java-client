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
 * The patchKey options.
 */
public class PatchKeyOptions extends GenericModel {

  protected String id;
  protected String bluemixInstance;
  protected InputStream keyPatchBody;
  protected String correlationId;
  protected String xKmsKeyRing;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String bluemixInstance;
    private InputStream keyPatchBody;
    private String correlationId;
    private String xKmsKeyRing;

    /**
     * Instantiates a new Builder from an existing PatchKeyOptions instance.
     *
     * @param patchKeyOptions the instance to initialize the Builder with
     */
    private Builder(PatchKeyOptions patchKeyOptions) {
      this.id = patchKeyOptions.id;
      this.bluemixInstance = patchKeyOptions.bluemixInstance;
      this.keyPatchBody = patchKeyOptions.keyPatchBody;
      this.correlationId = patchKeyOptions.correlationId;
      this.xKmsKeyRing = patchKeyOptions.xKmsKeyRing;
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
     * Builds a PatchKeyOptions.
     *
     * @return the new PatchKeyOptions instance
     */
    public PatchKeyOptions build() {
      return new PatchKeyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the PatchKeyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the PatchKeyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the keyPatchBody.
     *
     * @param keyPatchBody the keyPatchBody
     * @return the PatchKeyOptions builder
     */
    public Builder keyPatchBody(InputStream keyPatchBody) {
      this.keyPatchBody = keyPatchBody;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the PatchKeyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the xKmsKeyRing.
     *
     * @param xKmsKeyRing the xKmsKeyRing
     * @return the PatchKeyOptions builder
     */
    public Builder xKmsKeyRing(String xKmsKeyRing) {
      this.xKmsKeyRing = xKmsKeyRing;
      return this;
    }

    /**
     * Set the keyPatchBody.
     *
     * @param keyPatchBody the keyPatchBody
     * @return the PatchKeyOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder keyPatchBody(File keyPatchBody) throws FileNotFoundException {
      this.keyPatchBody = new FileInputStream(keyPatchBody);
      return this;
    }
  }

  protected PatchKeyOptions() { }

  protected PatchKeyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    id = builder.id;
    bluemixInstance = builder.bluemixInstance;
    keyPatchBody = builder.keyPatchBody;
    correlationId = builder.correlationId;
    xKmsKeyRing = builder.xKmsKeyRing;
  }

  /**
   * New builder.
   *
   * @return a PatchKeyOptions builder
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
   * Gets the keyPatchBody.
   *
   * The base request for patch key.
   *
   * @return the keyPatchBody
   */
  public InputStream keyPatchBody() {
    return keyPatchBody;
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

