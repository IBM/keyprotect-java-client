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
import com.ibm.cloud.ibm_key_protect_api.v2.model.ModifiableRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UpdateRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateRegistrationOptions model.
 */
public class UpdateRegistrationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateRegistrationOptions() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    ModifiableRegistrationResourceBody modifiableRegistrationResourceBodyModel = new ModifiableRegistrationResourceBody.Builder()
      .preventKeyDeletion(true)
      .description("testString")
      .registrationMetadata("testString")
      .keyVersionId("testString")
      .build();
    assertEquals(modifiableRegistrationResourceBodyModel.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(modifiableRegistrationResourceBodyModel.description(), "testString");
    assertEquals(modifiableRegistrationResourceBodyModel.registrationMetadata(), "testString");
    assertEquals(modifiableRegistrationResourceBodyModel.keyVersionId(), "testString");

    UpdateRegistrationOptions updateRegistrationOptionsModel = new UpdateRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(modifiableRegistrationResourceBodyModel))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .ifMatch("W/\"c8f7e349e5a1f8d7255de81f2508e5914667fg5e4aeb88945002286f753064b7\"")
      .build();
    assertEquals(updateRegistrationOptionsModel.id(), "testString");
    assertEquals(updateRegistrationOptionsModel.urlEncodedResourceCrn(), "crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket");
    assertEquals(updateRegistrationOptionsModel.bluemixInstance(), "testString");
    assertEquals(updateRegistrationOptionsModel.metadata(), collectionMetadataModel);
    assertEquals(updateRegistrationOptionsModel.resources(), java.util.Arrays.asList(modifiableRegistrationResourceBodyModel));
    assertEquals(updateRegistrationOptionsModel.correlationId(), "testString");
    assertEquals(updateRegistrationOptionsModel.xKmsKeyRing(), "testString");
    assertEquals(updateRegistrationOptionsModel.ifMatch(), "W/\"c8f7e349e5a1f8d7255de81f2508e5914667fg5e4aeb88945002286f753064b7\"");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateRegistrationOptionsError() throws Throwable {
    new UpdateRegistrationOptions.Builder().build();
  }

}