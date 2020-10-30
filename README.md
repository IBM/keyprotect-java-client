[![Build Status](https://travis-ci.com/IBM/keyprotect-java-client.svg?branch=master)](https://travis-ci.com/IBM/keyprotect-java-client)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)


# IBM Cloud Key Protect Java SDK Version 0.1.0
Java client library to interact with [IBM Key Protect](https://cloud.ibm.com/apidocs/key-protect).

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

      npx markdown-toc -i README.md
  -->

<!-- toc -->

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Using the SDK](#using-the-sdk)
- [Questions](#questions)
- [Issues](#issues)
- [Open source @ IBM](#open-source--ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

## Overview

The IBM Cloud Key Protect Java SDK allows developers to programmatically interact with the IBM Cloud Key Protect services

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.


#### Installation
To define a dependency on the entire set of services contained in the project, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.ibm.cloud</groupId>
	<artifactId>ibm-key-protect-sdk</artifactId>
	<version>0.1.0</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.cloud:ibm-key-protect-sdk:0.1.0'
```

## Using the SDK

### Creating key protect service

Import key-protect-api.jar into your project structure to access com.ibm.cloud.ibm_key_protect_api package.
Import sdk-core.jar to have IamAuthenticator. Create IamAuthenticator using IAM API key and IAM AUTH URL.
Then configure key protect service with the authenticator, then run operations on service.

```import com.ibm.cloud.ibm_key_protect_api.v2.IbmKeyProtectApi;
   import com.ibm.cloud.ibm_key_protect_api.v2.model.*;
   import com.ibm.cloud.sdk.core.http.Response;
   import com.ibm.cloud.sdk.core.security.*;

   import java.lang.*;
   import java.util.List;
   public class SampleCreateService {
       public static void main(String[] args) {
           String bluemixInstance = <INSTANCE_ID>;
           IbmKeyProtectApi testService;
           IamAuthenticator authenticator = new IamAuthenticator(<IAM_API_KEY>);
           authenticator.setURL(<IAM_AUTH_URL>);
           authenticator.validate();
           testService = IbmKeyProtectApi.newInstance(authenticator);
           testService.setServiceUrl(<KEY_PROTECT_URL>);
       }
   }
  ```
## Examples

Following examples use the service(testService) created above.

### Create a key
```
            InputStream inputstream = new FileInputStream(<PATH_TO_Create_Key_Body>)
            CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .createKeyOneOf(inputstream)
                    .correlationId("testString")
                    .prefer("return=representation")
                    .build();

            // Invoke operation with valid options model 
            Response<Key> response = testService.createKey(createKeyOptionsModel).execute();
```

### List keys
           GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
                   .bluemixInstance(bluemixInstance)
                   .build();
           Response<ListKeys> response = testService.getKeys(getKeysOptionsModel).execute();
           List<KeyRepresentation> keys = response.getResult().getResources();

### Get Key Metadata
```
           GetKeyMetadataOptions getKeyMetadataOptionsModel = new GetKeyMetadataOptions.Builder()
                   .id(keyId)
                   .bluemixInstance(bluemixInstance)
                   .build();

           // Invoke operation with valid options model
           Response<GetKeyMetadata> response = testService.getKeyMetadata(getKeyMetadataOptionsModel).execute();
           GetKeyMetadata responseObj = response.getResult();
```

### Delete a Key
```
            DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .force(true)
                    .build();

            // Invoke operation with valid options model 
            Response<DeleteKey> response = testService.deleteKey(deleteKeyOptionsModel).execute();
```

### Restore a Key
```
            InputStream inputstream = new FileInputStream(<PATH_TO_Restore_Key_Body>)
            ActionOnKeyOptions restoreKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .action("restore")
                    .keyActionOneOf(inputstream)
                    .prefer("return=representation")
                    .build();

            // Invoke operation with valid options model
            Response<KeyActionOneOfResponse> response = testService.actionOnKey(restoreKeyOptionsModel).execute();
            KeyActionOneOfResponse responseObj = response.getResult();
```

### List Key Versions
```
            GetKeyVersionsOptions getKeyVersionsOptionsModel = new GetKeyVersionsOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .build();

            // Invoke operation with valid options model 
            Response<ListKeyVersions> response = testService.getKeyVersions(getKeyVersionsOptionsModel).execute();
            List<KeyVersion> versions = response.getResult().getResources();
```

### Wrap/Unwrap a key
```
            InputStream inputstream = new FileInputStream(<PATH_TO_Wrap_Key_Body>);
            //body has base64 encoded standard key
            ActionOnKeyOptions wrapKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(id)
                    .bluemixInstance(bluemixInstance)
                    .action("wrap")
                    .keyActionOneOf(inputstream)
                    .prefer("return=representation")
                    .build();
            Response<KeyActionOneOfResponse> response = testService.actionOnKey(wrapKeyOptionsModel).execute();
            GetKey responseObj = response.getResult();
            KeyActionOneOfResponse responseObj = response.getResult();
            //Unwrapping Key
            inputstream = new FileInputStream(<PATH_TO_Unwrap_Key_Body>);
            //body contains cipher text from wrap key request
            ActionOnKeyOptions unWrapKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(id)
                    .bluemixInstance(bluemixInstance)
                    .action("unwrap")
                    .keyActionOneOf(inputstream)
                    .prefer("return=representation")
                    .build();
            response = testService.actionOnKey(unWrapKeyOptionsModel).execute();
            responseObj = response.getResult();
```

### Rotate a key
```
            InputStream inputstream = new FileInputStream(<PATH_TO_Rotate_Key_Body>)
            ActionOnKeyOptions actionOnKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .action("rotate")
                    .keyActionOneOf(inputstream)
                    .prefer("return=representation")
                    .build();
            Response<KeyActionOneOfResponse> response = testService.actionOnKey(actionOnKeyOptionsModel).execute();
            KeyActionOneOfResponse responseObj = response.getResult();
```

### Disable a key
```
            ActionOnKeyOptions disableKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .action("disable")
                    .prefer("return=representation")
                    .build();
            Response<KeyActionOneOfResponse> response = testService.actionOnKey(disableKeyOptionsModel).execute();
            KeyActionOneOfResponse responseObj = response.getResult();
```

### Enable a key
```
            ActionOnKeyOptions enableKeyOptionsModel = new ActionOnKeyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .action("enable")
                    .prefer("return=representation")
                    .build();
            Response<KeyActionOneOfResponse> response = testService.actionOnKey(enableKeyOptionsModel).execute();
            KeyActionOneOfResponse responseObj = response.getResult();
```

### Create/Retrieve an Import token
```
            //Creating Import Token
            PostImportTokenOptions postImportTokenOptionsModel = new PostImportTokenOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .expiration(Double.valueOf("86400"))
                    .maxAllowedRetrievals(Double.valueOf("500"))
                    .build();
            Response<ImportToken> response = testService.postImportToken(postImportTokenOptionsModel).execute();
            ImportToken responseObj = response.getResult();

            //Retrieving Import Token
            GetImportTokenOptions getImportTokenOptionsModel = new GetImportTokenOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .build();

            Response<GetImportToken> getResponse = testService.getImportToken(getImportTokenOptionsModel).execute();
            GetImportToken getResponseObj = getResponse.getResult();
```
### List Registrations

```
            // Construct an instance of the GetRegistrationsOptions model
            GetRegistrationsOptions getRegistrationsOptionsModel = new GetRegistrationsOptions.Builder()
                     //.id(keyId)          // uncomment to list registrations for a key in the instance
                    .bluemixInstance(bluemixInstance)
                    .limit(Long.valueOf("50"))
                    .totalCount(true)
                    .build();

            // Invoke operation with valid options model
            Response<RegistrationWithTotalCount> response = testService.getRegistrations(getRegistrationsOptionsModel).execute();
            RegistrationWithTotalCount responseObj = response.getResult();
```

### Set(create or update)/Retrieve key policies

###### Set automatic rotation policy for a key
```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();

            // Construct an instance of the KeyPolicyRotationRotation model
            // Build a policy that will cause keys to be automatically rotated every 2 months
            KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
                    .intervalMonth(2)
                    .build();

            // Construct an instance of the KeyPolicyRotation model
            KeyPolicyRotation keyPolicyRotationModel = new KeyPolicyRotation.Builder()
                    .type("application/vnd.ibm.kms.policy+json")
                    .rotation(keyPolicyRotationRotationModel)
                    .build();

            // Construct an instance of the SetKeyPoliciesOneOfSetKeyPolicyRotation model
            SetKeyPoliciesOneOfSetKeyPolicyRotation setKeyPoliciesOneOfModel = new SetKeyPoliciesOneOfSetKeyPolicyRotation.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<KeyPolicyRotation>(Arrays.asList(keyPolicyRotationModel)))
                    .build();

            // Construct an instance of the PutPolicyOptions model
            PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .setKeyPoliciesOneOf(setKeyPoliciesOneOfModel)
                    .policy("rotation")
                    .build();

            // Invoke operation with valid options model
            Response<GetKeyPoliciesOneOf> response = testService.putPolicy(putPolicyOptionsModel).execute();
            GetKeyPoliciesOneOf responseObj = response.getResult();
```
###### Set dual authorization policy for a key
```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();
            
            // Construct an instance of the KeyPolicyDualAuthDeleteDualAuthDelete model
            KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
                    .enabled(true)
                    .build();

            // Construct an instance of the KeyPolicyDualAuthDelete model
            KeyPolicyDualAuthDelete keyPolicyDualAuthDeleteModel = new KeyPolicyDualAuthDelete.Builder()
                    .type("application/vnd.ibm.kms.policy+json")
                    .dualAuthDelete(keyPolicyDualAuthDeleteDualAuthDeleteModel)
                    .build();

            // Construct an instance of the SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete model
            SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete setKeyPoliciesOneOfModel = new SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<KeyPolicyDualAuthDelete>(Arrays.asList(keyPolicyDualAuthDeleteModel)))
                    .build();

            // Construct an instance of the PutPolicyOptions model
            PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .setKeyPoliciesOneOf(setKeyPoliciesOneOfModel)
                    .policy("dualAuthDelete")
                    .build();

            // Invoke operation with valid options model (positive test)
            Response<GetKeyPoliciesOneOf> response = testService.putPolicy(putPolicyOptionsModel).execute();
            GetKeyPoliciesOneOf responseObj = response.getResult();
```
###### Set multiple policies for a key
Set up a dual auth delete policy and also a policy to rotate the key every 2 months, using one HTTP request.

```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("2"))
                    .build();

            // Construct a list of SetMultipleKeyPoliciesResourcesItem
            ArrayList<SetMultipleKeyPoliciesResourcesItem> setMultipleKeyPoliciesResourcesItemList = new ArrayList<SetMultipleKeyPoliciesResourcesItem>();

            // Construct an instance of the KeyPolicyDualAuthDeleteDualAuthDelete model
            KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
                    .enabled(true)
                    .build();

            // Construct an instance of the SetMultipleKeyPoliciesResourcesItem model for dualAuthDelete
            SetMultipleKeyPoliciesResourcesItem setMultipleKeyPoliciesResourcesItemModel = new SetMultipleKeyPoliciesResourcesItem.Builder()
                    .type("application/vnd.ibm.kms.policy+json")
                    .dualAuthDelete(keyPolicyDualAuthDeleteDualAuthDeleteModel)
                    .build();

            // Add to the list
            setMultipleKeyPoliciesResourcesItemList.add(setMultipleKeyPoliciesResourcesItemModel);

            // Construct an instance of the KeyPolicyRotationRotation model
            KeyPolicyRotationRotation keyPolicyRotationRotationModel = new KeyPolicyRotationRotation.Builder()
                    .intervalMonth(2)
                    .build();

            // Construct an instance of the SetMultipleKeyPoliciesResourcesItem model for rotation
            SetMultipleKeyPoliciesResourcesItem setMultipleKeyPoliciesResourcesItemModel2 = new SetMultipleKeyPoliciesResourcesItem.Builder()
                    .type("application/vnd.ibm.kms.policy+json")
                    .rotation(keyPolicyRotationRotationModel)
                    .build();

            // Add to the list
            setMultipleKeyPoliciesResourcesItemList.add(setMultipleKeyPoliciesResourcesItemModel2);

            // Construct an instance of the SetKeyPoliciesOneOfSetMultipleKeyPolicies model
            SetKeyPoliciesOneOfSetMultipleKeyPolicies setKeyPoliciesOneOfModel = new SetKeyPoliciesOneOfSetMultipleKeyPolicies.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetMultipleKeyPoliciesResourcesItem>(setMultipleKeyPoliciesResourcesItemList))
                    .build();

            // Construct an instance of the PutPolicyOptions model
            PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
                    .id(keyId)
                    .bluemixInstance(bluemixInstance)
                    .setKeyPoliciesOneOf(setKeyPoliciesOneOfModel)
                    .build();

            // Invoke operation with valid options model
            Response<GetKeyPoliciesOneOf> response = testService.putPolicy(putPolicyOptionsModel).execute();
            GetKeyPoliciesOneOf responseObj = response.getResult();
```
###### List policies for a key
```
            // Construct an instance of the GetPolicyOptions model
            GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
                    .id(id)
                    .bluemixInstance(bluemixInstance)
            //      .policy("dualAuthDelete")     //uncomment to get only dualAuthDelete policy
            //      .policy("rotation")           //uncomment to get only rotation policy
                    .build();

            // Invoke operation with valid options model (positive test)
            Response<GetKeyPoliciesOneOf> response = testService.getPolicy(getPolicyOptionsModel).execute();
            GetKeyPoliciesOneOf responseObj = response.getResult();
```

### Set(create or update)/Retrieve instance policies

###### Set dual authorization policy for an instance

```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();

            // Construct an instance of the DualAuthDeleteProperties model
            DualAuthDeleteProperties dualAuthDeletePropertiesModel = new DualAuthDeleteProperties.Builder()
                    .enabled(true)
                    .build();

            // Construct an instance of the SetInstancePolicyDualAuthDeleteResourcesItem model
            SetInstancePolicyDualAuthDeleteResourcesItem setInstancePolicyDualAuthDeleteResourcesItemModel = new SetInstancePolicyDualAuthDeleteResourcesItem.Builder()
                    .policyType("dualAuthDelete")
                    .policyData(dualAuthDeletePropertiesModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete model
            SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete setInstancePoliciesOneOfModel = new SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetInstancePolicyDualAuthDeleteResourcesItem>(Arrays.asList(setInstancePolicyDualAuthDeleteResourcesItemModel)))
                    .build();

            // Construct an instance of the PutInstancePolicyOptions model
            PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .setInstancePoliciesOneOf(setInstancePoliciesOneOfModel)
                    .policy("dualAuthDelete")
                    .build();

            // Invoke operation with valid options model 
            Response<Void> response = testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();

```

###### Set allowed network policy for an instance

```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();

            // Construct an instance of the InstancePolicyAllowedNetworkPolicyDataAttributes model
            // Build a network policy that allows access to the instance via public and private networks (the default)
            InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModel = new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder()
                    .allowedNetwork("public-and-private")
                    .build();

            // Construct an instance of the InstancePolicyAllowedNetworkPolicyData model
            InstancePolicyAllowedNetworkPolicyData instancePolicyAllowedNetworkPolicyDataModel = new InstancePolicyAllowedNetworkPolicyData.Builder()
                    .enabled(true)
                    .attributes(instancePolicyAllowedNetworkPolicyDataAttributesModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem model
            SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem.Builder()
                    .policyType("allowedNetwork")
                    .policyData(instancePolicyAllowedNetworkPolicyDataModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork model
            SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork setInstancePoliciesOneOfModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem>(Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel)))
                    .build();

            // Construct an instance of the PutInstancePolicyOptions model
            PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .setInstancePoliciesOneOf(setInstancePoliciesOneOfModel)
                    .policy("allowedNetwork")
                    .build();

            // Invoke operation with valid options model
            testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
```

###### Set allowed IP policy for an instance
```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("1"))
                    .build();

            // Construct an instance of the InstancePolicyAllowedIPPolicyDataAttributes model
            InstancePolicyAllowedIPPolicyDataAttributes instancePolicyAllowedIpPolicyDataAttributesModel = new InstancePolicyAllowedIPPolicyDataAttributes.Builder()
                    .allowedIp(new ArrayList<String>(Arrays.asList("X.X.X.X/N", "X.X.X.X/N")))
                    .build();

            // Construct an instance of the InstancePolicyAllowedIPPolicyData model
            InstancePolicyAllowedIPPolicyData instancePolicyAllowedIpPolicyDataModel = new InstancePolicyAllowedIPPolicyData.Builder()
                    .enabled(true)
                    .attributes(instancePolicyAllowedIpPolicyDataAttributesModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem model
            SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem.Builder()
                    .policyType("allowedIP")
                    .policyData(instancePolicyAllowedIpPolicyDataModel)
                    .build();

            // Construct an instance of the SetInstancePoliciesOneOfSetInstancePolicyAllowedIP model
            SetInstancePoliciesOneOfSetInstancePolicyAllowedIP setInstancePoliciesOneOfModel = new SetInstancePoliciesOneOfSetInstancePolicyAllowedIP.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem>(Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedIpResourcesItemModel)))
                    .build();

            PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .setInstancePoliciesOneOf(setInstancePoliciesOneOfModel)
                    .build();

            // Invoke operation with valid options model
            testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
```

###### Set multiple policies for an instance

```
            // Construct an instance of the CollectionMetadata model
            CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                    .collectionType("application/vnd.ibm.kms.policy+json")
                    .collectionTotal(Long.valueOf("2"))
                    .build();

            //Construct a list of SetMultipleInstancePoliciesResourcesItem
            ArrayList<SetMultipleInstancePoliciesResourcesItem> setMultipleInstancePoliciesResourcesItemList = new ArrayList<SetMultipleInstancePoliciesResourcesItem>();
            
            // Construct an instance of the SetMultipleInstancePoliciesResourcesItemPolicyData model for dual authorization delete
            SetMultipleInstancePoliciesResourcesItemPolicyData setMultipleInstancePoliciesResourcesItemPolicyDataModel = new SetMultipleInstancePoliciesResourcesItemPolicyData.Builder()
                    .enabled(true)
                    .build();

            // Construct an instance of the SetMultipleInstancePoliciesResourcesItem model for dual authorization delete
            SetMultipleInstancePoliciesResourcesItem setMultipleInstancePoliciesResourcesItemModel = new SetMultipleInstancePoliciesResourcesItem.Builder()
                    .policyType("dualAuthDelete")
                    .policyData(setMultipleInstancePoliciesResourcesItemPolicyDataModel)
                    .build();

            // Add to the list
            setMultipleInstancePoliciesResourcesItemList.add(setMultipleInstancePoliciesResourcesItemModel);

            // Construct an instance of the SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes model for allowed network
            SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel = new SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes.Builder()
                    .allowedNetwork("public-and-private")
                    .build();

            // Construct an instance of the SetMultipleInstancePoliciesResourcesItemPolicyData model for allowed network
            SetMultipleInstancePoliciesResourcesItemPolicyData setMultipleInstancePoliciesResourcesItemPolicyDataModel2 = new SetMultipleInstancePoliciesResourcesItemPolicyData.Builder()
                    .enabled(true)
                    .attributes(setMultipleInstancePoliciesResourcesItemPolicyDataAttributesModel)
                    .build();

            // Construct an instance of the SetMultipleInstancePoliciesResourcesItem model for allowed network
            SetMultipleInstancePoliciesResourcesItem setMultipleInstancePoliciesResourcesItemModel2 = new SetMultipleInstancePoliciesResourcesItem.Builder()
                    .policyType("allowedNetwork")
                    .policyData(setMultipleInstancePoliciesResourcesItemPolicyDataModel2)
                    .build();

            // Add to the list
            setMultipleInstancePoliciesResourcesItemList.add(setMultipleInstancePoliciesResourcesItemModel2);

            // Construct an instance of the SetInstancePoliciesOneOfSetMultipleInstancePolicies model
            SetInstancePoliciesOneOfSetMultipleInstancePolicies setInstancePoliciesOneOfModel = new SetInstancePoliciesOneOfSetMultipleInstancePolicies.Builder()
                    .metadata(collectionMetadataModel)
                    .resources(new ArrayList<SetMultipleInstancePoliciesResourcesItem>(setMultipleInstancePoliciesResourcesItemList))
                    .build();

            // Construct an instance of the PutInstancePolicyOptions model
            PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .setInstancePoliciesOneOf(setInstancePoliciesOneOfModel)
                    .build();

            // Invoke operation with valid options model 
            Response<Void> response = testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
```
###### List policies for an instance
```
            // Construct an instance of the GetInstancePolicyOptions model
            GetInstancePolicyOptions getInstancePolicyOptionsModel = new GetInstancePolicyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
            //      .policy("allowedNetwork")       //uncomment to get only allowedNetwork policy
            //      .policy("dualAuthDelete")       //uncomment to get only dualAuthDeletee policy
            //      .policy("allowedIP")            //uncomment to get only allowedIP policy
                    .build();

            // Invoke operation with valid options model
            Response<GetInstancePoliciesOneOf> response = testService.getInstancePolicy(getInstancePolicyOptionsModel).execute();
            GetInstancePoliciesOneOf responseObj = response.getResult();
```

###### Retrieve Allowed IP Port
```
            // Construct an instance of the GetAllowedIPPortOptions model
            GetAllowedIPPortOptions getAllowedIpPortOptionsModel = new GetAllowedIPPortOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .build();

            // Invoke operation with valid options model
            Response<AllowedIPPort> response = testService.getAllowedIPPort(getAllowedIpPortOptionsModel).execute();
            AllowedIPPort responseObj = response.getResult();
```

### Set Maximum Retries attempts and Max Interval time
Key protect service has exponential back-off retry policy.
To configure retry policy  set maxRetry which is maximum number of retries allowed for failed HTTP requests and
retryMaxInterval which is maximum time interval between two subsequent retries

```
            IbmKeyProtectApi testService;
            int maxRetry = 5;
            long retryMaxInterval = 30L; // 30s
            IamAuthenticator authenticator = new IamAuthenticator(<IAM_API_KEY>);
            authenticator.setURL(<IAM_AUTH_URL>);
            authenticator.validate();
            testService = IbmKeyProtectApi.newInstance(authenticator, maxRetry, retryMaxInterval);
            testService.setServiceUrl(<KEY_PROTECT_URL>);
```

### Working with private network
When working with private network, just set the service url to the end point of private network, for example:
```
testService.setServiceUrl("https://private.us-south.kms.cloud.ibm.com/");
```
## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.ibm.com/CloudEngineering/keyprotect-java-sdk/issues).
Before that, please search for similar issues. It's possible that someone has already reported the problem.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud MySDK Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
