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

import com.ibm.cloud.ibm_key_protect_api.v2.model.ImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ImportToken model.
 */
public class ImportTokenTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImportToken() throws Throwable {
    ImportToken importTokenModel = new ImportToken.Builder()
      .expiration(Double.valueOf("300"))
      .maxAllowedRetrievals(Double.valueOf("1"))
      .build();
    assertEquals(importTokenModel.expiration(), Double.valueOf("300"));
    assertEquals(importTokenModel.maxAllowedRetrievals(), Double.valueOf("1"));

    String json = TestUtilities.serialize(importTokenModel);

    ImportToken importTokenModelNew = TestUtilities.deserialize(json, ImportToken.class);
    assertTrue(importTokenModelNew instanceof ImportToken);
    assertEquals(importTokenModelNew.expiration(), Double.valueOf("300"));
    assertEquals(importTokenModelNew.maxAllowedRetrievals(), Double.valueOf("1"));
  }
}