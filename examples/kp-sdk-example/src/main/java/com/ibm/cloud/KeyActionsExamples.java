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

 package com.ibm.cloud;

 import com.ibm.cloud.utils.KpUtilities;
 import com.ibm.cloud.ibm_key_protect_api.v2.*;
 import com.ibm.cloud.ibm_key_protect_api.v2.model.WrapKeyResponseBody;
import com.ibm.cloud.platform_services.resource_controller.v2.ResourceController;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//
// This class provides examples of how to use the Key Protect key actions services.
//
// The following configuration properties are assumed to be exported as environment variables
//
// APIKEY=<IBM Cloud APIKEY for the User>
// AUTH_URL=<IAM Token Service URL>
// RESOURCE_GROUP=<ID of the User's Resource Group>
// KP_SERVICE_URL=<Service URL>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class KeyActionsExamples {

    private static final Logger logger = LoggerFactory.getLogger(KeyActionsExamples.class);

    //values to be read from the env setting
    private static Map<String, String> config;
    private static String exampleInstance;
    private static String resourceGroup;
    private static String serviceUrl;

    static {
        config = System.getenv();
        resourceGroup = config.get("RESOURCE_GROUP");
        serviceUrl = config.get("KP_SERVICE_URL");
    }

    public static void keyActionsExamples() {
        IamAuthenticator authenticator = IamAuthenticator.fromConfiguration(config);

        String keyName = "sdk-created-key";
        String keyDesc = "created via sdk";

        // payload is base64 encoded string of "It is a really important message"
        String str = "It is a really important message";
        String payload = Base64.getEncoder().encodeToString(str.getBytes());

        try {
            // Create an instance
            ResourceController controllerService = KpUtilities.getResourceController(authenticator);
            exampleInstance = KpUtilities.createInstance(controllerService, resourceGroup);

            IbmKeyProtectApi exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create key
            logger.info("Create a key");
            String keyId = KpUtilities.createKey(exampleService, exampleInstance, keyName, keyDesc,
                    payload, false);
            logger.info(String.format("Key with ID %s created", keyId));

            // Wrap a key
            logger.info("Wrap a key");
            Response<WrapKeyResponseBody> responseObj = KpUtilities.wrapKey(exampleService, exampleInstance, keyId, payload);
            logger.info(String.format("Key with ID %s wrapped", keyId));

            // UnWrap a key
            logger.info("UnWrap a key");
            KpUtilities.unWrapKey(exampleService, exampleInstance, keyId, responseObj.getResult().getCiphertext());
            logger.info(String.format("Key with ID %s unwrapped", keyId));

            // Disable a key
            logger.info("Disable a key");
            KpUtilities.disableKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s disabled", keyId));

            // Need to delay 30 seconds before calling enable
            TimeUnit.SECONDS.sleep(30);

            // Enable a key
            logger.info("Enable a key");
            KpUtilities.enableKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s enabled", keyId));

            // Clean up
            // Delete key
            logger.info("Clean up : delete key");
            KpUtilities.deleteKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s deleted", keyId));

            KpUtilities.deleteInstance(controllerService, exampleInstance);
        }catch (ServiceResponseException sre) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    sre.getStatusCode(), sre.getMessage(), sre.getDebuggingInfo()), sre);
        } catch (InterruptedException ie) {
            logger.error(String.format("Error details: %s", ie.getMessage()),  ie);
        }
    }
}