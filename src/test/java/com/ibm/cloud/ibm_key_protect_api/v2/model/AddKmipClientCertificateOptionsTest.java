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

import com.ibm.cloud.ibm_key_protect_api.v2.model.AddKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKMIPClientCertificateObject;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddKmipClientCertificateOptions model.
 */
public class AddKmipClientCertificateOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddKmipClientCertificateOptions() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.kmip_client_certificate+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.kmip_client_certificate+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    CreateKMIPClientCertificateObject createKmipClientCertificateObjectModel = new CreateKMIPClientCertificateObject.Builder()
      .certificate("testString")
      .name("testString")
      .build();
    assertEquals(createKmipClientCertificateObjectModel.certificate(), "testString");
    assertEquals(createKmipClientCertificateObjectModel.name(), "testString");

    AddKmipClientCertificateOptions addKmipClientCertificateOptionsModel = new AddKmipClientCertificateOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(createKmipClientCertificateObjectModel))
      .correlationId("testString")
      .build();
    assertEquals(addKmipClientCertificateOptionsModel.adapterId(), "testString");
    assertEquals(addKmipClientCertificateOptionsModel.bluemixInstance(), "testString");
    assertEquals(addKmipClientCertificateOptionsModel.metadata(), collectionMetadataModel);
    assertEquals(addKmipClientCertificateOptionsModel.resources(), java.util.Arrays.asList(createKmipClientCertificateObjectModel));
    assertEquals(addKmipClientCertificateOptionsModel.correlationId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddKmipClientCertificateOptionsError() throws Throwable {
    new AddKmipClientCertificateOptions.Builder().build();
  }

}