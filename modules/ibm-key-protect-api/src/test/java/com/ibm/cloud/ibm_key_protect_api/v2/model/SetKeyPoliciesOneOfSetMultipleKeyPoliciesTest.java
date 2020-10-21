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
 * Unit test class for the SetKeyPoliciesOneOfSetMultipleKeyPolicies model.
 */
public class SetKeyPoliciesOneOfSetMultipleKeyPoliciesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetKeyPoliciesOneOfSetMultipleKeyPolicies() throws Throwable {
    KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
      .intervalMonth(Long.valueOf("1"))
      .build();
    assertEquals(keyPolicyRotationRotationModel.intervalMonth(), Long.valueOf("1"));

    KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDelete = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
      .enabled(true)
      .build();
    assertEquals(keyPolicyDualAuthDeleteDualAuthDelete.enabled(), Boolean.valueOf(true));

    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    SetMultipleKeyPoliciesResourcesItem setMultipleKeyPoliciesResourcesItemModel = new SetMultipleKeyPoliciesResourcesItem.Builder()
      .type("application/vnd.ibm.kms.policy+json")
      .dualAuthDelete(keyPolicyDualAuthDeleteDualAuthDelete)
      .rotation(keyPolicyRotationRotationModel)
      .build();
    assertEquals(setMultipleKeyPoliciesResourcesItemModel.type(), "application/vnd.ibm.kms.policy+json");
    assertEquals(setMultipleKeyPoliciesResourcesItemModel.dualAuthDelete(), keyPolicyDualAuthDeleteDualAuthDelete);
    assertEquals(setMultipleKeyPoliciesResourcesItemModel.rotation(), keyPolicyRotationRotationModel);

    SetKeyPoliciesOneOfSetMultipleKeyPolicies setKeyPoliciesOneOfSetMultipleKeyPoliciesModel = new SetKeyPoliciesOneOfSetMultipleKeyPolicies.Builder()
      .metadata(collectionMetadataModel)
      .resources(new ArrayList<SetMultipleKeyPoliciesResourcesItem>(Arrays.asList(setMultipleKeyPoliciesResourcesItemModel)))
      .build();
    assertEquals(setKeyPoliciesOneOfSetMultipleKeyPoliciesModel.metadata(), collectionMetadataModel);
    assertEquals(setKeyPoliciesOneOfSetMultipleKeyPoliciesModel.resources(), new ArrayList<SetMultipleKeyPoliciesResourcesItem>(Arrays.asList(setMultipleKeyPoliciesResourcesItemModel)));

    String json = TestUtilities.serialize(setKeyPoliciesOneOfSetMultipleKeyPoliciesModel);

    SetKeyPoliciesOneOfSetMultipleKeyPolicies setKeyPoliciesOneOfSetMultipleKeyPoliciesModelNew = TestUtilities.deserialize(json, SetKeyPoliciesOneOfSetMultipleKeyPolicies.class);
    assertTrue(setKeyPoliciesOneOfSetMultipleKeyPoliciesModelNew instanceof SetKeyPoliciesOneOfSetMultipleKeyPolicies);
    assertEquals(setKeyPoliciesOneOfSetMultipleKeyPoliciesModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKeyPoliciesOneOfSetMultipleKeyPoliciesError() throws Throwable {
    new SetKeyPoliciesOneOfSetMultipleKeyPolicies.Builder().build();
  }

}