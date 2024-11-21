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

import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetMultipleInstancePoliciesResourcesItemPolicyData model.
 */
public class SetMultipleInstancePoliciesResourcesItemPolicyDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetMultipleInstancePoliciesResourcesItemPolicyData() throws Throwable {
    SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel = new SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes.Builder()
      .allowedNetwork("public-and-private")
      .allowedIp(java.util.Arrays.asList("10.1.0.0/32", "10.0.0.0/24", "192.0.2.0/32", "198.51.100.0/24", "2001:db8::/60"))
      .createRootKey(true)
      .createStandardKey(true)
      .importRootKey(true)
      .importStandardKey(true)
      .enforceToken(true)
      .intervalMonth(Long.valueOf("3"))
      .build();
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.allowedNetwork(), "public-and-private");
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.allowedIp(), java.util.Arrays.asList("10.1.0.0/32", "10.0.0.0/24", "192.0.2.0/32", "198.51.100.0/24", "2001:db8::/60"));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.createRootKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.createStandardKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.importRootKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.importStandardKey(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.enforceToken(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.intervalMonth(), Long.valueOf("3"));

    SetMultipleInstancePoliciesResourcesItemPolicyData setMultipleInstancePoliciesResourcesItemPolicyDataModel = new SetMultipleInstancePoliciesResourcesItemPolicyData.Builder()
      .enabled(true)
      .attributes(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel)
      .build();
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataModel.attributes(), setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel);

    String json = TestUtilities.serialize(setMultipleInstancePoliciesResourcesItemPolicyDataModel);

    SetMultipleInstancePoliciesResourcesItemPolicyData setMultipleInstancePoliciesResourcesItemPolicyDataModelNew = TestUtilities.deserialize(json, SetMultipleInstancePoliciesResourcesItemPolicyData.class);
    assertTrue(setMultipleInstancePoliciesResourcesItemPolicyDataModelNew instanceof SetMultipleInstancePoliciesResourcesItemPolicyData);
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(setMultipleInstancePoliciesResourcesItemPolicyDataModelNew.attributes().toString(), setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetMultipleInstancePoliciesResourcesItemPolicyDataError() throws Throwable {
    new SetMultipleInstancePoliciesResourcesItemPolicyData.Builder().build();
  }

}