/*
 * (C) Copyright IBM Corp. 2021.
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
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Unit test class for the IbmKeyProtectApi service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class IbmKeyProtectApiTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IbmKeyProtectApi ibmKeyProtectApiService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    ibmKeyProtectApiService = IbmKeyProtectApi.newInstance(serviceName);
    String url = server.url("/").toString();
    ibmKeyProtectApiService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IbmKeyProtectApi(serviceName, null);
  }

  @Test
  public void testCreateKeyAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"84a53643-9ca8-4ff2-9c68-d7842526167b\", \"alias\": \"Example-test-key\", \"createdBy\": \"...\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}]}";
    String createKeyAliasPath = "/api/v2/keys/testString/aliases/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateKeyAliasOptions model
    CreateKeyAliasOptions createKeyAliasOptionsModel = new CreateKeyAliasOptions.Builder()
    .id("testString")
    .alias("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<KeyAlias> response = ibmKeyProtectApiService.createKeyAlias(createKeyAliasOptionsModel).execute();
    assertNotNull(response);
    KeyAlias responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyAliasPath);
  }

  // Test the createKeyAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.createKeyAlias(null).execute();
  }

  @Test
  public void testDeleteKeyAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteKeyAliasPath = "/api/v2/keys/testString/aliases/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteKeyAliasOptions model
    DeleteKeyAliasOptions deleteKeyAliasOptionsModel = new DeleteKeyAliasOptions.Builder()
    .id("testString")
    .alias("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.deleteKeyAlias(deleteKeyAliasOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKeyAliasPath);
  }

  // Test the deleteKeyAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.deleteKeyAlias(null).execute();
  }

  @Test
  public void testPostImportTokenWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 300, \"maxAllowedRetrievals\": 1, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"remainingRetrievals\": 1}";
    String postImportTokenPath = "/api/v2/import_token";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostImportTokenOptions model
    PostImportTokenOptions postImportTokenOptionsModel = new PostImportTokenOptions.Builder()
    .bluemixInstance("testString")
    .expiration(Double.valueOf("300"))
    .maxAllowedRetrievals(Double.valueOf("1"))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ImportToken> response = ibmKeyProtectApiService.postImportToken(postImportTokenOptionsModel).execute();
    assertNotNull(response);
    ImportToken responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postImportTokenPath);
  }

  // Test the postImportToken operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostImportTokenNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.postImportToken(null).execute();
  }

  @Test
  public void testGetImportTokenWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 300, \"maxAllowedRetrievals\": 1, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"remainingRetrievals\": 1, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"nonce\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}";
    String getImportTokenPath = "/api/v2/import_token";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetImportTokenOptions model
    GetImportTokenOptions getImportTokenOptionsModel = new GetImportTokenOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetImportToken> response = ibmKeyProtectApiService.getImportToken(getImportTokenOptionsModel).execute();
    assertNotNull(response);
    GetImportToken responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getImportTokenPath);
  }

  // Test the getImportToken operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetImportTokenNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getImportToken(null).execute();
  }

  @Test
  public void testWrapKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}}";
    String wrapKeyPath = "/api/v2/keys/testString/actions/wrap";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the WrapKeyOptions model
    WrapKeyOptions wrapKeyOptionsModel = new WrapKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .keyActionWrapBody(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<WrapKeyResponseBody> response = ibmKeyProtectApiService.wrapKey(wrapKeyOptionsModel).execute();
    assertNotNull(response);
    WrapKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, wrapKeyPath);
  }

  // Test the wrapKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testWrapKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.wrapKey(null).execute();
  }

  @Test
  public void testUnwrapKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"rewrappedKeyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}}";
    String unwrapKeyPath = "/api/v2/keys/testString/actions/unwrap";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UnwrapKeyOptions model
    UnwrapKeyOptions unwrapKeyOptionsModel = new UnwrapKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .keyActionUnwrapBody(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UnwrapKeyResponseBody> response = ibmKeyProtectApiService.unwrapKey(unwrapKeyOptionsModel).execute();
    assertNotNull(response);
    UnwrapKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unwrapKeyPath);
  }

  // Test the unwrapKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnwrapKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.unwrapKey(null).execute();
  }

  @Test
  public void testRewrapKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"rewrappedKeyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}}";
    String rewrapKeyPath = "/api/v2/keys/testString/actions/rewrap";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RewrapKeyOptions model
    RewrapKeyOptions rewrapKeyOptionsModel = new RewrapKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .keyActionRewrapBody(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RewrapKeyResponseBody> response = ibmKeyProtectApiService.rewrapKey(rewrapKeyOptionsModel).execute();
    assertNotNull(response);
    RewrapKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, rewrapKeyPath);
  }

  // Test the rewrapKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRewrapKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.rewrapKey(null).execute();
  }

  @Test
  public void testRotateKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String rotateKeyPath = "/api/v2/keys/testString/actions/rotate";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RotateKeyOptions model
    RotateKeyOptions rotateKeyOptionsModel = new RotateKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .keyActionRotateBody(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .prefer("return=representation")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.rotateKey(rotateKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, rotateKeyPath);
  }

  // Test the rotateKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRotateKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.rotateKey(null).execute();
  }

  @Test
  public void testSetKeyForDeletionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String setKeyForDeletionPath = "/api/v2/keys/testString/actions/setKeyForDeletion";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SetKeyForDeletionOptions model
    SetKeyForDeletionOptions setKeyForDeletionOptionsModel = new SetKeyForDeletionOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.setKeyForDeletion(setKeyForDeletionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, setKeyForDeletionPath);
  }

  // Test the setKeyForDeletion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKeyForDeletionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.setKeyForDeletion(null).execute();
  }

  @Test
  public void testUnsetKeyForDeletionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String unsetKeyForDeletionPath = "/api/v2/keys/testString/actions/unsetKeyForDeletion";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UnsetKeyForDeletionOptions model
    UnsetKeyForDeletionOptions unsetKeyForDeletionOptionsModel = new UnsetKeyForDeletionOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.unsetKeyForDeletion(unsetKeyForDeletionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unsetKeyForDeletionPath);
  }

  // Test the unsetKeyForDeletion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnsetKeyForDeletionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.unsetKeyForDeletion(null).execute();
  }

  @Test
  public void testEnableKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String enableKeyPath = "/api/v2/keys/testString/actions/enable";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the EnableKeyOptions model
    EnableKeyOptions enableKeyOptionsModel = new EnableKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.enableKey(enableKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, enableKeyPath);
  }

  // Test the enableKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnableKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.enableKey(null).execute();
  }

  @Test
  public void testDisableKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String disableKeyPath = "/api/v2/keys/testString/actions/disable";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DisableKeyOptions model
    DisableKeyOptions disableKeyOptionsModel = new DisableKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.disableKey(disableKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, disableKeyPath);
  }

  // Test the disableKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDisableKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.disableKey(null).execute();
  }

  @Test
  public void testSyncAssociatedResourcesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String syncAssociatedResourcesPath = "/api/v2/keys/testString/actions/sync";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SyncAssociatedResourcesOptions model
    SyncAssociatedResourcesOptions syncAssociatedResourcesOptionsModel = new SyncAssociatedResourcesOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.syncAssociatedResources(syncAssociatedResourcesOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, syncAssociatedResourcesPath);
  }

  // Test the syncAssociatedResources operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSyncAssociatedResourcesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.syncAssociatedResources(null).execute();
  }

  @Test
  public void testEventAcknowledgeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String eventAcknowledgePath = "/api/v2/event_ack";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the EventAcknowledgeOptions model
    EventAcknowledgeOptions eventAcknowledgeOptionsModel = new EventAcknowledgeOptions.Builder()
    .bluemixInstance("testString")
    .body(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.eventAcknowledge(eventAcknowledgeOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, eventAcknowledgePath);
  }

  // Test the eventAcknowledge operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEventAcknowledgeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.eventAcknowledge(null).execute();
  }

  @Test
  public void testListKeyRingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"creationDate\": \"2019-01-01T12:00:00.000Z\", \"createdBy\": \"createdBy\"}]}";
    String listKeyRingsPath = "/api/v2/key_rings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListKeyRingsOptions model
    ListKeyRingsOptions listKeyRingsOptionsModel = new ListKeyRingsOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeyRings> response = ibmKeyProtectApiService.listKeyRings(listKeyRingsOptionsModel).execute();
    assertNotNull(response);
    ListKeyRings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listKeyRingsPath);
  }

  // Test the listKeyRings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListKeyRingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.listKeyRings(null).execute();
  }

  @Test
  public void testCreateKeyRingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String createKeyRingPath = "/api/v2/key_rings/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateKeyRingOptions model
    CreateKeyRingOptions createKeyRingOptionsModel = new CreateKeyRingOptions.Builder()
    .keyRingId("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.createKeyRing(createKeyRingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyRingPath);
  }

  // Test the createKeyRing operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyRingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.createKeyRing(null).execute();
  }

  @Test
  public void testDeleteKeyRingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteKeyRingPath = "/api/v2/key_rings/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteKeyRingOptions model
    DeleteKeyRingOptions deleteKeyRingOptionsModel = new DeleteKeyRingOptions.Builder()
    .keyRingId("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.deleteKeyRing(deleteKeyRingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKeyRingPath);
  }

  // Test the deleteKeyRing operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyRingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.deleteKeyRing(null).execute();
  }

  @Test
  public void testGetKeyCollectionMetadataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getKeyCollectionMetadataPath = "/api/v2/keys";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetKeyCollectionMetadataOptions model
    GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptionsModel = new GetKeyCollectionMetadataOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .state(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))))
    .extractable(true)
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.getKeyCollectionMetadata(getKeyCollectionMetadataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("state"), RequestUtils.join(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))), ","));
    assertEquals(Boolean.valueOf(query.get("extractable")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyCollectionMetadataPath);
  }

  // Test the getKeyCollectionMetadata operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyCollectionMetadataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getKeyCollectionMetadata(null).execute();
  }

  @Test
  public void testCreateKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
    String createKeyPath = "/api/v2/keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateKeyOptions model
    CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
    .bluemixInstance("testString")
    .body(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .prefer("return=representation")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Key> response = ibmKeyProtectApiService.createKey(createKeyOptionsModel).execute();
    assertNotNull(response);
    Key responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createKeyPath);
  }

  // Test the createKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.createKey(null).execute();
  }

  @Test
  public void testGetKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getKeysPath = "/api/v2/keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetKeysOptions model
    GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .limit(Long.valueOf("1"))
    .offset(Long.valueOf("0"))
    .state(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))))
    .extractable(true)
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeys> response = ibmKeyProtectApiService.getKeys(getKeysOptionsModel).execute();
    assertNotNull(response);
    ListKeys responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("state"), RequestUtils.join(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("0"))), ","));
    assertEquals(Boolean.valueOf(query.get("extractable")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeysPath);
  }

  // Test the getKeys operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeysNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getKeys(null).execute();
  }

  @Test
  public void testGetKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
    String getKeyPath = "/api/v2/keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetKeyOptions model
    GetKeyOptions getKeyOptionsModel = new GetKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKey> response = ibmKeyProtectApiService.getKey(getKeyOptionsModel).execute();
    assertNotNull(response);
    GetKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyPath);
  }

  // Test the getKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getKey(null).execute();
  }

  @Test
  public void testActionOnKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}}";
    String actionOnKeyPath = "/api/v2/keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ActionOnKeyOptions model
    ActionOnKeyOptions actionOnKeyOptionsModel = new ActionOnKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .action("disable")
    .body(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .prefer("return=representation")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<KeyActionOneOfResponse> response = ibmKeyProtectApiService.actionOnKey(actionOnKeyOptionsModel).execute();
    assertNotNull(response);
    KeyActionOneOfResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("action"), "disable");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, actionOnKeyPath);
  }

  // Test the actionOnKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testActionOnKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.actionOnKey(null).execute();
  }

  @Test
  public void testPatchKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\"}]}";
    String patchKeyPath = "/api/v2/keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PatchKeyOptions model
    PatchKeyOptions patchKeyOptionsModel = new PatchKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .keyPatchBody(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PatchKeyResponseBody> response = ibmKeyProtectApiService.patchKey(patchKeyOptionsModel).execute();
    assertNotNull(response);
    PatchKeyResponseBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, patchKeyPath);
  }

  // Test the patchKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPatchKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.patchKey(null).execute();
  }

  @Test
  public void testDeleteKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
    String deleteKeyPath = "/api/v2/keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteKeyOptions model
    DeleteKeyOptions deleteKeyOptionsModel = new DeleteKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .prefer("return=representation")
    .force(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteKey> response = ibmKeyProtectApiService.deleteKey(deleteKeyOptionsModel).execute();
    assertNotNull(response);
    DeleteKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteKeyPath);
  }

  // Test the deleteKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.deleteKey(null).execute();
  }

  @Test
  public void testGetKeyMetadataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getKeyMetadataPath = "/api/v2/keys/testString/metadata";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetKeyMetadataOptions model
    GetKeyMetadataOptions getKeyMetadataOptionsModel = new GetKeyMetadataOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyMetadata> response = ibmKeyProtectApiService.getKeyMetadata(getKeyMetadataOptionsModel).execute();
    assertNotNull(response);
    GetKeyMetadata responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyMetadataPath);
  }

  // Test the getKeyMetadata operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyMetadataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getKeyMetadata(null).execute();
  }

  @Test
  public void testPurgeKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2018-12-01T23:20:50.520Z\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2018-04-12T23:20:50.520Z\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2018-04-12T23:20:50.520Z\", \"lastRotateDate\": \"2018-04-12T23:20:50.520Z\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00.000Z\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00.000Z\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00.000Z\", \"restoreAllowed\": true, \"purgeAllowed\": true, \"purgeAllowedFrom\": \"2019-01-01T12:00:00.000Z\", \"purgeScheduledOn\": \"2019-01-01T12:00:00.000Z\"}]}";
    String purgeKeyPath = "/api/v2/keys/testString/purge";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PurgeKeyOptions model
    PurgeKeyOptions purgeKeyOptionsModel = new PurgeKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .prefer("return=representation")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PurgeKey> response = ibmKeyProtectApiService.purgeKey(purgeKeyOptionsModel).execute();
    assertNotNull(response);
    PurgeKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, purgeKeyPath);
  }

  // Test the purgeKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPurgeKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.purgeKey(null).execute();
  }

  @Test
  public void testRestoreKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String restoreKeyPath = "/api/v2/keys/testString/restore";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/vnd.ibm.kms.key+json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RestoreKeyOptions model
    RestoreKeyOptions restoreKeyOptionsModel = new RestoreKeyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .keyRestoreBody(TestUtilities.createMockStream("This is a mock file."))
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .prefer("return=representation")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = ibmKeyProtectApiService.restoreKey(restoreKeyOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, restoreKeyPath);
  }

  // Test the restoreKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRestoreKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.restoreKey(null).execute();
  }

  @Test
  public void testGetKeyVersionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getKeyVersionsPath = "/api/v2/keys/testString/versions";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetKeyVersionsOptions model
    GetKeyVersionsOptions getKeyVersionsOptionsModel = new GetKeyVersionsOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .limit(Long.valueOf("1"))
    .offset(Long.valueOf("0"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeyVersions> response = ibmKeyProtectApiService.getKeyVersions(getKeyVersionsOptionsModel).execute();
    assertNotNull(response);
    ListKeyVersions responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyVersionsPath);
  }

  // Test the getKeyVersions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetKeyVersionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getKeyVersions(null).execute();
  }

  @Test
  public void testPutPolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance:policy:<policy-id>\", \"creationDate\": \"2019-01-01T12:00:00.000Z\", \"createdBy\": \"createdBy\", \"lastUpdateDate\": \"2019-01-01T12:00:00.000Z\", \"updatedBy\": \"updatedBy\", \"type\": \"application/vnd.ibm.kms.policy+json\", \"dualAuthDelete\": {\"enabled\": true}}]}";
    String putPolicyPath = "/api/v2/keys/testString/policies";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
    .collectionType("application/vnd.ibm.kms.crn+json")
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
    .resources(new java.util.ArrayList<KeyPolicyDualAuthDelete>(java.util.Arrays.asList(keyPolicyDualAuthDeleteModel)))
    .build();

    // Construct an instance of the PutPolicyOptions model
    PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .setKeyPoliciesOneOf(setKeyPoliciesOneOfModel)
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .policy("dualAuthDelete")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyPoliciesOneOf> response = ibmKeyProtectApiService.putPolicy(putPolicyOptionsModel).execute();
    assertNotNull(response);
    GetKeyPoliciesOneOf responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("policy"), "dualAuthDelete");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putPolicyPath);
  }

  // Test the putPolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutPolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.putPolicy(null).execute();
  }

  @Test
  public void testGetPolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance:policy:<policy-id>\", \"creationDate\": \"2019-01-01T12:00:00.000Z\", \"createdBy\": \"createdBy\", \"lastUpdateDate\": \"2019-01-01T12:00:00.000Z\", \"updatedBy\": \"updatedBy\", \"type\": \"application/vnd.ibm.kms.policy+json\", \"dualAuthDelete\": {\"enabled\": true}}]}";
    String getPolicyPath = "/api/v2/keys/testString/policies";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPolicyOptions model
    GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .policy("dualAuthDelete")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyPoliciesOneOf> response = ibmKeyProtectApiService.getPolicy(getPolicyOptionsModel).execute();
    assertNotNull(response);
    GetKeyPoliciesOneOf responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("policy"), "dualAuthDelete");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPolicyPath);
  }

  // Test the getPolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getPolicy(null).execute();
  }

  @Test
  public void testPutInstancePolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String putInstancePolicyPath = "/api/v2/instance/policies";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
    .collectionType("application/vnd.ibm.kms.crn+json")
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
    .resources(new java.util.ArrayList<SetInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItem>(java.util.Arrays.asList(setInstancePoliciesOneOfSetInstancePolicyAllowedNetworkResourcesItemModel)))
    .build();

    // Construct an instance of the PutInstancePolicyOptions model
    PutInstancePolicyOptions putInstancePolicyOptionsModel = new PutInstancePolicyOptions.Builder()
    .bluemixInstance("testString")
    .setInstancePoliciesOneOf(setInstancePoliciesOneOfModel)
    .correlationId("testString")
    .policy("allowedNetwork")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmKeyProtectApiService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("policy"), "allowedNetwork");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putInstancePolicyPath);
  }

  // Test the putInstancePolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutInstancePolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.putInstancePolicy(null).execute();
  }

  @Test
  public void testGetInstancePolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"creationDate\": \"2019-01-01T12:00:00.000Z\", \"createdBy\": \"createdBy\", \"updatedBy\": \"updatedBy\", \"lastUpdated\": \"2019-01-01T12:00:00.000Z\", \"policy_type\": \"policyType\", \"policy_data\": {\"enabled\": true, \"attributes\": {\"allowed_network\": \"public-and-private\"}}}]}";
    String getInstancePolicyPath = "/api/v2/instance/policies";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetInstancePolicyOptions model
    GetInstancePolicyOptions getInstancePolicyOptionsModel = new GetInstancePolicyOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .policy("allowedNetwork")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetInstancePoliciesOneOf> response = ibmKeyProtectApiService.getInstancePolicy(getInstancePolicyOptionsModel).execute();
    assertNotNull(response);
    GetInstancePoliciesOneOf responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("policy"), "allowedNetwork");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getInstancePolicyPath);
  }

  // Test the getInstancePolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstancePolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getInstancePolicy(null).execute();
  }

  @Test
  public void testGetAllowedIpPortWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"private_endpoint_port\": 8888}]}";
    String getAllowedIpPortPath = "/api/v2/instance/allowed_ip_port";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAllowedIPPortOptions model
    GetAllowedIPPortOptions getAllowedIpPortOptionsModel = new GetAllowedIPPortOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AllowedIPPort> response = ibmKeyProtectApiService.getAllowedIPPort(getAllowedIpPortOptionsModel).execute();
    assertNotNull(response);
    AllowedIPPort responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAllowedIpPortPath);
  }

  // Test the getAllowedIPPort operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAllowedIpPortNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getAllowedIPPort(null).execute();
  }

  @Test
  public void testGetRegistrationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"keyId\": \"84a53643-9ca8-4ff2-9c68-d7842526167b\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/<account-id>:<service-instance>:bucket:<bucket-name>\", \"createdBy\": \"examplecreator@ibm.com\", \"creationDate\": \"2019-01-01T12:00:00.000Z\", \"updatedBy\": \"exampleupdater@ibm.com\", \"lastUpdated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": true, \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}}]}";
    String getRegistrationsPath = "/api/v2/keys/testString/registrations";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetRegistrationsOptions model
    GetRegistrationsOptions getRegistrationsOptionsModel = new GetRegistrationsOptions.Builder()
    .id("testString")
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .limit(Long.valueOf("1"))
    .offset(Long.valueOf("0"))
    .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*")
    .preventKeyDeletion(true)
    .totalCount(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RegistrationWithTotalCount> response = ibmKeyProtectApiService.getRegistrations(getRegistrationsOptionsModel).execute();
    assertNotNull(response);
    RegistrationWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("urlEncodedResourceCRNQuery"), "crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*");
    assertEquals(Boolean.valueOf(query.get("preventKeyDeletion")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRegistrationsPath);
  }

  // Test the getRegistrations operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRegistrationsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getRegistrations(null).execute();
  }

  @Test
  public void testGetRegistrationsAllKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"keyId\": \"84a53643-9ca8-4ff2-9c68-d7842526167b\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/<account-id>:<service-instance>:bucket:<bucket-name>\", \"createdBy\": \"examplecreator@ibm.com\", \"creationDate\": \"2019-01-01T12:00:00.000Z\", \"updatedBy\": \"exampleupdater@ibm.com\", \"lastUpdated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": true, \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00.000Z\"}}]}";
    String getRegistrationsAllKeysPath = "/api/v2/keys/registrations";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetRegistrationsAllKeysOptions model
    GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptionsModel = new GetRegistrationsAllKeysOptions.Builder()
    .bluemixInstance("testString")
    .correlationId("testString")
    .xKmsKeyRing("testString")
    .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*")
    .limit(Long.valueOf("1"))
    .offset(Long.valueOf("0"))
    .preventKeyDeletion(true)
    .totalCount(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RegistrationWithTotalCount> response = ibmKeyProtectApiService.getRegistrationsAllKeys(getRegistrationsAllKeysOptionsModel).execute();
    assertNotNull(response);
    RegistrationWithTotalCount responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("Bluemix-Instance"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("urlEncodedResourceCRNQuery"), "crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("preventKeyDeletion")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("totalCount")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRegistrationsAllKeysPath);
  }

  // Test the getRegistrationsAllKeys operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRegistrationsAllKeysNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmKeyProtectApiService.getRegistrationsAllKeys(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    ibmKeyProtectApiService = null;
  }
}