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

package com.ibm.cloud.ibm_key_protect_api.v2.utils;

import com.ibm.cloud.ibm_key_protect_api.v2.IbmKeyProtectApi;
import com.ibm.cloud.ibm_key_protect_api.v2.model.*;
import com.ibm.cloud.platform_services.resource_controller.v2.ResourceController;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// API docs: https://cloud.ibm.com/apidocs/key-protect
// Utilities class to provide KP services

public class KpUtilities {

    private static final Logger logger = LoggerFactory.getLogger(KpUtilities.class);

    public KpUtilities() {
    }

    public static ResourceController getResourceController(Authenticator authenticator) {
        String serviceName = "resource_controller";
        ResourceController service = new ResourceController(serviceName, authenticator);
        service.configureService(serviceName);
        return service;
    }
    public static String createInstance(ResourceController service, String resourceGroup) {
        String resourceInstanceName = "java-sdk-test-instance";
        String targetRegion = "us-south";
        String resourcePlanId = "eedd3585-90c6-4c8f-be3d-062069e99fc3";  // keyprotect tiered-pricing ID

        CreateResourceInstanceOptions createResourceInstanceOptions = new CreateResourceInstanceOptions.Builder()
                .name(resourceInstanceName)
                .target(targetRegion)
                .resourceGroup(resourceGroup)
                .resourcePlanId(resourcePlanId)
                .build();

        Response<ResourceInstance> response = service.createResourceInstance(createResourceInstanceOptions).execute();
        ResourceInstance resourceInstance = response.getResult();

        return resourceInstance.getGuid();
    }

    public static void deleteInstance(ResourceController service, String instanceGuid) {
        DeleteResourceInstanceOptions deleteResourceInstanceOptions = new DeleteResourceInstanceOptions.Builder()
                .id(instanceGuid)
                .recursive(false)
                .build();

        Response<Void> response = service.deleteResourceInstance(deleteResourceInstanceOptions).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#createkey
    // payload is null if not an imported key
    // notRootKey is false if this is a root key
    public static String createKey(IbmKeyProtectApi testService, String testInstance, String keyName,
                                   String keyDesc, String payload, boolean notRootKey) {

        InputStream inputstream = KpUtilities.buildCreateKeyInputStream(keyName, keyDesc, payload, notRootKey);

        CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
                .bluemixInstance(testInstance)
                .body(inputstream)
                .prefer("return=representation")
                .build();

        Response<Key> response = testService.createKey(createKeyOptionsModel).execute();
        KeyWithPayload keyWithPayload = response.getResult().getResources().get(0);
        String keyId = keyWithPayload.getId();
        return keyId;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getkey
    public static KeyWithPayload getKey(IbmKeyProtectApi testService, String testInstance, String keyId_or_alias) {
        GetKeyOptions options = new GetKeyOptions.Builder().id(keyId_or_alias)
                .bluemixInstance(testInstance)
                .build();
        Response<GetKey> response = testService.getKey(options).execute();
        GetKey responseObj = response.getResult();
        KeyWithPayload keyWithPayload = responseObj.getResources().get(0);
        return keyWithPayload;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getkeys
    public static List<KeyFullRepresentation> getKeys(IbmKeyProtectApi testService, String testInstance) {
        GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
                .bluemixInstance(testInstance)
                .build();
        Response<ListKeys> response = testService.getKeys(getKeysOptionsModel).execute();
        return response.getResult().getResources();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#deletekey
    public static Response<DeleteKey> deleteKey(IbmKeyProtectApi testService, String testInstance, String keyId) {
        DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .force(true)
                .build();

        return testService.deleteKey(deleteKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#restorekey
    public static Response<InputStream> restoreKey(IbmKeyProtectApi testService, String testInstance, String keyId,
                                                   String payload) {
        InputStream  inputstream = KpUtilities.buildRestoreKeyInputStream(payload);
        RestoreKeyOptions restoreKeyOptionsModel = new RestoreKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .keyRestoreBody(inputstream)
                .prefer("return=representation")
                .build();

        return testService.restoreKey(restoreKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#rotatekey
    public static Response<Void> rotateKey(IbmKeyProtectApi testService, String testInstance, String keyId, String payload) {
        InputStream inputstream = KpUtilities.buildRotateKeyInputStream(payload);
        RotateKeyOptions rotateKeyOptionsModel = new RotateKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .keyActionRotateBody(inputstream)
                .prefer("return=representation")
                .build();

        return testService.rotateKey(rotateKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#wrapkey
    public static Response<WrapKeyResponseBody> wrapKey(IbmKeyProtectApi testService, String testInstance,
                                                        String keyId, String payload) {

        InputStream wrapInputStream = KpUtilities.buildWrapKeyInputStream(payload);

        WrapKeyOptions wrapKeyOptionsModel = new WrapKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .keyActionWrapBody(wrapInputStream)
                .build();

        return testService.wrapKey(wrapKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#unwrapkey
    public static Response<UnwrapKeyResponseBody> unWrapKey(IbmKeyProtectApi testService, String testInstance,
                                                            String keyId, String ciphertext) {

        InputStream unWrapInputStream = KpUtilities.buildUnWrapKeyInputStream(ciphertext);
        UnwrapKeyOptions unwrapKeyOptionsModel = new UnwrapKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .keyActionUnwrapBody(unWrapInputStream)
                .build();
        return testService.unwrapKey(unwrapKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#disablekey
    public static Response<Void> disableKey(IbmKeyProtectApi testService, String testInstance, String keyId) {
        DisableKeyOptions disableKeyOptionsModel = new DisableKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .build();
        return testService.disableKey(disableKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#enablekey
    public static Response<Void> enableKey(IbmKeyProtectApi testService, String testInstance, String keyId) {
        EnableKeyOptions enableKeyOptionsModel = new EnableKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .build();
        return testService.enableKey(enableKeyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getkeyversions
    public static List<KeyVersion> getKeyVersions(IbmKeyProtectApi testService, String testInstance, String keyId) {
        GetKeyVersionsOptions getKeyVersionsOptionsModel = new GetKeyVersionsOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .build();
        Response<ListKeyVersions> response = testService.getKeyVersions(getKeyVersionsOptionsModel).execute();
        return response.getResult().getResources();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getregistrations
    public static Response<RegistrationWithTotalCount> getRegistrationsForKey(IbmKeyProtectApi testService,
                                                                              String testInstance, String keyId) {
        // Construct an instance of the GetRegistrationsOptions model
        GetRegistrationsOptions getRegistrationsOptionsModel = new GetRegistrationsOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .limit(Long.valueOf("50"))
                .totalCount(true)
                .build();

        // Invoke operation with valid options model
        Response<RegistrationWithTotalCount> response = testService.
                getRegistrations(getRegistrationsOptionsModel).execute();

        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getregistrationsallkeys
    public static Response<RegistrationWithTotalCount> getRegistrationsForInstance(IbmKeyProtectApi testService,
                                                                              String testInstance, String keyId) {
        // Construct an instance of the GetRegistrationsAllKeysOptions model
        GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptionsModel
                = new GetRegistrationsAllKeysOptions.Builder()
                .bluemixInstance(testInstance)
                .limit(Long.valueOf("50"))
                .totalCount(true)
                .build();

        // Invoke operation with valid options model
        Response<RegistrationWithTotalCount> response
                = testService.getRegistrationsAllKeys(getRegistrationsAllKeysOptionsModel).execute();

        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putpolicy
    public static Response<GetKeyPoliciesOneOf> createKeyPolicyDualAuthDelete (IbmKeyProtectApi testService,
                                                                               String testInstance, String keyId, boolean dualAuth) {
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
                .bluemixInstance(testInstance)
                .setKeyPoliciesOneOf(setKeyPoliciesOneOfDualAuthDeleteModel)
                .policy("dualAuthDelete")
                .build();

        // Invoke operation with valid options model
        return testService.putPolicy(putPolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putpolicy
    public static Response<GetKeyPoliciesOneOf> createKeyPolicyRotation (IbmKeyProtectApi testService,
                                                                         String testInstance, String keyId, int intervalMonth) {
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
                .bluemixInstance(testInstance)
                .setKeyPoliciesOneOf(setKeyPoliciesOneOfRotationModel)
                .policy("rotation")
                .build();

        // Invoke operation with valid options model
        return testService.putPolicy(putPolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getpolicy
    public static Response<GetKeyPoliciesOneOf> getKeyPolicies (IbmKeyProtectApi testService,
                                                                String testInstance, String keyId) {
        GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .build();

        return testService.getPolicy(getPolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static Response<Void> createInstancePolicyDualAuthDelete (IbmKeyProtectApi testService,
                                                                     String testInstance, boolean dualAuth) {
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
                .bluemixInstance(testInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfDualAuthDeleteModel)
                .policy("dualAuthDelete")
                .build();

        // Invoke operation with valid options model (positive test)
        return testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static Response<Void> createInstancePolicyAllowedNetwork (IbmKeyProtectApi testService,
                                                                     String testInstance, String allowedNetworkType) {
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
                .bluemixInstance(testInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfAllowedNetworkModel)
                .policy("allowedNetwork")
                .build();

        // Invoke operation with valid options model
        return testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static Response<Void> createInstancePolicyMetrics (IbmKeyProtectApi testService,
                                                              String testInstance, boolean metrics) {
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
                .bluemixInstance(testInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfMetricsModel)
                .policy("metrics")
                .build();

        // Invoke operation with valid options model
        return testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#putinstancepolicy
    public static Response<Void> createInstancePolicyKeyCreateImportAccess (IbmKeyProtectApi testService,
                                                                            String testInstance,
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
                .bluemixInstance(testInstance)
                .setInstancePoliciesOneOf(setInstancePoliciesOneOfKeyCreateImportAccessModel)
                .policy("keyCreateImportAccess")
                .build();

        // Invoke operation with valid options model
        return testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#getinstancepolicy
    public static Response<GetInstancePoliciesOneOf> getInstancePolicies (IbmKeyProtectApi testService,
                                                                          String testInstance) {
        // Construct an instance of the GetInstancePolicyOptions model
        GetInstancePolicyOptions getInstancePolicyOptionsModel = new GetInstancePolicyOptions.Builder()
                .bluemixInstance(testInstance)
                .build();

        // Invoke operation with valid options model
        Response<GetInstancePoliciesOneOf> response = testService.getInstancePolicy
                (getInstancePolicyOptionsModel).execute();

        return response;
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#createkeyalias
    public static Response<KeyAlias> createKeyAlias (IbmKeyProtectApi testService,
                                                     String testInstance, String keyId, String keyAlias) {

        // Construct an instance of the CreateKeyAliasOptions model
        CreateKeyAliasOptions createKeyAliasOptionsModel = new CreateKeyAliasOptions.Builder()
                .id(keyId)
                .alias(keyAlias)
                .bluemixInstance(testInstance)
                .build();

        // Invoke operation with valid options model
        return testService.createKeyAlias(createKeyAliasOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect#deletekeyalias
    public static Response<Void> deleteKeyAlias (IbmKeyProtectApi testService,
                                       String testInstance, String keyId, String keyAlias) {

        // Construct an instance of the DeleteKeyAliasOptions model
        DeleteKeyAliasOptions deleteKeyAliasOptionsModel = new DeleteKeyAliasOptions.Builder()
                .id(keyId)
                .alias(keyAlias)
                .bluemixInstance(testInstance)
                .build();

        // Invoke operation with valid options model
        return testService.deleteKeyAlias(deleteKeyAliasOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect
    public static Response<Void> createKeyRing (IbmKeyProtectApi testService,
                                                String testInstance, String keyRingId) {

        // Construct an instance of the CreateKeyRingOptions model
        CreateKeyRingOptions createKeyRingOptionsModel = new CreateKeyRingOptions.Builder()
                .keyRingId(keyRingId)
                .bluemixInstance(testInstance)
                .build();

        // Invoke operation with valid options model
        return testService.createKeyRing(createKeyRingOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect
    public static Response<ListKeyRings> getKeyRings (IbmKeyProtectApi testService,
                                      String testInstance) {

        // Construct an instance of the ListKeyRingsOptions model
        ListKeyRingsOptions listKeyRingsOptionsModel = new ListKeyRingsOptions.Builder()
                .bluemixInstance(testInstance)
                .build();

        // Invoke operation with valid options model
        return testService.listKeyRings(listKeyRingsOptionsModel).execute();
    }

    // API docs: https://cloud.ibm.com/apidocs/key-protect
    public static Response<Void> deleteKeyRing (IbmKeyProtectApi testService,
                                                String testInstance, String keyRingId) {

        // Construct an instance of the DeleteKeyRingOptions model
        DeleteKeyRingOptions deleteKeyRingOptionsModel = new DeleteKeyRingOptions.Builder()
                .keyRingId(keyRingId)
                .bluemixInstance(testInstance)
                .build();

        // Invoke operation with valid options model
        return testService.deleteKeyRing(deleteKeyRingOptionsModel).execute();
    }

    // https://cloud.ibm.com/apidocs/key-protect#patchkey
    public static Response<PatchKeyResponseBody> setKeyRing (IbmKeyProtectApi testService,
                                      String testInstance, String keyId, String keyRingId, String newKeyRingId) {
        // Construct an instance of the PatchKeyOptions model
        PatchKeyOptions patchKeyOptionsModel = new PatchKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .keyPatchBody(buildSetKeyRingStream(newKeyRingId))
                .xKmsKeyRing(keyRingId)
                .build();

        // Invoke operation with valid options model
        return testService.patchKey(patchKeyOptionsModel).execute();
    }

    // https://cloud.ibm.com/apidocs/key-protect#purgekey
    public static void purgeKey (IbmKeyProtectApi testService,
                                   String testInstance, String keyId) {
        // Construct an instance of the PurgeKeyOptions model
        PurgeKeyOptions purgeKeyOptionsModel = new PurgeKeyOptions.Builder()
                .id(keyId)
                .bluemixInstance(testInstance)
                .prefer("return=representation")
                .build();

        // Invoke operation with valid options model
        Response<PurgeKey> response = testService.purgeKey(purgeKeyOptionsModel).execute();
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

    public static InputStream buildSetKeyRingStream(String newKeyRingId) {

        // build json format input stream
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("keyRingID", newKeyRingId);

        JsonObject jsonObject = jsonObjectBuilder.build();

        InputStream inputstream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        return inputstream;
    }
}