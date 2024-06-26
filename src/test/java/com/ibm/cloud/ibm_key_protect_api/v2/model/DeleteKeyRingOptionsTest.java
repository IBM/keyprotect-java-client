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

import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteKeyRingOptions model.
 */
public class DeleteKeyRingOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteKeyRingOptions() throws Throwable {
    DeleteKeyRingOptions deleteKeyRingOptionsModel = new DeleteKeyRingOptions.Builder()
      .keyRingId("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .force(false)
      .build();
    assertEquals(deleteKeyRingOptionsModel.keyRingId(), "testString");
    assertEquals(deleteKeyRingOptionsModel.bluemixInstance(), "testString");
    assertEquals(deleteKeyRingOptionsModel.correlationId(), "testString");
    assertEquals(deleteKeyRingOptionsModel.force(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyRingOptionsError() throws Throwable {
    new DeleteKeyRingOptions.Builder().build();
  }

}