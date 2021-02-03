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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

//
// This class provides examples of how to handle policies that are associated with an instance
//
// The following configuration properties are assumed to be exported as environment variables
//
// IBMCLOUD_API_KEY=<IBM Cloud APIKEY for the User>
// KP_INSTANCE_ID=<ID of the service instance to be used >
// IAM_AUTH_URL=<IAM Token Service URL>
// KP_SERVICE_URL=<Service URL>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class InstancePolicies {

    private static final Logger logger = LoggerFactory.getLogger(InstancePolicies.class);

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

    public InstancePolicies() {
    }

    public static void main(String[] args) {
        IbmKeyProtectApi exampleService;
        IamAuthenticator authenticator = new IamAuthenticator(ibmCloudApiKey);
        authenticator.setURL(iamAuthUrl);
        authenticator.validate();

        try {
            exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create instance dual auth delete policy
            logger.info("Create instance dual auth delete policy");

            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();

            // Construct an instance of the DualAuthDeleteProperties model
            DualAuthDeleteProperties dualAuthDeletePropertiesModel = new DualAuthDeleteProperties.Builder()
                    .enabled(false)
                    .build();

            // Construct an instance of the SetInstancePolicyDualAuthDeleteResourcesItem model
            SetInstancePolicyDualAuthDeleteResourcesItem setInstancePolicyDualAuthDeleteResourcesItemModel
                    = new SetInstancePolicyDualAuthDeleteResourcesItem.Builder()
                    .policyType("dualAuthDelete")
                    .policyData(dualAuthDeletePropertiesModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete model
            SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete setInstancePoliciesOneOfDualAuthDeleteModel
                    = new SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetInstancePolicyDualAuthDeleteResourcesItem>
                            (Arrays.asList(setInstancePolicyDualAuthDeleteResourcesItemModel)))
                    .build();

            // Construct an instance of the PutInstancePolicyOptions model
            PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .setInstancePoliciesOneOf(setInstancePoliciesOneOfDualAuthDeleteModel)
                    .policy("dualAuthDelete")
                    .build();

            // Invoke operation with valid options model (positive test)
            exampleService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
            logger.info("Dual auth delete instance policy created");

            // Create instance allowed network policy
            logger.info("Create instance allowed network policy");

            // Construct an instance of the InstancePolicyAllowedNetworkPolicyDataAttributes model
            InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModel
                    = new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder()
                    .allowedNetwork("public-and-private")
                    .build();

            // Construct an instance of the InstancePolicyAllowedNetworkPolicyData model
            InstancePolicyAllowedNetworkPolicyData instancePolicyAllowedNetworkPolicyDataModel
                    = new InstancePolicyAllowedNetworkPolicyData.Builder()
                    .enabled(true)
                    .attributes(instancePolicyAllowedNetworkPolicyDataAttributesModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem model
            SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem
                    setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel
                    = new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem.Builder()
                    .policyType("allowedNetwork")
                    .policyData(instancePolicyAllowedNetworkPolicyDataModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork model
            SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork setInstancePoliciesOneOfAllowedNetworkModel
                    = new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem>
                            (Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel)))
                    .build();

            // Construct an instance of the PutInstancePolicyOptions model
            putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .setInstancePoliciesOneOf(setInstancePoliciesOneOfAllowedNetworkModel)
                    .policy("allowedNetwork")
                    .build();

            // Invoke operation with valid options model
            exampleService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
            logger.info("Allowed network instance policy created");

            // Get instance policies
            logger.info("Get instance policies");
            // Construct an instance of the GetInstancePolicyOptions model
            GetInstancePolicyOptions getInstancePolicyOptionsModel = new GetInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .build();

            // Invoke operation with valid options model
            Response<GetInstancePoliciesOneOf> get_response = exampleService.getInstancePolicy
                    (getInstancePolicyOptionsModel).execute();
            GetInstancePoliciesOneOf responseObj = get_response.getResult();

            logger.info("Instance Policies: " + responseObj.getResources());


        } catch (ServiceResponseException e2) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    e2.getStatusCode(), e2.getMessage(), e2.getDebuggingInfo()), e2);
        }
    }
}