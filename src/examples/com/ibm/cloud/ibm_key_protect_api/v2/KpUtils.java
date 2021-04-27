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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

// API docs: https://cloud.ibm.com/apidocs/key-protect
// Utilities class to provide KP services

public class KpUtils {

    private static final Logger logger = LoggerFactory.getLogger(KpUtils.class);

    public KpUtils() {
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#createkey
    // payload is null if not an imported key
    // notRootKey is false if this is a root key
    public static String createKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyName,
                                   String keyDesc, String payload, boolean notRootKey) {

        InputStream inputstream = KpUtils.buildCreateKeyInputStream(keyName, keyDesc, payload, notRootKey);

        CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
                .bluemixInstance(exampleInstance)
                .createKeyOneOf(inputstream)
                .prefer("return=representation")
                .build();

        Response<Key> response = exampleService.createKey(createKeyOptionsModel).execute();
        KeyWithPayload keyWithPayload = response.getResult().getResources().get(0);
        String keyId = keyWithPayload.getId();
        return keyId;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getkey
    public static KeyWithPayload getKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyId_or_alias) {
        GetKeyOptions options = new GetKeyOptions.Builder().id(keyId_or_alias)
                .bluemixInstance(exampleInstance)
                .build();
        Response<GetKey> response = exampleService.getKey(options).execute();
        GetKey responseObj = response.getResult();
        KeyWithPayload keyWithPayload = responseObj.getResources().get(0);
        return keyWithPayload;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getkeys
    public static List<KeyRepresentation> getKeys(IbmKeyProtectApi exampleService, String exampleInstance) {
        GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
                .bluemixInstance(exampleInstance)
                .build();
        Response<ListKeys> response = exampleService.getKeys(getKeysOptionsModel).execute();
        return response.getResult().getResources();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#deletekey
    public static void deleteKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyId) {
        DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .force(true)
                .build();

        exampleService.deleteKey(deleteKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#restorekey
    public static void restoreKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyId,
                                  String payload) {
        InputStream  inputstream = KpUtils.buildRestoreKeyInputStream(payload);
        ActionOnKeyOptions restoreKeyOptionsModel = new ActionOnKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .action("restore")
                .keyActionOneOf(inputstream)
                .build();

        exampleService.actionOnKey(restoreKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#rotatekey
    public static void rotateKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyId, String payload) {
        InputStream inputstream = KpUtils.buildRotateKeyInputStream(payload);
        ActionOnKeyOptions actionOnKeyOptionsModel = new ActionOnKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .action("rotate")
                .keyActionOneOf(inputstream)
                .prefer("return=representation")
                .build();

        exampleService.actionOnKey(actionOnKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#wrapkey
    public static KeyActionOneOfResponse wrapKey(IbmKeyProtectApi exampleService, String exampleInstance,
                                                 String keyId, String payload) {

        InputStream wrapInputStream = KpUtils.buildWrapKeyInputStream(payload);

        ActionOnKeyOptions wrapKeyOptionsModel = new ActionOnKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .action("wrap")
                .keyActionOneOf(wrapInputStream)
                .prefer("return=representation")
                .build();

        return exampleService.actionOnKey(wrapKeyOptionsModel).execute().getResult();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#unwrapkey
    public static KeyActionOneOfResponse unWrapKey(IbmKeyProtectApi exampleService, String exampleInstance,
                                                   String keyId, String ciphertext) {

        InputStream unWrapInputStream = KpUtils.buildUnWrapKeyInputStream(ciphertext);
        ActionOnKeyOptions unWrapKeyOptionsModel = new ActionOnKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .action("unwrap")
                .keyActionOneOf(unWrapInputStream)
                .prefer("return=representation")
                .build();
        return exampleService.actionOnKey(unWrapKeyOptionsModel).execute().getResult();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#disablekey
    public static void disableKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyId) {
        ActionOnKeyOptions disableKeyOptionsModel = new ActionOnKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .action("disable")
                .prefer("return=representation")
                .build();
        exampleService.actionOnKey(disableKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#enablekey
    public static void enableKey(IbmKeyProtectApi exampleService, String exampleInstance, String keyId) {
        ActionOnKeyOptions enableKeyOptionsModel = new ActionOnKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .action("enable")
                .prefer("return=representation")
                .build();
        exampleService.actionOnKey(enableKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getkeyversions
    public static List<KeyVersion> getKeyVersions(IbmKeyProtectApi exampleService, String exampleInstance, String keyId) {
        GetKeyVersionsOptions getKeyVersionsOptionsModel = new GetKeyVersionsOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .build();
        Response<ListKeyVersions> response = exampleService.getKeyVersions(getKeyVersionsOptionsModel).execute();
        return response.getResult().getResources();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getregistrations
    public static Response<RegistrationWithTotalCount> getRegistrationsForKey(IbmKeyProtectApi exampleService,
                                                                              String exampleInstance, String keyId) {
        // Construct an instance of the GetRegistrationsOptions model
        GetRegistrationsOptions getRegistrationsOptionsModel = new GetRegistrationsOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .limit(Long.valueOf("50"))
                .totalCount(true)
                .build();

        // Invoke operation with valid options model
        Response<RegistrationWithTotalCount> response = exampleService.
                getRegistrations(getRegistrationsOptionsModel).execute();

        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getregistrationsallkeys
    public static Response<RegistrationWithTotalCount> getRegistrationsForInstance(IbmKeyProtectApi exampleService,
                                                                              String exampleInstance, String keyId) {
        // Construct an instance of the GetRegistrationsAllKeysOptions model
        GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptionsModel
                = new GetRegistrationsAllKeysOptions.Builder()
                .bluemixInstance(exampleInstance)
                .limit(Long.valueOf("50"))
                .totalCount(true)
                .build();

        // Invoke operation with valid options model
        Response<RegistrationWithTotalCount> response
                = exampleService.getRegistrationsAllKeys(getRegistrationsAllKeysOptionsModel).execute();

        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putpolicy
    public static void createKeyPolicyDualAuthDelete (IbmKeyProtectApi exampleService,
                                                      String exampleInstance, String keyId, boolean dualAuth) {
        // Construct an instance of the CollectionMetadata model
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.kms.policy+json")
                .collectionTotal(Long.valueOf("1"))
                .build();

        // Construct an instance of the KeyPolicyDualAuthDeleteDualAuthDelete model
        KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel
                = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
                .enabled(dualAuth)
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
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .setKeyPoliciesOneOf(setKeyPoliciesOneOfDualAuthDeleteModel)
                .policy("dualAuthDelete")
                .build();

        // Invoke operation with valid options model
        exampleService.putPolicy(putPolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putpolicy
    public static void createKeyPolicyRotation (IbmKeyProtectApi exampleService,
                                                      String exampleInstance, String keyId, int intervalMonth) {
        // Construct an instance of the CollectionMetadata model
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.kms.policy+json")
                .collectionTotal(Long.valueOf("1"))
                .build();

        // Construct an instance of the KeyPolicyRotationRotation model
        KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
                .intervalMonth(intervalMonth)
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
        PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .setKeyPoliciesOneOf(setKeyPoliciesOneOfRotationModel)
                .policy("rotation")
                .build();

        // Invoke operation with valid options model
        exampleService.putPolicy(putPolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getpolicy
    public static Response<GetKeyPoliciesOneOf> getKeyPolicies (IbmKeyProtectApi exampleService,
                                                                String exampleInstance, String keyId) {
        GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
                .id(keyId)
                .bluemixInstance(exampleInstance)
                .build();

        Response<GetKeyPoliciesOneOf> response = exampleService.getPolicy(getPolicyOptionsModel).execute();
        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static void createInstancePolicyDualAuthDelete (IbmKeyProtectApi exampleService,
                                                String exampleInstance, boolean dualAuth) {
        // Construct an instance of the CollectionMetadata model
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.kms.policy+json")
                .collectionTotal(Long.valueOf("1"))
                .build();

        // Construct an instance of the DualAuthDeleteProperties model
        DualAuthDeleteProperties dualAuthDeletePropertiesModel = new DualAuthDeleteProperties.Builder()
                .enabled(dualAuth)
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
                .bluemixInstance(exampleInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfDualAuthDeleteModel)
                .policy("dualAuthDelete")
                .build();

        // Invoke operation with valid options model (positive test)
        exampleService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static void createInstancePolicyAllowedNetwork (IbmKeyProtectApi exampleService,
                                                           String exampleInstance, String allowedNetworkType) {
        // Construct an instance of the CollectionMetadata model
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.kms.policy+json")
                .collectionTotal(Long.valueOf("1"))
                .build();

        // Construct an instance of the InstancePolicyAllowedNetworkPolicyDataAttributes model
        InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModel
                = new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder()
                .allowedNetwork(allowedNetworkType)
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
        PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                .bluemixInstance(exampleInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfAllowedNetworkModel)
                .policy("allowedNetwork")
                .build();

        // Invoke operation with valid options model
        exampleService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static void createInstancePolicyMetrics (IbmKeyProtectApi exampleService,
                                                           String exampleInstance, boolean metrics) {
        // Construct an instance of the CollectionMetadata model
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.kms.policy+json")
                .collectionTotal(Long.valueOf("1"))
                .build();

        // Construct an instance of the MetricsProperties model
        MetricsProperties metricsPropertiesModel = new MetricsProperties.Builder()
                .enabled(metrics)
                .build();

        // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem model
        SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem
                setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel
                = new SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem.Builder()
                .policyType("metrics")
                .policyData(metricsPropertiesModel)
                .build();

        // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyMetrics model
        SetInstancePoliciesOneOfSetInstancePolicyMetrics setInstancePoliciesOneOfMetricsModel
                = new SetInstancePoliciesOneOfSetInstancePolicyMetrics.Builder()
                .metadata(collectionMetadataModel)
                .resources(new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem>
                        (Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItemModel)))
                .build();

        // Construct an instance of the PutInstancePolicyOptions model
        PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                .bluemixInstance(exampleInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfMetricsModel)
                .policy("metrics")
                .build();

        // Invoke operation with valid options model
        exampleService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static void createInstancePolicyKeyCreateImportAccess (IbmKeyProtectApi exampleService,
                                                                  String exampleInstance,
                                                                  boolean createRootKey, boolean createStandardKey,
                                                                  boolean importRootKey, boolean importStandardKey,
                                                                  boolean enforceToken) {
        // Construct an instance of the CollectionMetadata model
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.kms.policy+json")
                .collectionTotal(Long.valueOf("1"))
                .build();

        // Construct an instance of the InstancePolicyKeyCreateImportAccessPolicyDataAttributes model
        InstancePolicyKeyCreateImportAccessPolicyDataAttributes instancePolicyKeyCreateImportAccessPolicyDataAttributesModel
                = new InstancePolicyKeyCreateImportAccessPolicyDataAttributes.Builder()
                .createRootKey(createRootKey)
                .createStandardKey(createStandardKey)
                .importRootKey(importRootKey)
                .importStandardKey(importStandardKey)
                .enforceToken(enforceToken)
                .build();

        // Construct an instance of the InstancePolicyKeyCreateImportAccessPolicyData model
        InstancePolicyKeyCreateImportAccessPolicyData instancePolicyKeyCreateImportAccessPolicyDataModel
                = new InstancePolicyKeyCreateImportAccessPolicyData.Builder()
                .enabled(true)
                .attributes(instancePolicyKeyCreateImportAccessPolicyDataAttributesModel)
                .build();

        // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem model
        SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem
                setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel
                = new SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem.Builder()
                .policyType("keyCreateImportAccess")
                .policyData(instancePolicyKeyCreateImportAccessPolicyDataModel)
                .build();

        // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess model
        SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess setInstancePoliciesOneOfKeyCreateImportAccessModel
                = new SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess.Builder()
                .metadata(collectionMetadataModel)
                .resources(new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem>
                        (Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItemModel)))
                .build();

        // Construct an instance of the PutInstancePolicyOptions model
        PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                .bluemixInstance(exampleInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfKeyCreateImportAccessModel)
                .policy("keyCreateImportAccess")
                .build();

        // Invoke operation with valid options model
        exampleService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getinstancepolicy
    public static Response<GetInstancePoliciesOneOf> getInstancePolicies (IbmKeyProtectApi exampleService,
                                                                          String exampleInstance) {
        // Construct an instance of the GetInstancePolicyOptions model
        GetInstancePolicyOptions getInstancePolicyOptionsModel = new GetInstancePolicyOptions.Builder()
                .bluemixInstance(exampleInstance)
                .build();

        // Invoke operation with valid options model
        Response<GetInstancePoliciesOneOf> response = exampleService.getInstancePolicy
                (getInstancePolicyOptionsModel).execute();

        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#createkeyalias
    public static void createKeyAlias (IbmKeyProtectApi exampleService,
                                                     String exampleInstance, String keyId, String keyAlias) {

        // Construct an instance of the CreateKeyAliasOptions model
        CreateKeyAliasOptions createKeyAliasOptionsModel = new CreateKeyAliasOptions.Builder()
                .id(keyId)
                .alias(keyAlias)
                .bluemixInstance(exampleInstance)
                .build();

        // Invoke operation with valid options model
        exampleService.createKeyAlias(createKeyAliasOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#deletekeyalias
    public static void deleteKeyAlias (IbmKeyProtectApi exampleService,
                                       String exampleInstance, String keyId, String keyAlias) {

        // Construct an instance of the DeleteKeyAliasOptions model
        DeleteKeyAliasOptions deleteKeyAliasOptionsModel = new DeleteKeyAliasOptions.Builder()
                .id(keyId)
                .alias(keyAlias)
                .bluemixInstance(exampleInstance)
                .build();

        // Invoke operation with valid options model
        exampleService.deleteKeyAlias(deleteKeyAliasOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect
    public static void createKeyRing (IbmKeyProtectApi exampleService,
                                       String exampleInstance, String keyRingId) {

        // Construct an instance of the CreateKeyRingOptions model
        CreateKeyRingOptions createKeyRingOptionsModel = new CreateKeyRingOptions.Builder()
                .keyRingId(keyRingId)
                .bluemixInstance(exampleInstance)
                .build();

        // Invoke operation with valid options model
        exampleService.createKeyRing(createKeyRingOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect
    public static Response<ListKeyRings> getKeyRings (IbmKeyProtectApi exampleService,
                                      String exampleInstance) {

        // Construct an instance of the ListKeyRingsOptions model
        ListKeyRingsOptions listKeyRingsOptionsModel = new ListKeyRingsOptions.Builder()
                .bluemixInstance(exampleInstance)
                .build();

        // Invoke operation with valid options model
        return exampleService.listKeyRings(listKeyRingsOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect
    public static void deleteKeyRing (IbmKeyProtectApi exampleService,
                                      String exampleInstance, String keyRingId) {

        // Construct an instance of the DeleteKeyRingOptions model
        DeleteKeyRingOptions deleteKeyRingOptionsModel = new DeleteKeyRingOptions.Builder()
                .keyRingId(keyRingId)
                .bluemixInstance(exampleInstance)
                .build();

        // Invoke operation with valid options model
        exampleService.deleteKeyRing(deleteKeyRingOptionsModel).execute();
    }

    // payload should be base64 encoded string
    // notRootKey is false if this is a root key
    public static InputStream buildCreateKeyInputStream(String keyName,String keyDesc, String payload,
                                                        boolean notRootKey) {

        // build json format input stream
        JsonObjectBuilder resourceObjectBuilder = Json.createObjectBuilder()
                .add("name", keyName)
                .add("extractable", notRootKey)
                .add("description", keyDesc);

        // imported key
        if (payload != null)
            resourceObjectBuilder.add("payload", payload);

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("metadata", Json.createObjectBuilder()
                        .add("collectionType", "application/vnd.ibm.kms.key+json")
                        .add("collectionTotal", 1))
                .add("resources", Json.createArrayBuilder()
                        .add(resourceObjectBuilder));

        JsonObject jsonObject = jsonObjectBuilder.build();

        InputStream inputstream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        return inputstream;
    }

    // payload should be base64 encoded string
    public static InputStream buildRestoreKeyInputStream(String payload) {

        // build json format input stream
        JsonObjectBuilder resourceObjectBuilder = Json.createObjectBuilder()
                .add("payload", payload);

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("metadata", Json.createObjectBuilder()
                        .add("collectionType", "application/vnd.ibm.kms.key+json")
                        .add("collectionTotal", 1))
                .add("resources", Json.createArrayBuilder()
                        .add(resourceObjectBuilder));

        JsonObject jsonObject = jsonObjectBuilder.build();

        InputStream inputstream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        return inputstream;
    }

    // payload should be base64 encoded string
    public static InputStream buildRotateKeyInputStream(String payload) {

        // build json format input stream
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("payload", payload);

        JsonObject jsonObject = jsonObjectBuilder.build();

        InputStream inputstream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        return inputstream;
    }

    public static InputStream buildWrapKeyInputStream(String encodedString) {

        // build json format input stream
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("plaintext", encodedString);

        JsonObject jsonObject = jsonObjectBuilder.build();

        InputStream inputstream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        return inputstream;
    }

    public static InputStream buildUnWrapKeyInputStream(String ciphertext) {

        // build json format input stream
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("ciphertext", ciphertext);

        JsonObject jsonObject = jsonObjectBuilder.build();

        InputStream inputstream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        return inputstream;
    }
}