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

package com.ibm.cloud.ibm_key_protect_api.v2;

import com.ibm.cloud.ibm_key_protect_api.v2.model.*;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.KpUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Integration test class for the IbmKeyProtectApi service.
 *
 * The following configuration properties are assumed to be exported as environment variables
 *
 * APIKEY=<IBM Cloud APIKEY for the User>
 * KP_INSTANCE_ID=<ID of the service instance to be used >
 * AUTH_URL=<IAM Token Service URL>
 * KP_SERVICE_URL=<Service URL>
 */
public class IbmKeyProtectApiIT {

    private static final Logger logger = LoggerFactory.getLogger(IbmKeyProtectApiIT.class);

    private static Map<String, String> config;
    private static String testInstance;
    private static IbmKeyProtectApi testService;

    private static String keyName = "sdk-created-key";
    private static String keyDesc = "created via sdk";
    private static String keyAlias = "sdk-key-alias-test";

    String str = "It is a really important message";
    String payload = Base64.getEncoder().encodeToString(str.getBytes());

    @BeforeClass
    public void constructService() {
        config = System.getenv();
        testInstance = config.get("KP_INSTANCE_ID");

        IamAuthenticator authenticator = IamAuthenticator.fromConfiguration(config);
        testService = IbmKeyProtectApi.newInstance(authenticator);
        testService.setServiceUrl(config.get("KP_SERVICE_URL"));
        logger.info("Setup complete.");
    }

    /**
     * Integration test for create key, get key, get list of keys, delete key, restore key, rotate key, key versions
     * and purge key
     */
    @Test
    public void testKeyFunctions() throws Exception {
        try {
            // test creating key
            String keyId = KpUtilities.createKey(testService, testInstance, keyName, keyDesc,
                    payload, false);
            assertNotNull(keyId);

            // test getting a key
            KeyWithPayload keyWithPayload = KpUtilities.getKey(testService, testInstance, keyId);
            assertEquals(keyWithPayload.getName(), keyName);
            assertEquals(keyWithPayload.getState(), new Long(1));

            // test getting a list of keys associated to the instance
            List<KeyFullRepresentation> keys = KpUtilities.getKeys(testService, testInstance);
            assertTrue(keys.size() >= 1);

            // test deleting a key
            Response<DeleteKey> deleteResponse = KpUtilities.deleteKey(testService, testInstance, keyId);
            assertEquals(deleteResponse.getStatusCode(), 204);
            assertEquals(KpUtilities.getKey(testService, testInstance, keyId).getState(), new Long(5));

            // Need to delay 30 seconds before calling restore
            TimeUnit.SECONDS.sleep(30);

            // test restoring a key
            Response<InputStream> restoreResponse = KpUtilities.restoreKey(testService, testInstance, keyId, payload);
            assertEquals(restoreResponse.getStatusCode(), 201);
            assertEquals(KpUtilities.getKey(testService, testInstance, keyId).getState(), new Long(1));

            // test rotating a key
            Response<Void> rotateResponse = KpUtilities.rotateKey(testService, testInstance, keyId, payload);
            assertEquals(rotateResponse.getStatusCode(), 204);

            //test key versions
            List<KeyVersion> versions = KpUtilities.getKeyVersions(testService, testInstance, keyId);
            assertTrue(versions.size() > 1);

            // delete the key again then try to purge it
            KpUtilities.deleteKey(testService, testInstance, keyId);

            // test purging key, this should fail since the key just got deleted
            try {
                KpUtilities.purgeKey(testService, testInstance, keyId);
            } catch (ServiceResponseException e) {
                assertTrue(((ArrayList)e.getDebuggingInfo().get("resources")).get(0).toString().contains("REQ_TOO_EARLY_ERR"));
            }

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    /**
     * Integration test for wrap key, unwrap key, disable key and enable key
     */
    @Test
    public void testKeyActions() throws Exception {
        try {
            // create a key to be used for test
            String keyId = KpUtilities.createKey(testService, testInstance, keyName, keyDesc,
                    payload, false);

            // test wrapping a key
            Response<WrapKeyResponseBody> wrapResponseObj = KpUtilities.wrapKey(testService, testInstance, keyId, payload);
            assertNotNull(wrapResponseObj.getResult().getCiphertext());

            // test unwrapping a key
            Response<UnwrapKeyResponseBody> unWrapResponseObj = KpUtilities.unWrapKey(testService, testInstance, keyId, wrapResponseObj.getResult().getCiphertext());
            assertEquals(payload, unWrapResponseObj.getResult().getPlaintext());

            // test disabling a key
            Response<Void> disableResponse = KpUtilities.disableKey(testService, testInstance, keyId);
            assertEquals(disableResponse.getStatusCode(), 204);
            assertEquals(KpUtilities.getKey(testService, testInstance, keyId).getState(), new Long(2));

            // need to delay 30 seconds before calling enable
            TimeUnit.SECONDS.sleep(30);

            // test enabling a key
            Response<Void> enableResponse = KpUtilities.enableKey(testService, testInstance, keyId);
            assertEquals(enableResponse.getStatusCode(), 204);
            assertEquals(KpUtilities.getKey(testService, testInstance, keyId).getState(), new Long(1));

            // clean up
            KpUtilities.deleteKey(testService, testInstance, keyId);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    /**
     * Integration test for key policies
     */
    @Test
    public void testKeyPolicies() throws Exception {
        // payload is null, rotation policy cannot be set on imported CRK
        String payload = null;

        try {
            // create a key to be used for test
            String keyId = KpUtilities.createKey(testService, testInstance, keyName, keyDesc,
                    payload, false);

            // test creating key dual auth delete policy
            Response<GetKeyPoliciesOneOf> createDualAuthResponse = KpUtilities.createKeyPolicyDualAuthDelete(testService, testInstance, keyId, false);
            assertEquals(createDualAuthResponse.getStatusCode(), 200);

            // test creating key rotation policy
            Response<GetKeyPoliciesOneOf> createRotationResponse = KpUtilities.createKeyPolicyRotation(testService, testInstance, keyId, 3);
            assertEquals(createRotationResponse.getStatusCode(), 200);

            // test listing key policies
            Response<GetKeyPoliciesOneOf> getResponse = KpUtilities.getKeyPolicies(testService, testInstance, keyId);
            assertEquals(getResponse.getStatusCode(), 200);
            assertEquals(getResponse.getResult().getResources().size(), 2);

            // clean up
            KpUtilities.deleteKey(testService, testInstance, keyId);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    /**
     * Integration test for instance policies
     */
    @Test
    public void testInstancePolicies() throws Exception {
        try {
            // test creating instance dual auth delete policy
            Response<Void> createDualAuthResponse = KpUtilities.createInstancePolicyDualAuthDelete(testService, testInstance, false);
            assertEquals(createDualAuthResponse.getStatusCode(), 204);

            // test creating instance allowed network policy
            Response<Void> createAllowedNetworkResponse = KpUtilities.createInstancePolicyAllowedNetwork(testService, testInstance, "public-and-private");
            assertEquals(createAllowedNetworkResponse.getStatusCode(), 204);

            // test creating instance metrics policy
            Response<Void> createMetricsResponse = KpUtilities.createInstancePolicyMetrics(testService, testInstance, true);
            assertEquals(createMetricsResponse.getStatusCode(), 204);

            // test creating instance key create import access policy
            Response<Void> createImportAccessResponse = KpUtilities.createInstancePolicyKeyCreateImportAccess(testService, testInstance, true, true,
                    true, true, false);
            assertEquals(createImportAccessResponse.getStatusCode(), 204);

            // test get instance policies
            Response<GetInstancePoliciesOneOf> getResponse = KpUtilities.getInstancePolicies(testService, testInstance);
            assertEquals(getResponse.getStatusCode(), 200);
            assertEquals(getResponse.getResult().getResources().size(), 4);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    /**
     * Integration test for getting registrations
     */
    @Test
    public void testGetRegistrations() throws Exception {
        try {
            // create a key to be used for test
            String keyId = KpUtilities.createKey(testService, testInstance, keyName, keyDesc,
                    payload, false);

            // test getting registrations associated with a key
            Response<RegistrationWithTotalCount> keyRegistrationResponse = KpUtilities.getRegistrationsForKey(testService,
                    testInstance, keyId);
            assertEquals(keyRegistrationResponse.getStatusCode(), 200);

            // test getting registrations associated with an instance
            Response<RegistrationWithTotalCount> instanceRegistrationResponse = KpUtilities.getRegistrationsForInstance(testService, testInstance, keyId);
            assertEquals(instanceRegistrationResponse.getStatusCode(), 200);

            // Clean up
            KpUtilities.deleteKey(testService, testInstance, keyId);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    /**
     * Integration test for key alias functions
     */
    @Test
    public void testKeyAlias() throws Exception {
        try {
            // create a key to be used for test
            String keyId = KpUtilities.createKey(testService, testInstance, keyName, keyDesc,
                    payload, false);

            // test creating key alias
            Response<KeyAlias> createResponse = KpUtilities.createKeyAlias(testService, testInstance, keyId, keyAlias);
            assertEquals(createResponse.getStatusCode(), 201);

            // test getting a key using key alias
            KeyWithPayload keyWithPayload = KpUtilities.getKey(testService, testInstance, keyAlias);
            assertEquals(keyWithPayload.getDescription(), keyDesc);

            // test deleting key alias
            Response<Void> deleteResponse = KpUtilities.deleteKeyAlias(testService, testInstance, keyId, keyAlias);
            assertEquals(deleteResponse.getStatusCode(), 204);

            // Clean up
            KpUtilities.deleteKey(testService, testInstance, keyId);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    /**
     * Integration test for key ring and transferring key ring functions
     */
    @Test
    public void testKeyRing() throws Exception {
        String sdkKeyRingId = "sdkTestKeyRingId";
        try {
            // test creating key ring
            Response<Void> createResponse = KpUtilities.createKeyRing(testService, testInstance, sdkKeyRingId);
            assertEquals(createResponse.getStatusCode(), 201);

            // test listing key rings
            Response<ListKeyRings> listResponse = KpUtilities.getKeyRings(testService, testInstance);
            assertEquals(listResponse.getStatusCode(), 200);

            // test transferring a key to a different key ring
            // first create a key
            String keyId = KpUtilities.createKey(testService, testInstance, keyName, keyDesc,
                    payload, false);
            // transfer
            Response<PatchKeyResponseBody> patchResponse = KpUtilities.setKeyRing(testService, testInstance, keyId, "default", sdkKeyRingId);
            assertEquals(patchResponse.getStatusCode(), 200);

            // transfer key out of the key ring, so that the key ring can be deleted
            KpUtilities.setKeyRing(testService, testInstance, keyId, sdkKeyRingId, "default");

            // test deleting key ring
            Response<Void> deleteResponse = KpUtilities.deleteKeyRing(testService, testInstance, sdkKeyRingId);
            assertEquals(deleteResponse.getStatusCode(), 204);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @AfterClass
    public void tearDown() {
        // Remove all test keys
        List<KeyFullRepresentation> keys = KpUtilities.getKeys(testService, testInstance);
        if (keys != null)
            for (KeyFullRepresentation key: keys)
                KpUtilities.deleteKey(testService, testInstance, key.getId());

        logger.info("Clean up complete.");
    }
}
