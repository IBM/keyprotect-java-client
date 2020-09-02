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

import com.ibm.cloud.ibm_key_protect_api.v2.IbmKeyProtectApi;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CloudResourceName;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CollectionMetadataWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.EventAcknowledgeOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyCollectionMetadataOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyMetadataOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyVersionsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.Key;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponse;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponseRewrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponseUnwrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponseWrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyFullRepresentation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyFullRepresentationAlgorithmMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyRepresentation;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyRepresentationAlgorithmMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyVersion;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayload;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyWithPayloadAlgorithmMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyVersions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeys;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PostImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RetryPolicy;
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import com.ibm.cloud.sdk.core.util.EnvironmentUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * Unit test class for the IbmKeyProtectApi service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class IbmKeyProtectApiTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IbmKeyProtectApi testService;

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

    testService = IbmKeyProtectApi.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
   * Negative Test - construct the service with a null authenticator.
   */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IbmKeyProtectApi(serviceName, null);
  }

  /**
   * Positive Test - construct the service with a no service name
   */
  @Test
  public void testConstructorWithNoName() throws Throwable {
    Authenticator authenticator = mock(Authenticator.class);
    IbmKeyProtectApi sampleTestService = IbmKeyProtectApi.newInstance(authenticator);
    assertEquals(sampleTestService.DEFAULT_SERVICE_NAME, "ibm_key_protect_api");
    assertEquals(sampleTestService.DEFAULT_RETRY_MAX_INTERVAL, 30L);
    assertEquals(sampleTestService.DEFAULT_MAX_RETRY, 4);
  }

  /**
   * Positive Test - construct the service with retry params.
   */
  @Test
  public void testConstructorWithRetryParams() throws Throwable {
    Authenticator authenticator = mock(Authenticator.class);
    IbmKeyProtectApi sampleTestService = IbmKeyProtectApi.newInstance(authenticator, 4, 30L);
    assertEquals(sampleTestService.DEFAULT_MAX_RETRY, 4);
    assertEquals(sampleTestService.DEFAULT_RETRY_MAX_INTERVAL, 30L);
  }

  @Test
  public void testPostImportTokenWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 10, \"maxAllowedRetrievals\": 20, \"creationDate\": \"2019-01-01T12:00:00\", \"expirationDate\": \"2019-01-01T12:00:00\", \"remainingRetrievals\": 19}";
    String postImportTokenPath = "/api/v2/import_token";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostImportTokenOptions model
    PostImportTokenOptions postImportTokenOptionsModel = new PostImportTokenOptions.Builder()
            .bluemixInstance("testString")
            .expiration(Double.valueOf("72.5"))
            .maxAllowedRetrievals(Double.valueOf("72.5"))
            .correlationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ImportToken> response = testService.postImportToken(postImportTokenOptionsModel).execute();
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

  @Test
  public void testPostImportTokenWithoutSomeOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 10, \"maxAllowedRetrievals\": 20, \"creationDate\": \"2019-01-01T12:00:00\", \"expirationDate\": \"2019-01-01T12:00:00\", \"remainingRetrievals\": 19}";
    String postImportTokenPath = "/api/v2/import_token";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostImportTokenOptions model
    PostImportTokenOptions postImportTokenOptionsModel = new PostImportTokenOptions.Builder()
            .bluemixInstance("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ImportToken> response = testService.postImportToken(postImportTokenOptionsModel).execute();
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
    testService.postImportToken(null).execute();
  }

  @Test
  public void testGetImportTokenWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 10, \"maxAllowedRetrievals\": 20, \"creationDate\": \"2019-01-01T12:00:00\", \"expirationDate\": \"2019-01-01T12:00:00\", \"remainingRetrievals\": 19, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"nonce\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetImportToken> response = testService.getImportToken(getImportTokenOptionsModel).execute();
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

  @Test
  public void testGetImportTokenWithOutCoID() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 10, \"maxAllowedRetrievals\": 20, \"creationDate\": \"2019-01-01T12:00:00\", \"expirationDate\": \"2019-01-01T12:00:00\", \"remainingRetrievals\": 19, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"nonce\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}";
    String getImportTokenPath = "/api/v2/import_token";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetImportTokenOptions model
    GetImportTokenOptions getImportTokenOptionsModel = new GetImportTokenOptions.Builder()
            .bluemixInstance("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetImportToken> response = testService.getImportToken(getImportTokenOptionsModel).execute();
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

  //Test Retry Interceptor with different response codes which should be retried
  @Test
  public void testRetryInterceptor() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"expiration\": 10, \"maxAllowedRetrievals\": 20, \"creationDate\": \"2019-01-01T12:00:00\", \"expirationDate\": \"2019-01-01T12:00:00\", \"remainingRetrievals\": 19, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\", \"nonce\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}";
    String getImportTokenPath = "/api/v2/import_token";

    //retry for response code 429
    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(429)
            .setBody(mockResponseBody));

    //retry for response code 502
    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(502)
            .setBody(mockResponseBody));

    //retry for response code 503
    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(503)
            .setBody(mockResponseBody));

    //retry for response code 504
    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(504)
            .setBody(mockResponseBody));

    //successful response
    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetImportTokenOptions model
    GetImportTokenOptions getImportTokenOptionsModel = new GetImportTokenOptions.Builder()
            .bluemixInstance("testString")
            .correlationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetImportToken> response = testService.getImportToken(getImportTokenOptionsModel).execute();
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

  // Test the Retry Policy which implements exponential backOffs
  @Test
  public void testRetryPolicy() throws Throwable {
    int retries = 0;
    long waitTime;
    //retry interval does not hit upper limit
    RetryPolicy retryPolicy  = new RetryPolicy(3,10L);
    while(retryPolicy.allowRetry(429)){
      waitTime = (long) Math.pow(2, retries);
      assertEquals(Math.min(waitTime, 10L), retryPolicy.waitTime());
      retryPolicy.decreaseRetryCount();
      retries++;
    }
    assertEquals(retries, 3);

    //retry interval does hit upper limit
    retries = 0;
    retryPolicy  = new RetryPolicy(4,6L);
    while(retryPolicy.allowRetry(429)){
      waitTime = (long) Math.pow(2, retries);
      assertEquals(Math.min(waitTime, 6L), retryPolicy.waitTime());
      retryPolicy.decreaseRetryCount();
      retries++;
    }
    assertEquals(retries, 4);
  }

  // Test the getImportToken operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetImportTokenNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getImportToken(null).execute();
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
            .eventAcknowledge(TestUtilities.createMockStream("This is a mock file."))
            .correlationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.eventAcknowledge(eventAcknowledgeOptionsModel).execute();
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

  @Test
  public void testEventAcknowledgeWithoutCoID() throws Throwable {
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
            .eventAcknowledge(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.eventAcknowledge(eventAcknowledgeOptionsModel).execute();
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
    testService.eventAcknowledge(null).execute();
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
            .state(new ArrayList<Long>(Arrays.asList(Long.valueOf("0"))))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getKeyCollectionMetadata(getKeyCollectionMetadataOptionsModel).execute();
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
    assertEquals(new ArrayList<Long>(Arrays.asList(Long.valueOf(query.get("state")))), new ArrayList<Long>(Arrays.asList(Long.valueOf("0"))));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyCollectionMetadataPath);
  }

  @Test
  public void testGetKeyCollectionMetadataWithoutState() throws Throwable {
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getKeyCollectionMetadata(getKeyCollectionMetadataOptionsModel).execute();
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
    assertNull(query);
    // Get query params
    //assertEquals(new ArrayList<Long>(Arrays.asList(Long.valueOf(query.get("state")))), new ArrayList<Long>(Arrays.asList(Long.valueOf("0"))));
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
    testService.getKeyCollectionMetadata(null).execute();
  }

  @Test
  public void testCreateKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
    String createKeyPath = "/api/v2/keys";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateKeyOptions model
    CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
            .bluemixInstance("testString")
            .createKeyOneOf(TestUtilities.createMockStream("This is a mock file."))
            .correlationId("testString")
            .prefer("return=representation")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Key> response = testService.createKey(createKeyOptionsModel).execute();
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

  @Test
  public void testCreateKeyWithoutSomeOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
    String createKeyPath = "/api/v2/keys";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateKeyOptions model
    CreateKeyOptions createKeyOptionsModel = new CreateKeyOptions.Builder()
            .bluemixInstance("testString")
            .createKeyOneOf(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Key> response = testService.createKey(createKeyOptionsModel).execute();
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
    testService.createKey(null).execute();
  }

  @Test
  public void testGetKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}}]}";
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
            .limit(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .state(new ArrayList<Long>(Arrays.asList(Long.valueOf("0"))))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeys> response = testService.getKeys(getKeysOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(new ArrayList<Long>(Arrays.asList(Long.valueOf(query.get("state")))), new ArrayList<Long>(Arrays.asList(Long.valueOf("0"))));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeysPath);
  }

  @Test
  public void testGetKeysWithoutOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}}]}";
    String getKeysPath = "/api/v2/keys";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetKeysOptions model
    GetKeysOptions getKeysOptionsModel = new GetKeysOptions.Builder()
            .bluemixInstance("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeys> response = testService.getKeys(getKeysOptionsModel).execute();
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
    assertNull(query);
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
    testService.getKeys(null).execute();
  }

  @Test
  public void testGetKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKey> response = testService.getKey(getKeyOptionsModel).execute();
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

  @Test
  public void testGetKeyWithoutCoID() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKey> response = testService.getKey(getKeyOptionsModel).execute();
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
    testService.getKey(null).execute();
  }

  @Test
  public void testActionOnKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}}";
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
            .action("wrap")
            .keyActionOneOf(TestUtilities.createMockStream("This is a mock file."))
            .correlationId("testString")
            .prefer("return=representation")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<KeyActionOneOfResponse> response = testService.actionOnKey(actionOnKeyOptionsModel).execute();
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
    assertEquals(query.get("action"), "wrap");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, actionOnKeyPath);
  }

  @Test
  public void testActionOnKeyWithoutOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"plaintext\": \"plaintext\", \"ciphertext\": \"ciphertext\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}}";
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
            .action("wrap")
            .keyActionOneOf(TestUtilities.createMockStream("This is a mock file."))
            //.correlationId("testString")
            //.prefer("return=representation")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<KeyActionOneOfResponse> response = testService.actionOnKey(actionOnKeyOptionsModel).execute();
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
    assertEquals(query.get("action"), "wrap");
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
    testService.actionOnKey(null).execute();
  }

  @Test
  public void testDeleteKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
            .prefer("return=representation")
            .force(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteKey> response = testService.deleteKey(deleteKeyOptionsModel).execute();
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

  @Test
  public void testDeleteKeyWithoutOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteKey> response = testService.deleteKey(deleteKeyOptionsModel).execute();
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
    assertNull(query);
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
    testService.deleteKey(null).execute();
  }

  @Test
  public void testGetKeyMetadataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyMetadata> response = testService.getKeyMetadata(getKeyMetadataOptionsModel).execute();
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

  @Test
  public void testGetKeyMetadataWithoutCoID() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyMetadata> response = testService.getKeyMetadata(getKeyMetadataOptionsModel).execute();
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
    testService.getKeyMetadata(null).execute();
  }

  @Test
  public void testGetKeyVersionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}]}";
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
            .limit(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeyVersions> response = testService.getKeyVersions(getKeyVersionsOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getKeyVersionsPath);
  }

  @Test
  public void testGetKeyVersionsWithoutOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListKeyVersions> response = testService.getKeyVersions(getKeyVersionsOptionsModel).execute();
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
    assertNull(query);
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
    testService.getKeyVersions(null).execute();
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
    testService = null;
  }
}