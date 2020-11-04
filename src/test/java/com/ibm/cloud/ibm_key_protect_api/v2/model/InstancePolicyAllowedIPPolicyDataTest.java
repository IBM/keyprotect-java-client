/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyDataAttributes;
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
    InstancePolicyAllowedIPPolicyDataAttributes instancePolicyAllowedIpPolicyDataAttributesModel = new InstancePolicyAllowedIPPolicyDataAttributes.Builder()
      .allowedIp(new ArrayList<String>(Arrays.asList("testString")))
      .build();
    assertEquals(instancePolicyAllowedIpPolicyDataAttributesModel.allowedIp(), new ArrayList<String>(Arrays.asList("testString")));

    InstancePolicyAllowedIPPolicyData instancePolicyAllowedIpPolicyDataModel = new InstancePolicyAllowedIPPolicyData.Builder()
      .enabled(true)
      .attributes(instancePolicyAllowedIpPolicyDataAttributesModel)
      .build();
    assertEquals(instancePolicyAllowedIpPolicyDataModel.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyAllowedIpPolicyDataModel.attributes(), instancePolicyAllowedIpPolicyDataAttributesModel);

    String json = TestUtilities.serialize(instancePolicyAllowedIpPolicyDataModel);

    InstancePolicyAllowedIPPolicyData instancePolicyAllowedIpPolicyDataModelNew = TestUtilities.deserialize(json, InstancePolicyAllowedIPPolicyData.class);
    assertTrue(instancePolicyAllowedIpPolicyDataModelNew instanceof InstancePolicyAllowedIPPolicyData);
    assertEquals(instancePolicyAllowedIpPolicyDataModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(instancePolicyAllowedIpPolicyDataModelNew.attributes().toString(), instancePolicyAllowedIpPolicyDataAttributesModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInstancePolicyAllowedIPPolicyDataError() throws Throwable {
    new InstancePolicyAllowedIPPolicyData.Builder().build();
  }

}