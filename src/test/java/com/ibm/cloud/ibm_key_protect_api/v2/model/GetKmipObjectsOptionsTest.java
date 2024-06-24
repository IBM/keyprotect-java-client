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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipObjectsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetKmipObjectsOptions model.
 */
public class GetKmipObjectsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetKmipObjectsOptions() throws Throwable {
    GetKmipObjectsOptions getKmipObjectsOptionsModel = new GetKmipObjectsOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .state(java.util.Arrays.asList(Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3"), Long.valueOf("4")))
      .correlationId("testString")
      .build();
    assertEquals(getKmipObjectsOptionsModel.adapterId(), "testString");
    assertEquals(getKmipObjectsOptionsModel.bluemixInstance(), "testString");
    assertEquals(getKmipObjectsOptionsModel.limit(), Long.valueOf("100"));
    assertEquals(getKmipObjectsOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(getKmipObjectsOptionsModel.totalCount(), Boolean.valueOf(true));
    assertEquals(getKmipObjectsOptionsModel.state(), java.util.Arrays.asList(Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3"), Long.valueOf("4")));
    assertEquals(getKmipObjectsOptionsModel.correlationId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipObjectsOptionsError() throws Throwable {
    new GetKmipObjectsOptions.Builder().build();
  }

}