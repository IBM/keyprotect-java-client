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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKMIPAdapterRequestBodyResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPProfileDataBodyKMIPProfileDataNative;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateKMIPAdapterRequestBodyResourcesItem model.
 */
public class CreateKMIPAdapterRequestBodyResourcesItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateKMIPAdapterRequestBodyResourcesItem() throws Throwable {
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

    String json = TestUtilities.serialize(createKmipAdapterRequestBodyResourcesItemModel);

    CreateKMIPAdapterRequestBodyResourcesItem createKmipAdapterRequestBodyResourcesItemModelNew = TestUtilities.deserialize(json, CreateKMIPAdapterRequestBodyResourcesItem.class);
    assertTrue(createKmipAdapterRequestBodyResourcesItemModelNew instanceof CreateKMIPAdapterRequestBodyResourcesItem);
    assertEquals(createKmipAdapterRequestBodyResourcesItemModelNew.name(), "kmip-adapter-name");
    assertEquals(createKmipAdapterRequestBodyResourcesItemModelNew.description(), "kmip adapter description");
    assertEquals(createKmipAdapterRequestBodyResourcesItemModelNew.profile(), "native_1.0");
    assertEquals(createKmipAdapterRequestBodyResourcesItemModelNew.profileData().toString(), kmipProfileDataBodyModel.toString());
  }
}