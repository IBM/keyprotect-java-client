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

import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetRegistrationsOptions model.
 */
public class GetRegistrationsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetRegistrationsOptions() throws Throwable {
    GetRegistrationsOptions getRegistrationsOptionsModel = new GetRegistrationsOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .limit(Long.valueOf("26"))
      .offset(Long.valueOf("26"))
      .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*")
      .preventKeyDeletion(true)
      .totalCount(true)
      .build();
    assertEquals(getRegistrationsOptionsModel.id(), "testString");
    assertEquals(getRegistrationsOptionsModel.bluemixInstance(), "testString");
    assertEquals(getRegistrationsOptionsModel.correlationId(), "testString");
    assertEquals(getRegistrationsOptionsModel.limit(), Long.valueOf("26"));
    assertEquals(getRegistrationsOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(getRegistrationsOptionsModel.urlEncodedResourceCrnQuery(), "crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*");
    assertEquals(getRegistrationsOptionsModel.preventKeyDeletion(), Boolean.valueOf(true));
    assertEquals(getRegistrationsOptionsModel.totalCount(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRegistrationsOptionsError() throws Throwable {
    new GetRegistrationsOptions.Builder().build();
  }

}