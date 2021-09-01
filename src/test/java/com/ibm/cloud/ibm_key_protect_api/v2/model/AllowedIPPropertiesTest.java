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

import com.ibm.cloud.ibm_key_protect_api.v2.model.AllowedIPProperties;
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
 * Unit test class for the AllowedIPProperties model.
 */
public class AllowedIPPropertiesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAllowedIPProperties() throws Throwable {
    AllowedIPProperties allowedIpPropertiesModel = new AllowedIPProperties.Builder()
      .allowedIp(new java.util.ArrayList<String>(java.util.Arrays.asList("10.1.0.0/32", "10.0.0.0/24", "192.0.2.0/32", "198.51.100.0/24", "2001:db8::/60")))
      .build();
    assertEquals(allowedIpPropertiesModel.allowedIp(), new java.util.ArrayList<String>(java.util.Arrays.asList("10.1.0.0/32", "10.0.0.0/24", "192.0.2.0/32", "198.51.100.0/24", "2001:db8::/60")));

    String json = TestUtilities.serialize(allowedIpPropertiesModel);

    AllowedIPProperties allowedIpPropertiesModelNew = TestUtilities.deserialize(json, AllowedIPProperties.class);
    assertTrue(allowedIpPropertiesModelNew instanceof AllowedIPProperties);
  }
}