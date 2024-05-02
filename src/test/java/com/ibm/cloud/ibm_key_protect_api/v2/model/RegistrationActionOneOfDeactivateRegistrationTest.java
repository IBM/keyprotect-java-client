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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CloudResourceName;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationActionOneOfDeactivateRegistration;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RegistrationActionOneOfDeactivateRegistration model.
 */
public class RegistrationActionOneOfDeactivateRegistrationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRegistrationActionOneOfDeactivateRegistration() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.crn+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.crn+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    CloudResourceName cloudResourceNameModel = new CloudResourceName.Builder()
      .resourceCrn("crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>")
      .build();
    assertEquals(cloudResourceNameModel.resourceCrn(), "crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>");

    RegistrationActionOneOfDeactivateRegistration registrationActionOneOfDeactivateRegistrationModel = new RegistrationActionOneOfDeactivateRegistration.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(cloudResourceNameModel))
      .build();
    assertEquals(registrationActionOneOfDeactivateRegistrationModel.metadata(), collectionMetadataModel);
    assertEquals(registrationActionOneOfDeactivateRegistrationModel.resources(), java.util.Arrays.asList(cloudResourceNameModel));

    String json = TestUtilities.serialize(registrationActionOneOfDeactivateRegistrationModel);

    RegistrationActionOneOfDeactivateRegistration registrationActionOneOfDeactivateRegistrationModelNew = TestUtilities.deserialize(json, RegistrationActionOneOfDeactivateRegistration.class);
    assertTrue(registrationActionOneOfDeactivateRegistrationModelNew instanceof RegistrationActionOneOfDeactivateRegistration);
    assertEquals(registrationActionOneOfDeactivateRegistrationModelNew.metadata().toString(), collectionMetadataModel.toString());
  }
}