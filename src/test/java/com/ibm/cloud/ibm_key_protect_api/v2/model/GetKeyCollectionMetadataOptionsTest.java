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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyCollectionMetadataOptions;
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
 * Unit test class for the GetKeyCollectionMetadataOptions model.
 */
public class GetKeyCollectionMetadataOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetKeyCollectionMetadataOptions() throws Throwable {
    GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptionsModel = new GetKeyCollectionMetadataOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .state(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))))
      .extractable(true)
      .xKmsKeyRing("testString")
      .build();
    assertEquals(getKeyCollectionMetadataOptionsModel.bluemixInstance(), "testString");
    assertEquals(getKeyCollectionMetadataOptionsModel.correlationId(), "testString");
    assertEquals(getKeyCollectionMetadataOptionsModel.state(), new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))));
    assertEquals(getKeyCollectionMetadataOptionsModel.extractable(), Boolean.valueOf(true));
    assertEquals(getKeyCollectionMetadataOptionsModel.xKmsKeyRing(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyCollectionMetadataOptionsError() throws Throwable {
    new GetKeyCollectionMetadataOptions.Builder().build();
  }

}