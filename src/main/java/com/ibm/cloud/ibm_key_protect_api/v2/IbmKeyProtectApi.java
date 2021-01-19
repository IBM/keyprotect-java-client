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

import com.google.gson.JsonObject;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.EventAcknowledgeOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePoliciesOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstancePolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyCollectionMetadataOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyMetadata;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyMetadataOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyPoliciesOneOf;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeyVersionsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsAllKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.Key;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponse;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyProtectException;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyVersions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeys;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PostImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutInstancePolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RestoreKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RetryInterceptor;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AddHeaderInterceptor;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AllowedIPPort;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetAllowedIPPortOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyAliasOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyAliasOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyAlias;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRings;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRingsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyRing;
import com.ibm.cloud.key_protect.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.util.Map;
import java.util.Map.Entry;


/**
 * IBM Key Protect helps you provision encrypted keys for apps across IBM Cloud. As you manage the lifecycle of your
 * keys, you can benefit from knowing that your keys are secured by cloud-based FIPS 140-2 Level 3 hardware security
 * modules (HSMs) that protect against theft of information. You can use the Key Protect API to store, generate, and
 * retrieve your key material. Keys within the service can protect any type of data in your symmetric key based
 * encryption solution.
 *
 * @version v2
 */
public class IbmKeyProtectApi extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "ibm_key_protect_api";
  public static final int  DEFAULT_MAX_RETRY = 4;
  public static final long DEFAULT_RETRY_MAX_INTERVAL = 30L;


  /**
   * Class method which constructs an instance of the `IbmKeyProtectApi` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `IbmKeyProtectApi` client using external configuration
   */
  public static IbmKeyProtectApi newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `IbmKeyProtectApi` client.
   * The default service name is used to configure the client instance.
   * The specified authenticator is used to configure the client instance.
   *
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   * @return an instance of the `IbmKeyProtectApi` client using external configuration
   */
  public static IbmKeyProtectApi newInstance(Authenticator authenticator) {
    IbmKeyProtectApi service =  new IbmKeyProtectApi(DEFAULT_SERVICE_NAME, authenticator);
    service.configureService(DEFAULT_SERVICE_NAME);
    return service;
  }

  /**
   * Class method which constructs an instance of the `IbmKeyProtectApi` client.
   * The default service name is used to configure the client instance.
   * The specified authenticator is used to configure the client instance.
   *  The specified retry attempts and intervals can be passed
   *  @param authenticator the {@link Authenticator} instance to be configured for this client
   *  @param maxRetry maximum number of retry attempts for failed HTTP requests
   *  @param retryMaxInterval maximum time interval between two subsequent retries
   *  @return an instance of the `IbmKeyProtectApi` client using external configuration
   */
  public static IbmKeyProtectApi newInstance(Authenticator authenticator, int maxRetry, long retryMaxInterval) {
    IbmKeyProtectApi service =  new IbmKeyProtectApi(DEFAULT_SERVICE_NAME, authenticator, maxRetry, retryMaxInterval);
    service.configureService(DEFAULT_SERVICE_NAME);
    return service;
  }

  /**
   * Class method which constructs an instance of the `IbmKeyProtectApi` client.
   * The default service name is used to configure the client instance.
   * The specified authenticator is used to configure the client instance.
   * The specified key ring ID is used to configure the client instance.
   *  @param authenticator the {@link Authenticator} instance to be configured for this client
   *  @param keyRingId identifier of the key ring belongs to the instance
   *  @return an instance of the `IbmKeyProtectApi` client using external configuration
   */
  public static IbmKeyProtectApi newInstance(Authenticator authenticator, String keyRingId) {
    IbmKeyProtectApi service =  new IbmKeyProtectApi(DEFAULT_SERVICE_NAME, authenticator, keyRingId);
    service.configureService(DEFAULT_SERVICE_NAME);
    return service;
  }

  /**
   * Class method which constructs an instance of the `IbmKeyProtectApi` client.
   * The default service name is used to configure the client instance.
   * The specified authenticator is used to configure the client instance.
   * The specified key ring ID is used to configure the client instance.
   * The specified retry attempts and intervals can be passed
   *  @param authenticator the {@link Authenticator} instance to be configured for this client
   *  @param keyRingId identifier of the key ring belongs to the instance
   *  @param maxRetry maximum number of retry attempts for failed HTTP requests
   *  @param retryMaxInterval maximum time interval between two subsequent retries
   *  @return an instance of the `IbmKeyProtectApi` client using external configuration
   */
  public static IbmKeyProtectApi newInstance(Authenticator authenticator, String keyRingId, int maxRetry, long retryMaxInterval) {
    IbmKeyProtectApi service =  new IbmKeyProtectApi(DEFAULT_SERVICE_NAME, authenticator, keyRingId, maxRetry, retryMaxInterval);
    service.configureService(DEFAULT_SERVICE_NAME);
    return service;
  }

  /**
   * Class method which constructs an instance of the `IbmKeyProtectApi` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `IbmKeyProtectApi` client using external configuration
   */
  public static IbmKeyProtectApi newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    IbmKeyProtectApi service = new IbmKeyProtectApi(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `IbmKeyProtectApi` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName   the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IbmKeyProtectApi(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    // Creating new okHttp Client with retry interceptor
    RetryInterceptor interceptor = new RetryInterceptor(DEFAULT_MAX_RETRY, DEFAULT_RETRY_MAX_INTERVAL);
    OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            //httpLogging interceptor for logging network requests
            .addInterceptor(interceptor)
            .build();
    // updating service with new client
    this.setClient(okHttpClient);
  }

  /**
   * Constructs an instance of the `IbmKeyProtectApi` client, and use the key ring in the instance
   * The specified service name, authenticator and key ring ID are used to configure the client instance.
   *
   * @param serviceName   the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   * @param keyRingId     identifier of the key ring belongs to the instance
   */
  public IbmKeyProtectApi(String serviceName, Authenticator authenticator, String keyRingId) {
    super(serviceName, authenticator);
    // Creating new okHttp Client with add header interceptor
    AddHeaderInterceptor interceptor = new AddHeaderInterceptor("x-kms-key-ring", keyRingId);
    OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build();
    // updating service with new client
    this.setClient(okHttpClient);
  }

  /**
   * Constructs an instance of the `IbmKeyProtectApi` client.
   * The specified service name, authenticator, retries and intervals are used to configure the client instance.
   *
   * @param serviceName   the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   * @param maxRetry maximum number of retry attempts for failed HTTP requests
   * @param retryMaxInterval maximum time interval between two subsequent retries
   */
  public IbmKeyProtectApi(String serviceName, Authenticator authenticator, int maxRetry, long retryMaxInterval) {
    super(serviceName, authenticator);
    // Creating new okHttp Client with retry interceptor
    RetryInterceptor interceptor = new RetryInterceptor(maxRetry, retryMaxInterval);
    OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build();
    // updating service with new client
    this.setClient(okHttpClient);
  }

  /**
   * Constructs an instance of the `IbmKeyProtectApi` client.
   * The specified service name, authenticator, key ring ID, retries and intervals are used to configure the client
   * instance.
   *
   * @param serviceName   the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   * @param keyRingId     identifier of the key ring belongs to the instance
   * @param maxRetry maximum number of retry attempts for failed HTTP requests
   * @param retryMaxInterval maximum time interval between two subsequent retries
   */
  public IbmKeyProtectApi(String serviceName, Authenticator authenticator, String keyRingId, int maxRetry,
                          long retryMaxInterval) {
    super(serviceName, authenticator);
    // Creating new okHttp Client with retry interceptor and header interceptor
    RetryInterceptor retryInterceptor = new RetryInterceptor(maxRetry, retryMaxInterval);
    AddHeaderInterceptor headerInterceptor = new AddHeaderInterceptor("x-kms-key-ring", keyRingId);
    OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(retryInterceptor)
            .addInterceptor(headerInterceptor)
            .build();
    // updating service with new client
    this.setClient(okHttpClient);
  }

  @Override
  protected <T> T processServiceCall(ResponseConverter<T> converter, Response response) {
    if (response.isSuccessful()) {
      return converter.convert(response);
    } else
      throw new KeyProtectException(response.code(), response);
  }

  /**
   * Create an import token.
   * <p>
   * Creates an import token that you can use to encrypt and import root keys into the service. [Learn
   * more](/docs/key-protect?topic=key-protect-importing-keys#using-import-tokens) When you call `POST /import_token`,
   * Key Protect creates an RSA key-pair from its HSMs. The service encrypts and stores the private key in the HSM, and
   * returns the corresponding public key when you call `GET /import_token`. You can create only one import token per
   * service instance.
   *
   * @param postImportTokenOptions the {@link PostImportTokenOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ImportToken}
   */
  public ServiceCall<ImportToken> postImportToken(PostImportTokenOptions postImportTokenOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postImportTokenOptions,
            "postImportTokenOptions cannot be null");
    String[] pathSegments = {"api/v2/import_token"};
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "postImportToken");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", postImportTokenOptions.bluemixInstance());
    if (postImportTokenOptions.correlationId() != null) {
      builder.header("Correlation-Id", postImportTokenOptions.correlationId());
    }
    final JsonObject contentJson = new JsonObject();
    if (postImportTokenOptions.expiration() != null) {
      contentJson.addProperty("expiration", postImportTokenOptions.expiration());
    }
    if (postImportTokenOptions.maxAllowedRetrievals() != null) {
      contentJson.addProperty("maxAllowedRetrievals", postImportTokenOptions.maxAllowedRetrievals());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ImportToken> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ImportToken>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve an import token.
   * <p>
   * Retrieves the import token that is associated with your service instance. When you call `GET /import_token`, Key
   * Protect returns the public key that you can use to encrypt and import key material to the service, along with
   * details about the key.
   * **Note:** After you reach the `maxAllowedRetrievals` or `expirationDate` for the import token, the import token and
   * its associated public key can no longer be used for key operations. To create a new import token, use `POST
   * /import_token`.
   *
   * @param getImportTokenOptions the {@link GetImportTokenOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetImportToken}
   */
  public ServiceCall<GetImportToken> getImportToken(GetImportTokenOptions getImportTokenOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getImportTokenOptions,
            "getImportTokenOptions cannot be null");
    String[] pathSegments = {"api/v2/import_token"};
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getImportToken");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getImportTokenOptions.bluemixInstance());
    if (getImportTokenOptions.correlationId() != null) {
      builder.header("Correlation-Id", getImportTokenOptions.correlationId());
    }
    ResponseConverter<GetImportToken> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetImportToken>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Acknowledge key events.
   * <p>
   * **Service to service calls only.** Acknowledges a key lifecycle event.
   * When a customer performs an action on a root key, Key Protect uses  Hyperwarp to notify the cloud services that
   * are registered with the  key. To acknowledge the Hyperwarp event, registered services must  call `POST
   * /api/v2/event_ack`.
   *
   * @param eventAcknowledgeOptions the {@link EventAcknowledgeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> eventAcknowledge(EventAcknowledgeOptions eventAcknowledgeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(eventAcknowledgeOptions,
            "eventAcknowledgeOptions cannot be null");
    String[] pathSegments = {"api/v2/event_ack"};
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "eventAcknowledge");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", eventAcknowledgeOptions.bluemixInstance());
    if (eventAcknowledgeOptions.correlationId() != null) {
      builder.header("Correlation-Id", eventAcknowledgeOptions.correlationId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("EventAcknowledge", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(eventAcknowledgeOptions.eventAcknowledge()));
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve key total.
   * <p>
   * Returns the same HTTP headers as a GET request without returning the entity-body. This operation returns the number
   * of keys in your instance in a header called `Key-Total`.
   *
   * @param getKeyCollectionMetadataOptions the {@link GetKeyCollectionMetadataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getKeyCollectionMetadata(GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyCollectionMetadataOptions,
            "getKeyCollectionMetadataOptions cannot be null");
    String[] pathSegments = {"api/v2/keys"};
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeyCollectionMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", getKeyCollectionMetadataOptions.bluemixInstance());
    if (getKeyCollectionMetadataOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyCollectionMetadataOptions.correlationId());
    }
    if (getKeyCollectionMetadataOptions.state() != null) {
      builder.query("state", RequestUtils.join(getKeyCollectionMetadataOptions.state(), ","));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a key.
   * <p>
   * Creates a new key with specified key material.
   * Key Protect designates the resource as either a root key or a standard key based on the `extractable` value
   * that you specify. A successful `POST /keys` operation adds the key to the service and  returns the details of the
   * request in the response entity-body, if the Prefer header is set to  `return=representation`.
   *
   * @param createKeyOptions the {@link CreateKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Key}
   */
  public ServiceCall<Key> createKey(CreateKeyOptions createKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyOptions,
            "createKeyOptions cannot be null");
    String[] pathSegments = {"api/v2/keys"};
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createKeyOptions.bluemixInstance());
    if (createKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKeyOptions.correlationId());
    }
    if (createKeyOptions.prefer() != null) {
      builder.header("Prefer", createKeyOptions.prefer());
    }
    builder.bodyContent(createKeyOptions.createKeyOneOf(), "application/vnd.ibm.kms.key+json");
    ResponseConverter<Key> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Key>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List keys.
   * <p>
   * Retrieves a list of keys that are stored in your Key Protect service instance.
   * <p>
   * **Note:** `GET /keys` will not return the key material in the response body. You can retrieve the key material for
   * a standard key with a subsequent `GET /keys/{id}` request.
   *
   * @param getKeysOptions the {@link GetKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKeys}
   */
  public ServiceCall<ListKeys> getKeys(GetKeysOptions getKeysOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeysOptions,
            "getKeysOptions cannot be null");
    String[] pathSegments = {"api/v2/keys"};
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeysOptions.bluemixInstance());
    if (getKeysOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeysOptions.correlationId());
    }
    if (getKeysOptions.limit() != null) {
      builder.query("limit", String.valueOf(getKeysOptions.limit()));
    }
    if (getKeysOptions.offset() != null) {
      builder.query("offset", String.valueOf(getKeysOptions.offset()));
    }
    if (getKeysOptions.state() != null) {
      builder.query("state", RequestUtils.join(getKeysOptions.state(), ","));
    }
    ResponseConverter<ListKeys> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKeys>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a key.
   *
   * Retrieves a key and its details by specifying the ID or alias of the key.
   *
   * @param getKeyOptions the {@link GetKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKey}
   */
  public ServiceCall<GetKey> getKey(GetKeyOptions getKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyOptions,
            "getKeyOptions cannot be null");
    String[] pathSegments = { "api/v2/keys" };
    String[] pathParameters = { getKeyOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeyOptions.bluemixInstance());
    if (getKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyOptions.correlationId());
    }
    ResponseConverter<GetKey> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Invoke an action on a key.
   * <p>
   * Invokes an action on a specified key. This method supports the following actions:
   * <p>
   * - `wrap`: Use a root key to [wrap or encrypt a data encryption key](/docs/key-protect?topic=key-protect-wrap-keys)
   * - `unwrap`: Use a root key to [unwrap or decrypt a data encryption
   * key](/docs/key-protect?topic=key-protect-unwrap-keys)
   * - `rewrap`: Use a root key to [rewrap or reencrypt a data encryption
   * key](/docs/key-protect?topic=key-protect-rewrap-keys)
   * - `rotate`: [Create a new version](/docs/key-protect?topic=key-protect-rotate-keys) of a root key
   * - `disable`: [Disable operations](/docs/key-protect?topic=key-protect-disable-keys) for a key
   * - `enable`: [Enable operations](/docs/key-protect?topic=key-protect-disable-keys#enable-api) for a key
   * - `setKeyDeletion`: [Authorize
   * deletion](/docs/key-protect?topic=key-protect-delete-dual-auth-keys#set-key-deletion-api) for a key with a dual
   * authorization policy
   * - `unsetKeyDeletion`: [Remove an
   * authorization]((/docs/key-protect?topic=key-protect-delete-dual-auth-keys#unset-key-deletion-api) for a key with a
   * dual authorization policy
   * - `restore`: [Restore a previously imported root key](/docs/key-protect?topic=key-protect-restore-keys)
   * <p>
   * **Note:** When you unwrap a wrapped data encryption key (WDEK) by using a rotated root key, the service returns a
   * new ciphertext in the response entity-body. Each ciphertext remains available for `unwrap` actions. If you unwrap a
   * DEK with a previous ciphertext, the service also returns the latest ciphertext and latest key version in the
   * response.  Use the latest ciphertext for future unwrap operations.
   *
   * @param actionOnKeyOptions the {@link ActionOnKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link KeyActionOneOfResponse}
   */
  public ServiceCall<KeyActionOneOfResponse> actionOnKey(ActionOnKeyOptions actionOnKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(actionOnKeyOptions,
            "actionOnKeyOptions cannot be null");
    String[] pathSegments = {"api/v2/keys"};
    String[] pathParameters = {actionOnKeyOptions.id()};
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "actionOnKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", actionOnKeyOptions.bluemixInstance());
    if (actionOnKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", actionOnKeyOptions.correlationId());
    }
    if (actionOnKeyOptions.prefer() != null) {
      builder.header("Prefer", actionOnKeyOptions.prefer());
    }
    builder.query("action", actionOnKeyOptions.action());
    if (actionOnKeyOptions.keyActionOneOf() != null) {
      builder.bodyContent(actionOnKeyOptions.keyActionOneOf(), "application/vnd.ibm.kms.key_action+json");
    }
    ResponseConverter<KeyActionOneOfResponse> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<KeyActionOneOfResponse>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a key.
   * <p>
   * Deletes a key by specifying the ID of the key.
   * By default, Key Protect requires a single authorization to delete keys. For added protection,  you can [enable a
   * dual authorization policy](#set-key-policies) to  safely delete keys from your service instance.
   * <p>
   * **Important:** When you delete a key, you permanently shred its contents and associated data. The action cannot be
   * reversed.
   * <p>
   * **Note:** By default, Key Protect blocks the deletion of a key that's protecting a cloud resource, such as a  Cloud
   * Object Storage bucket. Use `GET keys/{id}/registrations` to verify if the key has an active registration to a
   * resource. To delete the key and its associated registrations, set the optional `force` parameter to `true`.
   *
   * @param deleteKeyOptions the {@link DeleteKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteKey}
   */
  public ServiceCall<DeleteKey> deleteKey(DeleteKeyOptions deleteKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKeyOptions,
            "deleteKeyOptions cannot be null");
    String[] pathSegments = {"api/v2/keys"};
    String[] pathParameters = {deleteKeyOptions.id()};
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", deleteKeyOptions.bluemixInstance());
    if (deleteKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKeyOptions.correlationId());
    }
    if (deleteKeyOptions.prefer() != null) {
      builder.header("Prefer", deleteKeyOptions.prefer());
    }
    if (deleteKeyOptions.force() != null) {
      builder.query("force", String.valueOf(deleteKeyOptions.force()));
    }
    ResponseConverter<DeleteKey> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteKey>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve key metadata.
   * <p>
   * Retrieves the details of a key by specifying the ID of the key.
   *
   * @param getKeyMetadataOptions the {@link GetKeyMetadataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKeyMetadata}
   */
  public ServiceCall<GetKeyMetadata> getKeyMetadata(GetKeyMetadataOptions getKeyMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyMetadataOptions,
            "getKeyMetadataOptions cannot be null");
    String[] pathSegments = {"api/v2/keys", "metadata"};
    String[] pathParameters = {getKeyMetadataOptions.id()};
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeyMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeyMetadataOptions.bluemixInstance());
    if (getKeyMetadataOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyMetadataOptions.correlationId());
    }
    ResponseConverter<GetKeyMetadata> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetKeyMetadata>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Restore a Key.
   *
   * [Restore a previously imported root key](/docs/key-protect?topic=key-protect-restore-keys).
   *
   * @param restoreKeyOptions the {@link RestoreKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Key}
   */
  public ServiceCall<Key> restoreKey(RestoreKeyOptions restoreKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(restoreKeyOptions,
            "restoreKeyOptions cannot be null");
    String[] pathSegments = { "api/v2/keys", "restore" };
    String[] pathParameters = { restoreKeyOptions.id() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "restoreKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/vnd.ibm.kms.key+json");
    builder.header("Bluemix-Instance", restoreKeyOptions.bluemixInstance());
    if (restoreKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", restoreKeyOptions.correlationId());
    }
    if (restoreKeyOptions.prefer() != null) {
      builder.header("Prefer", restoreKeyOptions.prefer());
    }
    if (restoreKeyOptions.keyRestoreBody() != null) {
      builder.bodyContent(restoreKeyOptions.keyRestoreBody(), "application/vnd.ibm.kms.key_action_restore+json");
    }
    ResponseConverter<Key> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Key>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List key versions.
   * <p>
   * Retrieves all versions of a root key by specifying the ID of the key.
   * When you rotate a root key, you generate a new version of the key. If you're using the root key to protect
   * resources across IBM Cloud, the registered cloud services that you associate with the key use the latest  key
   * version to wrap your data. [Learn more](/docs/key-protect?topic=key-protect-key-rotation).
   *
   * @param getKeyVersionsOptions the {@link GetKeyVersionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKeyVersions}
   */
  public ServiceCall<ListKeyVersions> getKeyVersions(GetKeyVersionsOptions getKeyVersionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyVersionsOptions,
            "getKeyVersionsOptions cannot be null");
    String[] pathSegments = {"api/v2/keys", "versions"};
    String[] pathParameters = {getKeyVersionsOptions.id()};
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeyVersions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeyVersionsOptions.bluemixInstance());
    if (getKeyVersionsOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyVersionsOptions.correlationId());
    }
    if (getKeyVersionsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getKeyVersionsOptions.limit()));
    }
    if (getKeyVersionsOptions.offset() != null) {
      builder.query("offset", String.valueOf(getKeyVersionsOptions.offset()));
    }
    ResponseConverter<ListKeyVersions> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKeyVersions>() {
            }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List registrations for a key.
   *
   * Retrieves a list of registrations that are associated with a specified root key.
   *    When you use a root key to protect an IBM Cloud resource, such as a Cloud Object Storage bucket, Key Protect
   * creates a registration between the resource and root key. You can use `GET /keys/{id}/registrations` to  understand
   * which cloud resources are protected by the key that you specify.
   *
   * @param getRegistrationsOptions the {@link GetRegistrationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RegistrationWithTotalCount}
   */
  public ServiceCall<RegistrationWithTotalCount> getRegistrations(GetRegistrationsOptions getRegistrationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRegistrationsOptions,
            "getRegistrationsOptions cannot be null");
    String[] pathSegments = { "api/v2/keys", "registrations" };
    String[] pathParameters = { getRegistrationsOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getRegistrations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getRegistrationsOptions.bluemixInstance());
    if (getRegistrationsOptions.correlationId() != null) {
      builder.header("Correlation-Id", getRegistrationsOptions.correlationId());
    }
    if (getRegistrationsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getRegistrationsOptions.limit()));
    }
    if (getRegistrationsOptions.offset() != null) {
      builder.query("offset", String.valueOf(getRegistrationsOptions.offset()));
    }
    if (getRegistrationsOptions.urlEncodedResourceCrnQuery() != null) {
      builder.query("urlEncodedResourceCRNQuery", getRegistrationsOptions.urlEncodedResourceCrnQuery());
    }
    if (getRegistrationsOptions.preventKeyDeletion() != null) {
      builder.query("preventKeyDeletion", String.valueOf(getRegistrationsOptions.preventKeyDeletion()));
    }
    if (getRegistrationsOptions.totalCount() != null) {
      builder.query("totalCount", String.valueOf(getRegistrationsOptions.totalCount()));
    }
    ResponseConverter<RegistrationWithTotalCount> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RegistrationWithTotalCount>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List registrations for any key.
   *
   * Retrieves a list of registrations that match the Cloud Resource Name (CRN) query that you specify.
   *    When you use a root key to protect an IBM Cloud resource, such as a Cloud Object Storage bucket, Key Protect
   * creates a registration between the resource and root key. You can use `GET /keys/registrations` to  understand
   * which cloud resources are protected by keys in your Key Protect service instance.
   *
   * @param getRegistrationsAllKeysOptions the {@link GetRegistrationsAllKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RegistrationWithTotalCount}
   */
  public ServiceCall<RegistrationWithTotalCount> getRegistrationsAllKeys(GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRegistrationsAllKeysOptions,
            "getRegistrationsAllKeysOptions cannot be null");
    String[] pathSegments = { "api/v2/keys/registrations" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getRegistrationsAllKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getRegistrationsAllKeysOptions.bluemixInstance());
    if (getRegistrationsAllKeysOptions.correlationId() != null) {
      builder.header("Correlation-Id", getRegistrationsAllKeysOptions.correlationId());
    }
    if (getRegistrationsAllKeysOptions.urlEncodedResourceCrnQuery() != null) {
      builder.query("urlEncodedResourceCRNQuery", getRegistrationsAllKeysOptions.urlEncodedResourceCrnQuery());
    }
    if (getRegistrationsAllKeysOptions.limit() != null) {
      builder.query("limit", String.valueOf(getRegistrationsAllKeysOptions.limit()));
    }
    if (getRegistrationsAllKeysOptions.offset() != null) {
      builder.query("offset", String.valueOf(getRegistrationsAllKeysOptions.offset()));
    }
    if (getRegistrationsAllKeysOptions.preventKeyDeletion() != null) {
      builder.query("preventKeyDeletion", String.valueOf(getRegistrationsAllKeysOptions.preventKeyDeletion()));
    }
    if (getRegistrationsAllKeysOptions.totalCount() != null) {
      builder.query("totalCount", String.valueOf(getRegistrationsAllKeysOptions.totalCount()));
    }
    ResponseConverter<RegistrationWithTotalCount> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RegistrationWithTotalCount>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Set key policies.
   *
   * Creates or updates one or more policies for the specified key.
   *    You can set policies for a key, such as an [automatic rotation
   * policy](/docs/key-protect?topic=key-protect-set-rotation-policy)  or a [dual authorization
   * policy](/docs/key-protect?topic=key-protect-set-dual-auth-key-policy) to protect  against the accidental deletion
   * of keys. Use `PUT /keys/{id}/policies` to create new policies for a key or update an existing policy.
   *
   * @param putPolicyOptions the {@link PutPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKeyPoliciesOneOf}
   */
  public ServiceCall<GetKeyPoliciesOneOf> putPolicy(PutPolicyOptions putPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putPolicyOptions,
            "putPolicyOptions cannot be null");
    String[] pathSegments = { "api/v2/keys", "policies" };
    String[] pathParameters = { putPolicyOptions.id() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "putPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", putPolicyOptions.bluemixInstance());
    if (putPolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", putPolicyOptions.correlationId());
    }
    if (putPolicyOptions.policy() != null) {
      builder.query("policy", putPolicyOptions.policy());
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(putPolicyOptions.setKeyPoliciesOneOf()), "application/json");
    ResponseConverter<GetKeyPoliciesOneOf> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetKeyPoliciesOneOf>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List key policies.
   *
   * Retrieves a list of policies that are associated with a specified key.
   *    You can set policies for a key, such as an [automatic rotation
   * policy](/docs/key-protect?topic=key-protect-set-rotation-policy)  or a [dual authorization
   * policy](/docs/key-protect?topic=key-protect-set-dual-auth-key-policy) to protect  against the accidental deletion
   * of keys. Use `GET /keys/{id}/policies` to browse the policies that exist for a  specified key.
   *
   * @param getPolicyOptions the {@link GetPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKeyPoliciesOneOf}
   */
  public ServiceCall<GetKeyPoliciesOneOf> getPolicy(GetPolicyOptions getPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPolicyOptions,
            "getPolicyOptions cannot be null");
    String[] pathSegments = { "api/v2/keys", "policies" };
    String[] pathParameters = { getPolicyOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getPolicyOptions.bluemixInstance());
    if (getPolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", getPolicyOptions.correlationId());
    }
    if (getPolicyOptions.policy() != null) {
      builder.query("policy", getPolicyOptions.policy());
    }
    ResponseConverter<GetKeyPoliciesOneOf> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetKeyPoliciesOneOf>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Set instance policies.
   *
   * Creates or updates one or more policies for the specified service instance.
   *
   * **Note:** When you set an instance policy, Key Protect associates the policy information with keys that you add to
   * the instance after the policy is updated. This operation does not affect existing keys in the instance.
   *
   * @param putInstancePolicyOptions the {@link PutInstancePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> putInstancePolicy(PutInstancePolicyOptions putInstancePolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putInstancePolicyOptions,
            "putInstancePolicyOptions cannot be null");
    String[] pathSegments = { "api/v2/instance/policies" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "putInstancePolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", putInstancePolicyOptions.bluemixInstance());
    if (putInstancePolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", putInstancePolicyOptions.correlationId());
    }
    if (putInstancePolicyOptions.policy() != null) {
      builder.query("policy", putInstancePolicyOptions.policy());
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(putInstancePolicyOptions.setInstancePoliciesOneOf()), "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List instance policies.
   *
   * Retrieves a list of policies that are associated with a specified service instance. You can manage advanced
   * preferences for keys in your service instance by creating instance-level policies. Use `GET /instance/policies` to
   * browse the policies that are associated with the specified instance. Currently,   dual authorization policies are
   * supported.
   *
   * @param getInstancePolicyOptions the {@link GetInstancePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetInstancePoliciesOneOf}
   */
  public ServiceCall<GetInstancePoliciesOneOf> getInstancePolicy(GetInstancePolicyOptions getInstancePolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getInstancePolicyOptions,
            "getInstancePolicyOptions cannot be null");
    String[] pathSegments = { "api/v2/instance/policies" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getInstancePolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getInstancePolicyOptions.bluemixInstance());
    if (getInstancePolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", getInstancePolicyOptions.correlationId());
    }
    if (getInstancePolicyOptions.policy() != null) {
      builder.query("policy", getInstancePolicyOptions.policy());
    }
    ResponseConverter<GetInstancePoliciesOneOf> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetInstancePoliciesOneOf>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve Allowed IP Port.
   *
   * Retrieves the private endpoint port associated with your service instance's active allowed ip policy. If the
   * instance does not contain an active allowed ip policy, no information will be returned.
   *
   * @param getAllowedIpPortOptions the {@link GetAllowedIPPortOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllowedIPPort}
   */
  public ServiceCall<AllowedIPPort> getAllowedIPPort(GetAllowedIPPortOptions getAllowedIpPortOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAllowedIpPortOptions,
            "getAllowedIpPortOptions cannot be null");
    String[] pathSegments = { "api/v2/instance/allowed_ip_port" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getAllowedIPPort");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getAllowedIpPortOptions.bluemixInstance());
    if (getAllowedIpPortOptions.correlationId() != null) {
      builder.header("Correlation-Id", getAllowedIpPortOptions.correlationId());
    }
    ResponseConverter<AllowedIPPort> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllowedIPPort>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }


  /**
   * Create an alias.
   *
   * Creates an alias for the specified key.
   *
   * @param createKeyAliasOptions the {@link CreateKeyAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link KeyAlias}
   */
  public ServiceCall<KeyAlias> createKeyAlias(CreateKeyAliasOptions createKeyAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyAliasOptions,
            "createKeyAliasOptions cannot be null");
    String[] pathSegments = { "api/v2/keys", "aliases" };
    String[] pathParameters = { createKeyAliasOptions.id(), createKeyAliasOptions.alias() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKeyAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createKeyAliasOptions.bluemixInstance());
    if (createKeyAliasOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKeyAliasOptions.correlationId());
    }
    ResponseConverter<KeyAlias> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<KeyAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an alias.
   *
   * Deletes an alias from the associated key. Delete alias does not delete the key.
   *
   * @param deleteKeyAliasOptions the {@link DeleteKeyAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteKeyAlias(DeleteKeyAliasOptions deleteKeyAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKeyAliasOptions,
            "deleteKeyAliasOptions cannot be null");
    String[] pathSegments = { "api/v2/keys", "aliases" };
    String[] pathParameters = { deleteKeyAliasOptions.id(), deleteKeyAliasOptions.alias() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKeyAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteKeyAliasOptions.bluemixInstance());
    if (deleteKeyAliasOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKeyAliasOptions.correlationId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Key Rings.
   *
   * List all key rings in the instance.
   *
   * @param listKeyRingsOptions the {@link ListKeyRingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKeyRings}
   */
  public ServiceCall<ListKeyRings> listKeyRings(ListKeyRingsOptions listKeyRingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listKeyRingsOptions,
            "listKeyRingsOptions cannot be null");
    String[] pathSegments = { "api/v2/key_rings" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "listKeyRings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", listKeyRingsOptions.bluemixInstance());
    if (listKeyRingsOptions.correlationId() != null) {
      builder.header("Correlation-Id", listKeyRingsOptions.correlationId());
    }
    ResponseConverter<ListKeyRings> responseConverter =
            ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKeyRings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create Key Ring.
   *
   * Create a key ring in the instance with the specified name. The key ring ID `default` is a reserved key ring ID and
   * cannot be created nor destroyed. The default key ring is initial key ring that is generated with each newly created
   * instance. All keys not associated with an otherwise specified key ring exist within the default key ring.
   *
   * @param createKeyRingOptions the {@link CreateKeyRingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<KeyRing> createKeyRing(CreateKeyRingOptions createKeyRingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyRingOptions,
            "createKeyRingOptions cannot be null");
    String[] pathSegments = { "api/v2/key_rings" };
    String[] pathParameters = { createKeyRingOptions.keyRingId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKeyRing");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", createKeyRingOptions.bluemixInstance());
    if (createKeyRingOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKeyRingOptions.correlationId());
    }
    ResponseConverter<KeyRing> responseConverter = ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<KeyRing>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete Key Ring.
   *
   * Delete the key ring from the instance. key ring ID `default` cannot be destroyed. Currently, only key rings with 0
   * (zero) keys, in any state [Active (1), Suspended (2), Deactivated (3), Destroyed (5)], may be deleted.
   *
   * @param deleteKeyRingOptions the {@link DeleteKeyRingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<KeyRing> deleteKeyRing(DeleteKeyRingOptions deleteKeyRingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKeyRingOptions,
            "deleteKeyRingOptions cannot be null");
    String[] pathSegments = { "api/v2/key_rings" };
    String[] pathParameters = { deleteKeyRingOptions.keyRingId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKeyRing");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteKeyRingOptions.bluemixInstance());
    if (deleteKeyRingOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKeyRingOptions.correlationId());
    }
    ResponseConverter<KeyRing> responseConverter = ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<KeyRing>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }
}

