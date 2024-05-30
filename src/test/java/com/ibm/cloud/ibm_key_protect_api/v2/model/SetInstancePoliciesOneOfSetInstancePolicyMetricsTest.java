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

import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.MetricsProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyMetrics;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetInstancePoliciesOneOfSetInstancePolicyMetrics model.
 */
public class SetInstancePoliciesOneOfSetInstancePolicyMetricsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetInstancePoliciesOneOfSetInstancePolicyMetrics() throws Throwable {
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
      .collectionTotal(Long.valueOf("1"))
      .build();
    assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.kms.allowed_ip_metadata+json");
    assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

    MetricsProperties metricsPropertiesModel = new MetricsProperties.Builder()
      .enabled(true)
      .build();
    assertEquals(metricsPropertiesModel.enabled(), Boolean.valueOf(true));

    SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem.Builder()
      .policyType("metrics")
      .policyData(metricsPropertiesModel)
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel.policyType(), "metrics");
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel.policyData(), metricsPropertiesModel);

    SetInstancePoliciesOneOfSetInstancePolicyMetrics setInstancePoliciesOneOfSetInstancePolicyMetricsModel = new SetInstancePoliciesOneOfSetInstancePolicyMetrics.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel))
      .build();
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyMetricsModel.metadata(), collectionMetadataModel);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyMetricsModel.resources(), java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel));

    String json = TestUtilities.serialize(setInstancePoliciesOneOfSetInstancePolicyMetricsModel);

    SetInstancePoliciesOneOfSetInstancePolicyMetrics setInstancePoliciesOneOfSetInstancePolicyMetricsModelNew = TestUtilities.deserialize(json, SetInstancePoliciesOneOfSetInstancePolicyMetrics.class);
    assertTrue(setInstancePoliciesOneOfSetInstancePolicyMetricsModelNew instanceof SetInstancePoliciesOneOfSetInstancePolicyMetrics);
    assertEquals(setInstancePoliciesOneOfSetInstancePolicyMetricsModelNew.metadata().toString(), collectionMetadataModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstancePoliciesOneOfSetInstancePolicyMetricsError() throws Throwable {
    new SetInstancePoliciesOneOfSetInstancePolicyMetrics.Builder().build();
  }

}