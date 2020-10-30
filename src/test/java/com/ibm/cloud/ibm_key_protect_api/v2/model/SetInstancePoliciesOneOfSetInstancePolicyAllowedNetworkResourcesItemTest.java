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

import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem() throws Throwable {
    InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModel = new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder()
      .allowedNetwork("public-and-private")
      .build();
    assertEquals(instancePolicyAllowedNetworkPolicyDataAttributesModel.allowedNetwork(), "public-and-private");

    InstancePolicyAllowedNetworkPolicyData instancePolicyAllowedNetworkPolicyDataModel = new InstancePolicyAllowedNetworkPolicyData.Builder()
      .enabled(true)
      .attributes(instancePolicyAllowedNetworkPolicyDataAttributesModel)
      .build();
    assertEquals(instancePolicyAllowedNetworkPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyAllowedNetworkPolicyDataModel.attributes(), instancePolicyAllowedNetworkPolicyDataAttributesModel);

    SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem.Builder()
      .policyType("allowedNetwork")
      .policyData(instancePolicyAllowedNetworkPolicyDataModel)
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel.policyType(), "allowedNetwork");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel.policyData(), instancePolicyAllowedNetworkPolicyDataModel);

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel);

    SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModelNew.policyType(), "allowedNetwork");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModelNew.policyData().toString(), instancePolicyAllowedNetworkPolicyDataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem.Builder().build();
  }

}