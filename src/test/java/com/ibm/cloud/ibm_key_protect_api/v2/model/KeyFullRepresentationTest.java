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

import com.ibm.cloud.ibm_key_protect_api.v2.model.DualAuthKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyFullRepresentation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RotationKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the KeyFullRepresentation model.
 */
public class KeyFullRepresentationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testKeyFullRepresentation() throws Throwable {
    KeyFullRepresentation keyFullRepresentationModel = new KeyFullRepresentation();
    assertNull(keyFullRepresentationModel.getType());
    assertNull(keyFullRepresentationModel.getName());
    assertNull(keyFullRepresentationModel.getAliases());
    assertNull(keyFullRepresentationModel.getDescription());
    assertNull(keyFullRepresentationModel.getTags());
    assertNull(keyFullRepresentationModel.getExpirationDate());
    assertNull(keyFullRepresentationModel.isExtractable());
    assertNull(keyFullRepresentationModel.getKeyRingId());
    assertNull(keyFullRepresentationModel.getAlgorithmBitSize());
    assertNull(keyFullRepresentationModel.getAlgorithmMode());
    assertNull(keyFullRepresentationModel.getDualAuthDelete());
    assertNull(keyFullRepresentationModel.getRotation());
    assertNull(keyFullRepresentationModel.getRestoreExpirationDate());
    assertNull(keyFullRepresentationModel.isRestoreAllowed());
    assertNull(keyFullRepresentationModel.isPurgeAllowed());
    assertNull(keyFullRepresentationModel.getPurgeAllowedFrom());
    assertNull(keyFullRepresentationModel.getPurgeScheduledOn());
  }
}