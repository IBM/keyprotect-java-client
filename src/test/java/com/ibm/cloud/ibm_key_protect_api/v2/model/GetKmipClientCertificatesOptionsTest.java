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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipClientCertificatesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetKmipClientCertificatesOptions model.
 */
public class GetKmipClientCertificatesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetKmipClientCertificatesOptions() throws Throwable {
    GetKmipClientCertificatesOptions getKmipClientCertificatesOptionsModel = new GetKmipClientCertificatesOptions.Builder()
      .bluemixInstance("testString")
      .adapterId("testString")
      .correlationId("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .build();
    assertEquals(getKmipClientCertificatesOptionsModel.bluemixInstance(), "testString");
    assertEquals(getKmipClientCertificatesOptionsModel.adapterId(), "testString");
    assertEquals(getKmipClientCertificatesOptionsModel.correlationId(), "testString");
    assertEquals(getKmipClientCertificatesOptionsModel.limit(), Long.valueOf("100"));
    assertEquals(getKmipClientCertificatesOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(getKmipClientCertificatesOptionsModel.totalCount(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipClientCertificatesOptionsError() throws Throwable {
    new GetKmipClientCertificatesOptions.Builder().build();
  }

}