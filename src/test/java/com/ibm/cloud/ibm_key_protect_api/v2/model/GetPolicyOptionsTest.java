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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetPolicyOptions model.
 */
public class GetPolicyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetPolicyOptions() throws Throwable {
    GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .policy("dualAuthDelete")
      .build();
    assertEquals(getPolicyOptionsModel.id(), "testString");
    assertEquals(getPolicyOptionsModel.bluemixInstance(), "testString");
    assertEquals(getPolicyOptionsModel.correlationId(), "testString");
    assertEquals(getPolicyOptionsModel.xKmsKeyRing(), "testString");
    assertEquals(getPolicyOptionsModel.policy(), "dualAuthDelete");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPolicyOptionsError() throws Throwable {
    new GetPolicyOptions.Builder().build();
  }

}