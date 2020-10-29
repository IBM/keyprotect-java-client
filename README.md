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

### creating key protect service

import key-protect-api.jar into your project structure to access com.ibm.cloud.ibm_key_protect_api package.
import sdk-core.jar to have IamAuthenticator . create  IamAuthenticator using IAM API key and IAM AUTH URL.
then configure key protect service with authenticator. then run operations on service.

```import com.ibm.cloud.ibm_key_protect_api.v2.IbmKeyProtectApi;
   import com.ibm.cloud.ibm_key_protect_api.v2.model.*;
   import com.ibm.cloud.sdk.core.http.Response;
   import com.ibm.cloud.sdk.core.security.*;

   import java.lang.*;
   import java.util.List;
   public class sampleGetKeys {
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

### creating a key
```
            InputStream inputstream = new FileInputStream(<PATH_TO_Create_Key_Body>)
            CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
                    .bluemixInstance(bluemixInstance)
                    .createKeyOneOf(inputstream)
                    .correlationId("testString")
                    .prefer("return=representation")
                    .build();

            // Invoke operation with valid options model (positive test)
            Response<Key> response = testService.createKey(createKeyOptionsModel).execute();
```

### list keys
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

               // Invoke operation with valid options model (positive test)
               Response<GetKeyMetadata> response = testService.getKeyMetadata(getKeyMetadataOptionsModel).execute();
               GetKeyMetadata responseObj = response.getResult();
```

### wrapping unwrapping a key
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
### Creating/Retrieving an Import token
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
