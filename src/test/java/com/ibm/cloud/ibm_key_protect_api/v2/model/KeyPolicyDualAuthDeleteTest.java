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

import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDeleteDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the KeyPolicyDualAuthDelete model.
 */
public class KeyPolicyDualAuthDeleteTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testKeyPolicyDualAuthDelete() throws Throwable {
    KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
      .enabled(true)
      .build();
    assertEquals(keyPolicyDualAuthDeleteDualAuthDeleteModel.enabled(), Boolean.valueOf(true));

    KeyPolicyDualAuthDelete keyPolicyDualAuthDeleteModel = new KeyPolicyDualAuthDelete.Builder()
      .type("application/vnd.ibm.kms.policy+json")
      .dualAuthDelete(keyPolicyDualAuthDeleteDualAuthDeleteModel)
      .build();
    assertEquals(keyPolicyDualAuthDeleteModel.type(), "application/vnd.ibm.kms.policy+json");
    assertEquals(keyPolicyDualAuthDeleteModel.dualAuthDelete(), keyPolicyDualAuthDeleteDualAuthDeleteModel);

    String json = TestUtilities.serialize(keyPolicyDualAuthDeleteModel);

    KeyPolicyDualAuthDelete keyPolicyDualAuthDeleteModelNew = TestUtilities.deserialize(json, KeyPolicyDualAuthDelete.class);
    assertTrue(keyPolicyDualAuthDeleteModelNew instanceof KeyPolicyDualAuthDelete);
    assertEquals(keyPolicyDualAuthDeleteModelNew.type(), "application/vnd.ibm.kms.policy+json");
    assertEquals(keyPolicyDualAuthDeleteModelNew.dualAuthDelete().toString(), keyPolicyDualAuthDeleteDualAuthDeleteModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testKeyPolicyDualAuthDeleteError() throws Throwable {
    new KeyPolicyDualAuthDelete.Builder().build();
  }

}