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
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedIP;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem;
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
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyAllowedIP model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyAllowedIPTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyAllowedIP() throws Throwable {
    InstancePolicyAllowedIPPolicyDataAttributes instancePolicyAllowedIpPolicyDataAttributesModel = new InstancePolicyAllowedIPPolicyDataAttributes.Builder()
      .allowedIp(new ArrayList<String>(Arrays.asList("testString")))
      .build();
    assertEquals(instancePolicyAllowedIpPolicyDataAttributesModel.allowedIp(), new ArrayList<String>(Arrays.asList("testString")));

    InstancePolicyAllowedIPPolicyData instancePolicyAllowedIpPolicyDataModel = new InstancePolicyAllowedIPPolicyData.Builder()
      .enabled(true)
      .attributes(instancePolicyAllowedIpPolicyDataAttributesModel)
      .build();
    assertEquals(instancePolicyAllowedIpPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyAllowedIpPolicyDataModel.attributes(), instancePolicyAllowedIpPolicyDataAttributesModel);

    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem.Builder()
      .policyType("allowedIP")
      .policyData(instancePolicyAllowedIpPolicyDataModel)
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel.policyType(), "allowedIP");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel.policyData(), instancePolicyAllowedIpPolicyDataModel);

    SetInstancePoliciesOneOfSetInstancePolicyAllowedIP setInstancePoliciesOneOfSetInstancePolicyAllowedIpModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedIP.Builder()
      .metadata(collectionMetadataModel)
      .resources(new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem>(Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel)))
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedIpModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedIpModel.resources(), new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem>(Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel)));

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyAllowedIpModel);

    SetInstancePoliciesOneOfSetInstancePolicyAllowedIP setInstancePoliciesOneOfSetInstancePolicyAllowedIpModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyAllowedIP.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyAllowedIpModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyAllowedIP);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyAllowedIpModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyAllowedIPError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyAllowedIP.Builder().build();
  }

}