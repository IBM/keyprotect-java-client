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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetGovernanceConfigOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetGovernanceConfigOptions model.
 */
public class GetGovernanceConfigOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetGovernanceConfigOptions() throws Throwable {
    GetGovernanceConfigOptions getGovernanceConfigOptionsModel = new GetGovernanceConfigOptions.Builder()
      .configRequestId("testString")
      .accountId("testString")
      .resourceKind("instance")
      .serviceInstanceCrn("testString")
      .resourceGroupId("testString")
      .transactionId("testString")
      .limit(Long.valueOf("200"))
      .offset(Long.valueOf("0"))
      .build();
    assertEquals(getGovernanceConfigOptionsModel.configRequestId(), "testString");
    assertEquals(getGovernanceConfigOptionsModel.accountId(), "testString");
    assertEquals(getGovernanceConfigOptionsModel.resourceKind(), "instance");
    assertEquals(getGovernanceConfigOptionsModel.serviceInstanceCrn(), "testString");
    assertEquals(getGovernanceConfigOptionsModel.resourceGroupId(), "testString");
    assertEquals(getGovernanceConfigOptionsModel.transactionId(), "testString");
    assertEquals(getGovernanceConfigOptionsModel.limit(), Long.valueOf("200"));
    assertEquals(getGovernanceConfigOptionsModel.offset(), Long.valueOf("0"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGovernanceConfigOptionsError() throws Throwable {
    new GetGovernanceConfigOptions.Builder().build();
  }

}