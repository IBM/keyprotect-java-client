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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The actionOnKey options.
 */
public class ActionOnKeyOptions extends GenericModel {

  /**
   * The action to perform on the specified key.
   */
  public interface Action {
    /** wrap. */
    String WRAP = "wrap";
    /** unwrap. */
    String UNWRAP = "unwrap";
    /** rotate. */
    String ROTATE = "rotate";
    /** rewrap. */
    String REWRAP = "rewrap";
    /** setKeyForDeletion. */
    String SETKEYFORDELETION = "setKeyForDeletion";
    /** unsetKeyForDeletion. */
    String UNSETKEYFORDELETION = "unsetKeyForDeletion";
    /** disable. */
    String DISABLE = "disable";
    /** enable. */
    String ENABLE = "enable";
    /** restore. */
    String RESTORE = "restore";
  }

  /**
   * Alters server behavior for POST or DELETE operations. A header with `return=minimal` causes the service to  return
   * only the key identifier, or metadata. A header containing `return=representation` returns both the key  material
   * and metadata in the response entity-body. If the key has been designated as a root key, the  system cannot return
   * the key material.
   *
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
  protected String action;
  protected InputStream keyActionOneOf;
  protected String correlationId;
  protected String prefer;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String bluemixInstance;
    private String action;
    private InputStream keyActionOneOf;
    private String correlationId;
    private String prefer;

    private Builder(ActionOnKeyOptions actionOnKeyOptions) {
      this.id = actionOnKeyOptions.id;
      this.bluemixInstance = actionOnKeyOptions.bluemixInstance;
      this.action = actionOnKeyOptions.action;
      this.keyActionOneOf = actionOnKeyOptions.keyActionOneOf;
      this.correlationId = actionOnKeyOptions.correlationId;
      this.prefer = actionOnKeyOptions.prefer;
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
     * @param action the action
     * @param keyActionOneOf the keyActionOneOf
     */
    public Builder(String id, String bluemixInstance, String action, InputStream keyActionOneOf) {
      this.id = id;
      this.bluemixInstance = bluemixInstance;
      this.action = action;
      this.keyActionOneOf = keyActionOneOf;
    }

    /**
     * Builds a ActionOnKeyOptions.
     *
     * @return the new ActionOnKeyOptions instance
     */
    public ActionOnKeyOptions build() {
      return new ActionOnKeyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ActionOnKeyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the bluemixInstance.
     *
     * @param bluemixInstance the bluemixInstance
     * @return the ActionOnKeyOptions builder
     */
    public Builder bluemixInstance(String bluemixInstance) {
      this.bluemixInstance = bluemixInstance;
      return this;
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the ActionOnKeyOptions builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }

    /**
     * Set the keyActionOneOf.
     *
     * @param keyActionOneOf the keyActionOneOf
     * @return the ActionOnKeyOptions builder
     */
    public Builder keyActionOneOf(InputStream keyActionOneOf) {
      this.keyActionOneOf = keyActionOneOf;
      return this;
    }

    /**
     * Set the correlationId.
     *
     * @param correlationId the correlationId
     * @return the ActionOnKeyOptions builder
     */
    public Builder correlationId(String correlationId) {
      this.correlationId = correlationId;
      return this;
    }

    /**
     * Set the prefer.
     *
     * @param prefer the prefer
     * @return the ActionOnKeyOptions builder
     */
    public Builder prefer(String prefer) {
      this.prefer = prefer;
      return this;
    }

    /**
     * Set the keyActionOneOf.
     *
     * @param keyActionOneOf the keyActionOneOf
     * @return the ActionOnKeyOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder keyActionOneOf(File keyActionOneOf) throws FileNotFoundException {
      this.keyActionOneOf = new FileInputStream(keyActionOneOf);
      return this;
    }
  }

  protected ActionOnKeyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bluemixInstance,
      "bluemixInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action,
      "action cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.keyActionOneOf,
      "keyActionOneOf cannot be null");
    id = builder.id;
    bluemixInstance = builder.bluemixInstance;
    action = builder.action;
    keyActionOneOf = builder.keyActionOneOf;
    correlationId = builder.correlationId;
    prefer = builder.prefer;
  }

  /**
   * New builder.
   *
   * @return a ActionOnKeyOptions builder
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
   * Gets the action.
   *
   * The action to perform on the specified key.
   *
   * @return the action
   */
  public String action() {
    return action;
  }

  /**
   * Gets the keyActionOneOf.
   *
   * The base request for key actions.
   *
   * @return the keyActionOneOf
   */
  public InputStream keyActionOneOf() {
    return keyActionOneOf;
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
   * Alters server behavior for POST or DELETE operations. A header with `return=minimal` causes the service to  return
   * only the key identifier, or metadata. A header containing `return=representation` returns both the key  material
   * and metadata in the response entity-body. If the key has been designated as a root key, the  system cannot return
   * the key material.
   *
   * **Note:** During POST operations, Key Protect may not immediately return the key material due to key generation
   * time. To retrieve the key material, you can perform a subsequent `GET /keys/{id}` request.
   *
   * @return the prefer
   */
  public String prefer() {
    return prefer;
  }
}

