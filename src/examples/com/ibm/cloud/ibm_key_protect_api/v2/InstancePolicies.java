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

    public InstancePolicies() {
    }

    public static void main(String[] args) {
        IamAuthenticator authenticator = new IamAuthenticator(ibmCloudApiKey);
        authenticator.setURL(iamAuthUrl);
        authenticator.validate();

        try {
            IbmKeyProtectApi exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create instance dual auth delete policy
            logger.info("Create instance dual auth delete policy");
            KpUtils.createInstancePolicyDualAuthDelete (exampleService, exampleInstance, false);
            logger.info("Dual auth delete instance policy created");

            // Create instance allowed network policy that allows both public and private endpoint traffic
            // to the instance (the default)
            logger.info("Create instance allowed network policy");
            KpUtils.createInstancePolicyAllowedNetwork (exampleService, exampleInstance, "public-and-private");
            logger.info("Allowed network instance policy created");

            // Create instance metrics policy
            logger.info("Create instance metrics policy");
            KpUtils.createInstancePolicyMetrics (exampleService, exampleInstance, true);
            logger.info("Metrics instance policy created");

            // Create instance key create import access policy
            logger.info("Create instance key create import access policy");
            KpUtils.createInstancePolicyKeyCreateImportAccess (exampleService, exampleInstance, true, true,
                    true, true, false);
            logger.info("Key create import access instance policy created");

            // Get instance policies
            logger.info("Get instance policies");
            Response<GetInstancePoliciesOneOf> response = KpUtils.getInstancePolicies (exampleService, exampleInstance);
            logger.info("Instance Policies: " + response.getResult());

        } catch (ServiceResponseException sre) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    sre.getStatusCode(), sre.getMessage(), sre.getDebuggingInfo()), sre);
        }
    }
}