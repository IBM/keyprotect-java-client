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
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKMIPAdapterRequestBodyResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPProfileDataBodyKMIPProfileDataNative;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateKmipAdapterOptions model.
 */
public class CreateKmipAdapterOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateKmipAdapterOptions() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.kmip_adapter+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.kmip_adapter+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    KMIPProfileDataBodyKMIPProfileDataNative kmipProfileDataBodyModel = new KMIPProfileDataBodyKMIPProfileDataNative.Builder()
      .crkId("feddecaf-0000-0000-0000-1234567890ab")
      .targetKeyRingId("testString")
      .build();
    assertEquals(kmipProfileDataBodyModel.crkId(), "feddecaf-0000-0000-0000-1234567890ab");
    assertEquals(kmipProfileDataBodyModel.targetKeyRingId(), "testString");

    CreateKMIPAdapterRequestBodyResourcesItem createKmipAdapterRequestBodyResourcesItemModel = new CreateKMIPAdapterRequestBodyResourcesItem.Builder()
      .name("kmip-adapter-name")
      .description("kmip adapter description")
      .profile("native_1.0")
      .profileData(kmipProfileDataBodyModel)
      .build();
    assertEquals(createKmipAdapterRequestBodyResourcesItemModel.name(), "kmip-adapter-name");
    assertEquals(createKmipAdapterRequestBodyResourcesItemModel.description(), "kmip adapter description");
    assertEquals(createKmipAdapterRequestBodyResourcesItemModel.profile(), "native_1.0");
    assertEquals(createKmipAdapterRequestBodyResourcesItemModel.profileData(), kmipProfileDataBodyModel);

    CreateKmipAdapterOptions createKmipAdapterOptionsModel = new CreateKmipAdapterOptions.Builder()
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(createKmipAdapterRequestBodyResourcesItemModel))
      .correlationId("testString")
      .build();
    assertEquals(createKmipAdapterOptionsModel.bluemixInstance(), "testString");
    assertEquals(createKmipAdapterOptionsModel.metadata(), collectionMetadataModel);
    assertEquals(createKmipAdapterOptionsModel.resources(), java.util.Arrays.asList(createKmipAdapterRequestBodyResourcesItemModel));
    assertEquals(createKmipAdapterOptionsModel.correlationId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKmipAdapterOptionsError() throws Throwable {
    new CreateKmipAdapterOptions.Builder().build();
  }

}