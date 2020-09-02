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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The metadata for the key algorithm.
 */
public class KeyRepresentationAlgorithmMetadata extends GenericModel {

  /**
   * The encryption scheme used to generate the key. Currently, `CBC_PAD` is supported.
   */
  public interface Mode {
    /** CBC_PAD. */
    String CBC_PAD = "CBC_PAD";
  }

  protected String bitLength;
  protected String mode;

  /**
   * Gets the bitLength.
   *
   * The algorithm bit size used for key encryption.
   *
   * @return the bitLength
   */
  public String getBitLength() {
    return bitLength;
  }

  /**
   * Gets the mode.
   *
   * The encryption scheme used to generate the key. Currently, `CBC_PAD` is supported.
   *
   * @return the mode
   */
  public String getMode() {
    return mode;
  }
}

