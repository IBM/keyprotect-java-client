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

import com.ibm.cloud.ibm_key_protect_api.v2.model.ReplaceRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceRegistrationResourceBody model.
 */
public class ReplaceRegistrationResourceBodyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceRegistrationResourceBody() throws Throwable {
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

    String json = TestUtilities.serialize(replaceRegistrationResourceBodyModel);

    ReplaceRegistrationResourceBody replaceRegistrationResourceBodyModelNew = TestUtilities.deserialize(json, ReplaceRegistrationResourceBody.class);
    assertTrue(replaceRegistrationResourceBodyModelNew instanceof ReplaceRegistrationResourceBody);
    assertEquals(replaceRegistrationResourceBodyModelNew.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(replaceRegistrationResourceBodyModelNew.description(), "testString");
    assertEquals(replaceRegistrationResourceBodyModelNew.registrationMetadata(), "testString");
    assertEquals(replaceRegistrationResourceBodyModelNew.keyVersionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRegistrationResourceBodyError() throws Throwable {
    new ReplaceRegistrationResourceBody.Builder().build();
  }

}