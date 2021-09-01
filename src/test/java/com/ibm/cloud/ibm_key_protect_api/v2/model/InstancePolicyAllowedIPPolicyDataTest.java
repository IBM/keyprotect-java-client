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
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyData;
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
 * Unit test class for the InstancePolicyAllowedIPPolicyData model.
 */
public class InstancePolicyAllowedIPPolicyDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInstancePolicyAllowedIPPolicyData() throws Throwable {
    AllowedIPProperties allowedIpPropertiesModel = new AllowedIPProperties.Builder()
      .allowedIp(new java.util.ArrayList<String>(java.util.Arrays.asList("10.1.0.0/32", "10.0.0.0/24", "192.0.2.0/32", "198.51.100.0/24", "2001:db8::/60")))
      .build();
    assertEquals(allowedIpPropertiesModel.allowedIp(), new java.util.ArrayList<String>(java.util.Arrays.asList("10.1.0.0/32", "10.0.0.0/24", "192.0.2.0/32", "198.51.100.0/24", "2001:db8::/60")));

    InstancePolicyAllowedIPPolicyData instancePolicyAllowedIpPolicyDataModel = new InstancePolicyAllowedIPPolicyData.Builder()
      .enabled(true)
      .attributes(allowedIpPropertiesModel)
      .build();
    assertEquals(instancePolicyAllowedIpPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyAllowedIpPolicyDataModel.attributes(), allowedIpPropertiesModel);

    String json = TestUtilities.serialize(instancePolicyAllowedIpPolicyDataModel);

    InstancePolicyAllowedIPPolicyData instancePolicyAllowedIpPolicyDataModelNew = TestUtilities.deserialize(json, InstancePolicyAllowedIPPolicyData.class);
    assertTrue(instancePolicyAllowedIpPolicyDataModelNew instanceof InstancePolicyAllowedIPPolicyData);
    assertEquals(instancePolicyAllowedIpPolicyDataModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyAllowedIpPolicyDataModelNew.attributes().toString(), allowedIpPropertiesModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInstancePolicyAllowedIPPolicyDataError() throws Throwable {
    new InstancePolicyAllowedIPPolicyData.Builder().build();
  }

}