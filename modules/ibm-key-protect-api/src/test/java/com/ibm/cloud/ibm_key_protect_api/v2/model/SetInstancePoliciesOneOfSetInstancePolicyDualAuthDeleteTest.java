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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DualAuthDeleteProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePolicyDualAuthDeleteResourcesItem;
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
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete() throws Throwable {
    DualAuthDeleteProperties dualAuthDeletePropertiesModel = new DualAuthDeleteProperties.Builder()
      .enabled(true)
      .build();
    assertEquals(dualAuthDeletePropertiesModel.enabled(), Boolean.valueOf(true));

    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    SetInstancePolicyDualAuthDeleteResourcesItem setInstancePolicyDualAuthDeleteResourcesItemModel = new SetInstancePolicyDualAuthDeleteResourcesItem.Builder()
      .policyType("dualAuthDelete")
      .policyData(dualAuthDeletePropertiesModel)
      .build();
    assertEquals(setInstancePolicyDualAuthDeleteResourcesItemModel.policyType(), "dualAuthDelete");
    assertEquals(setInstancePolicyDualAuthDeleteResourcesItemModel.policyData(), dualAuthDeletePropertiesModel);

    SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModel = new SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete.Builder()
      .metadata(collectionMetadataModel)
      .resources(new ArrayList<SetInstancePolicyDualAuthDeleteResourcesItem>(Arrays.asList(setInstancePolicyDualAuthDeleteResourcesItemModel)))
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModel.resources(), new ArrayList<SetInstancePolicyDualAuthDeleteResourcesItem>(Arrays.asList(setInstancePolicyDualAuthDeleteResourcesItemModel)));

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModel);

    SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyDualAuthDeleteError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete.Builder().build();
  }

}