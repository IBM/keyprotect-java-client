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
import com.ibm.cloud.ibm_key_protect_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
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
import java.util.*;

import static org.mockito.Mockito.mock;
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
   * Positive Test - construct the service with a key ring ID but no service name
   */
  @Test
  public void testConstructorWithKeyRing() throws Throwable {
    Authenticator authenticator = mock(Authenticator.class);
    IbmKeyProtectApi sampleTestService = IbmKeyProtectApi.newInstance(authenticator, "testKeyRingId");
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

  /**
   * Positive Test - construct the service with a key ring ID and retry params.
   */
  @Test
  public void testConstructorWithKeyRingAndRetryParams() throws Throwable {
    Authenticator authenticator = mock(Authenticator.class);
    IbmKeyProtectApi sampleTestService = IbmKeyProtectApi.newInstance(authenticator, "testKeyRingId",
            4, 30L);
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
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00\", \"restoreAllowed\": true, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}}]}";
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
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00\", \"restoreAllowed\": true, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00\", \"restoreAllowed\": true, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00\", \"restoreAllowed\": true}]}";
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
  public void testRestoreKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"type\": \"type\", \"id\": \"id\", \"name\": \"name\", \"aliases\": [\"aliases\"], \"description\": \"description\", \"tags\": [\"tags\"], \"state\": 0, \"expirationDate\": \"2019-01-01T12:00:00\", \"extractable\": false, \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance>:key:<key-id>\", \"imported\": true, \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"algorithmType\": \"AES\", \"algorithmMetadata\": {\"bitLength\": \"128\", \"mode\": \"CBC_PAD\"}, \"algorithmBitSize\": 128, \"algorithmMode\": \"CBC_PAD\", \"nonactiveStateReason\": 20, \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"lastRotateDate\": \"2019-01-01T12:00:00\", \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}, \"dualAuthDelete\": {\"enabled\": true, \"keySetForDeletion\": true, \"authExpiration\": \"2019-01-01T12:00:00\"}, \"deleted\": false, \"deletionDate\": \"2019-01-01T12:00:00\", \"deletedBy\": \"deletedBy\", \"restoreExpirationDate\": \"2019-01-01T12:00:00\", \"restoreAllowed\": true, \"payload\": \"VGhpcyBpcyBhbiBlbmNvZGVkIGJ5dGUgYXJyYXku\"}]}";
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
            .prefer("return=representation")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Key> response = testService.restoreKey(restoreKeyOptionsModel).execute();
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
    assertEquals(parsedPath, restoreKeyPath);
  }

  // Test the restoreKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRestoreKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.restoreKey(null).execute();
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

  @Test
  public void testGetRegistrationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"keyId\": \"84a53643-9ca8-4ff2-9c68-d7842526167b\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/<account-id>:<service-instance>:bucket:<bucket-name>\", \"createdBy\": \"examplecreator@ibm.com\", \"creationDate\": \"2019-01-01T12:00:00\", \"updatedBy\": \"exampleupdater@ibm.com\", \"lastUpdated\": \"2019-01-01T12:00:00\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": true, \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}}]}";
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
            .limit(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*")
            .preventKeyDeletion(true)
            .totalCount(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<RegistrationWithTotalCount> response = testService.getRegistrations(getRegistrationsOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
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
    testService.getRegistrations(null).execute();
  }

  @Test
  public void testGetRegistrationsAllKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1, \"totalCount\": 1}, \"resources\": [{\"keyId\": \"84a53643-9ca8-4ff2-9c68-d7842526167b\", \"keyName\": \"Example Key Name\", \"resourceCrn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/<account-id>:<service-instance>:bucket:<bucket-name>\", \"createdBy\": \"examplecreator@ibm.com\", \"creationDate\": \"2019-01-01T12:00:00\", \"updatedBy\": \"exampleupdater@ibm.com\", \"lastUpdated\": \"2019-01-01T12:00:00\", \"description\": \"Example description\", \"registrationMetadata\": \"us-south\", \"preventKeyDeletion\": true, \"keyVersion\": {\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creationDate\": \"2019-01-01T12:00:00\"}}]}";
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
            .urlEncodedResourceCrnQuery("crn%3Av1%3Abluemix%3Apublic%3Adatabases-for-postgresql%3Aus-south%3Aa%2F274074dce64e9c423ffc238516c755e1%3A29caf0e7-120f-4da8-9551-3abf57ebcfc7%3A*%3A*")
            .limit(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .preventKeyDeletion(true)
            .totalCount(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<RegistrationWithTotalCount> response = testService.getRegistrationsAllKeys(getRegistrationsAllKeysOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
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
    testService.getRegistrationsAllKeys(null).execute();
  }

  @Test
  public void testPutPolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance:policy:<policy-id>\", \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"updatedBy\": \"updatedBy\", \"type\": \"application/vnd.ibm.kms.policy+json\", \"dualAuthDelete\": {\"enabled\": true}}]}";
    String putPolicyPath = "/api/v2/keys/testString/policies";

    server.enqueue(new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the KeyPolicyDualAuthDeleteDualAuthDelete model
    KeyPolicyDualAuthDeleteDualAuthDelete keyPolicyDualAuthDeleteDualAuthDeleteModel = new KeyPolicyDualAuthDeleteDualAuthDelete.Builder()
            .enabled(true)
            .build();

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
            .collectionType("application/vnd.ibm.kms.crn+json")
            .collectionTotal(Long.valueOf("1"))
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
            .id("testString")
            .bluemixInstance("testString")
            .setKeyPoliciesOneOf(setKeyPoliciesOneOfModel)
            .correlationId("testString")
            .policy("dualAuthDelete")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyPoliciesOneOf> response = testService.putPolicy(putPolicyOptionsModel).execute();
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
    testService.putPolicy(null).execute();
  }

  @Test
  public void testGetPolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:kms:<region>:a/<account-id>:<service-instance:policy:<policy-id>\", \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"lastUpdateDate\": \"2019-01-01T12:00:00\", \"updatedBy\": \"updatedBy\", \"type\": \"application/vnd.ibm.kms.policy+json\", \"dualAuthDelete\": {\"enabled\": true}}]}";
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
            .policy("dualAuthDelete")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GetKeyPoliciesOneOf> response = testService.getPolicy(getPolicyOptionsModel).execute();
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
    testService.getPolicy(null).execute();
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

    // Construct an instance of the InstancePolicyAllowedNetworkPolicyDataAttributes model
    InstancePolicyAllowedNetworkPolicyDataAttributes instancePolicyAllowedNetworkPolicyDataAttributesModel = new InstancePolicyAllowedNetworkPolicyDataAttributes.Builder()
            .allowedNetwork("public-and-private")
            .build();

    // Construct an instance of the InstancePolicyAllowedNetworkPolicyData model
    InstancePolicyAllowedNetworkPolicyData instancePolicyAllowedNetworkPolicyDataModel = new InstancePolicyAllowedNetworkPolicyData.Builder()
            .enabled(true)
            .attributes(instancePolicyAllowedNetworkPolicyDataAttributesModel)
            .build();

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
            .collectionType("application/vnd.ibm.kms.crn+json")
            .collectionTotal(Long.valueOf("1"))
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
            .bluemixInstance("testString")
            .setInstancePoliciesOneOf(setInstancePoliciesOneOfModel)
            .correlationId("testString")
            .policy("allowedNetwork")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.putInstancePolicy(putInstancePolicyOptionsModel).execute();
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
    testService.putInstancePolicy(null).execute();
  }

  @Test
  public void testGetInstancePolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\", \"updatedBy\": \"updatedBy\", \"lastUpdated\": \"2019-01-01T12:00:00\", \"policy_type\": \"policyType\", \"policy_data\": {\"enabled\": true, \"attributes\": {\"allowed_network\": \"public-and-private\"}}}]}";
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
    Response<GetInstancePoliciesOneOf> response = testService.getInstancePolicy(getInstancePolicyOptionsModel).execute();
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
    testService.getInstancePolicy(null).execute();
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
    Response<AllowedIPPort> response = testService.getAllowedIPPort(getAllowedIpPortOptionsModel).execute();
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
    testService.getAllowedIPPort(null).execute();
  }


  @Test
  public void testCreateKeyAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"keyId\": \"84a53643-9ca8-4ff2-9c68-d7842526167b\", \"alias\": \"Example-test-key\", \"createdBy\": \"...\", \"creationDate\": \"2019-01-01T12:00:00\"}]}";
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<KeyAlias> response = testService.createKeyAlias(createKeyAliasOptionsModel).execute();
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
    testService.createKeyAlias(null).execute();
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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteKeyAlias(deleteKeyAliasOptionsModel).execute();
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
    testService.deleteKeyAlias(null).execute();
  }

  @Test
  public void testListKeyRingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"collectionType\": \"application/vnd.ibm.kms.crn+json\", \"collectionTotal\": 1}, \"resources\": [{\"id\": \"id\", \"creationDate\": \"2019-01-01T12:00:00\", \"createdBy\": \"createdBy\"}]}";
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
    Response<ListKeyRings> response = testService.listKeyRings(listKeyRingsOptionsModel).execute();
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
    testService.listKeyRings(null).execute();
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
    Response<KeyRing> response = testService.createKeyRing(createKeyRingOptionsModel).execute();
    assertNotNull(response);
    KeyRing responseObj = response.getResult();
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
    testService.createKeyRing(null).execute();
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
    Response<KeyRing> response = testService.deleteKeyRing(deleteKeyRingOptionsModel).execute();
    assertNotNull(response);
    KeyRing responseObj = response.getResult();
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
    testService.deleteKeyRing(null).execute();
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