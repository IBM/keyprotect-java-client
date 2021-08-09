/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDeleteDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete model.
 */
public class SetKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

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

    SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModel = new SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.Builder()
      .metadata(collectionMetadataModel)
      .resources(new java.util.ArrayList<KeyPolicyDualAuthDelete>(java.util.Arrays.asList(keyPolicyDualAuthDeleteModel)))
      .build();
    assertEquals(setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModel.metadata(), collectionMetadataModel);
    assertEquals(setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModel.resources(), new java.util.ArrayList<KeyPolicyDualAuthDelete>(java.util.Arrays.asList(keyPolicyDualAuthDeleteModel)));

    String json = TestUtilities.serialize(setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModel);

    SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModelNew = TestUtilities.deserialize(json, SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.class);
    assertTrue(setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModelNew instanceof SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete);
    assertEquals(setKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKeyPoliciesOneOfSetKeyPolicyDualAuthDeleteError() throws Throwable {
    new SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.Builder().build();
  }

}