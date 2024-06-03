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
import com.ibm.cloud.ibm_key_protect_api.v2.model.ReplaceRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ReplaceRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceRegistrationOptions model.
 */
public class ReplaceRegistrationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceRegistrationOptions() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.allowed_ip_metadata+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    ReplaceRegistrationResourceBody replaceRegistrationResourceBodyModel = new ReplaceRegistrationResourceBody.Builder()
      .preventKeyDeletion(true)
      .description("testString")
      .registrationMetadata("testString")
      .keyVersionId("testString")
      .build();
    assertEquals(replaceRegistrationResourceBodyModel.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(replaceRegistrationResourceBodyModel.description(), "testString");
    assertEquals(replaceRegistrationResourceBodyModel.registrationMetadata(), "testString");
    assertEquals(replaceRegistrationResourceBodyModel.keyVersionId(), "testString");

    ReplaceRegistrationOptions replaceRegistrationOptionsModel = new ReplaceRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(replaceRegistrationResourceBodyModel))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();
    assertEquals(replaceRegistrationOptionsModel.id(), "testString");
    assertEquals(replaceRegistrationOptionsModel.urlEncodedResourceCrn(), "crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket");
    assertEquals(replaceRegistrationOptionsModel.bluemixInstance(), "testString");
    assertEquals(replaceRegistrationOptionsModel.metadata(), collectionMetadataModel);
    assertEquals(replaceRegistrationOptionsModel.resources(), java.util.Arrays.asList(replaceRegistrationResourceBodyModel));
    assertEquals(replaceRegistrationOptionsModel.correlationId(), "testString");
    assertEquals(replaceRegistrationOptionsModel.xKmsKeyRing(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRegistrationOptionsError() throws Throwable {
    new ReplaceRegistrationOptions.Builder().build();
  }

}