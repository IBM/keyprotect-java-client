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

import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotationRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the KeyPolicyRotationRotation model.
 */
public class KeyPolicyRotationRotationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testKeyPolicyRotationRotation() throws Throwable {
    KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
      .intervalMonth(Long.valueOf("1"))
      .build();
    assertEquals(keyPolicyRotationRotationModel.intervalMonth(), Long.valueOf("1"));

    String json = TestUtilities.serialize(keyPolicyRotationRotationModel);

    KeyPolicyRotationRotation keyPolicyRotationRotationModelNew = TestUtilities.deserialize(json, KeyPolicyRotationRotation.class);
    assertTrue(keyPolicyRotationRotationModelNew instanceof KeyPolicyRotationRotation);
    assertEquals(keyPolicyRotationRotationModelNew.intervalMonth(), Long.valueOf("1"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testKeyPolicyRotationRotationError() throws Throwable {
    new KeyPolicyRotationRotation.Builder().build();
  }

}