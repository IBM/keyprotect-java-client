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

import com.ibm.cloud.ibm_key_protect_api.v2.model.RotateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RotateKeyOptions model.
 */
public class RotateKeyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRotateKeyOptions() throws Throwable {
    RotateKeyOptions rotateKeyOptionsModel = new RotateKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyActionRotateBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();
    assertEquals(rotateKeyOptionsModel.id(), "testString");
    assertEquals(rotateKeyOptionsModel.bluemixInstance(), "testString");
    assertEquals(IOUtils.toString(rotateKeyOptionsModel.keyActionRotateBody()), IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(rotateKeyOptionsModel.correlationId(), "testString");
    assertEquals(rotateKeyOptionsModel.xKmsKeyRing(), "testString");
    assertEquals(rotateKeyOptionsModel.prefer(), "return=representation");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRotateKeyOptionsError() throws Throwable {
    new RotateKeyOptions.Builder().build();
  }

}