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

 import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipAdaptersOptions;
 import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
 import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
 import java.io.InputStream;
 import java.util.HashMap;
 import java.util.List;
 import org.testng.annotations.Test;
 import static org.testng.Assert.*;
 
 /**
  * Unit test class for the GetKmipAdaptersOptions model.
  */
 public class GetKmipAdaptersOptionsTest {
   final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
   final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
 
   @Test
   public void testGetKmipAdaptersOptions() throws Throwable {
     GetKmipAdaptersOptions getKmipAdaptersOptionsModel = new GetKmipAdaptersOptions.Builder()
       .bluemixInstance("testString")
       .correlationId("testString")
       .limit(Long.valueOf("100"))
       .offset(Long.valueOf("0"))
       .totalCount(true)
       .crkId("feddecaf-0000-0000-0000-1234567890ab")
       .build();
     assertEquals(getKmipAdaptersOptionsModel.bluemixInstance(), "testString");
     assertEquals(getKmipAdaptersOptionsModel.correlationId(), "testString");
     assertEquals(getKmipAdaptersOptionsModel.limit(), Long.valueOf("100"));
     assertEquals(getKmipAdaptersOptionsModel.offset(), Long.valueOf("0"));
     assertEquals(getKmipAdaptersOptionsModel.totalCount(), Boolean.valueOf(true));
     assertEquals(getKmipAdaptersOptionsModel.crkId(), "feddecaf-0000-0000-0000-1234567890ab");
   }
 
   @Test(expectedExceptions = IllegalArgumentException.class)
   public void testGetKmipAdaptersOptionsError() throws Throwable {
     new GetKmipAdaptersOptions.Builder().build();
   }
 
 }