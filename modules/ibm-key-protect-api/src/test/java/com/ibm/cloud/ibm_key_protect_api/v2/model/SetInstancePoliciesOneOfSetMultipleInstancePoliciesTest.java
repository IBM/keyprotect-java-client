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
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetMultipleInstancePolicies;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes;
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
 * Unit test class for the SetInstancePoliciesOneOfSetMultipleInstancePolicies model.
 */
public class SetInstancePoliciesOneOfSetMultipleInstancePoliciesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetMultipleInstancePolicies() throws Throwable {
    SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel = new SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes.Builder()
      .allowedNetwork("public-and-private")
      .allowedIp(new ArrayList<String>(Arrays.asList("testString")))
      .createRootKey(true)
      .createStandardKey(true)
      .importRootKey(true)
      .importStandardKey(true)
      .enforceToken(true)
      .build();
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.allowedNetwork(), "public-and-private");
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.allowedIp(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.createRootKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.createStandardKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.importRootKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.importStandardKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.enforceToken(), Boolean.valueOf(true));

    SetMultipleInstancePoliciesResourcesItemPolicyData setMultipleInstancePoliciesResourcesItemPolicyDataModel = new SetMultipleInstancePoliciesResourcesItemPolicyData.Builder()
      .enabled(true)
      .attributes(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel)
      .build();
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataModel.attributes(), setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel);

    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    SetMultipleInstancePoliciesResourcesItem setMultipleInstancePoliciesResourcesItemModel = new SetMultipleInstancePoliciesResourcesItem.Builder()
      .policyType("allowedNetwork")
      .policyData(setMultipleInstancePoliciesResourcesItemPolicyDataModel)
      .build();
    assertEquals(setMultipleInstancePoliciesResourcesItemModel.policyType(), "allowedNetwork");
    assertEquals(setMultipleInstancePoliciesResourcesItemModel.policyData(), setMultipleInstancePoliciesResourcesItemPolicyDataModel);

    SetInstancePoliciesOneOfSetMultipleInstancePolicies setInstancePoliciesOneOfSetMultipleInstancePoliciesModel = new SetInstancePoliciesOneOfSetMultipleInstancePolicies.Builder()
      .metadata(collectionMetadataModel)
      .resources(new ArrayList<SetMultipleInstancePoliciesResourcesItem>(Arrays.asList(setMultipleInstancePoliciesResourcesItemModel)))
      .build();
    assertEquals(setInstancePoliciesOneOfSetMultipleInstancePoliciesModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfSetMultipleInstancePoliciesModel.resources(), new ArrayList<SetMultipleInstancePoliciesResourcesItem>(Arrays.asList(setMultipleInstancePoliciesResourcesItemModel)));

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetMultipleInstancePoliciesModel);

    SetInstancePoliciesOneOfSetMultipleInstancePolicies setInstancePoliciesOneOfSetMultipleInstancePoliciesModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetMultipleInstancePolicies.class);
    assertTrue(setInstancePoliciesOneOfSetMultipleInstancePoliciesModelNew instanceof SetInstancePoliciesOneOfSetMultipleInstancePolicies);
    assertEquals(setInstancePoliciesOneOfSetMultipleInstancePoliciesModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetMultipleInstancePoliciesError() throws Throwable {
    new SetInstancePoliciesOneOfSetMultipleInstancePolicies.Builder().build();
  }

}