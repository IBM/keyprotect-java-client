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

import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the InstancePolicyAllowedNetworkPolicyDataAttributes model.
 */
public class InstancePolicyAllowedNetworkPolicyDataAttributesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInstancePolicyAllowedNetworkPolicyDataAttributes() throws Throwable {
    InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModel = new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder()
      .allowedNetwork("public-and-private")
      .build();
    assertEquals(instancePolicyAllowedNetworkPolicyDataAttributesModel.allowedNetwork(), "public-and-private");

    String json = TestUtilities.serialize(instancePolicyAllowedNetworkPolicyDataAttributesModel);

    InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModelNew = TestUtilities.deserialize(json, InstancePolicyAllowedNetworkPolicyDataAttributes.class);
    assertTrue(instancePolicyAllowedNetworkPolicyDataAttributesModelNew instanceof InstancePolicyAllowedNetworkPolicyDataAttributes);
    assertEquals(instancePolicyAllowedNetworkPolicyDataAttributesModelNew.allowedNetwork(), "public-and-private");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInstancePolicyAllowedNetworkPolicyDataAttributesError() throws Throwable {
    new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder().build();
  }

}