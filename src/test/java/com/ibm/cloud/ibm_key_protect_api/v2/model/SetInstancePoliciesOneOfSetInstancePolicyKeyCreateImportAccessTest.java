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
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyKeyCreateImportAccessPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyCreateImportAccessProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    KeyCreateImportAccessProperties keyCreateImportAccessPropertiesModel = new KeyCreateImportAccessProperties.Builder()
      .createRootKey(true)
      .createStandardKey(true)
      .importRootKey(true)
      .importStandardKey(true)
      .enforceToken(true)
      .build();
    assertEquals(keyCreateImportAccessPropertiesModel.createRootKey(), Boolean.valueOf(true));
    assertEquals(keyCreateImportAccessPropertiesModel.createStandardKey(), Boolean.valueOf(true));
    assertEquals(keyCreateImportAccessPropertiesModel.importRootKey(), Boolean.valueOf(true));
    assertEquals(keyCreateImportAccessPropertiesModel.importStandardKey(), Boolean.valueOf(true));
    assertEquals(keyCreateImportAccessPropertiesModel.enforceToken(), Boolean.valueOf(true));

    InstancePolicyKeyCreateImportAccessPolicyData instancePolicyKeyCreateImportAccessPolicyDataModel = new InstancePolicyKeyCreateImportAccessPolicyData.Builder()
      .enabled(true)
      .attributes(keyCreateImportAccessPropertiesModel)
      .build();
    assertEquals(instancePolicyKeyCreateImportAccessPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyKeyCreateImportAccessPolicyDataModel.attributes(), keyCreateImportAccessPropertiesModel);

    SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem.Builder()
      .policyType("keyCreateImportAccess")
      .policyData(instancePolicyKeyCreateImportAccessPolicyDataModel)
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel.policyType(), "keyCreateImportAccess");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel.policyData(), instancePolicyKeyCreateImportAccessPolicyDataModel);

    SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModel = new SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel))
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModel.resources(), java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel));

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModel);

    SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess.Builder().build();
  }

}