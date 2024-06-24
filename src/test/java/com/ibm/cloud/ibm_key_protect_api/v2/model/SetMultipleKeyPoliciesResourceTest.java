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

import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDeleteDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotationRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleKeyPoliciesResource;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetMultipleKeyPoliciesResource model.
 */
public class SetMultipleKeyPoliciesResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetMultipleKeyPoliciesResource() throws Throwable {
    KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
      .enabled(true)
      .build();
    assertEquals(keyPolicyDualAuthDeleteDualAuthDeleteModel.enabled(), Boolean.valueOf(true));

    KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
      .enabled(true)
      .intervalMonth(Long.valueOf("1"))
      .build();
    assertEquals(keyPolicyRotationRotationModel.enabled(), Boolean.valueOf(true));
    assertEquals(keyPolicyRotationRotationModel.intervalMonth(), Long.valueOf("1"));

    SetMultipleKeyPoliciesResource setMultipleKeyPoliciesResourceModel = new SetMultipleKeyPoliciesResource.Builder()
      .type("application/vnd.ibm.kms.policy+json")
      .dualAuthDelete(keyPolicyDualAuthDeleteDualAuthDeleteModel)
      .rotation(keyPolicyRotationRotationModel)
      .build();
    assertEquals(setMultipleKeyPoliciesResourceModel.type(), "application/vnd.ibm.kms.policy+json");
    assertEquals(setMultipleKeyPoliciesResourceModel.dualAuthDelete(), keyPolicyDualAuthDeleteDualAuthDeleteModel);
    assertEquals(setMultipleKeyPoliciesResourceModel.rotation(), keyPolicyRotationRotationModel);

    String json = TestUtilities.serialize(setMultipleKeyPoliciesResourceModel);

    SetMultipleKeyPoliciesResource setMultipleKeyPoliciesResourceModelNew = TestUtilities.deserialize(json, SetMultipleKeyPoliciesResource.class);
    assertTrue(setMultipleKeyPoliciesResourceModelNew instanceof SetMultipleKeyPoliciesResource);
    assertEquals(setMultipleKeyPoliciesResourceModelNew.type(), "application/vnd.ibm.kms.policy+json");
    assertEquals(setMultipleKeyPoliciesResourceModelNew.dualAuthDelete().toString(), keyPolicyDualAuthDeleteDualAuthDeleteModel.toString());
    assertEquals(setMultipleKeyPoliciesResourceModelNew.rotation().toString(), keyPolicyRotationRotationModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetMultipleKeyPoliciesResourceError() throws Throwable {
    new SetMultipleKeyPoliciesResource.Builder().build();
  }

}