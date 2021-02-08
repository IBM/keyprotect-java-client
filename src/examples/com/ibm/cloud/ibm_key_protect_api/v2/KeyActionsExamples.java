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

package com.ibm.cloud.ibm_key_protect_api.v2;

import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponse;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

//
// This class provides examples of how to use the Key Protect key actions services.
//
// The following configuration properties are assumed to be exported as environment variables
//
// IBMCLOUD_API_KEY=<IBM Cloud APIKEY for the User>
// KP_INSTANCE_ID=<ID of the service instance to be used >
// IAM_AUTH_URL=<IAM Token Service URL>
// KP_SERVICE_URL=<Service URL>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class KeyActionsExamples {

    private static final Logger logger = LoggerFactory.getLogger(KeyActionsExamples.class);

    //values to be read from the env setting
    private static String ibmCloudApiKey;
    private static String exampleInstance;
    private static String iamAuthUrl;
    private static String serviceUrl;

    static {
        Map<String, String> config = System.getenv();
        ibmCloudApiKey = config.get("IBMCLOUD_API_KEY");
        exampleInstance = config.get("KP_INSTANCE_ID");
        iamAuthUrl = config.get("IAM_AUTH_URL");
        serviceUrl = config.get("KP_SERVICE_URL");
    }

    public KeyActionsExamples() {
    }

    public static void main(String[] args) {
        IamAuthenticator authenticator = new IamAuthenticator(ibmCloudApiKey);
        authenticator.setURL(iamAuthUrl);
        authenticator.validate();
        // payload is base64 encoded string of "It is a really important message"
        String payload = "SXQgaXMgYSByZWFsbHkgaW1wb3J0YW50IG1lc3NhZ2U=";

        try {
            IbmKeyProtectApi exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create key
            logger.info("Create a key");
            String keyId = KpUtils.createKey(exampleService, exampleInstance, "sdk-created-key",
                    "created via sdk", payload, false);
            logger.info(String.format("Key with ID %s created", keyId));

            // Wrap a key
            logger.info("Wrap a key");
            KeyActionOneOfResponse responseObj = KpUtils.wrapKey(exampleService, exampleInstance, keyId, payload);
            logger.info(String.format("Key with ID %s wrapped", keyId));

            // UnWrap a key
            logger.info("UnWrap a key");
            KpUtils.unWrapKey(exampleService, exampleInstance, keyId, responseObj.getCiphertext());
            logger.info(String.format("Key with ID %s unwrapped", keyId));

            // Disable a key
            logger.info("Disable a key");
            KpUtils.disableKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s disabled", keyId));

            // Need to delay 30 seconds before calling enable
            TimeUnit.SECONDS.sleep(30);

            // Enable a key
            logger.info("Enable a key");
            KpUtils.enableKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s enabled", keyId));

            // Clean up
            // Delete key
            logger.info("Clean up : delete key");
            KpUtils.deleteKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s deleted", keyId));

        } catch (ServiceResponseException e2) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e2.getStatusCode(), e2.getMessage(), e2.getDebuggingInfo()), e2);
        } catch (InterruptedException e3) {
            logger.error(String.format("Error details: %s", e3.getMessage()), e3);
        }
    }
}