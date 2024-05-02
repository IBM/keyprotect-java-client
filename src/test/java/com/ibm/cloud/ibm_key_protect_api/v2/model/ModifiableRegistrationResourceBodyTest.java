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

import com.ibm.cloud.ibm_key_protect_api.v2.model.ModifiableRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ModifiableRegistrationResourceBody model.
 */
public class ModifiableRegistrationResourceBodyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testModifiableRegistrationResourceBody() throws Throwable {
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

    String json = TestUtilities.serialize(modifiableRegistrationResourceBodyModel);

    ModifiableRegistrationResourceBody modifiableRegistrationResourceBodyModelNew = TestUtilities.deserialize(json, ModifiableRegistrationResourceBody.class);
    assertTrue(modifiableRegistrationResourceBodyModelNew instanceof ModifiableRegistrationResourceBody);
    assertEquals(modifiableRegistrationResourceBodyModelNew.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(modifiableRegistrationResourceBodyModelNew.description(), "testString");
    assertEquals(modifiableRegistrationResourceBodyModelNew.registrationMetadata(), "testString");
    assertEquals(modifiableRegistrationResourceBodyModelNew.keyVersionId(), "testString");
  }
}