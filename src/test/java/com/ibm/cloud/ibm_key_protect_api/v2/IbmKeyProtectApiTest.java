/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.ibm_key_protect_api.v2.IbmKeyProtectApi;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AddKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AllowedIPPort;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AllowedIPPortResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CloudResourceName;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadataListKeys;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadataOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadataOneOfCollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadataWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKMIPAdapterRequestBodyResources;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKMIPClientCertificateObject;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyAliasOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyWithPoliciesOverridesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeactivateRegistration;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyAliasOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKmipObjectOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DisableKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DualAuthDeleteProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DualAuthKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.EnableKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.EventAcknowledgeOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetAllowedIPPortOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyAllowedIP;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyAllowedNetwork;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyAllowedNetworkResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyAllowedNetworkResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyAllowedNetworkResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyKeyCreateImportAccess;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyKeyCreateImportAccessResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyKeyCreateImportAccessResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyKeyCreateImportAccessResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyMetrics;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetInstancePolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfGetMultipleInstancePolicies;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOfResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyAllowedIPResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyAllowedIPResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyAllowedIPResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyDualAuthDeleteResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyMetricsResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyRotationResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyRotationResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyRotationResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyCollectionMetadataOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyMetadataOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOfGetKeyPolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOfGetKeyPolicyDualAuthDeleteResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOfGetKeyPolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOfGetMultipleKeyPolicies;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOfResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPolicyRotationResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyVersionsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipAdaptersOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipClientCertificatesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipObjectOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipObjectsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetMultipleKeyPoliciesResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetMultipleKeyPoliciesResourceDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsAllKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedIPPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyAllowedNetworkPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyKeyCreateImportAccessPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyKeyCreateImportAccessPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyPropertiesAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyRotationPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.InstancePolicyRotationPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPAdapter;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPClientCertificate;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPClientPartialCertificate;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPObject;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPProfileDataBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KMIPProfileDataBodyKMIPProfileDataNative;
import com.ibm.cloud.ibm_key_protect_api.v2.model.Key;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponse;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponseRewrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponseUnwrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponseWrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyAlias;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyAliasResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyFullRepresentation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyFullRepresentationAlgorithmMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyDualAuthDeleteDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotationNonRequiredRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyPolicyRotationRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyRing;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyVersion;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayload;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayloadAlgorithmMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListCollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListCollectionMetadataCollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListCollectionMetadataCollectionMetadataWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPAdapters;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPAdaptersWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPClientCertificates;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPObjectsWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPPartialClientCertificatesWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRingsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRingsWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyVersions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeys;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeysMetadataPropertiesSearchQuery;
import com.ibm.cloud.ibm_key_protect_api.v2.model.MetricsProperties;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ModifiableRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PatchKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PatchKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PostImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PurgeKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PurgeKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutInstancePolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.Registration;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationActionOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationActionOneOfDeactivateRegistration;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ReplaceRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ReplaceRegistrationResourceBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RestoreKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RewrapKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RewrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RewrappedKeyVersionRewrappedKeyVersion;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RotateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RotationKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedIP;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedIPResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedNetwork;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccess;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyKeyCreateImportAccessResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyMetrics;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyMetricsResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetInstancePolicyRotationResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePoliciesOneOfSetMultipleInstancePolicies;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetInstancePolicyDualAuthDeleteResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyForDeletionOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyPoliciesOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyPoliciesOneOfSetKeyPolicyDualAuthDelete;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyPoliciesOneOfSetKeyPolicyRotation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyPoliciesOneOfSetMultipleKeyPolicies;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItem;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItemPolicyData;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleInstancePoliciesResourcesItemPolicyDataAttributes;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetMultipleKeyPoliciesResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SyncAssociatedResourcesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UnsetKeyForDeletionOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UnwrapKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UnwrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UpdateRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.WrapKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.WrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.WrappedKeyVersionKeyVersion;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the IbmKeyProtectApi service.
 */
public class IbmKeyProtectApiTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IbmKeyProtectApi ibmKeyProtectApiService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new IbmKeyProtectApi(serviceName, null);
  }

  // Construct the service URL using the default server variable values
  @Test
  public void testConstructServiceURLwithDefaultValues() throws Throwable {
    String defaultFormattedUrl = "https://us-south.kms.cloud.ibm.com";
    String constructedUrl = IbmKeyProtectApi.constructServiceUrl(null);
    assertEquals(constructedUrl, defaultFormattedUrl);
  }

  // Construct the service URL with an invalid server variable name (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructServiceURLWithInvalidVariable() throws Throwable {
    Map<String, String> variables = new HashMap<>();
    variables.put("invalid_variable_name", "value");

    IbmKeyProtectApi.constructServiceUrl(variables);
  }

  // Test the getKeyCollectionMetadata operation with a valid options model parameter
  @Test
  public void testGetKeyCollectionMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String getKeyCollectionMetadataPath = "/api/v2/keys";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKeyCollectionMetadataOptions model
    GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptionsModel = new GetKeyCollectionMetadataOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .state(java.util.Arrays.asList(Long.valueOf("0"), Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3")))
      .extractable(true)
      .filter("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke getKeyCollectionMetadata() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.getKeyCollectionMetadata(getKeyCollectionMetadataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyCollectionMetadataPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("state"), RequestUtils.join(java.util.Arrays.asList(Long.valueOf("0"), Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3")), ","));
    assertEquals(Boolean.valueOf(query.get("extractable")), Boolean.valueOf(true));
    assertEquals(query.get("filter"), "testString");
  }

  // Test the getKeyCollectionMetadata operation with and without retries enabled
  @Test
  public void testGetKeyCollectionMetadataWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKeyCollectionMetadataWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKeyCollectionMetadataWOptions();
  }

  // Test the getKeyCollectionMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyCollectionMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKeyCollectionMetadata(null).execute();
  }

  // Test the createKey operation with a valid options model parameter
  @Test
  public void testCreateKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\"}]}";
    String createKeyPath = "/api/v2/keys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateKeyOptions model
    CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
      .bluemixInstance("testString")
      .keyCreateBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .prefer("return=representation")
      .xKmsKeyRing("default")
      .build();

    // Invoke createKey() with a valid options model and verify the result
    Response<Key> response = ibmKeyProtectApiService.createKey(createKeyOptionsModel).execute();
    assertNotNull(response);
    Key responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createKey operation with and without retries enabled
  @Test
  public void testCreateKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testCreateKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testCreateKeyWOptions();
  }

  // Test the createKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.createKey(null).execute();
  }

  // Test the getKeys operation with a valid options model parameter
  @Test
  public void testGetKeysWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"incompleteSearch\": true, \"searchQuery\": {\"query\": \"query\", \"scopes\": [\"name\"], \"not\": false, \"exact\": false}}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\"}]}";
    String getKeysPath = "/api/v2/keys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKeysOptions model
    GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .limit(Long.valueOf("200"))
      .offset(Long.valueOf("0"))
      .state(java.util.Arrays.asList(Long.valueOf("0"), Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3")))
      .extractable(true)
      .search("testString")
      .sort("id")
      .filter("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke getKeys() with a valid options model and verify the result
    Response<ListKeys> response = ibmKeyProtectApiService.getKeys(getKeysOptionsModel).execute();
    assertNotNull(response);
    ListKeys responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeysPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("200"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("state"), RequestUtils.join(java.util.Arrays.asList(Long.valueOf("0"), Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3")), ","));
    assertEquals(Boolean.valueOf(query.get("extractable")), Boolean.valueOf(true));
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("sort"), "id");
    assertEquals(query.get("filter"), "testString");
  }

  // Test the getKeys operation with and without retries enabled
  @Test
  public void testGetKeysWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKeysWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKeysWOptions();
  }

  // Test the getKeys operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeysNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKeys(null).execute();
  }

  // Test the createKeyWithPoliciesOverrides operation with a valid options model parameter
  @Test
  public void testCreateKeyWithPoliciesOverridesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\"}]}";
    String createKeyWithPoliciesOverridesPath = "/api/v2/keys_with_policy_overrides";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateKeyWithPoliciesOverridesOptions model
    CreateKeyWithPoliciesOverridesOptions createKeyWithPoliciesOverridesOptionsModel = new CreateKeyWithPoliciesOverridesOptions.Builder()
      .bluemixInstance("testString")
      .keyWithPolicyOverridesCreateBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .prefer("return=representation")
      .xKmsKeyRing("default")
      .build();

    // Invoke createKeyWithPoliciesOverrides() with a valid options model and verify the result
    Response<Key> response = ibmKeyProtectApiService.createKeyWithPoliciesOverrides(createKeyWithPoliciesOverridesOptionsModel).execute();
    assertNotNull(response);
    Key responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyWithPoliciesOverridesPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createKeyWithPoliciesOverrides operation with and without retries enabled
  @Test
  public void testCreateKeyWithPoliciesOverridesWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testCreateKeyWithPoliciesOverridesWOptions();

    ibmKeyProtectApiService.disableRetries();
    testCreateKeyWithPoliciesOverridesWOptions();
  }

  // Test the createKeyWithPoliciesOverrides operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyWithPoliciesOverridesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.createKeyWithPoliciesOverrides(null).execute();
  }

  // Test the getKey operation with a valid options model parameter
  @Test
  public void testGetKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\"}]}";
    String getKeyPath = "/api/v2/keys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKeyOptions model
    GetKeyOptions getKeyOptionsModel = new GetKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke getKey() with a valid options model and verify the result
    Response<GetKey> response = ibmKeyProtectApiService.getKey(getKeyOptionsModel).execute();
    assertNotNull(response);
    GetKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getKey operation with and without retries enabled
  @Test
  public void testGetKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKeyWOptions();
  }

  // Test the getKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKey(null).execute();
  }

  // Test the actionOnKey operation with a valid options model parameter
  @Test
  public void testActionOnKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\"}}";
    String actionOnKeyPath = "/api/v2/keys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ActionOnKeyOptions model
    ActionOnKeyOptions actionOnKeyOptionsModel = new ActionOnKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .action("disable")
      .keyActionBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();

    // Invoke actionOnKey() with a valid options model and verify the result
    Response<KeyActionOneOfResponse> response = ibmKeyProtectApiService.actionOnKey(actionOnKeyOptionsModel).execute();
    assertNotNull(response);
    KeyActionOneOfResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, actionOnKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("action"), "disable");
  }

  // Test the actionOnKey operation with and without retries enabled
  @Test
  public void testActionOnKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testActionOnKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testActionOnKeyWOptions();
  }

  // Test the actionOnKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testActionOnKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.actionOnKey(null).execute();
  }

  // Test the patchKey operation with a valid options model parameter
  @Test
  public void testPatchKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\"}]}";
    String patchKeyPath = "/api/v2/keys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PatchKeyOptions model
    PatchKeyOptions patchKeyOptionsModel = new PatchKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyPatchBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke patchKey() with a valid options model and verify the result
    Response<PatchKeyResponseBody> response = ibmKeyProtectApiService.patchKey(patchKeyOptionsModel).execute();
    assertNotNull(response);
    PatchKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, patchKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the patchKey operation with and without retries enabled
  @Test
  public void testPatchKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testPatchKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testPatchKeyWOptions();
  }

  // Test the patchKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPatchKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.patchKey(null).execute();
  }

  // Test the deleteKey operation with a valid options model parameter
  @Test
  public void testDeleteKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\"}]}";
    String deleteKeyPath = "/api/v2/keys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteKeyOptions model
    DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .force(false)
      .build();

    // Invoke deleteKey() with a valid options model and verify the result
    Response<DeleteKey> response = ibmKeyProtectApiService.deleteKey(deleteKeyOptionsModel).execute();
    assertNotNull(response);
    DeleteKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(false));
  }

  // Test the deleteKey operation with and without retries enabled
  @Test
  public void testDeleteKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteKeyWOptions();
  }

  // Test the deleteKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteKey(null).execute();
  }

  // Test the getKeyMetadata operation with a valid options model parameter
  @Test
  public void testGetKeyMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\"}]}";
    String getKeyMetadataPath = "/api/v2/keys/testString/metadata";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKeyMetadataOptions model
    GetKeyMetadataOptions getKeyMetadataOptionsModel = new GetKeyMetadataOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke getKeyMetadata() with a valid options model and verify the result
    Response<GetKeyMetadata> response = ibmKeyProtectApiService.getKeyMetadata(getKeyMetadataOptionsModel).execute();
    assertNotNull(response);
    GetKeyMetadata responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyMetadataPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getKeyMetadata operation with and without retries enabled
  @Test
  public void testGetKeyMetadataWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKeyMetadataWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKeyMetadataWOptions();
  }

  // Test the getKeyMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKeyMetadata(null).execute();
  }

  // Test the purgeKey operation with a valid options model parameter
  @Test
  public void testPurgeKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"application/vnd.ibm.kms.key+json\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"extractable\": true, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": false, \"keyRingID\": \"keyRingId\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"256\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 256, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"lastRotateDate\": \"2000-03-21T00:00:00.000Z\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2000-03-21T00:00:00.000Z\"}, \"rotation\": {\"enabled\": true, \"interval_month\": 3}, \"deleted\": false, \"deletionDate\": \"2000-03-21T00:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2000-03-21T00:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2000-03-21T00:00:00.000Z\", \"purgeScheduledOn\": \"2000-03-21T00:00:00.000Z\"}]}";
    String purgeKeyPath = "/api/v2/keys/testString/purge";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PurgeKeyOptions model
    PurgeKeyOptions purgeKeyOptionsModel = new PurgeKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();

    // Invoke purgeKey() with a valid options model and verify the result
    Response<PurgeKey> response = ibmKeyProtectApiService.purgeKey(purgeKeyOptionsModel).execute();
    assertNotNull(response);
    PurgeKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, purgeKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the purgeKey operation with and without retries enabled
  @Test
  public void testPurgeKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testPurgeKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testPurgeKeyWOptions();
  }

  // Test the purgeKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPurgeKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.purgeKey(null).execute();
  }

  // Test the restoreKey operation with a valid options model parameter
  @Test
  public void testRestoreKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String restoreKeyPath = "/api/v2/keys/testString/restore";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/vnd.ibm.kms.key+json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the RestoreKeyOptions model
    RestoreKeyOptions restoreKeyOptionsModel = new RestoreKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyRestoreBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();

    // Invoke restoreKey() with a valid options model and verify the result
    Response<InputStream> response = ibmKeyProtectApiService.restoreKey(restoreKeyOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);
    responseObj.close();

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, restoreKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the restoreKey operation with and without retries enabled
  @Test
  public void testRestoreKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testRestoreKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testRestoreKeyWOptions();
  }

  // Test the restoreKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRestoreKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.restoreKey(null).execute();
  }

  // Test the getKeyVersions operation with a valid options model parameter
  @Test
  public void testGetKeyVersionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}]}";
    String getKeyVersionsPath = "/api/v2/keys/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKeyVersionsOptions model
    GetKeyVersionsOptions getKeyVersionsOptionsModel = new GetKeyVersionsOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .limit(Long.valueOf("200"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .allKeyStates(false)
      .build();

    // Invoke getKeyVersions() with a valid options model and verify the result
    Response<ListKeyVersions> response = ibmKeyProtectApiService.getKeyVersions(getKeyVersionsOptionsModel).execute();
    assertNotNull(response);
    ListKeyVersions responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyVersionsPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("200"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("allKeyStates")), Boolean.valueOf(false));
  }

  // Test the getKeyVersions operation with and without retries enabled
  @Test
  public void testGetKeyVersionsWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKeyVersionsWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKeyVersionsWOptions();
  }

  // Test the getKeyVersions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyVersionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKeyVersions(null).execute();
  }

  // Test the wrapKey operation with a valid options model parameter
  @Test
  public void testWrapKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\"}}";
    String wrapKeyPath = "/api/v2/keys/testString/actions/wrap";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the WrapKeyOptions model
    WrapKeyOptions wrapKeyOptionsModel = new WrapKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyActionWrapBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke wrapKey() with a valid options model and verify the result
    Response<WrapKeyResponseBody> response = ibmKeyProtectApiService.wrapKey(wrapKeyOptionsModel).execute();
    assertNotNull(response);
    WrapKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, wrapKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the wrapKey operation with and without retries enabled
  @Test
  public void testWrapKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testWrapKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testWrapKeyWOptions();
  }

  // Test the wrapKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testWrapKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.wrapKey(null).execute();
  }

  // Test the unwrapKey operation with a valid options model parameter
  @Test
  public void testUnwrapKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\"}, \"rewrappedKeyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\"}}";
    String unwrapKeyPath = "/api/v2/keys/testString/actions/unwrap";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UnwrapKeyOptions model
    UnwrapKeyOptions unwrapKeyOptionsModel = new UnwrapKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyActionUnwrapBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke unwrapKey() with a valid options model and verify the result
    Response<UnwrapKeyResponseBody> response = ibmKeyProtectApiService.unwrapKey(unwrapKeyOptionsModel).execute();
    assertNotNull(response);
    UnwrapKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unwrapKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unwrapKey operation with and without retries enabled
  @Test
  public void testUnwrapKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testUnwrapKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testUnwrapKeyWOptions();
  }

  // Test the unwrapKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnwrapKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.unwrapKey(null).execute();
  }

  // Test the rewrapKey operation with a valid options model parameter
  @Test
  public void testRewrapKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\"}, \"rewrappedKeyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\"}}";
    String rewrapKeyPath = "/api/v2/keys/testString/actions/rewrap";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the RewrapKeyOptions model
    RewrapKeyOptions rewrapKeyOptionsModel = new RewrapKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyActionRewrapBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke rewrapKey() with a valid options model and verify the result
    Response<RewrapKeyResponseBody> response = ibmKeyProtectApiService.rewrapKey(rewrapKeyOptionsModel).execute();
    assertNotNull(response);
    RewrapKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, rewrapKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the rewrapKey operation with and without retries enabled
  @Test
  public void testRewrapKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testRewrapKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testRewrapKeyWOptions();
  }

  // Test the rewrapKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRewrapKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.rewrapKey(null).execute();
  }

  // Test the rotateKey operation with a valid options model parameter
  @Test
  public void testRotateKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String rotateKeyPath = "/api/v2/keys/testString/actions/rotate";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the RotateKeyOptions model
    RotateKeyOptions rotateKeyOptionsModel = new RotateKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyActionRotateBody(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();

    // Invoke rotateKey() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.rotateKey(rotateKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, rotateKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the rotateKey operation with and without retries enabled
  @Test
  public void testRotateKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testRotateKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testRotateKeyWOptions();
  }

  // Test the rotateKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRotateKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.rotateKey(null).execute();
  }

  // Test the setKeyForDeletion operation with a valid options model parameter
  @Test
  public void testSetKeyForDeletionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String setKeyForDeletionPath = "/api/v2/keys/testString/actions/setKeyForDeletion";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the SetKeyForDeletionOptions model
    SetKeyForDeletionOptions setKeyForDeletionOptionsModel = new SetKeyForDeletionOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke setKeyForDeletion() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.setKeyForDeletion(setKeyForDeletionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, setKeyForDeletionPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the setKeyForDeletion operation with and without retries enabled
  @Test
  public void testSetKeyForDeletionWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testSetKeyForDeletionWOptions();

    ibmKeyProtectApiService.disableRetries();
    testSetKeyForDeletionWOptions();
  }

  // Test the setKeyForDeletion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKeyForDeletionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.setKeyForDeletion(null).execute();
  }

  // Test the unsetKeyForDeletion operation with a valid options model parameter
  @Test
  public void testUnsetKeyForDeletionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String unsetKeyForDeletionPath = "/api/v2/keys/testString/actions/unsetKeyForDeletion";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UnsetKeyForDeletionOptions model
    UnsetKeyForDeletionOptions unsetKeyForDeletionOptionsModel = new UnsetKeyForDeletionOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke unsetKeyForDeletion() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.unsetKeyForDeletion(unsetKeyForDeletionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unsetKeyForDeletionPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unsetKeyForDeletion operation with and without retries enabled
  @Test
  public void testUnsetKeyForDeletionWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testUnsetKeyForDeletionWOptions();

    ibmKeyProtectApiService.disableRetries();
    testUnsetKeyForDeletionWOptions();
  }

  // Test the unsetKeyForDeletion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnsetKeyForDeletionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.unsetKeyForDeletion(null).execute();
  }

  // Test the enableKey operation with a valid options model parameter
  @Test
  public void testEnableKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String enableKeyPath = "/api/v2/keys/testString/actions/enable";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the EnableKeyOptions model
    EnableKeyOptions enableKeyOptionsModel = new EnableKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke enableKey() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.enableKey(enableKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, enableKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the enableKey operation with and without retries enabled
  @Test
  public void testEnableKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testEnableKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testEnableKeyWOptions();
  }

  // Test the enableKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnableKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.enableKey(null).execute();
  }

  // Test the disableKey operation with a valid options model parameter
  @Test
  public void testDisableKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String disableKeyPath = "/api/v2/keys/testString/actions/disable";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DisableKeyOptions model
    DisableKeyOptions disableKeyOptionsModel = new DisableKeyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke disableKey() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.disableKey(disableKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, disableKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the disableKey operation with and without retries enabled
  @Test
  public void testDisableKeyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDisableKeyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDisableKeyWOptions();
  }

  // Test the disableKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDisableKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.disableKey(null).execute();
  }

  // Test the syncAssociatedResources operation with a valid options model parameter
  @Test
  public void testSyncAssociatedResourcesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String syncAssociatedResourcesPath = "/api/v2/keys/testString/actions/sync";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the SyncAssociatedResourcesOptions model
    SyncAssociatedResourcesOptions syncAssociatedResourcesOptionsModel = new SyncAssociatedResourcesOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke syncAssociatedResources() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.syncAssociatedResources(syncAssociatedResourcesOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, syncAssociatedResourcesPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the syncAssociatedResources operation with and without retries enabled
  @Test
  public void testSyncAssociatedResourcesWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testSyncAssociatedResourcesWOptions();

    ibmKeyProtectApiService.disableRetries();
    testSyncAssociatedResourcesWOptions();
  }

  // Test the syncAssociatedResources operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSyncAssociatedResourcesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.syncAssociatedResources(null).execute();
  }

  // Test the putPolicy operation with a valid options model parameter
  @Test
  public void testPutPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:policy:<policy-id>\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"updatedBy\", \"type\": \"application/vnd.ibm.kms.policy+json\", \"dualAuthDelete\": {\"enabled\": true}}]}";
    String putPolicyPath = "/api/v2/keys/testString/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
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
      .resources(java.util.Arrays.asList(keyPolicyDualAuthDeleteModel))
      .build();

    // Construct an instance of the PutPolicyOptions model
    PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .keyPolicyPutBody(setKeyPoliciesOneOfModel)
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .policy("dualAuthDelete")
      .build();

    // Invoke putPolicy() with a valid options model and verify the result
    Response<GetKeyPoliciesOneOf> response = ibmKeyProtectApiService.putPolicy(putPolicyOptionsModel).execute();
    assertNotNull(response);
    GetKeyPoliciesOneOf responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putPolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("policy"), "dualAuthDelete");
  }

  // Test the putPolicy operation with and without retries enabled
  @Test
  public void testPutPolicyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testPutPolicyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testPutPolicyWOptions();
  }

  // Test the putPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.putPolicy(null).execute();
  }

  // Test the getPolicy operation with a valid options model parameter
  @Test
  public void testGetPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:policy:<policy-id>\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"lastUpdateDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"updatedBy\", \"type\": \"application/vnd.ibm.kms.policy+json\", \"dualAuthDelete\": {\"enabled\": true}}]}";
    String getPolicyPath = "/api/v2/keys/testString/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPolicyOptions model
    GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .policy("dualAuthDelete")
      .build();

    // Invoke getPolicy() with a valid options model and verify the result
    Response<GetKeyPoliciesOneOf> response = ibmKeyProtectApiService.getPolicy(getPolicyOptionsModel).execute();
    assertNotNull(response);
    GetKeyPoliciesOneOf responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("policy"), "dualAuthDelete");
  }

  // Test the getPolicy operation with and without retries enabled
  @Test
  public void testGetPolicyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetPolicyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetPolicyWOptions();
  }

  // Test the getPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getPolicy(null).execute();
  }

  // Test the putInstancePolicy operation with a valid options model parameter
  @Test
  public void testPutInstancePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String putInstancePolicyPath = "/api/v2/instance/policies";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the InstancePolicyAllowedNetworkPolicyDataAttributes model
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
      .resources(java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel))
      .build();

    // Construct an instance of the PutInstancePolicyOptions model
    PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
      .bluemixInstance("testString")
      .instancePolicyPutBody(setInstancePoliciesOneOfModel)
      .correlationId("testString")
      .policy("allowedNetwork")
      .build();

    // Invoke putInstancePolicy() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putInstancePolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("policy"), "allowedNetwork");
  }

  // Test the putInstancePolicy operation with and without retries enabled
  @Test
  public void testPutInstancePolicyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testPutInstancePolicyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testPutInstancePolicyWOptions();
  }

  // Test the putInstancePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutInstancePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.putInstancePolicy(null).execute();
  }

  // Test the getInstancePolicy operation with a valid options model parameter
  @Test
  public void testGetInstancePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\", \"updatedBy\": \"updatedBy\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"policy_type\": \"policyType\", \"policy_data\": {\"enabled\": true, \"attributes\": {\"allowed_network\": \"public-and-private\"}}}]}";
    String getInstancePolicyPath = "/api/v2/instance/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetInstancePolicyOptions model
    GetInstancePolicyOptions getInstancePolicyOptionsModel = new GetInstancePolicyOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .policy("allowedNetwork")
      .build();

    // Invoke getInstancePolicy() with a valid options model and verify the result
    Response<GetInstancePoliciesOneOf> response = ibmKeyProtectApiService.getInstancePolicy(getInstancePolicyOptionsModel).execute();
    assertNotNull(response);
    GetInstancePoliciesOneOf responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getInstancePolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("policy"), "allowedNetwork");
  }

  // Test the getInstancePolicy operation with and without retries enabled
  @Test
  public void testGetInstancePolicyWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetInstancePolicyWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetInstancePolicyWOptions();
  }

  // Test the getInstancePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstancePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getInstancePolicy(null).execute();
  }

  // Test the getAllowedIPPort operation with a valid options model parameter
  @Test
  public void testGetAllowedIpPortWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"private_endpoint_port\": 8888}]}";
    String getAllowedIpPortPath = "/api/v2/instance/allowed_ip_port";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAllowedIPPortOptions model
    GetAllowedIPPortOptions getAllowedIpPortOptionsModel = new GetAllowedIPPortOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .build();

    // Invoke getAllowedIPPort() with a valid options model and verify the result
    Response<AllowedIPPort> response = ibmKeyProtectApiService.getAllowedIPPort(getAllowedIpPortOptionsModel).execute();
    assertNotNull(response);
    AllowedIPPort responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAllowedIpPortPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAllowedIPPort operation with and without retries enabled
  @Test
  public void testGetAllowedIpPortWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetAllowedIpPortWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetAllowedIpPortWOptions();
  }

  // Test the getAllowedIPPort operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAllowedIpPortNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getAllowedIPPort(null).execute();
  }

  // Test the postImportToken operation with a valid options model parameter
  @Test
  public void testPostImportTokenWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"expiration\": 600, \"maxAllowedRetrievals\": 1, \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"remainingRetrievals\": 1}";
    String postImportTokenPath = "/api/v2/import_token";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PostImportTokenOptions model
    PostImportTokenOptions postImportTokenOptionsModel = new PostImportTokenOptions.Builder()
      .bluemixInstance("testString")
      .expiration(Double.valueOf("600"))
      .maxAllowedRetrievals(Double.valueOf("1"))
      .correlationId("testString")
      .xKmsKeyRing("default")
      .build();

    // Invoke postImportToken() with a valid options model and verify the result
    Response<ImportToken> response = ibmKeyProtectApiService.postImportToken(postImportTokenOptionsModel).execute();
    assertNotNull(response);
    ImportToken responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postImportTokenPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postImportToken operation with and without retries enabled
  @Test
  public void testPostImportTokenWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testPostImportTokenWOptions();

    ibmKeyProtectApiService.disableRetries();
    testPostImportTokenWOptions();
  }

  // Test the postImportToken operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostImportTokenNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.postImportToken(null).execute();
  }

  // Test the getImportToken operation with a valid options model parameter
  @Test
  public void testGetImportTokenWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"expiration\": 600, \"maxAllowedRetrievals\": 1, \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"expirationDate\": \"2000-03-21T00:00:00.000Z\", \"remainingRetrievals\": 1, \"payload\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\", \"nonce\": \"VGhpcyBpcyBhIG1vY2sgYnl0ZSBhcnJheSB2YWx1ZS4=\"}";
    String getImportTokenPath = "/api/v2/import_token";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetImportTokenOptions model
    GetImportTokenOptions getImportTokenOptionsModel = new GetImportTokenOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("default")
      .build();

    // Invoke getImportToken() with a valid options model and verify the result
    Response<GetImportToken> response = ibmKeyProtectApiService.getImportToken(getImportTokenOptionsModel).execute();
    assertNotNull(response);
    GetImportToken responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getImportTokenPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getImportToken operation with and without retries enabled
  @Test
  public void testGetImportTokenWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetImportTokenWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetImportTokenWOptions();
  }

  // Test the getImportToken operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetImportTokenNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getImportToken(null).execute();
  }

  // Test the createRegistration operation with a valid options model parameter
  @Test
  public void testCreateRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"IBMid-0000000000\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": false, \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}}]}";
    String createRegistrationPath = "/api/v2/keys/testString/registrations/crn%253av1%253abluemix%253apublic%253acloud-object-storage%253aglobal%253aa%252f00000000000000000000000000000000%253afeddecaf-0000-0000-0000-1234567890ab%253a%253abucket";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.registration_input+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the CreateRegistrationResourceBody model
    CreateRegistrationResourceBody createRegistrationResourceBodyModel = new CreateRegistrationResourceBody.Builder()
      .preventKeyDeletion(false)
      .description("A resource registration on a Key Protect key")
      .registrationMetadata("testString")
      .build();

    // Construct an instance of the CreateRegistrationOptions model
    CreateRegistrationOptions createRegistrationOptionsModel = new CreateRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(createRegistrationResourceBodyModel))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke createRegistration() with a valid options model and verify the result
    Response<Registration> response = ibmKeyProtectApiService.createRegistration(createRegistrationOptionsModel).execute();
    assertNotNull(response);
    Registration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createRegistrationPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createRegistration operation with and without retries enabled
  @Test
  public void testCreateRegistrationWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testCreateRegistrationWOptions();

    ibmKeyProtectApiService.disableRetries();
    testCreateRegistrationWOptions();
  }

  // Test the createRegistration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRegistrationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.createRegistration(null).execute();
  }

  // Test the updateRegistration operation with a valid options model parameter
  @Test
  public void testUpdateRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"IBMid-0000000000\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": false, \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}}]}";
    String updateRegistrationPath = "/api/v2/keys/testString/registrations/crn%253av1%253abluemix%253apublic%253acloud-object-storage%253aglobal%253aa%252f00000000000000000000000000000000%253afeddecaf-0000-0000-0000-1234567890ab%253a%253abucket";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.registration_input+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the ModifiableRegistrationResourceBody model
    ModifiableRegistrationResourceBody modifiableRegistrationResourceBodyModel = new ModifiableRegistrationResourceBody.Builder()
      .preventKeyDeletion(false)
      .description("A resource registration on a Key Protect key")
      .registrationMetadata("testString")
      .keyVersionId("testString")
      .build();

    // Construct an instance of the UpdateRegistrationOptions model
    UpdateRegistrationOptions updateRegistrationOptionsModel = new UpdateRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(modifiableRegistrationResourceBodyModel))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke updateRegistration() with a valid options model and verify the result
    Response<Registration> response = ibmKeyProtectApiService.updateRegistration(updateRegistrationOptionsModel).execute();
    assertNotNull(response);
    Registration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateRegistrationPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateRegistration operation with and without retries enabled
  @Test
  public void testUpdateRegistrationWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testUpdateRegistrationWOptions();

    ibmKeyProtectApiService.disableRetries();
    testUpdateRegistrationWOptions();
  }

  // Test the updateRegistration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateRegistrationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.updateRegistration(null).execute();
  }

  // Test the replaceRegistration operation with a valid options model parameter
  @Test
  public void testReplaceRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"IBMid-0000000000\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": false, \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}}]}";
    String replaceRegistrationPath = "/api/v2/keys/testString/registrations/crn%253av1%253abluemix%253apublic%253acloud-object-storage%253aglobal%253aa%252f00000000000000000000000000000000%253afeddecaf-0000-0000-0000-1234567890ab%253a%253abucket";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.registration_input+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the ReplaceRegistrationResourceBody model
    ReplaceRegistrationResourceBody replaceRegistrationResourceBodyModel = new ReplaceRegistrationResourceBody.Builder()
      .preventKeyDeletion(false)
      .description("A resource registration on a Key Protect key")
      .registrationMetadata("Registration metadata")
      .keyVersionId("fadedbee-0000-0000-0000-1234567890ab")
      .build();

    // Construct an instance of the ReplaceRegistrationOptions model
    ReplaceRegistrationOptions replaceRegistrationOptionsModel = new ReplaceRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(replaceRegistrationResourceBodyModel))
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke replaceRegistration() with a valid options model and verify the result
    Response<Registration> response = ibmKeyProtectApiService.replaceRegistration(replaceRegistrationOptionsModel).execute();
    assertNotNull(response);
    Registration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceRegistrationPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceRegistration operation with and without retries enabled
  @Test
  public void testReplaceRegistrationWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testReplaceRegistrationWOptions();

    ibmKeyProtectApiService.disableRetries();
    testReplaceRegistrationWOptions();
  }

  // Test the replaceRegistration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRegistrationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.replaceRegistration(null).execute();
  }

  // Test the deleteRegistration operation with a valid options model parameter
  @Test
  public void testDeleteRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"IBMid-0000000000\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": false, \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}}]}";
    String deleteRegistrationPath = "/api/v2/keys/testString/registrations/crn%253av1%253abluemix%253apublic%253acloud-object-storage%253aglobal%253aa%252f00000000000000000000000000000000%253afeddecaf-0000-0000-0000-1234567890ab%253a%253abucket";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteRegistrationOptions model
    DeleteRegistrationOptions deleteRegistrationOptionsModel = new DeleteRegistrationOptions.Builder()
      .id("testString")
      .urlEncodedResourceCrn("crn%3av1%3abluemix%3apublic%3acloud-object-storage%3aglobal%3aa%2f00000000000000000000000000000000%3afeddecaf-0000-0000-0000-1234567890ab%3a%3abucket")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();

    // Invoke deleteRegistration() with a valid options model and verify the result
    Response<Registration> response = ibmKeyProtectApiService.deleteRegistration(deleteRegistrationOptionsModel).execute();
    assertNotNull(response);
    Registration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteRegistrationPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteRegistration operation with and without retries enabled
  @Test
  public void testDeleteRegistrationWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteRegistrationWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteRegistrationWOptions();
  }

  // Test the deleteRegistration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRegistrationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteRegistration(null).execute();
  }

  // Test the actionOnRegistration operation with a valid options model parameter
  @Test
  public void testActionOnRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"resourceCrn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/<account-id>:<service-instance>:bucket:<bucket-name>\"}]}";
    String actionOnRegistrationPath = "/api/v2/keys/testString/registrations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.allowed_ip_metadata+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the CloudResourceName model
    CloudResourceName cloudResourceNameModel = new CloudResourceName.Builder()
      .resourceCrn("crn:v1:bluemix:public:cloud-object-storage:global:a/<account-id>:<service-instance>:bucket:<bucket-name>")
      .build();

    // Construct an instance of the RegistrationActionOneOfDeactivateRegistration model
    RegistrationActionOneOfDeactivateRegistration registrationActionOneOfModel = new RegistrationActionOneOfDeactivateRegistration.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(cloudResourceNameModel))
      .build();

    // Construct an instance of the ActionOnRegistrationOptions model
    ActionOnRegistrationOptions actionOnRegistrationOptionsModel = new ActionOnRegistrationOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .action("deactivate")
      .registrationDeactivateBody(registrationActionOneOfModel)
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .prefer("return=representation")
      .build();

    // Invoke actionOnRegistration() with a valid options model and verify the result
    Response<DeactivateRegistration> response = ibmKeyProtectApiService.actionOnRegistration(actionOnRegistrationOptionsModel).execute();
    assertNotNull(response);
    DeactivateRegistration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, actionOnRegistrationPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("action"), "deactivate");
  }

  // Test the actionOnRegistration operation with and without retries enabled
  @Test
  public void testActionOnRegistrationWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testActionOnRegistrationWOptions();

    ibmKeyProtectApiService.disableRetries();
    testActionOnRegistrationWOptions();
  }

  // Test the actionOnRegistration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testActionOnRegistrationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.actionOnRegistration(null).execute();
  }

  // Test the getRegistrations operation with a valid options model parameter
  @Test
  public void testGetRegistrationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"IBMid-0000000000\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": false, \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}}]}";
    String getRegistrationsPath = "/api/v2/keys/testString/registrations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetRegistrationsOptions model
    GetRegistrationsOptions getRegistrationsOptionsModel = new GetRegistrationsOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .limit(Long.valueOf("200"))
      .offset(Long.valueOf("0"))
      .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F00000000000000000000000000000000%3Afeddecaf-0000-0000-0000-1234567890ab%3A*%3A*")
      .preventKeyDeletion(true)
      .totalCount(true)
      .build();

    // Invoke getRegistrations() with a valid options model and verify the result
    Response<RegistrationWithTotalCount> response = ibmKeyProtectApiService.getRegistrations(getRegistrationsOptionsModel).execute();
    assertNotNull(response);
    RegistrationWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRegistrationsPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("200"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("urlEncodedResourceCRNQuery"), "crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F00000000000000000000000000000000%3Afeddecaf-0000-0000-0000-1234567890ab%3A*%3A*");
    assertEquals(Boolean.valueOf(query.get("preventKeyDeletion")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
  }

  // Test the getRegistrations operation with and without retries enabled
  @Test
  public void testGetRegistrationsWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetRegistrationsWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetRegistrationsWOptions();
  }

  // Test the getRegistrations operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRegistrationsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getRegistrations(null).execute();
  }

  // Test the getRegistrationsAllKeys operation with a valid options model parameter
  @Test
  public void testGetRegistrationsAllKeysWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:<service-name>:<location>:a/<account-id>:<service-instance>:<resource-type>:<resource>\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"updatedBy\": \"IBMid-0000000000\", \"lastUpdated\": \"2000-03-21T00:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": false, \"keyVersion\": {\"id\": \"fadedbee-0000-0000-0000-1234567890ab\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}}]}";
    String getRegistrationsAllKeysPath = "/api/v2/keys/registrations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetRegistrationsAllKeysOptions model
    GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptionsModel = new GetRegistrationsAllKeysOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F00000000000000000000000000000000%3Afeddecaf-0000-0000-0000-1234567890ab%3A*%3A*")
      .limit(Long.valueOf("200"))
      .offset(Long.valueOf("0"))
      .preventKeyDeletion(true)
      .totalCount(true)
      .build();

    // Invoke getRegistrationsAllKeys() with a valid options model and verify the result
    Response<RegistrationWithTotalCount> response = ibmKeyProtectApiService.getRegistrationsAllKeys(getRegistrationsAllKeysOptionsModel).execute();
    assertNotNull(response);
    RegistrationWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRegistrationsAllKeysPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("urlEncodedResourceCRNQuery"), "crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F00000000000000000000000000000000%3Afeddecaf-0000-0000-0000-1234567890ab%3A*%3A*");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("200"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("preventKeyDeletion")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
  }

  // Test the getRegistrationsAllKeys operation with and without retries enabled
  @Test
  public void testGetRegistrationsAllKeysWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetRegistrationsAllKeysWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetRegistrationsAllKeysWOptions();
  }

  // Test the getRegistrationsAllKeys operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRegistrationsAllKeysNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getRegistrationsAllKeys(null).execute();
  }

  // Test the eventAcknowledge operation with a valid options model parameter
  @Test
  public void testEventAcknowledgeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String eventAcknowledgePath = "/api/v2/event_ack";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the EventAcknowledgeOptions model
    EventAcknowledgeOptions eventAcknowledgeOptionsModel = new EventAcknowledgeOptions.Builder()
      .bluemixInstance("testString")
      .eventAcknowledge(TestUtilities.createMockStream("This is a mock file."))
      .correlationId("testString")
      .xKmsKeyRing("default")
      .build();

    // Invoke eventAcknowledge() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.eventAcknowledge(eventAcknowledgeOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, eventAcknowledgePath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the eventAcknowledge operation with and without retries enabled
  @Test
  public void testEventAcknowledgeWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testEventAcknowledgeWOptions();

    ibmKeyProtectApiService.disableRetries();
    testEventAcknowledgeWOptions();
  }

  // Test the eventAcknowledge operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEventAcknowledgeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.eventAcknowledge(null).execute();
  }

  // Test the createKeyAlias operation with a valid options model parameter
  @Test
  public void testCreateKeyAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"fadedbee-0000-0000-0000-1234567890ab\", \"alias\": \"Example-test-key\", \"createdBy\": \"IBMid-0000000000\", \"creationDate\": \"2000-03-21T00:00:00.000Z\"}]}";
    String createKeyAliasPath = "/api/v2/keys/testString/aliases/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateKeyAliasOptions model
    CreateKeyAliasOptions createKeyAliasOptionsModel = new CreateKeyAliasOptions.Builder()
      .id("testString")
      .alias("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke createKeyAlias() with a valid options model and verify the result
    Response<KeyAlias> response = ibmKeyProtectApiService.createKeyAlias(createKeyAliasOptionsModel).execute();
    assertNotNull(response);
    KeyAlias responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyAliasPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createKeyAlias operation with and without retries enabled
  @Test
  public void testCreateKeyAliasWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testCreateKeyAliasWOptions();

    ibmKeyProtectApiService.disableRetries();
    testCreateKeyAliasWOptions();
  }

  // Test the createKeyAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.createKeyAlias(null).execute();
  }

  // Test the deleteKeyAlias operation with a valid options model parameter
  @Test
  public void testDeleteKeyAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteKeyAliasPath = "/api/v2/keys/testString/aliases/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteKeyAliasOptions model
    DeleteKeyAliasOptions deleteKeyAliasOptionsModel = new DeleteKeyAliasOptions.Builder()
      .id("testString")
      .alias("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .xKmsKeyRing("testString")
      .build();

    // Invoke deleteKeyAlias() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.deleteKeyAlias(deleteKeyAliasOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKeyAliasPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteKeyAlias operation with and without retries enabled
  @Test
  public void testDeleteKeyAliasWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteKeyAliasWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteKeyAliasWOptions();
  }

  // Test the deleteKeyAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteKeyAlias(null).execute();
  }

  // Test the listKeyRings operation with a valid options model parameter
  @Test
  public void testListKeyRingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"id\", \"creationDate\": \"2000-03-21T00:00:00.000Z\", \"createdBy\": \"createdBy\"}]}";
    String listKeyRingsPath = "/api/v2/key_rings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListKeyRingsOptions model
    ListKeyRingsOptions listKeyRingsOptionsModel = new ListKeyRingsOptions.Builder()
      .bluemixInstance("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .correlationId("testString")
      .build();

    // Invoke listKeyRings() with a valid options model and verify the result
    Response<ListKeyRingsWithTotalCount> response = ibmKeyProtectApiService.listKeyRings(listKeyRingsOptionsModel).execute();
    assertNotNull(response);
    ListKeyRingsWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listKeyRingsPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
  }

  // Test the listKeyRings operation with and without retries enabled
  @Test
  public void testListKeyRingsWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testListKeyRingsWOptions();

    ibmKeyProtectApiService.disableRetries();
    testListKeyRingsWOptions();
  }

  // Test the listKeyRings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListKeyRingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.listKeyRings(null).execute();
  }

  // Test the createKeyRing operation with a valid options model parameter
  @Test
  public void testCreateKeyRingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String createKeyRingPath = "/api/v2/key_rings/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateKeyRingOptions model
    CreateKeyRingOptions createKeyRingOptionsModel = new CreateKeyRingOptions.Builder()
      .keyRingId("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .build();

    // Invoke createKeyRing() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.createKeyRing(createKeyRingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyRingPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createKeyRing operation with and without retries enabled
  @Test
  public void testCreateKeyRingWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testCreateKeyRingWOptions();

    ibmKeyProtectApiService.disableRetries();
    testCreateKeyRingWOptions();
  }

  // Test the createKeyRing operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyRingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.createKeyRing(null).execute();
  }

  // Test the deleteKeyRing operation with a valid options model parameter
  @Test
  public void testDeleteKeyRingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteKeyRingPath = "/api/v2/key_rings/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteKeyRingOptions model
    DeleteKeyRingOptions deleteKeyRingOptionsModel = new DeleteKeyRingOptions.Builder()
      .keyRingId("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .force(false)
      .build();

    // Invoke deleteKeyRing() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.deleteKeyRing(deleteKeyRingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKeyRingPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(false));
  }

  // Test the deleteKeyRing operation with and without retries enabled
  @Test
  public void testDeleteKeyRingWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteKeyRingWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteKeyRingWOptions();
  }

  // Test the deleteKeyRing operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyRingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteKeyRing(null).execute();
  }

  // Test the getKmipAdapters operation with a valid options model parameter
  @Test
  public void testGetKmipAdaptersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"name\": \"kmip-adapter-name\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"profile\": \"native_1.0\", \"description\": \"kmip adapter description\", \"profile_data\": {\"crk_id\": \"feddecaf-0000-0000-0000-1234567890ab\"}}]}";
    String getKmipAdaptersPath = "/api/v2/kmip_adapters";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKmipAdaptersOptions model
    GetKmipAdaptersOptions getKmipAdaptersOptionsModel = new GetKmipAdaptersOptions.Builder()
      .bluemixInstance("testString")
      .correlationId("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .build();

    // Invoke getKmipAdapters() with a valid options model and verify the result
    Response<ListKMIPAdaptersWithTotalCount> response = ibmKeyProtectApiService.getKmipAdapters(getKmipAdaptersOptionsModel).execute();
    assertNotNull(response);
    ListKMIPAdaptersWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKmipAdaptersPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
  }

  // Test the getKmipAdapters operation with and without retries enabled
  @Test
  public void testGetKmipAdaptersWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKmipAdaptersWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKmipAdaptersWOptions();
  }

  // Test the getKmipAdapters operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipAdaptersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKmipAdapters(null).execute();
  }

  // Test the createKmipAdapter operation with a valid options model parameter
  @Test
  public void testCreateKmipAdapterWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"name\": \"kmip-adapter-name\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"profile\": \"native_1.0\", \"description\": \"kmip adapter description\", \"profile_data\": {\"crk_id\": \"feddecaf-0000-0000-0000-1234567890ab\"}}]}";
    String createKmipAdapterPath = "/api/v2/kmip_adapters";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.kmip_adapter+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the KMIPProfileDataBodyKMIPProfileDataNative model
    KMIPProfileDataBodyKMIPProfileDataNative kmipProfileDataBodyModel = new KMIPProfileDataBodyKMIPProfileDataNative.Builder()
      .crkId("feddecaf-0000-0000-0000-1234567890ab")
      .build();

    // Construct an instance of the CreateKMIPAdapterRequestBodyResources model
    CreateKMIPAdapterRequestBodyResources createKmipAdapterRequestBodyResourcesModel = new CreateKMIPAdapterRequestBodyResources.Builder()
      .name("kmip-adapter-name")
      .description("kmip adapter description")
      .profile("native_1.0")
      .profileData(kmipProfileDataBodyModel)
      .build();

    // Construct an instance of the CreateKmipAdapterOptions model
    CreateKmipAdapterOptions createKmipAdapterOptionsModel = new CreateKmipAdapterOptions.Builder()
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(createKmipAdapterRequestBodyResourcesModel))
      .correlationId("testString")
      .build();

    // Invoke createKmipAdapter() with a valid options model and verify the result
    Response<ListKMIPAdapters> response = ibmKeyProtectApiService.createKmipAdapter(createKmipAdapterOptionsModel).execute();
    assertNotNull(response);
    ListKMIPAdapters responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKmipAdapterPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createKmipAdapter operation with and without retries enabled
  @Test
  public void testCreateKmipAdapterWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testCreateKmipAdapterWOptions();

    ibmKeyProtectApiService.disableRetries();
    testCreateKmipAdapterWOptions();
  }

  // Test the createKmipAdapter operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKmipAdapterNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.createKmipAdapter(null).execute();
  }

  // Test the getKmipAdapter operation with a valid options model parameter
  @Test
  public void testGetKmipAdapterWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"name\": \"kmip-adapter-name\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"profile\": \"native_1.0\", \"description\": \"kmip adapter description\", \"profile_data\": {\"crk_id\": \"feddecaf-0000-0000-0000-1234567890ab\"}}]}";
    String getKmipAdapterPath = "/api/v2/kmip_adapters/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKmipAdapterOptions model
    GetKmipAdapterOptions getKmipAdapterOptionsModel = new GetKmipAdapterOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .build();

    // Invoke getKmipAdapter() with a valid options model and verify the result
    Response<ListKMIPAdapters> response = ibmKeyProtectApiService.getKmipAdapter(getKmipAdapterOptionsModel).execute();
    assertNotNull(response);
    ListKMIPAdapters responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKmipAdapterPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getKmipAdapter operation with and without retries enabled
  @Test
  public void testGetKmipAdapterWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKmipAdapterWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKmipAdapterWOptions();
  }

  // Test the getKmipAdapter operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipAdapterNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKmipAdapter(null).execute();
  }

  // Test the deleteKmipAdapter operation with a valid options model parameter
  @Test
  public void testDeleteKmipAdapterWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteKmipAdapterPath = "/api/v2/kmip_adapters/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteKmipAdapterOptions model
    DeleteKmipAdapterOptions deleteKmipAdapterOptionsModel = new DeleteKmipAdapterOptions.Builder()
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .build();

    // Invoke deleteKmipAdapter() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.deleteKmipAdapter(deleteKmipAdapterOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKmipAdapterPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteKmipAdapter operation with and without retries enabled
  @Test
  public void testDeleteKmipAdapterWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteKmipAdapterWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteKmipAdapterWOptions();
  }

  // Test the deleteKmipAdapter operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKmipAdapterNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteKmipAdapter(null).execute();
  }

  // Test the getKmipObjects operation with a valid options model parameter
  @Test
  public void testGetKmipObjectsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"kmip_object_type\": 2, \"state\": 1, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_kmip_client_cert_id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by_kmip_client_cert_id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"updated_by\": \"updatedBy\", \"destroyed_at\": \"2019-01-01T12:00:00.000Z\", \"destroyed_by_kmip_client_cert_id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"destroyed_by\": \"destroyedBy\"}]}";
    String getKmipObjectsPath = "/api/v2/kmip_adapters/testString/kmip_objects";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKmipObjectsOptions model
    GetKmipObjectsOptions getKmipObjectsOptionsModel = new GetKmipObjectsOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .state(java.util.Arrays.asList(Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3"), Long.valueOf("4")))
      .correlationId("testString")
      .build();

    // Invoke getKmipObjects() with a valid options model and verify the result
    Response<ListKMIPObjectsWithTotalCount> response = ibmKeyProtectApiService.getKmipObjects(getKmipObjectsOptionsModel).execute();
    assertNotNull(response);
    ListKMIPObjectsWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKmipObjectsPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
    assertEquals(query.get("state"), RequestUtils.join(java.util.Arrays.asList(Long.valueOf("1"), Long.valueOf("2"), Long.valueOf("3"), Long.valueOf("4")), ","));
  }

  // Test the getKmipObjects operation with and without retries enabled
  @Test
  public void testGetKmipObjectsWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKmipObjectsWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKmipObjectsWOptions();
  }

  // Test the getKmipObjects operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipObjectsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKmipObjects(null).execute();
  }

  // Test the getKmipObject operation with a valid options model parameter
  @Test
  public void testGetKmipObjectWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"kmip_object_type\": 2, \"state\": 1, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_kmip_client_cert_id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by_kmip_client_cert_id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"updated_by\": \"updatedBy\", \"destroyed_at\": \"2019-01-01T12:00:00.000Z\", \"destroyed_by_kmip_client_cert_id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"destroyed_by\": \"destroyedBy\"}]}";
    String getKmipObjectPath = "/api/v2/kmip_adapters/testString/kmip_objects/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKmipObjectOptions model
    GetKmipObjectOptions getKmipObjectOptionsModel = new GetKmipObjectOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .id("testString")
      .correlationId("testString")
      .build();

    // Invoke getKmipObject() with a valid options model and verify the result
    Response<ListKMIPObjectsWithTotalCount> response = ibmKeyProtectApiService.getKmipObject(getKmipObjectOptionsModel).execute();
    assertNotNull(response);
    ListKMIPObjectsWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKmipObjectPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getKmipObject operation with and without retries enabled
  @Test
  public void testGetKmipObjectWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKmipObjectWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKmipObjectWOptions();
  }

  // Test the getKmipObject operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipObjectNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKmipObject(null).execute();
  }

  // Test the deleteKmipObject operation with a valid options model parameter
  @Test
  public void testDeleteKmipObjectWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteKmipObjectPath = "/api/v2/kmip_adapters/testString/kmip_objects/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteKmipObjectOptions model
    DeleteKmipObjectOptions deleteKmipObjectOptionsModel = new DeleteKmipObjectOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .id("testString")
      .correlationId("testString")
      .build();

    // Invoke deleteKmipObject() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.deleteKmipObject(deleteKmipObjectOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKmipObjectPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteKmipObject operation with and without retries enabled
  @Test
  public void testDeleteKmipObjectWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteKmipObjectWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteKmipObjectWOptions();
  }

  // Test the deleteKmipObject operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKmipObjectNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteKmipObject(null).execute();
  }

  // Test the getKmipClientCertificates operation with a valid options model parameter
  @Test
  public void testGetKmipClientCertificatesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"name\": \"name\", \"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\"}]}";
    String getKmipClientCertificatesPath = "/api/v2/kmip_adapters/testString/certificates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKmipClientCertificatesOptions model
    GetKmipClientCertificatesOptions getKmipClientCertificatesOptionsModel = new GetKmipClientCertificatesOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .totalCount(true)
      .correlationId("testString")
      .build();

    // Invoke getKmipClientCertificates() with a valid options model and verify the result
    Response<ListKMIPPartialClientCertificatesWithTotalCount> response = ibmKeyProtectApiService.getKmipClientCertificates(getKmipClientCertificatesOptionsModel).execute();
    assertNotNull(response);
    ListKMIPPartialClientCertificatesWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKmipClientCertificatesPath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
  }

  // Test the getKmipClientCertificates operation with and without retries enabled
  @Test
  public void testGetKmipClientCertificatesWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKmipClientCertificatesWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKmipClientCertificatesWOptions();
  }

  // Test the getKmipClientCertificates operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipClientCertificatesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKmipClientCertificates(null).execute();
  }

  // Test the addKmipClientCertificate operation with a valid options model parameter
  @Test
  public void testAddKmipClientCertificateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"name\": \"name\", \"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"certificate\": \"certificate\"}]}";
    String addKmipClientCertificatePath = "/api/v2/kmip_adapters/testString/certificates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.kms.kmip_client_certificate+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the CreateKMIPClientCertificateObject model
    CreateKMIPClientCertificateObject createKmipClientCertificateObjectModel = new CreateKMIPClientCertificateObject.Builder()
      .certificate("testString")
      .name("testString")
      .build();

    // Construct an instance of the AddKmipClientCertificateOptions model
    AddKmipClientCertificateOptions addKmipClientCertificateOptionsModel = new AddKmipClientCertificateOptions.Builder()
      .adapterId("testString")
      .bluemixInstance("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(createKmipClientCertificateObjectModel))
      .correlationId("testString")
      .build();

    // Invoke addKmipClientCertificate() with a valid options model and verify the result
    Response<ListKMIPClientCertificates> response = ibmKeyProtectApiService.addKmipClientCertificate(addKmipClientCertificateOptionsModel).execute();
    assertNotNull(response);
    ListKMIPClientCertificates responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addKmipClientCertificatePath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addKmipClientCertificate operation with and without retries enabled
  @Test
  public void testAddKmipClientCertificateWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testAddKmipClientCertificateWOptions();

    ibmKeyProtectApiService.disableRetries();
    testAddKmipClientCertificateWOptions();
  }

  // Test the addKmipClientCertificate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddKmipClientCertificateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.addKmipClientCertificate(null).execute();
  }

  // Test the getKmipClientCertificate operation with a valid options model parameter
  @Test
  public void testGetKmipClientCertificateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.allowed_ip_metadata+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"name\": \"name\", \"id\": \"feddecaf-0000-0000-0000-1234567890ab\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"certificate\": \"certificate\"}]}";
    String getKmipClientCertificatePath = "/api/v2/kmip_adapters/testString/certificates/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetKmipClientCertificateOptions model
    GetKmipClientCertificateOptions getKmipClientCertificateOptionsModel = new GetKmipClientCertificateOptions.Builder()
      .adapterId("testString")
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .build();

    // Invoke getKmipClientCertificate() with a valid options model and verify the result
    Response<ListKMIPClientCertificates> response = ibmKeyProtectApiService.getKmipClientCertificate(getKmipClientCertificateOptionsModel).execute();
    assertNotNull(response);
    ListKMIPClientCertificates responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKmipClientCertificatePath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getKmipClientCertificate operation with and without retries enabled
  @Test
  public void testGetKmipClientCertificateWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testGetKmipClientCertificateWOptions();

    ibmKeyProtectApiService.disableRetries();
    testGetKmipClientCertificateWOptions();
  }

  // Test the getKmipClientCertificate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKmipClientCertificateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.getKmipClientCertificate(null).execute();
  }

  // Test the deleteKmipClientCertificate operation with a valid options model parameter
  @Test
  public void testDeleteKmipClientCertificateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteKmipClientCertificatePath = "/api/v2/kmip_adapters/testString/certificates/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteKmipClientCertificateOptions model
    DeleteKmipClientCertificateOptions deleteKmipClientCertificateOptionsModel = new DeleteKmipClientCertificateOptions.Builder()
      .adapterId("testString")
      .id("testString")
      .bluemixInstance("testString")
      .correlationId("testString")
      .build();

    // Invoke deleteKmipClientCertificate() with a valid options model and verify the result
    Response<Void> response = ibmKeyProtectApiService.deleteKmipClientCertificate(deleteKmipClientCertificateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKmipClientCertificatePath);
    // Verify header parameters
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteKmipClientCertificate operation with and without retries enabled
  @Test
  public void testDeleteKmipClientCertificateWRetries() throws Throwable {
    ibmKeyProtectApiService.enableRetries(4, 30);
    testDeleteKmipClientCertificateWOptions();

    ibmKeyProtectApiService.disableRetries();
    testDeleteKmipClientCertificateWOptions();
  }

  // Test the deleteKmipClientCertificate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKmipClientCertificateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmKeyProtectApiService.deleteKmipClientCertificate(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    ibmKeyProtectApiService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    ibmKeyProtectApiService = IbmKeyProtectApi.newInstance(serviceName);
    String url = server.url("/").toString();
    ibmKeyProtectApiService.setServiceUrl(url);
  }
}