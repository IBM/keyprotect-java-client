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

import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteRegistrationOptions model.
 */
public class DeleteRegistrationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteRegistrationOptions() throws Throwable {
    DeleteRegistrationOptions deleteRegistrationOptionsModel = new DeleteRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();
    assertEquals(deleteRegistrationOptionsModel.id(), "testString");
    assertEquals(deleteRegistrationOptionsModel.urlEncodedResourceCrn(), "crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket");
    assertEquals(deleteRegistrationOptionsModel.bluemixInstance(), "testString");
    assertEquals(deleteRegistrationOptionsModel.correlationId(), "testString");
    assertEquals(deleteRegistrationOptionsModel.xKmsKeyRing(), "testString");
    assertEquals(deleteRegistrationOptionsModel.prefer(), "return=representation");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRegistrationOptionsError() throws Throwable {
    new DeleteRegistrationOptions.Builder().build();
  }

}