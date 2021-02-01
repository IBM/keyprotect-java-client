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

import com.ibm.cloud.ibm_key_protect_api.v2.model.*;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.*;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This class provides examples of how to use the Key Protect key services.
//
// The following configuration properties are assumed to be exported as environment variables
//
// IBMCLOUD_API_KEY=<IBM Cloud APIKEY for the User>
// KP_INSTANCE_ID=<ID of the service instance to be used >
// IAM_AUTH_URL=<IAM Token Service url>
// KP_SERVICE_URL=<service url>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class KeysExamples {

    private static final Logger logger = LoggerFactory.getLogger(KeysExamples.class);

    //values to be read from the env setting
    private static String ibmCloudApiKey;
    private static String bluemixInstance;
    private static String iamAuthUrl;
    private static String serviceUrl;

    static {
        Map<String, String> config = System.getenv();
        ibmCloudApiKey = config.get("IBMCLOUD_API_KEY");
        bluemixInstance = config.get("KP_INSTANCE_ID");
        iamAuthUrl = config.get("IAM_AUTH_URL");
        serviceUrl = config.get("KP_SERVICE_URL");
    }

    public KeysExamples() {
    }

    public static void main(String[] args) {
        IbmKeyProtectApi exampleService;
        IamAuthenticator authenticator = new IamAuthenticator(ibmCloudApiKey);
        authenticator.setURL(iamAuthUrl);
        authenticator.validate();

        try {
            exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create key
            logger.info("Create a key");
            InputStream inputstream = new FileInputStream("createImportKeyBody.txt");
            CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .createKeyOneOf(inputstream)
                    .prefer("return=representation")
                    .build();

            // Invoke operation with valid options model
            Response<Key> create_response = exampleService.createKey(createKeyOptionsModel).execute();
            KeyWithPayload keyWithPayload = create_response.getResult().getResources().get(0);
            String key_id = keyWithPayload.getId();
            logger.info(String.format("Key with ID %s created", key_id));

            // Get a key
            logger.info("Get a key");
            GetKeyOptions options = new GetKeyOptions.Builder().id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .build();
            Response<GetKey> get_response = exampleService.getKey(options).execute();
            GetKey responseObj = get_response.getResult();
            KeyWithPayload key = responseObj.getResources().get(0);
            logger.info(String.format("Got key with ID %s: ", key_id) + key);

            // Get list of keys associated to the instance
            logger.info("List keys");
            GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .build();
            Response<ListKeys> list_response = exampleService.getKeys(getKeysOptionsModel).execute();
            List<KeyRepresentation> keys = list_response.getResult().getResources();
            for (int i = 0; i < keys.size(); i++) {
                logger.info("key " + (i+1) + " ID is --> " + keys.get(i).getId());
            }

            // Delete a key
            logger.info("Delete a key");
            DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .force(true)
                    .build();

            exampleService.deleteKey(deleteKeyOptionsModel).execute();
            logger.info(String.format("Key with ID %s deleted", key_id));

            // Need to delay 30 seconds before calling restore
            TimeUnit.SECONDS.sleep(30);

            // Restore a key
            logger.info("Restore a key");
            inputstream = new FileInputStream("restoreKeyBody.txt");
            ActionOnKeyOptions restoreKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .action("restore")
                    .keyActionOneOf(inputstream)
                    .build();
            exampleService.actionOnKey(restoreKeyOptionsModel).execute();
            logger.info(String.format("Key with ID %s restored", key_id));

            // Rotate a key
            logger.info("Rotate a key");
            InputStream rotateInputstream = new FileInputStream("rotateKeyBody.txt");
            ActionOnKeyOptions actionOnKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .action("rotate")
                    .keyActionOneOf(rotateInputstream)
                    .prefer("return=representation")
                    .build();
            exampleService.actionOnKey(actionOnKeyOptionsModel).execute();
            logger.info(String.format("Key with ID %s rotated", key_id));

            //List key version
            logger.info("List key versions");
            GetKeyVersionsOptions getKeyVersionsOptionsModel = new GetKeyVersionsOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .build();
            Response<ListKeyVersions> response = exampleService.getKeyVersions(getKeyVersionsOptionsModel).execute();
            List<KeyVersion> versions = response.getResult().getResources();
            for (int i = 0; i < versions.size(); i++) {
                logger.info("Version " + (i + 1) + " of key is --> " + versions.get(i));
            }
        }catch (FileNotFoundException e1) {
            logger.error(String.format("Error details: %s", e1.getMessage()),  e1);
        }catch (ServiceResponseException e2) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e2.getStatusCode(), e2.getMessage(), e2.getDebuggingInfo()), e2);
        } catch (InterruptedException e3) {
            logger.error(String.format("Error details: %s", e3.getMessage()),  e3);
        }
    }
}