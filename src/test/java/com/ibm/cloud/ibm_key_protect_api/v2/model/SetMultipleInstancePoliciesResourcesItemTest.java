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
 * Unit test class for the SetMultipleInstancePoliciesResourcesItem model.
 */
public class SetMultipleInstancePoliciesResourcesItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetMultipleInstancePoliciesResourcesItem() throws Throwable {
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

    SetMultipleInstancePoliciesResourcesItem setMultipleInstancePoliciesResourcesItemModel = new SetMultipleInstancePoliciesResourcesItem.Builder()
      .policyType("allowedNetwork")
      .policyData(setMultipleInstancePoliciesResourcesItemPolicyDataModel)
      .build();
    assertEquals(setMultipleInstancePoliciesResourcesItemModel.policyType(), "allowedNetwork");
    assertEquals(setMultipleInstancePoliciesResourcesItemModel.policyData(), setMultipleInstancePoliciesResourcesItemPolicyDataModel);

    String json = TestUtilities.serialize(setMultipleInstancePoliciesResourcesItemModel);

    SetMultipleInstancePoliciesResourcesItem setMultipleInstancePoliciesResourcesItemModelNew = TestUtilities.deserialize(json, SetMultipleInstancePoliciesResourcesItem.class);
    assertTrue(setMultipleInstancePoliciesResourcesItemModelNew instanceof SetMultipleInstancePoliciesResourcesItem);
    assertEquals(setMultipleInstancePoliciesResourcesItemModelNew.policyType(), "allowedNetwork");
    assertEquals(setMultipleInstancePoliciesResourcesItemModelNew.policyData().toString(), setMultipleInstancePoliciesResourcesItemPolicyDataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetMultipleInstancePoliciesResourcesItemError() throws Throwable {
    new SetMultipleInstancePoliciesResourcesItem.Builder().build();
  }

}