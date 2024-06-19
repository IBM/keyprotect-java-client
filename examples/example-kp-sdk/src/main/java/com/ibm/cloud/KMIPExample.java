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
import com.ibm.cloud.ibm_key_protect_api.v2.model.*;
import com.ibm.cloud.platform_services.resource_controller.v2.ResourceController;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//
// This class provides examples of how to use the Key Protect key services.
//
// The following configuration properties are assumed to be exported as environment variables
//
// APIKEY=<IBM Cloud APIKEY for the User>
// AUTH_URL=<IAM Token Service URL>
// RESOURCE_GROUP=<ID of the User's Resource Group>
// KP_SERVICE_URL=<Service URL>
//
// API docs: https://cloud.ibm.com/apidocs/key-protect

public class KMIPExample {

    private static final Logger logger = LoggerFactory.getLogger(KMIPExample.class);

    // values to be read from the env setting
    private static Map<String, String> config;
    private static String exampleInstance;
    private static String resourceGroup;
    private static String serviceUrl;

    static {
        config = System.getenv();
        resourceGroup = config.get("RESOURCE_GROUP");
        serviceUrl = config.get("KP_SERVICE_URL");
    }

    public static void kmipExamples() {
        IamAuthenticator authenticator = IamAuthenticator.fromConfiguration(config);

        String keyName = "example-root-key";
        String keyDesc = "created via java sdk";

        try {
            // Create an instance
            ResourceController controllerService = KpUtilities.getResourceController(authenticator);
            exampleInstance = KpUtilities.createInstance(controllerService, resourceGroup);

            IbmKeyProtectApi exampleService = IbmKeyProtectApi.newInstance(authenticator);
            exampleService.setServiceUrl(serviceUrl);

            // Create key
            logger.info("Create a key");
            String keyId = KpUtilities.createKey(exampleService, exampleInstance, keyName, keyDesc,
                    null, false);
            logger.info(String.format("Key with ID %s created", keyId));

            // Create a KMIP adapter
            logger.info("Create a KMIP adapter");
            KMIPAdapter adapter = KpUtilities.createKmipAdapterNative(exampleService, exampleInstance, keyId, "myadapter", null);
            logger.info("KMIP adapter created with ID " + adapter.getId());

            // Create a KMIP client cert
            logger.info("Create a KMIP adapter");
            // This is an example self-signed certificate.
            String certPayload = "-----BEGIN CERTIFICATE-----\n" + //
                                "MIIC9zCCAd+gAwIBAgIUc0tA6jgIVaFUM9jeV7fkY5wRXwgwDQYJKoZIhvcNAQEL\n" + //
                                "BQAwADAeFw0yNDA2MTkxNzA5MDlaFw0yNTA2MTkxNzA5MDlaMAAwggEiMA0GCSqG\n" + //
                                "SIb3DQEBAQUAA4IBDwAwggEKAoIBAQCs/37mbKL6s0Ln8PGZRGVocjGIyUZM5fOu\n" + //
                                "qTjIf+6YvsCILr7HHG6+otBY9bldPcdTu1RNvoEj7JKiQhbefiGh3aeN/j1/JYXS\n" + //
                                "EXD02s9lfZnAbgMQGo6dtf7ONM0E07pNpoAdOxMPAdFsc4IN4lM6x1qVQIYiMR3A\n" + //
                                "Uz/xkKvJYPv8Dti6R6VAGVrXoy+De2HjwDw/7rNyf9s0I70Yy6eDmnWLj8mLfy/L\n" + //
                                "4YcaQuMtNEQRYmNggskUkJyFuDRddbcs+Ffq9CaK3jAGlceC9lBbYXbhU46uRxUd\n" + //
                                "P5jb1B8uV7IZ9qPG6j3oVqeX36If3RkiJBAELbc53XtbvPxEecuDAgMBAAGjaTBn\n" + //
                                "MB0GA1UdDgQWBBQKQpXelJJb0wa60VtDtGNyFgO0ZDAfBgNVHSMEGDAWgBQKQpXe\n" + //
                                "lJJb0wa60VtDtGNyFgO0ZDAPBgNVHRMBAf8EBTADAQH/MBQGA1UdEQQNMAuCCTEy\n" + //
                                "Ny4wLjAuMTANBgkqhkiG9w0BAQsFAAOCAQEAAQbW2z5xUsw6AykHqknps4XoeigP\n" + //
                                "mWthNVo6dAZ+udE7jmGSUiwrHlbeb/rlc4mgVh7DVG1UnaOwJQmKjSDl/RdMtibP\n" + //
                                "6AEIdoeDNDTygeIxn+mVlmpUw8LGeUU8m1SgctVdsaugQjyuYxHZJLP7RewYKftv\n" + //
                                "MHkSt26YO8kIYQ0K4+IV0synz6ITUpsUenxrbsOY2UyAX1e4yIF9M5yZ67+r9zUN\n" + //
                                "A23L2o1IifHBcWbFZagoGv0aZrF9iqZOV0dkcJgZ1XnjW/Lny4SSg4J4tRLFlEtU\n" + //
                                "vg6GwJVcti/wHF6cgBay02gNRABiLeP7jaTbmy8ntuGG42Hi5yDbEourFA==\n" + //
                                "-----END CERTIFICATE-----";
            KMIPClientCertificate cert = KpUtilities.addKmipClientCertificate(exampleService, exampleInstance, "myadapter",certPayload, "mycert");
            logger.info("KMIP client cert created with ID " + cert.getId());
            
            // Delete a KMIP adapter
            logger.info("Delete a KMIP adapter with ID " + adapter.getId());
            KpUtilities.deleteKmipAdapter(exampleService, exampleInstance, adapter.getId());

            // Delete a key
            logger.info("Delete a key");
            KpUtilities.deleteKey(exampleService, exampleInstance, keyId);
            logger.info(String.format("Key with ID %s deleted", keyId));

            KpUtilities.deleteInstance(controllerService, exampleInstance);
        } catch (ServiceResponseException sre) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s",
                    sre.getStatusCode(), sre.getMessage(), sre.getDebuggingInfo()), sre);
        }
    }

}