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

import com.ibm.cloud.ibm_key_protect_api.v2.model.PostImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PostImportTokenOptions model.
 */
public class PostImportTokenOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPostImportTokenOptions() throws Throwable {
    PostImportTokenOptions postImportTokenOptionsModel = new PostImportTokenOptions.Builder()
      .bluemixInstance("testString")
      .expiration(Double.valueOf("300"))
      .maxAllowedRetrievals(Double.valueOf("1"))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();
    assertEquals(postImportTokenOptionsModel.bluemixInstance(), "testString");
    assertEquals(postImportTokenOptionsModel.expiration(), Double.valueOf("300"));
    assertEquals(postImportTokenOptionsModel.maxAllowedRetrievals(), Double.valueOf("1"));
    assertEquals(postImportTokenOptionsModel.correlationId(), "testString");
    assertEquals(postImportTokenOptionsModel.xKmsKeyRing(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostImportTokenOptionsError() throws Throwable {
    new PostImportTokenOptions.Builder().build();
  }

}