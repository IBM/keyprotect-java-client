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
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotationRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyPoliciesOneOfSetKeyPolicyRotation;
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
 * Unit test class for the SetKeyPoliciesOneOfSetKeyPolicyRotation model.
 */
public class SetKeyPoliciesOneOfSetKeyPolicyRotationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetKeyPoliciesOneOfSetKeyPolicyRotation() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
      .intervalMonth(Long.valueOf("1"))
      .build();
    assertEquals(keyPolicyRotationRotationModel.intervalMonth(), Long.valueOf("1"));

    KeyPolicyRotation keyPolicyRotationModel = new KeyPolicyRotation.Builder()
      .type("application/vnd.ibm.kms.policy+json")
      .rotation(keyPolicyRotationRotationModel)
      .build();
    assertEquals(keyPolicyRotationModel.type(), "application/vnd.ibm.kms.policy+json");
    assertEquals(keyPolicyRotationModel.rotation(), keyPolicyRotationRotationModel);

    SetKeyPoliciesOneOfSetKeyPolicyRotation setKeyPoliciesOneOfSetKeyPolicyRotationModel = new SetKeyPoliciesOneOfSetKeyPolicyRotation.Builder()
      .metadata(collectionMetadataModel)
      .resources(new java.util.ArrayList<KeyPolicyRotation>(java.util.Arrays.asList(keyPolicyRotationModel)))
      .build();
    assertEquals(setKeyPoliciesOneOfSetKeyPolicyRotationModel.metadata(), collectionMetadataModel);
    assertEquals(setKeyPoliciesOneOfSetKeyPolicyRotationModel.resources(), new java.util.ArrayList<KeyPolicyRotation>(java.util.Arrays.asList(keyPolicyRotationModel)));

    String json = TestUtilities.serialize(setKeyPoliciesOneOfSetKeyPolicyRotationModel);

    SetKeyPoliciesOneOfSetKeyPolicyRotation setKeyPoliciesOneOfSetKeyPolicyRotationModelNew = TestUtilities.deserialize(json, SetKeyPoliciesOneOfSetKeyPolicyRotation.class);
    assertTrue(setKeyPoliciesOneOfSetKeyPolicyRotationModelNew instanceof SetKeyPoliciesOneOfSetKeyPolicyRotation);
    assertEquals(setKeyPoliciesOneOfSetKeyPolicyRotationModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKeyPoliciesOneOfSetKeyPolicyRotationError() throws Throwable {
    new SetKeyPoliciesOneOfSetKeyPolicyRotation.Builder().build();
  }

}