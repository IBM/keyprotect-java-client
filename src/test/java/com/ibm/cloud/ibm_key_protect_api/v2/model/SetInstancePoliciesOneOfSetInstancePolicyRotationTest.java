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
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyRotationPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyRotationPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyRotation model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyRotationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyRotation() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.allowed_ip_metadata+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    InstancePolicyRotationPolicyDataAttributes instancePolicyRotationPolicyDataAttributesModel = new InstancePolicyRotationPolicyDataAttributes.Builder()
      .intervalMonth(Long.valueOf("3"))
      .build();
    assertEquals(instancePolicyRotationPolicyDataAttributesModel.intervalMonth(), Long.valueOf("3"));

    InstancePolicyRotationPolicyData instancePolicyRotationPolicyDataModel = new InstancePolicyRotationPolicyData.Builder()
      .enabled(true)
      .attributes(instancePolicyRotationPolicyDataAttributesModel)
      .build();
    assertEquals(instancePolicyRotationPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyRotationPolicyDataModel.attributes(), instancePolicyRotationPolicyDataAttributesModel);

    SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem.Builder()
      .policyType("rotation")
      .policyData(instancePolicyRotationPolicyDataModel)
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel.policyType(), "rotation");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel.policyData(), instancePolicyRotationPolicyDataModel);

    SetInstancePoliciesOneOfSetInstancePolicyRotation setInstancePoliciesOneOfSetInstancePolicyRotationModel = new SetInstancePoliciesOneOfSetInstancePolicyRotation.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel))
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationModel.resources(), java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel));

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyRotationModel);

    SetInstancePoliciesOneOfSetInstancePolicyRotation setInstancePoliciesOneOfSetInstancePolicyRotationModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyRotation.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyRotationModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyRotation);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyRotationError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyRotation.Builder().build();
  }

}