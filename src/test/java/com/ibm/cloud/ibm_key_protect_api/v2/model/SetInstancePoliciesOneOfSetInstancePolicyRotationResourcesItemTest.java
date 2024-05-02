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

import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyRotationPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RotationProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem() throws Throwable {
    RotationProperties rotationPropertiesModel = new RotationProperties.Builder()
      .intervalMonth(Long.valueOf("3"))
      .build();
    assertEquals(rotationPropertiesModel.intervalMonth(), Long.valueOf("3"));

    InstancePolicyRotationPolicyData instancePolicyRotationPolicyDataModel = new InstancePolicyRotationPolicyData.Builder()
      .enabled(true)
      .attributes(rotationPropertiesModel)
      .build();
    assertEquals(instancePolicyRotationPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyRotationPolicyDataModel.attributes(), rotationPropertiesModel);

    SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem.Builder()
      .policyType("rotation")
      .policyData(instancePolicyRotationPolicyDataModel)
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel.policyType(), "rotation");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel.policyData(), instancePolicyRotationPolicyDataModel);

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModel);

    SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModelNew.policyType(), "rotation");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemModelNew.policyData().toString(), instancePolicyRotationPolicyDataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItemError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem.Builder().build();
  }

}