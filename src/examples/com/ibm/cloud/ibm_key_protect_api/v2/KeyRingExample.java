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

import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayload;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRings;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

//
// This class provides examples of how to use the Key Protect key ring services.
//
// The following configuration properties are assumed to be exported as environment variables
//
// IBMCLOUD_API_KEY=<IBM Cloud APIKEY for the User>
// KP_INSTANCE_ID=<ID of the service instance to be used >
// IAM_AUTH_URL=<IAM Token Service URL>
// KP_SERVICE_URL=<Service URL>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class KeyRingExample {

    private static final Logger logger = LoggerFactory.getLogger(KeyRingExample.class);

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

    public KeyRingExample() {
    }

    public static void main(String[] args) {
        IamAuthenticator authenticator = new IamAuthenticator(ibmCloudApiKey);
        authenticator.setURL(iamAuthUrl);
        authenticator.validate();
        String keyRingId = "sdkKeyRingId";

        try {
            IbmKeyProtectApi exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create key ring
            logger.info("Create a key ring");
            KpUtils.createKeyRing(exampleService, exampleInstance, keyRingId);
            logger.info(String.format("Key ring %s created", keyRingId));

            // List key rings
            logger.info("List key rings");
            Response<ListKeyRings> response = KpUtils.getKeyRings(exampleService, exampleInstance);
            logger.info("Key rings associated with this instance: " + response.getResult());

            // Delete key ring
            logger.info("Delete a key ring");
            KpUtils.deleteKeyRing(exampleService, exampleInstance, keyRingId);
            logger.info(String.format("Key ring %s deleted", keyRingId));

        } catch (ServiceResponseException sre) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    sre.getStatusCode(), sre.getMessage(), sre.getDebuggingInfo()), sre);
        }
    }
}