/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetKeysOptions model.
 */
public class GetKeysOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetKeysOptions() throws Throwable {
    GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .state(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))))
      .extractable(true)
      .xKmsKeyRing("testString")
      .build();
    assertEquals(getKeysOptionsModel.bluemixInstance(), "testString");
    assertEquals(getKeysOptionsModel.correlationId(), "testString");
    assertEquals(getKeysOptionsModel.limit(), Long.valueOf("1"));
    assertEquals(getKeysOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(getKeysOptionsModel.state(), new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))));
    assertEquals(getKeysOptionsModel.extractable(), Boolean.valueOf(true));
    assertEquals(getKeysOptionsModel.xKmsKeyRing(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeysOptionsError() throws Throwable {
    new GetKeysOptions.Builder().build();
  }

}