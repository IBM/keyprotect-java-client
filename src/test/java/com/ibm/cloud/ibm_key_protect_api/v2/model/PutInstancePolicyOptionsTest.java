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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutInstancePolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PutInstancePolicyOptions model.
 */
public class PutInstancePolicyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutInstancePolicyOptions() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.allowed_ip_metadata+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

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

    SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork setInstancePoliciesOneOfModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel))
      .build();
    assertEquals(setInstancePoliciesOneOfModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfModel.resources(), java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel));

    PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
      .bluemixInstance("testString")
      .instancePolicyPutBody(setInstancePoliciesOneOfModel)
      .correlationId("testString")
      .policy("allowedNetwork")
      .build();
    assertEquals(putInstancePolicyOptionsModel.bluemixInstance(), "testString");
    assertEquals(putInstancePolicyOptionsModel.instancePolicyPutBody(), setInstancePoliciesOneOfModel);
    assertEquals(putInstancePolicyOptionsModel.correlationId(), "testString");
    assertEquals(putInstancePolicyOptionsModel.policy(), "allowedNetwork");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutInstancePolicyOptionsError() throws Throwable {
    new PutInstancePolicyOptions.Builder().build();
  }

}