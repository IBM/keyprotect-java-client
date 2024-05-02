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
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateRegistrationOptions model.
 */
public class CreateRegistrationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateRegistrationOptions() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    CreateRegistrationResourceBody createRegistrationResourceBodyModel = new CreateRegistrationResourceBody.Builder()
      .preventKeyDeletion(true)
      .description("testString")
      .registrationMetadata("testString")
      .build();
    assertEquals(createRegistrationResourceBodyModel.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(createRegistrationResourceBodyModel.description(), "testString");
    assertEquals(createRegistrationResourceBodyModel.registrationMetadata(), "testString");

    CreateRegistrationOptions createRegistrationOptionsModel = new CreateRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(createRegistrationResourceBodyModel))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();
    assertEquals(createRegistrationOptionsModel.id(), "testString");
    assertEquals(createRegistrationOptionsModel.urlEncodedResourceCrn(), "crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket");
    assertEquals(createRegistrationOptionsModel.bluemixInstance(), "testString");
    assertEquals(createRegistrationOptionsModel.metadata(), collectionMetadataModel);
    assertEquals(createRegistrationOptionsModel.resources(), java.util.Arrays.asList(createRegistrationResourceBodyModel));
    assertEquals(createRegistrationOptionsModel.correlationId(), "testString");
    assertEquals(createRegistrationOptionsModel.xKmsKeyRing(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRegistrationOptionsError() throws Throwable {
    new CreateRegistrationOptions.Builder().build();
  }

}