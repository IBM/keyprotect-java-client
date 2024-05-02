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

import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstancePoliciesOneOfResourcesItem model.
 */
public class SetInstancePoliciesOneOfResourcesItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfResourcesItem() throws Throwable {
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

    SetInstancePoliciesOneOfResourcesItem setInstancePoliciesOneOfResourcesItemModel = new SetInstancePoliciesOneOfResourcesItem.Builder()
      .policyType("allowedNetwork")
      .policyData(instancePolicyAllowedNetworkPolicyDataModel)
      .build();
    assertEquals(setInstancePoliciesOneOfResourcesItemModel.policyType(), "allowedNetwork");
    assertEquals(setInstancePoliciesOneOfResourcesItemModel.policyData(), instancePolicyAllowedNetworkPolicyDataModel);

    String json = TestUtilities.serialize(setInstancePoliciesOneOfResourcesItemModel);

    SetInstancePoliciesOneOfResourcesItem setInstancePoliciesOneOfResourcesItemModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfResourcesItem.class);
    assertTrue(setInstancePoliciesOneOfResourcesItemModelNew instanceof SetInstancePoliciesOneOfResourcesItem);
    assertEquals(setInstancePoliciesOneOfResourcesItemModelNew.policyType(), "allowedNetwork");
    assertEquals(setInstancePoliciesOneOfResourcesItemModelNew.policyData().toString(), instancePolicyAllowedNetworkPolicyDataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfResourcesItemError() throws Throwable {
    new SetInstancePoliciesOneOfResourcesItem.Builder().build();
  }

}