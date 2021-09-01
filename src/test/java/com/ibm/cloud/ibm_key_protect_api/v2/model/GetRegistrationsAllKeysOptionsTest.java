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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsAllKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetRegistrationsAllKeysOptions model.
 */
public class GetRegistrationsAllKeysOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetRegistrationsAllKeysOptions() throws Throwable {
    GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptionsModel = new GetRegistrationsAllKeysOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*")
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .preventKeyDeletion(true)
      .totalCount(true)
      .build();
    assertEquals(getRegistrationsAllKeysOptionsModel.bluemixInstance(), "testString");
    assertEquals(getRegistrationsAllKeysOptionsModel.correlationId(), "testString");
    assertEquals(getRegistrationsAllKeysOptionsModel.xKmsKeyRing(), "testString");
    assertEquals(getRegistrationsAllKeysOptionsModel.urlEncodedResourceCrnQuery(), "crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*");
    assertEquals(getRegistrationsAllKeysOptionsModel.limit(), Long.valueOf("1"));
    assertEquals(getRegistrationsAllKeysOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(getRegistrationsAllKeysOptionsModel.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(getRegistrationsAllKeysOptionsModel.totalCount(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRegistrationsAllKeysOptionsError() throws Throwable {
    new GetRegistrationsAllKeysOptions.Builder().build();
  }

}