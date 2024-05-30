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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKMIPAdapterRequestBodyResources;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPProfileDataBodyKMIPProfileDataNative;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateKMIPAdapterRequestBodyResources model.
 */
public class CreateKMIPAdapterRequestBodyResourcesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateKMIPAdapterRequestBodyResources() throws Throwable {
    KMIPProfileDataBodyKMIPProfileDataNative kmipProfileDataBodyModel = new KMIPProfileDataBodyKMIPProfileDataNative.Builder()
      .crkId("feddecaf-0000-0000-0000-1234567890ab")
      .build();
    assertEquals(kmipProfileDataBodyModel.crkId(), "feddecaf-0000-0000-0000-1234567890ab");

    CreateKMIPAdapterRequestBodyResources createKmipAdapterRequestBodyResourcesModel = new CreateKMIPAdapterRequestBodyResources.Builder()
      .name("kmip-adapter-name")
      .description("kmip adapter description")
      .profile("native_1.0")
      .profileData(kmipProfileDataBodyModel)
      .build();
    assertEquals(createKmipAdapterRequestBodyResourcesModel.name(), "kmip-adapter-name");
    assertEquals(createKmipAdapterRequestBodyResourcesModel.description(), "kmip adapter description");
    assertEquals(createKmipAdapterRequestBodyResourcesModel.profile(), "native_1.0");
    assertEquals(createKmipAdapterRequestBodyResourcesModel.profileData(), kmipProfileDataBodyModel);

    String json = TestUtilities.serialize(createKmipAdapterRequestBodyResourcesModel);

    CreateKMIPAdapterRequestBodyResources createKmipAdapterRequestBodyResourcesModelNew = TestUtilities.deserialize(json, CreateKMIPAdapterRequestBodyResources.class);
    assertTrue(createKmipAdapterRequestBodyResourcesModelNew instanceof CreateKMIPAdapterRequestBodyResources);
    assertEquals(createKmipAdapterRequestBodyResourcesModelNew.name(), "kmip-adapter-name");
    assertEquals(createKmipAdapterRequestBodyResourcesModelNew.description(), "kmip adapter description");
    assertEquals(createKmipAdapterRequestBodyResourcesModelNew.profile(), "native_1.0");
    assertEquals(createKmipAdapterRequestBodyResourcesModelNew.profileData().toString(), kmipProfileDataBodyModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKMIPAdapterRequestBodyResourcesError() throws Throwable {
    new CreateKMIPAdapterRequestBodyResources.Builder().build();
  }

}