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
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

//
// This class provides examples of how to handle policies that are associated with a specified key
//
// The following configuration properties are assumed to be exported as environment variables
//
// IBMCLOUD_API_KEY=<IBM Cloud APIKEY for the User>
// KP_INSTANCE_ID=<ID of the service instance to be used >
// IAM_AUTH_URL=<IAM Token Service URL>
// KP_SERVICE_URL=<Service URL>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class KeyPolicies {

    private static final Logger logger = LoggerFactory.getLogger(KeyPolicies.class);

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

    public KeyPolicies() {
    }

    public static void main(String[] args) {
        IbmKeyProtectApi exampleService;
        IamAuthenticator authenticator = new IamAuthenticator(ibmCloudApiKey);
        authenticator.setURL(iamAuthUrl);
        authenticator.validate();

        try {
            exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create a key
            logger.info("Create a key");
            InputStream inputstream = new FileInputStream("createKeyBody.txt");
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

            // Create key dual auth delete policy
            logger.info("Create key dual auth delete policy");
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();

            // Construct an instance of the KeyPolicyDualAuthDeleteDualAuthDelete model
            KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel
                    = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
                    .enabled(false)
                    .build();

            // Construct an instance of the KeyPolicyDualAuthDelete model
            KeyPolicyDualAuthDelete keyPolicyDualAuthDeleteModel = new KeyPolicyDualAuthDelete.Builder()
                    .type("application/vnd.ibm.kms.policy+json")
                    .dualAuthDelete(keyPolicyDualAuthDeleteDualAuthDeleteModel)
                    .build();

            // Construct an instance of the SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete model
            SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete setKeyPoliciesOneOfDualAuthDeleteModel
                    = new SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<KeyPolicyDualAuthDelete>(Arrays.asList(keyPolicyDualAuthDeleteModel)))
                    .build();

            // Construct an instance of the PutPolicyOptions model
            PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .setKeyPoliciesOneOf(setKeyPoliciesOneOfDualAuthDeleteModel)
                    .policy("dualAuthDelete")
                    .build();

            // Invoke operation with valid options model
            exampleService.putPolicy(putPolicyOptionsModel).execute();
            logger.info("Dual auth delete key policy created");

            // Create key rotation policy
            logger.info("Create key rotation policy");

            // Construct an instance of the KeyPolicyRotationRotation model
            KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
                    .intervalMonth(3)
                    .build();

            // Construct an instance of the KeyPolicyRotation model
            KeyPolicyRotation keyPolicyRotationModel = new KeyPolicyRotation.Builder()
                    .type("application/vnd.ibm.kms.policy+json")
                    .rotation(keyPolicyRotationRotationModel)
                    .build();

            // Construct an instance of the SetKeyPoliciesOneOfSetKeyPolicyRotation model
            SetKeyPoliciesOneOfSetKeyPolicyRotation setKeyPoliciesOneOfRotationModel
                    = new SetKeyPoliciesOneOfSetKeyPolicyRotation.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<KeyPolicyRotation>(Arrays.asList(keyPolicyRotationModel)))
                    .build();

            // Construct an instance of the PutPolicyOptions model
            putPolicyOptionsModel = new PutPolicyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .setKeyPoliciesOneOf(setKeyPoliciesOneOfRotationModel)
                    .policy("rotation")
                    .build();

            // Invoke operation with valid options model
            exampleService.putPolicy(putPolicyOptionsModel).execute();
            logger.info("Rotation key policy created");

            // List key policies
            logger.info("List key policies");
            GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .build();

            Response<GetKeyPoliciesOneOf> get_response = exampleService.getPolicy(getPolicyOptionsModel).execute();
            GetKeyPoliciesOneOf responseObj = get_response.getResult();
            logger.info("Key policies: " + responseObj);

            // Clean up
            // Delete key
            logger.info("Clean up : delete key");
            DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
                    .id(key_id)
                    .bluemixInstance(bluemixInstance)
                    .force(true)
                    .build();

            exampleService.deleteKey(deleteKeyOptionsModel).execute();
            logger.info(String.format("Key with ID %s deleted", key_id));

        } catch (FileNotFoundException e1) {
            logger.error(String.format("Error details: %s", e1.getMessage()), e1);
        } catch (ServiceResponseException e2) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e2.getStatusCode(), e2.getMessage(), e2.getDebuggingInfo()), e2);
        }
    }
}