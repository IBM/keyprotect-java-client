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

import com.ibm.cloud.ibm_key_protect_api.v2.model.DualAuthKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyVersion;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayload;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayloadAlgorithmMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the KeyWithPayload model.
 */
public class KeyWithPayloadTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testKeyWithPayload() throws Throwable {
    KeyWithPayload keyWithPayloadModel = new KeyWithPayload();
    assertNull(keyWithPayloadModel.getType());
    assertNull(keyWithPayloadModel.getName());
    assertNull(keyWithPayloadModel.getDescription());
    assertNull(keyWithPayloadModel.getTags());
    assertNull(keyWithPayloadModel.getExpirationDate());
    assertNull(keyWithPayloadModel.isExtractable());
    assertNull(keyWithPayloadModel.getAlgorithmMetadata());
    assertNull(keyWithPayloadModel.getAlgorithmBitSize());
    assertNull(keyWithPayloadModel.getAlgorithmMode());
    assertNull(keyWithPayloadModel.getKeyVersion());
    assertNull(keyWithPayloadModel.getDualAuthDelete());
  }
}