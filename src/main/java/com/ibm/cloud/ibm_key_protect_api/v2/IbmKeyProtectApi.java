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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.78.0-67aec9b7-20230818-174940
 */

package com.ibm.cloud.ibm_key_protect_api.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.common.SdkCommon;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ActionOnRegistrationResponse;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AddKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.AllowedIPPort;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CIPResource;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyAliasOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKeyWithPoliciesOverridesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateMigrationIntentOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CreateRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.CryptoV2GetInstanceEndpointsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyAliasOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKeyRingOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteMigrationIntentOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DeleteRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.DisableKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.EnableKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.EventAcknowledgeOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetAllowedIPPortOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetGovernanceConfigOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetInstanceEndpointInfo;
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
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipAdapterOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipAdaptersOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipClientCertificateOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetKmipClientCertificatesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetMigrationIntent;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetMigrationIntentOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsAllKeysOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.GetRegistrationsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ImportToken;
import com.ibm.cloud.ibm_key_protect_api.v2.model.Key;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyActionOneOfResponse;
import com.ibm.cloud.ibm_key_protect_api.v2.model.KeyAlias;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPAdapters;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPAdaptersWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPClientCertificates;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKMIPPartialClientCertificatesWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRingsOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyRingsWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeyVersions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ListKeys;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PatchKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PatchKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PostImportTokenOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PurgeKey;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PurgeKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutInstancePolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.PutPolicyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.Registration;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RegistrationWithTotalCount;
import com.ibm.cloud.ibm_key_protect_api.v2.model.ReplaceRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RestoreKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RewrapKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RewrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.RotateKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SetKeyForDeletionOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.SyncAssociatedResourcesOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UnsetKeyForDeletionOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UnwrapKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UnwrapKeyResponseBody;
import com.ibm.cloud.ibm_key_protect_api.v2.model.UpdateRegistrationOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.WrapKeyOptions;
import com.ibm.cloud.ibm_key_protect_api.v2.model.WrapKeyResponseBody;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * IBM Key Protect helps you provision encrypted keys for apps across IBM Cloud. As you manage the lifecycle of your
 * keys, you can benefit from knowing that your keys are secured by cloud-based FIPS 140-2 Level 3 hardware security
 * modules (HSMs) that protect against theft of information. You can use the Key Protect API to store, generate, and
 * retrieve your key material. Keys within the service can protect any type of data in your symmetric key-based
 * encryption solution.
 *
 * API Version: 2.0.0
 */
public class IbmKeyProtectApi extends BaseService {
  private static final Logger LOGGER = Logger.getLogger(IbmKeyProtectApi.class.getName());

  /**
   * Default service name used when configuring the `IbmKeyProtectApi` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "ibm_key_protect_api";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://us-south.kms.cloud.ibm.com";

  /**
   * The parameterized service endpoint URL.
   */
  public static final String PARAMETERIZED_SERVICE_URL = "https://{region}.kms.cloud.ibm.com";

  private static final Map<String, String> defaultUrlVariables = createDefaultUrlVariables();

  private static Map<String, String> createDefaultUrlVariables() {
    Map<String, String> map = new HashMap<>();
    map.put("region", "us-south");
    return map;
  }

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
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IbmKeyProtectApi(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Constructs a service URL by formatting the parameterized service URL.
   *
   * The parameterized service URL is:
   * 'https://{region}.kms.cloud.ibm.com'
   *
   * The default variable values are:
   * - 'region': 'us-south'
   *
   * @param providedUrlVariables map from variable names to desired values.
   *   If a variable is not provided in this map,
   *   the default variable value will be used instead.
   * @return the formatted URL with all variable placeholders replaced by values.
   */
  public static String constructServiceUrl(Map<String, String> providedUrlVariables) {
    return BaseService.constructServiceUrl(PARAMETERIZED_SERVICE_URL, defaultUrlVariables, providedUrlVariables);
  }

  /**
   * Create an alias.
   *
   * Creates a unique alias for the specified key.
   *
   * @param createKeyAliasOptions the {@link CreateKeyAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link KeyAlias}
   */
  public ServiceCall<KeyAlias> createKeyAlias(CreateKeyAliasOptions createKeyAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyAliasOptions,
      "createKeyAliasOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", createKeyAliasOptions.id());
    pathParamsMap.put("alias", createKeyAliasOptions.alias());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/aliases/{alias}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKeyAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createKeyAliasOptions.bluemixInstance());
    if (createKeyAliasOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKeyAliasOptions.correlationId());
    }
    if (createKeyAliasOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", createKeyAliasOptions.xKmsKeyRing());
    }
    ResponseConverter<KeyAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<KeyAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an alias.
   *
   * Deletes an alias from the associated key.
   *
   * Delete alias does not delete the key.
   *
   * @param deleteKeyAliasOptions the {@link DeleteKeyAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteKeyAlias(DeleteKeyAliasOptions deleteKeyAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKeyAliasOptions,
      "deleteKeyAliasOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteKeyAliasOptions.id());
    pathParamsMap.put("alias", deleteKeyAliasOptions.alias());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/aliases/{alias}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKeyAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteKeyAliasOptions.bluemixInstance());
    if (deleteKeyAliasOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKeyAliasOptions.correlationId());
    }
    if (deleteKeyAliasOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", deleteKeyAliasOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get instance endpoints.
   *
   * Retrieves the URL for the dedicated API endpoint for key management operations on a Key Protect instance.  The
   * endpoint URL varies depending on which regional service endpoint you are using.
   *
   * @param cryptoV2GetInstanceEndpointsOptions the {@link CryptoV2GetInstanceEndpointsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetInstanceEndpointInfo}
   */
  public ServiceCall<GetInstanceEndpointInfo> cryptoV2GetInstanceEndpoints(CryptoV2GetInstanceEndpointsOptions cryptoV2GetInstanceEndpointsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(cryptoV2GetInstanceEndpointsOptions,
      "cryptoV2GetInstanceEndpointsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instanceId", cryptoV2GetInstanceEndpointsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/crypto_v2/instances/{instanceId}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "cryptoV2GetInstanceEndpoints");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<GetInstanceEndpointInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetInstanceEndpointInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List resource configurations.
   *
   * [Configuration Information
   * Point](/docs/security-compliance?topic=security-compliance-internal-onboard-config#internal-cip) required to
   * maintain ongoing monitoring of [IBM Cloud Security and Compliance
   * Center](/docs/security-compliance?topic=security-compliance-getting-started) config rules. Returns the config
   * status of the requested resource(s).
   * **Note:** Configs returned may be slightly out of sync from the state's true configs at time of query.
   *
   * @param getGovernanceConfigOptions the {@link GetGovernanceConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CIPResource}
   */
  public ServiceCall<CIPResource> getGovernanceConfig(GetGovernanceConfigOptions getGovernanceConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getGovernanceConfigOptions,
      "getGovernanceConfigOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/governance/v1/configs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getGovernanceConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("config_request_id", String.valueOf(getGovernanceConfigOptions.configRequestId()));
    builder.query("account_id", String.valueOf(getGovernanceConfigOptions.accountId()));
    builder.query("resource_kind", String.valueOf(getGovernanceConfigOptions.resourceKind()));
    builder.query("service_instance_crn", String.valueOf(getGovernanceConfigOptions.serviceInstanceCrn()));
    builder.query("resource_group_id", String.valueOf(getGovernanceConfigOptions.resourceGroupId()));
    if (getGovernanceConfigOptions.transactionId() != null) {
      builder.query("Transaction-Id", String.valueOf(getGovernanceConfigOptions.transactionId()));
    }
    if (getGovernanceConfigOptions.limit() != null) {
      builder.query("limit", String.valueOf(getGovernanceConfigOptions.limit()));
    }
    if (getGovernanceConfigOptions.offset() != null) {
      builder.query("offset", String.valueOf(getGovernanceConfigOptions.offset()));
    }
    ResponseConverter<CIPResource> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CIPResource>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an import token.
   *
   * Creates an import token that you can use to encrypt and import root keys into the service.
   * [Learn more](/docs/key-protect?topic=key-protect-importing-keys#using-import-tokens).
   *
   * When you call `POST /import_token`, Key Protect creates an RSA key-pair from its HSMs. The service encrypts and
   * stores the private key in the HSM, and returns the corresponding public key when you call
   * `GET /import_token`. You can create only one import token per service instance.
   *
   * @param postImportTokenOptions the {@link PostImportTokenOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ImportToken}
   */
  public ServiceCall<ImportToken> postImportToken(PostImportTokenOptions postImportTokenOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postImportTokenOptions,
      "postImportTokenOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/import_token"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "postImportToken");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", postImportTokenOptions.bluemixInstance());
    if (postImportTokenOptions.correlationId() != null) {
      builder.header("Correlation-Id", postImportTokenOptions.correlationId());
    }
    if (postImportTokenOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", postImportTokenOptions.xKmsKeyRing());
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
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ImportToken>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve an import token.
   *
   * Retrieves the import token that is associated with your service instance.
   *
   * When you call `GET /import_token`, Key Protect returns the public key that you can use to encrypt and import key
   * material to the service, along with details about the key.
   *
   * **Note:** After you reach the `maxAllowedRetrievals` or `expirationDate` for the import token, the import token and
   * its associated public key can no longer be used for key operations. To create a new import token, use
   * `POST /import_token`.
   *
   * @param getImportTokenOptions the {@link GetImportTokenOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetImportToken}
   */
  public ServiceCall<GetImportToken> getImportToken(GetImportTokenOptions getImportTokenOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getImportTokenOptions,
      "getImportTokenOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/import_token"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getImportToken");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getImportTokenOptions.bluemixInstance());
    if (getImportTokenOptions.correlationId() != null) {
      builder.header("Correlation-Id", getImportTokenOptions.correlationId());
    }
    if (getImportTokenOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getImportTokenOptions.xKmsKeyRing());
    }
    ResponseConverter<GetImportToken> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetImportToken>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List KMIP Adapters.
   *
   * List all the KMIP Adapters in the kms instance.
   *
   * @param getKmipAdaptersOptions the {@link GetKmipAdaptersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKMIPAdaptersWithTotalCount}
   */
  public ServiceCall<ListKMIPAdaptersWithTotalCount> getKmipAdapters(GetKmipAdaptersOptions getKmipAdaptersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKmipAdaptersOptions,
      "getKmipAdaptersOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKmipAdapters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKmipAdaptersOptions.bluemixInstance());
    if (getKmipAdaptersOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKmipAdaptersOptions.correlationId());
    }
    if (getKmipAdaptersOptions.limit() != null) {
      builder.query("limit", String.valueOf(getKmipAdaptersOptions.limit()));
    }
    if (getKmipAdaptersOptions.offset() != null) {
      builder.query("offset", String.valueOf(getKmipAdaptersOptions.offset()));
    }
    if (getKmipAdaptersOptions.totalCount() != null) {
      builder.query("totalCount", String.valueOf(getKmipAdaptersOptions.totalCount()));
    }
    ResponseConverter<ListKMIPAdaptersWithTotalCount> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKMIPAdaptersWithTotalCount>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a KMIP Adapter.
   *
   * Create a KMIP adapter in a kms instance.
   *
   * @param createKmipAdapterOptions the {@link CreateKmipAdapterOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKMIPAdapters}
   */
  public ServiceCall<ListKMIPAdapters> createKmipAdapter(CreateKmipAdapterOptions createKmipAdapterOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKmipAdapterOptions,
      "createKmipAdapterOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKmipAdapter");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createKmipAdapterOptions.bluemixInstance());
    if (createKmipAdapterOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKmipAdapterOptions.correlationId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createKmipAdapterOptions.metadata()));
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createKmipAdapterOptions.resources()));
    builder.bodyJson(contentJson);
    ResponseConverter<ListKMIPAdapters> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKMIPAdapters>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a KMIP Adapter.
   *
   * Retrieve a KMIP adapter using its ID / name and get its full details.
   *
   * @param getKmipAdapterOptions the {@link GetKmipAdapterOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKMIPAdapters}
   */
  public ServiceCall<ListKMIPAdapters> getKmipAdapter(GetKmipAdapterOptions getKmipAdapterOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKmipAdapterOptions,
      "getKmipAdapterOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getKmipAdapterOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKmipAdapter");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKmipAdapterOptions.bluemixInstance());
    if (getKmipAdapterOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKmipAdapterOptions.correlationId());
    }
    ResponseConverter<ListKMIPAdapters> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKMIPAdapters>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a KMIP Adapter.
   *
   * Delete a KMIP Adapter with the given ID / name.
   *
   * @param deleteKmipAdapterOptions the {@link DeleteKmipAdapterOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteKmipAdapter(DeleteKmipAdapterOptions deleteKmipAdapterOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKmipAdapterOptions,
      "deleteKmipAdapterOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteKmipAdapterOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKmipAdapter");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteKmipAdapterOptions.bluemixInstance());
    if (deleteKmipAdapterOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKmipAdapterOptions.correlationId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all client certificates.
   *
   * Get all client certificates in a KMIP Adapter.
   *
   * @param getKmipClientCertificatesOptions the {@link GetKmipClientCertificatesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKMIPPartialClientCertificatesWithTotalCount}
   */
  public ServiceCall<ListKMIPPartialClientCertificatesWithTotalCount> getKmipClientCertificates(GetKmipClientCertificatesOptions getKmipClientCertificatesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKmipClientCertificatesOptions,
      "getKmipClientCertificatesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("adapter_id", getKmipClientCertificatesOptions.adapterId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters/{adapter_id}/certificates", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKmipClientCertificates");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKmipClientCertificatesOptions.bluemixInstance());
    if (getKmipClientCertificatesOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKmipClientCertificatesOptions.correlationId());
    }
    if (getKmipClientCertificatesOptions.limit() != null) {
      builder.query("limit", String.valueOf(getKmipClientCertificatesOptions.limit()));
    }
    if (getKmipClientCertificatesOptions.offset() != null) {
      builder.query("offset", String.valueOf(getKmipClientCertificatesOptions.offset()));
    }
    if (getKmipClientCertificatesOptions.totalCount() != null) {
      builder.query("totalCount", String.valueOf(getKmipClientCertificatesOptions.totalCount()));
    }
    ResponseConverter<ListKMIPPartialClientCertificatesWithTotalCount> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKMIPPartialClientCertificatesWithTotalCount>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a client certificate to a KMIP Adapter.
   *
   * Add a Certificate to a KMIP Adapter. A maximum of 200 certificates can be associated with a KMIP Adapter at a time.
   *
   * @param addKmipClientCertificateOptions the {@link AddKmipClientCertificateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKMIPClientCertificates}
   */
  public ServiceCall<ListKMIPClientCertificates> addKmipClientCertificate(AddKmipClientCertificateOptions addKmipClientCertificateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addKmipClientCertificateOptions,
      "addKmipClientCertificateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("adapter_id", addKmipClientCertificateOptions.adapterId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters/{adapter_id}/certificates", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "addKmipClientCertificate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", addKmipClientCertificateOptions.bluemixInstance());
    if (addKmipClientCertificateOptions.correlationId() != null) {
      builder.header("Correlation-Id", addKmipClientCertificateOptions.correlationId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addKmipClientCertificateOptions.metadata()));
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addKmipClientCertificateOptions.resources()));
    builder.bodyJson(contentJson);
    ResponseConverter<ListKMIPClientCertificates> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKMIPClientCertificates>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a client certificate from a KMIP Adapter.
   *
   * Retrieve a client certificate from a KMIP Adapter using its id / name.
   *
   * @param getKmipClientCertificateOptions the {@link GetKmipClientCertificateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKMIPClientCertificates}
   */
  public ServiceCall<ListKMIPClientCertificates> getKmipClientCertificate(GetKmipClientCertificateOptions getKmipClientCertificateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKmipClientCertificateOptions,
      "getKmipClientCertificateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("adapter_id", getKmipClientCertificateOptions.adapterId());
    pathParamsMap.put("id", getKmipClientCertificateOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters/{adapter_id}/certificates/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKmipClientCertificate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKmipClientCertificateOptions.bluemixInstance());
    if (getKmipClientCertificateOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKmipClientCertificateOptions.correlationId());
    }
    ResponseConverter<ListKMIPClientCertificates> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKMIPClientCertificates>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a client certificate from a KMIP Adapter.
   *
   * Remove a client certificate from a KMIP Adapter given its id / name.
   *
   * @param deleteKmipClientCertificateOptions the {@link DeleteKmipClientCertificateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteKmipClientCertificate(DeleteKmipClientCertificateOptions deleteKmipClientCertificateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKmipClientCertificateOptions,
      "deleteKmipClientCertificateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("adapter_id", deleteKmipClientCertificateOptions.adapterId());
    pathParamsMap.put("id", deleteKmipClientCertificateOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/kmip_adapters/{adapter_id}/certificates/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKmipClientCertificate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteKmipClientCertificateOptions.bluemixInstance());
    if (deleteKmipClientCertificateOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKmipClientCertificateOptions.correlationId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Wrap a key.
   *
   * Use a root key to [wrap or encrypt a data encryption key](/docs/key-protect?topic=key-protect-wrap-keys). When
   * present, the ciphertext contains the DEK wrapped by the latest version of the key (WDEK). It is recommended to
   * store and use this WDEK in future calls to Key Protect.
   *
   * @param wrapKeyOptions the {@link WrapKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link WrapKeyResponseBody}
   */
  public ServiceCall<WrapKeyResponseBody> wrapKey(WrapKeyOptions wrapKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(wrapKeyOptions,
      "wrapKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", wrapKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/wrap", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "wrapKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", wrapKeyOptions.bluemixInstance());
    if (wrapKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", wrapKeyOptions.correlationId());
    }
    if (wrapKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", wrapKeyOptions.xKmsKeyRing());
    }
    if (wrapKeyOptions.keyActionWrapBody() != null) {
      builder.bodyContent(wrapKeyOptions.keyActionWrapBody(), "application/vnd.ibm.kms.key_action_wrap+json");
    }
    ResponseConverter<WrapKeyResponseBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<WrapKeyResponseBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unwrap a key.
   *
   * Use a root key to
   * [unwrap or decrypt a data encryption key](/docs/key-protect?topic=key-protect-unwrap-keys).
   *
   * **Note:** When you unwrap a wrapped data encryption key (WDEK) by using a rotated root key, the service returns a
   * new ciphertext in the response entity-body. Each ciphertext remains available for `unwrap` actions. If you unwrap a
   * DEK with a previous ciphertext, the service also returns the latest ciphertext and latest key version in the
   * response. Use the latest ciphertext for future unwrap operations.
   *
   * @param unwrapKeyOptions the {@link UnwrapKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UnwrapKeyResponseBody}
   */
  public ServiceCall<UnwrapKeyResponseBody> unwrapKey(UnwrapKeyOptions unwrapKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(unwrapKeyOptions,
      "unwrapKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", unwrapKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/unwrap", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "unwrapKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", unwrapKeyOptions.bluemixInstance());
    if (unwrapKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", unwrapKeyOptions.correlationId());
    }
    if (unwrapKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", unwrapKeyOptions.xKmsKeyRing());
    }
    builder.bodyContent(unwrapKeyOptions.keyActionUnwrapBody(), "application/vnd.ibm.kms.key_action_unwrap+json");
    ResponseConverter<UnwrapKeyResponseBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UnwrapKeyResponseBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Rewrap a key.
   *
   * Use a root key to [rewrap or reencrypt a data encryption key](/docs/key-protect?topic=key-protect-rewrap-keys).
   *
   * @param rewrapKeyOptions the {@link RewrapKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RewrapKeyResponseBody}
   */
  public ServiceCall<RewrapKeyResponseBody> rewrapKey(RewrapKeyOptions rewrapKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(rewrapKeyOptions,
      "rewrapKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", rewrapKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/rewrap", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "rewrapKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", rewrapKeyOptions.bluemixInstance());
    if (rewrapKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", rewrapKeyOptions.correlationId());
    }
    if (rewrapKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", rewrapKeyOptions.xKmsKeyRing());
    }
    builder.bodyContent(rewrapKeyOptions.keyActionRewrapBody(), "application/vnd.ibm.kms.key_action_rewrap+json");
    ResponseConverter<RewrapKeyResponseBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RewrapKeyResponseBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Rotate a key.
   *
   * [Create a new version](/docs/key-protect?topic=key-protect-rotate-keys) of a root key.
   *
   * @param rotateKeyOptions the {@link RotateKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> rotateKey(RotateKeyOptions rotateKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(rotateKeyOptions,
      "rotateKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", rotateKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/rotate", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "rotateKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", rotateKeyOptions.bluemixInstance());
    if (rotateKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", rotateKeyOptions.correlationId());
    }
    if (rotateKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", rotateKeyOptions.xKmsKeyRing());
    }
    if (rotateKeyOptions.prefer() != null) {
      builder.header("Prefer", rotateKeyOptions.prefer());
    }
    if (rotateKeyOptions.keyActionRotateBody() != null) {
      builder.bodyContent(rotateKeyOptions.keyActionRotateBody(), "application/vnd.ibm.kms.key_action_rotate+json");
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Set a key for deletion.
   *
   * [Authorize deletion](/docs/key-protect?topic=key-protect-delete-dual-auth-keys#set-key-deletion-api) for a key with
   * a dual authorization policy.
   *
   * @param setKeyForDeletionOptions the {@link SetKeyForDeletionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> setKeyForDeletion(SetKeyForDeletionOptions setKeyForDeletionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(setKeyForDeletionOptions,
      "setKeyForDeletionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", setKeyForDeletionOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/setKeyForDeletion", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "setKeyForDeletion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", setKeyForDeletionOptions.bluemixInstance());
    if (setKeyForDeletionOptions.correlationId() != null) {
      builder.header("Correlation-Id", setKeyForDeletionOptions.correlationId());
    }
    if (setKeyForDeletionOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", setKeyForDeletionOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unset a key for deletion.
   *
   * [Remove an authorization](/docs/key-protect?topic=key-protect-delete-dual-auth-keys#unset-key-deletion-api) for a
   * key with a dual authorization policy.
   *
   * @param unsetKeyForDeletionOptions the {@link UnsetKeyForDeletionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> unsetKeyForDeletion(UnsetKeyForDeletionOptions unsetKeyForDeletionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(unsetKeyForDeletionOptions,
      "unsetKeyForDeletionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", unsetKeyForDeletionOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/unsetKeyForDeletion", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "unsetKeyForDeletion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", unsetKeyForDeletionOptions.bluemixInstance());
    if (unsetKeyForDeletionOptions.correlationId() != null) {
      builder.header("Correlation-Id", unsetKeyForDeletionOptions.correlationId());
    }
    if (unsetKeyForDeletionOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", unsetKeyForDeletionOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Enable a key.
   *
   * [Enable operations](/docs/key-protect?topic=key-protect-disable-keys#enable-api) for a key.
   *
   * @param enableKeyOptions the {@link EnableKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> enableKey(EnableKeyOptions enableKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(enableKeyOptions,
      "enableKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", enableKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/enable", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "enableKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", enableKeyOptions.bluemixInstance());
    if (enableKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", enableKeyOptions.correlationId());
    }
    if (enableKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", enableKeyOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Disable a key.
   *
   * [Disable operations](/docs/key-protect?topic=key-protect-disable-keys) for a key.
   *
   * @param disableKeyOptions the {@link DisableKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> disableKey(DisableKeyOptions disableKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(disableKeyOptions,
      "disableKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", disableKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/disable", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "disableKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", disableKeyOptions.bluemixInstance());
    if (disableKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", disableKeyOptions.correlationId());
    }
    if (disableKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", disableKeyOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Sync associated resources.
   *
   * Initiate a [manual data
   * synchronization](/docs/key-protect?topic=key-protect-sync-associated-resources&amp;interface=api) request to the
   * associated resources of a key. Regular key lifecycle events automatically notify integrated services of any change.
   * However, in the case a service does not respond to a key lifecycle event notification after four hours, the
   * `sync` API may be used to initiate a renotification to the integrated services that manage the associated resources
   * linked to the key.
   *
   * **Note:** The services that manage the associated resources linked to the key are responsible for maintaining
   * current records of the key state and version. Key Protect does not have the ability to force data synchronization
   * for other services, which may take up to four hours to complete. The `sync` API is meant to **initiate** a request
   * for all associated resources to synchronize their key records with the information returned from the Key Protect
   * API.
   *
   * @param syncAssociatedResourcesOptions the {@link SyncAssociatedResourcesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> syncAssociatedResources(SyncAssociatedResourcesOptions syncAssociatedResourcesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(syncAssociatedResourcesOptions,
      "syncAssociatedResourcesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", syncAssociatedResourcesOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/actions/sync", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "syncAssociatedResources");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", syncAssociatedResourcesOptions.bluemixInstance());
    if (syncAssociatedResourcesOptions.correlationId() != null) {
      builder.header("Correlation-Id", syncAssociatedResourcesOptions.correlationId());
    }
    if (syncAssociatedResourcesOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", syncAssociatedResourcesOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Acknowledge key events.
   *
   * **Service to service calls only.** Acknowledges a key lifecycle event.
   *
   * When a customer performs an action on a root key, Key Protect uses Hyperwarp to notify the cloud services that are
   * registered with the key. To acknowledge the Hyperwarp event, registered services must call
   * `POST /api/v2/event_ack`.
   *
   * @param eventAcknowledgeOptions the {@link EventAcknowledgeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> eventAcknowledge(EventAcknowledgeOptions eventAcknowledgeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(eventAcknowledgeOptions,
      "eventAcknowledgeOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/event_ack"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "eventAcknowledge");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", eventAcknowledgeOptions.bluemixInstance());
    if (eventAcknowledgeOptions.correlationId() != null) {
      builder.header("Correlation-Id", eventAcknowledgeOptions.correlationId());
    }
    if (eventAcknowledgeOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", eventAcknowledgeOptions.xKmsKeyRing());
    }
    builder.bodyContent(eventAcknowledgeOptions.body(), "application/vnd.ibm.kms.event_acknowledge+json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List key rings.
   *
   * List all key rings in the instance.
   *
   * @param listKeyRingsOptions the {@link ListKeyRingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKeyRingsWithTotalCount}
   */
  public ServiceCall<ListKeyRingsWithTotalCount> listKeyRings(ListKeyRingsOptions listKeyRingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listKeyRingsOptions,
      "listKeyRingsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/key_rings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "listKeyRings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", listKeyRingsOptions.bluemixInstance());
    if (listKeyRingsOptions.correlationId() != null) {
      builder.header("Correlation-Id", listKeyRingsOptions.correlationId());
    }
    if (listKeyRingsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listKeyRingsOptions.limit()));
    }
    if (listKeyRingsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listKeyRingsOptions.offset()));
    }
    if (listKeyRingsOptions.totalCount() != null) {
      builder.query("totalCount", String.valueOf(listKeyRingsOptions.totalCount()));
    }
    ResponseConverter<ListKeyRingsWithTotalCount> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKeyRingsWithTotalCount>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a key ring.
   *
   * Create a key ring in the instance with the specified name. The key ring ID `default` is a reserved key ring ID and
   * cannot be created nor destroyed. The `default` key ring is an initial key ring that is generated with each newly
   * created instance. All keys not associated with an otherwise specified key ring exist within the default key ring.
   *
   * @param createKeyRingOptions the {@link CreateKeyRingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> createKeyRing(CreateKeyRingOptions createKeyRingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyRingOptions,
      "createKeyRingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("key-ring-id", createKeyRingOptions.keyRingId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/key_rings/{key-ring-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKeyRing");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", createKeyRingOptions.bluemixInstance());
    if (createKeyRingOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKeyRingOptions.correlationId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete key ring.
   *
   * Delete the key ring from the instance. The key ring ID `default` cannot be destroyed. Currently, only key rings
   * with 0 (zero) keys in any state - Active (1), Suspended (2), Deactivated (3), Destroyed (5) - may be deleted.
   *
   * @param deleteKeyRingOptions the {@link DeleteKeyRingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteKeyRing(DeleteKeyRingOptions deleteKeyRingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKeyRingOptions,
      "deleteKeyRingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("key-ring-id", deleteKeyRingOptions.keyRingId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/key_rings/{key-ring-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKeyRing");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteKeyRingOptions.bluemixInstance());
    if (deleteKeyRingOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKeyRingOptions.correlationId());
    }
    if (deleteKeyRingOptions.force() != null) {
      builder.query("force", String.valueOf(deleteKeyRingOptions.force()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve key total.
   *
   * Returns the same HTTP headers as a GET request without returning the entity-body. This operation returns the number
   * of keys in your instance in a header called `Key-Total`.
   *
   * @param getKeyCollectionMetadataOptions the {@link GetKeyCollectionMetadataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getKeyCollectionMetadata(GetKeyCollectionMetadataOptions getKeyCollectionMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyCollectionMetadataOptions,
      "getKeyCollectionMetadataOptions cannot be null");
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeyCollectionMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", getKeyCollectionMetadataOptions.bluemixInstance());
    if (getKeyCollectionMetadataOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyCollectionMetadataOptions.correlationId());
    }
    if (getKeyCollectionMetadataOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getKeyCollectionMetadataOptions.xKmsKeyRing());
    }
    if (getKeyCollectionMetadataOptions.state() != null) {
      builder.query("state", RequestUtils.join(getKeyCollectionMetadataOptions.state(), ","));
    }
    if (getKeyCollectionMetadataOptions.extractable() != null) {
      builder.query("extractable", String.valueOf(getKeyCollectionMetadataOptions.extractable()));
    }
    if (getKeyCollectionMetadataOptions.filter() != null) {
      builder.query("filter", String.valueOf(getKeyCollectionMetadataOptions.filter()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a key.
   *
   * Creates a new key with specified key material.
   *
   * Key Protect designates the resource as either a root key or a standard key based on the `extractable` value that
   * you specify. A successful
   * `POST /keys` operation adds the key to the service and returns the details of the request in the response
   * entity-body, if the Prefer header is set to `return=representation`.
   *
   * @param createKeyOptions the {@link CreateKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Key}
   */
  public ServiceCall<Key> createKey(CreateKeyOptions createKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyOptions,
      "createKeyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys"));
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
    if (createKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", createKeyOptions.xKmsKeyRing());
    }
    builder.bodyContent(createKeyOptions.body(), "application/vnd.ibm.kms.key+json");
    ResponseConverter<Key> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Key>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List keys.
   *
   * Retrieves a list of keys that are stored in your Key Protect service instance.
   *
   * **Important:** When a user of Key Protect on Satellite views lists of  keys through the [IBM
   * Console](https://cloud.ibm.com/login),  or programmatically via this API, keys with ["fine grain"
   * permissions](/docs/key-protect?topic=key-protect-grant-access-keys#grant-access-key-level)  won't appear due to the
   * manner in which the service aggregates the  collection. While the user can still use the key resource, only by
   * using  the CLI or API and passing the specific key ID can a user access the  metadata and other details of the key.
   *
   * **Note:** `GET /keys` will not return the key material in the response body. You can retrieve the key material for
   * a standard key with a subsequent `GET /keys/{id}` request.
   *
   * @param getKeysOptions the {@link GetKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKeys}
   */
  public ServiceCall<ListKeys> getKeys(GetKeysOptions getKeysOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeysOptions,
      "getKeysOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeysOptions.bluemixInstance());
    if (getKeysOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeysOptions.correlationId());
    }
    if (getKeysOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getKeysOptions.xKmsKeyRing());
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
    if (getKeysOptions.extractable() != null) {
      builder.query("extractable", String.valueOf(getKeysOptions.extractable()));
    }
    if (getKeysOptions.search() != null) {
      builder.query("search", String.valueOf(getKeysOptions.search()));
    }
    if (getKeysOptions.sort() != null) {
      builder.query("sort", String.valueOf(getKeysOptions.sort()));
    }
    if (getKeysOptions.filter() != null) {
      builder.query("filter", String.valueOf(getKeysOptions.filter()));
    }
    ResponseConverter<ListKeys> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKeys>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a key with policy overrides.
   *
   * Creates a new key with specified key material and key policies. This API overrides the policy configurations set at
   * instance level with policies provided in the payload. Key Protect designates the resource as a root key or a
   * standard key based on the extractable value that you specify. A successful `POST /keys_with_policy_overrides`
   * operation adds the key and key policies to the service and returns the details of the request in the response
   * entity-body, if the Prefer header is set to `return=representation`.
   *
   * @param createKeyWithPoliciesOverridesOptions the {@link CreateKeyWithPoliciesOverridesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Key}
   */
  public ServiceCall<Key> createKeyWithPoliciesOverrides(CreateKeyWithPoliciesOverridesOptions createKeyWithPoliciesOverridesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createKeyWithPoliciesOverridesOptions,
      "createKeyWithPoliciesOverridesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys_with_policy_overrides"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createKeyWithPoliciesOverrides");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createKeyWithPoliciesOverridesOptions.bluemixInstance());
    if (createKeyWithPoliciesOverridesOptions.correlationId() != null) {
      builder.header("Correlation-Id", createKeyWithPoliciesOverridesOptions.correlationId());
    }
    if (createKeyWithPoliciesOverridesOptions.prefer() != null) {
      builder.header("Prefer", createKeyWithPoliciesOverridesOptions.prefer());
    }
    if (createKeyWithPoliciesOverridesOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", createKeyWithPoliciesOverridesOptions.xKmsKeyRing());
    }
    builder.bodyContent(createKeyWithPoliciesOverridesOptions.body(), "application/vnd.ibm.kms.key+json");
    ResponseConverter<Key> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Key>() { }.getType());
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
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getKeyOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeyOptions.bluemixInstance());
    if (getKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyOptions.correlationId());
    }
    if (getKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getKeyOptions.xKmsKeyRing());
    }
    ResponseConverter<GetKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Invoke an action on a key.
   *
   * **Note:** This API has been **deprecated** and transitioned to individual request paths. Existing actions using
   * this API will continue to be supported, but new actions will no longer be added to it. We recommend, if possible,
   * aligning your request URLs to the new API path. The generic format of actions is now the following:
   * `/api/v2/keys/&lt;key_ID&gt;/actions/&lt;action&gt;` where `key_ID` is the key you want to operate on/with and
   * `action` is the same action that was passed as a query parameter previously.
   *
   * Invokes an action on a specified key. This method supports the following actions:
   *
   * - `disable`: [Disable operations](/docs/key-protect?topic=key-protect-disable-keys) for a key
   * - `enable`: [Enable operations](/docs/key-protect?topic=key-protect-disable-keys#enable-api) for a key
   * - `restore`: [Restore a root key](/docs/key-protect?topic=key-protect-restore-keys)
   * - `rewrap`: Use a root key to [rewrap or reencrypt a data encryption
   * key](/docs/key-protect?topic=key-protect-rewrap-keys)
   * - `rotate`: [Create a new version](/docs/key-protect?topic=key-protect-rotate-keys) of a root key
   * - `setKeyForDeletion`: [Authorize
   * deletion](/docs/key-protect?topic=key-protect-delete-dual-auth-keys#set-key-deletion-api) for a key with a dual
   * authorization policy
   * - `unsetKeyForDeletion`: [Remove an
   * authorization]((/docs/key-protect?topic=key-protect-delete-dual-auth-keys#unset-key-deletion-api) for a key with a
   * dual authorization policy
   * - `unwrap`: Use a root key to [unwrap or decrypt a data encryption
   * key](/docs/key-protect?topic=key-protect-unwrap-keys)
   * - `wrap`: Use a root key to [wrap or encrypt a data encryption key](/docs/key-protect?topic=key-protect-wrap-keys)
   *
   * **Note:** If you unwrap a wrapped data encryption key (WDEK) that was not  wrapped by the latest version of the
   * key, the service also returns the a  new WDEK, wrapped with the latest version of the key as the ciphertext field.
   * The recommendation is to store and use that WDEK, although older WDEKs will continue to work.
   *
   * @param actionOnKeyOptions the {@link ActionOnKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link KeyActionOneOfResponse}
   * @deprecated this method is deprecated and may be removed in a future release
   */
   @Deprecated
  public ServiceCall<KeyActionOneOfResponse> actionOnKey(ActionOnKeyOptions actionOnKeyOptions) {
    LOGGER.warning("A deprecated operation has been invoked: actionOnKey");
    com.ibm.cloud.sdk.core.util.Validator.notNull(actionOnKeyOptions,
      "actionOnKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", actionOnKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "actionOnKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", actionOnKeyOptions.bluemixInstance());
    if (actionOnKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", actionOnKeyOptions.correlationId());
    }
    if (actionOnKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", actionOnKeyOptions.xKmsKeyRing());
    }
    if (actionOnKeyOptions.prefer() != null) {
      builder.header("Prefer", actionOnKeyOptions.prefer());
    }
    builder.query("action", String.valueOf(actionOnKeyOptions.action()));
    builder.bodyContent(actionOnKeyOptions.body(), "application/vnd.ibm.kms.key_action+json");
    ResponseConverter<KeyActionOneOfResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<KeyActionOneOfResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update (patch) a key.
   *
   * Update attributes of a key. Currently only the following attributes are applicable for update: - keyRingID Note: If
   * provided, the `X-Kms-Key-Ring` header should specify the key's current key ring. To change the key ring of the key,
   * specify the new key ring in the request body.
   *
   * @param patchKeyOptions the {@link PatchKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PatchKeyResponseBody}
   */
  public ServiceCall<PatchKeyResponseBody> patchKey(PatchKeyOptions patchKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(patchKeyOptions,
      "patchKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", patchKeyOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "patchKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", patchKeyOptions.bluemixInstance());
    if (patchKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", patchKeyOptions.correlationId());
    }
    if (patchKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", patchKeyOptions.xKmsKeyRing());
    }
    if (patchKeyOptions.keyPatchBody() != null) {
      builder.bodyContent(patchKeyOptions.keyPatchBody(), "application/vnd.ibm.kms.key+json");
    }
    ResponseConverter<PatchKeyResponseBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PatchKeyResponseBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a key.
   *
   * Deletes a key by specifying the ID or alias of the key.
   *
   * By default, Key Protect requires a single authorization to delete keys. For added protection, you can
   * [enable a dual authorization policy](#set-key-policies) to safely delete keys from your service instance.
   *
   * **Important:** After a key has been deleted, any data that is encrypted by the key becomes inaccessible, though
   * this can be reversed if the key is  restored within the 30-day time frame. After 30 days, key metadata,
   * registrations, and policies are available for up to 90 days, at which  point the key becomes eligible to be purged.
   * Note that once a key is no  longer restorable and has been purged, its associated data can no longer  be accessed.
   *
   * **Note:** By default, Key Protect blocks the deletion of a key that's protecting a cloud resource, such as a Cloud
   * Object Storage bucket. Use
   * `GET keys/{id}/registrations` to verify if the key has an active registration to a resource. To delete the key and
   * its associated registrations, set the optional `force` parameter to `true`.
   *
   * @param deleteKeyOptions the {@link DeleteKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteKey}
   */
  public ServiceCall<DeleteKey> deleteKey(DeleteKeyOptions deleteKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteKeyOptions,
      "deleteKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteKeyOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", deleteKeyOptions.bluemixInstance());
    if (deleteKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteKeyOptions.correlationId());
    }
    if (deleteKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", deleteKeyOptions.xKmsKeyRing());
    }
    if (deleteKeyOptions.prefer() != null) {
      builder.header("Prefer", deleteKeyOptions.prefer());
    }
    if (deleteKeyOptions.force() != null) {
      builder.query("force", String.valueOf(deleteKeyOptions.force()));
    }
    ResponseConverter<DeleteKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve key metadata.
   *
   * Retrieves the details of a key by specifying the ID of the key.
   *
   * @param getKeyMetadataOptions the {@link GetKeyMetadataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKeyMetadata}
   */
  public ServiceCall<GetKeyMetadata> getKeyMetadata(GetKeyMetadataOptions getKeyMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyMetadataOptions,
      "getKeyMetadataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getKeyMetadataOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/metadata", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeyMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeyMetadataOptions.bluemixInstance());
    if (getKeyMetadataOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyMetadataOptions.correlationId());
    }
    if (getKeyMetadataOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getKeyMetadataOptions.xKmsKeyRing());
    }
    ResponseConverter<GetKeyMetadata> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetKeyMetadata>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Purge a deleted key.
   *
   * Purges all key metadata and registrations associated with the specified key.  This method requires setting the
   * [_KeyPurge_
   * permission](https://cloud.ibm.com/docs/key-protect?topic=key-protect-grant-access-keys#grant-access-keys-specific-functions)
   * that is not enabled by default. Purging a key can only be applied to a key in the **Destroyed** (5) state.  After a
   * key is deleted, there is a wait period of up to four hours before purge key operation is allowed.
   * **Important:** When you purge a key, you permanently shred its contents and associated data. The action cannot be
   * reversed.
   *
   * @param purgeKeyOptions the {@link PurgeKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PurgeKey}
   */
  public ServiceCall<PurgeKey> purgeKey(PurgeKeyOptions purgeKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(purgeKeyOptions,
      "purgeKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", purgeKeyOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/purge", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "purgeKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", purgeKeyOptions.bluemixInstance());
    if (purgeKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", purgeKeyOptions.correlationId());
    }
    if (purgeKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", purgeKeyOptions.xKmsKeyRing());
    }
    if (purgeKeyOptions.prefer() != null) {
      builder.header("Prefer", purgeKeyOptions.prefer());
    }
    ResponseConverter<PurgeKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PurgeKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Restore a key.
   *
   * [Restore a key](/docs/key-protect?topic=key-protect-restore-keys) that has been deleted.
   *
   * @param restoreKeyOptions the {@link RestoreKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> restoreKey(RestoreKeyOptions restoreKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(restoreKeyOptions,
      "restoreKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", restoreKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/restore", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "restoreKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/vnd.ibm.kms.key+json");
    builder.header("Bluemix-Instance", restoreKeyOptions.bluemixInstance());
    if (restoreKeyOptions.correlationId() != null) {
      builder.header("Correlation-Id", restoreKeyOptions.correlationId());
    }
    if (restoreKeyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", restoreKeyOptions.xKmsKeyRing());
    }
    if (restoreKeyOptions.prefer() != null) {
      builder.header("Prefer", restoreKeyOptions.prefer());
    }
    if (restoreKeyOptions.keyRestoreBody() != null) {
      builder.bodyContent(restoreKeyOptions.keyRestoreBody(), "application/vnd.ibm.kms.key_action_restore+json");
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List key versions.
   *
   * Retrieves all versions of a root key by specifying the ID or alias of the key.
   *
   * When you rotate a root key, you generate a new version of the key. If you're using the root key to protect
   * resources across IBM Cloud, the registered cloud services that you associate with the key use the latest key
   * version to wrap your data.
   * [Learn more](/docs/key-protect?topic=key-protect-key-rotation).
   *
   * @param getKeyVersionsOptions the {@link GetKeyVersionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListKeyVersions}
   */
  public ServiceCall<ListKeyVersions> getKeyVersions(GetKeyVersionsOptions getKeyVersionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getKeyVersionsOptions,
      "getKeyVersionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getKeyVersionsOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/versions", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getKeyVersions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getKeyVersionsOptions.bluemixInstance());
    if (getKeyVersionsOptions.correlationId() != null) {
      builder.header("Correlation-Id", getKeyVersionsOptions.correlationId());
    }
    if (getKeyVersionsOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getKeyVersionsOptions.xKmsKeyRing());
    }
    if (getKeyVersionsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getKeyVersionsOptions.limit()));
    }
    if (getKeyVersionsOptions.offset() != null) {
      builder.query("offset", String.valueOf(getKeyVersionsOptions.offset()));
    }
    if (getKeyVersionsOptions.totalCount() != null) {
      builder.query("totalCount", String.valueOf(getKeyVersionsOptions.totalCount()));
    }
    if (getKeyVersionsOptions.allKeyStates() != null) {
      builder.query("allKeyStates", String.valueOf(getKeyVersionsOptions.allKeyStates()));
    }
    ResponseConverter<ListKeyVersions> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListKeyVersions>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Creates a Migration Intent associated with Customer Root Key (CRK).
   *
   * Creates a Migration Intent associated with Customer Root Key (CRK).
   *
   * @param createMigrationIntentOptions the {@link CreateMigrationIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetMigrationIntent}
   */
  public ServiceCall<GetMigrationIntent> createMigrationIntent(CreateMigrationIntentOptions createMigrationIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createMigrationIntentOptions,
      "createMigrationIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", createMigrationIntentOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/migrationIntent", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createMigrationIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createMigrationIntentOptions.bluemixInstance());
    if (createMigrationIntentOptions.correlationId() != null) {
      builder.header("Correlation-Id", createMigrationIntentOptions.correlationId());
    }
    if (createMigrationIntentOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", createMigrationIntentOptions.xKmsKeyRing());
    }
    final JsonObject contentJson = new JsonObject();
    if (createMigrationIntentOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createMigrationIntentOptions.metadata()));
    }
    if (createMigrationIntentOptions.resources() != null) {
      contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createMigrationIntentOptions.resources()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<GetMigrationIntent> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetMigrationIntent>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves a Migration Intent.
   *
   * Retrieves a Migration Intent.
   *
   * @param getMigrationIntentOptions the {@link GetMigrationIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetMigrationIntent}
   */
  public ServiceCall<GetMigrationIntent> getMigrationIntent(GetMigrationIntentOptions getMigrationIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getMigrationIntentOptions,
      "getMigrationIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getMigrationIntentOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/migrationIntent", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getMigrationIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getMigrationIntentOptions.bluemixInstance());
    if (getMigrationIntentOptions.correlationId() != null) {
      builder.header("Correlation-Id", getMigrationIntentOptions.correlationId());
    }
    if (getMigrationIntentOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getMigrationIntentOptions.xKmsKeyRing());
    }
    ResponseConverter<GetMigrationIntent> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetMigrationIntent>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deletes a Migration Intent.
   *
   * Delete a Migration Intent.
   *
   * @param deleteMigrationIntentOptions the {@link DeleteMigrationIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteMigrationIntent(DeleteMigrationIntentOptions deleteMigrationIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteMigrationIntentOptions,
      "deleteMigrationIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteMigrationIntentOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/migrationIntent", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteMigrationIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", deleteMigrationIntentOptions.bluemixInstance());
    if (deleteMigrationIntentOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteMigrationIntentOptions.correlationId());
    }
    if (deleteMigrationIntentOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", deleteMigrationIntentOptions.xKmsKeyRing());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Set key policies.
   *
   * Creates or updates one or more policies for the specified key.
   *
   * You can set policies for a key, such as an
   * [automatic rotation policy](/docs/key-protect?topic=key-protect-set-rotation-policy) or a
   * [dual authorization policy](/docs/key-protect?topic=key-protect-set-dual-auth-key-policy) to protect against the
   * accidental deletion of keys. Use
   * `PUT /keys/{id}/policies` to create new policies for a key or update an existing policy.
   *
   * @param putPolicyOptions the {@link PutPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKeyPoliciesOneOf}
   */
  public ServiceCall<GetKeyPoliciesOneOf> putPolicy(PutPolicyOptions putPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putPolicyOptions,
      "putPolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", putPolicyOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/policies", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "putPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", putPolicyOptions.bluemixInstance());
    if (putPolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", putPolicyOptions.correlationId());
    }
    if (putPolicyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", putPolicyOptions.xKmsKeyRing());
    }
    if (putPolicyOptions.policy() != null) {
      builder.query("policy", String.valueOf(putPolicyOptions.policy()));
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
   *
   * You can set policies for a key, such as an
   * [automatic rotation policy](/docs/key-protect?topic=key-protect-set-rotation-policy) or a
   * [dual authorization policy](/docs/key-protect?topic=key-protect-set-dual-auth-key-policy) to protect against the
   * accidental deletion of keys. Use
   * `GET /keys/{id}/policies` to browse the policies that exist for a specified key.
   *
   * @param getPolicyOptions the {@link GetPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetKeyPoliciesOneOf}
   */
  public ServiceCall<GetKeyPoliciesOneOf> getPolicy(GetPolicyOptions getPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPolicyOptions,
      "getPolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getPolicyOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/policies", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getPolicyOptions.bluemixInstance());
    if (getPolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", getPolicyOptions.correlationId());
    }
    if (getPolicyOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getPolicyOptions.xKmsKeyRing());
    }
    if (getPolicyOptions.policy() != null) {
      builder.query("policy", String.valueOf(getPolicyOptions.policy()));
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
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/instance/policies"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "putInstancePolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Bluemix-Instance", putInstancePolicyOptions.bluemixInstance());
    if (putInstancePolicyOptions.correlationId() != null) {
      builder.header("Correlation-Id", putInstancePolicyOptions.correlationId());
    }
    if (putInstancePolicyOptions.policy() != null) {
      builder.query("policy", String.valueOf(putInstancePolicyOptions.policy()));
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(putInstancePolicyOptions.setInstancePoliciesOneOf()), "application/json");
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List instance policies.
   *
   * Retrieves a list of policies that are associated with a specified service instance.
   *
   * You can manage advanced preferences for keys in your service instance by creating instance-level policies. Use `GET
   * /instance/policies` to browse the policies that are associated with the specified instance. Currently, dual
   * authorization policies are supported.
   *
   * @param getInstancePolicyOptions the {@link GetInstancePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetInstancePoliciesOneOf}
   */
  public ServiceCall<GetInstancePoliciesOneOf> getInstancePolicy(GetInstancePolicyOptions getInstancePolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getInstancePolicyOptions,
      "getInstancePolicyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/instance/policies"));
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
      builder.query("policy", String.valueOf(getInstancePolicyOptions.policy()));
    }
    ResponseConverter<GetInstancePoliciesOneOf> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetInstancePoliciesOneOf>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve allowed IP port.
   *
   * Retrieves the private endpoint port associated with your service instance's active allowed IP policy. If the
   * instance does not contain an active allowed IP policy, no information will be returned.
   *
   * @param getAllowedIpPortOptions the {@link GetAllowedIPPortOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllowedIPPort}
   */
  public ServiceCall<AllowedIPPort> getAllowedIPPort(GetAllowedIPPortOptions getAllowedIpPortOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAllowedIpPortOptions,
      "getAllowedIpPortOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/instance/allowed_ip_port"));
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
   * Create a registration.
   *
   * **Service to service calls only.** Creates a registration between a root key and a cloud resource, such as a Cloud
   * Object Storage bucket. The key is identified by its ID, and the cloud resource is identified by its Cloud Resource
   * Name (CRN).
   *
   * @param createRegistrationOptions the {@link CreateRegistrationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Registration}
   */
  public ServiceCall<Registration> createRegistration(CreateRegistrationOptions createRegistrationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createRegistrationOptions,
      "createRegistrationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", createRegistrationOptions.id());
    pathParamsMap.put("urlEncodedResourceCRN", createRegistrationOptions.urlEncodedResourceCrn());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/registrations/{urlEncodedResourceCRN}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "createRegistration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", createRegistrationOptions.bluemixInstance());
    if (createRegistrationOptions.correlationId() != null) {
      builder.header("Correlation-Id", createRegistrationOptions.correlationId());
    }
    if (createRegistrationOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", createRegistrationOptions.xKmsKeyRing());
    }
    final JsonObject contentJson = new JsonObject();
    if (createRegistrationOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRegistrationOptions.metadata()));
    }
    if (createRegistrationOptions.resources() != null) {
      contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRegistrationOptions.resources()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Registration> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Registration>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a registration.
   *
   * **Service to service calls only.** Updates an existing registration based on the properties that you specify.
   *
   * When you call `PATCH /registrations`, Key Protect updates only the properties that you specify in the request
   * entity-body. To replace the registration, use `PUT /registrations`. The `preventKeyDeletion` policy should  only be
   * set if a WORM policy must be satisfied (as would be needed for this example:
   * https://www.ibm.com/docs/en/spectrum-scale/5.0.1?topic=ics-how-write-once-read-many-worm-storage-works).  Do not
   * set this policy by default.
   *
   * @param updateRegistrationOptions the {@link UpdateRegistrationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Registration}
   */
  public ServiceCall<Registration> updateRegistration(UpdateRegistrationOptions updateRegistrationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateRegistrationOptions,
      "updateRegistrationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateRegistrationOptions.id());
    pathParamsMap.put("urlEncodedResourceCRN", updateRegistrationOptions.urlEncodedResourceCrn());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/registrations/{urlEncodedResourceCRN}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "updateRegistration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", updateRegistrationOptions.bluemixInstance());
    if (updateRegistrationOptions.correlationId() != null) {
      builder.header("Correlation-Id", updateRegistrationOptions.correlationId());
    }
    if (updateRegistrationOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", updateRegistrationOptions.xKmsKeyRing());
    }
    if (updateRegistrationOptions.ifMatch() != null) {
      builder.header("If-Match", updateRegistrationOptions.ifMatch());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateRegistrationOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRegistrationOptions.metadata()));
    }
    if (updateRegistrationOptions.resources() != null) {
      contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRegistrationOptions.resources()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Registration> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Registration>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace a registration.
   *
   * **Service to service calls only.** Replace an existing registration between a root key and a cloud resource. The
   * key is identified by its ID, and the cloud resource is identified by its Cloud Resource Name
   * (CRN).
   *
   * When you call `PUT /registrations`, Key Protect replaces the existing registration with the properties that you
   * provide in the request entity-body.
   *
   * @param replaceRegistrationOptions the {@link ReplaceRegistrationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Registration}
   */
  public ServiceCall<Registration> replaceRegistration(ReplaceRegistrationOptions replaceRegistrationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceRegistrationOptions,
      "replaceRegistrationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", replaceRegistrationOptions.id());
    pathParamsMap.put("urlEncodedResourceCRN", replaceRegistrationOptions.urlEncodedResourceCrn());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/registrations/{urlEncodedResourceCRN}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "replaceRegistration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", replaceRegistrationOptions.bluemixInstance());
    if (replaceRegistrationOptions.correlationId() != null) {
      builder.header("Correlation-Id", replaceRegistrationOptions.correlationId());
    }
    if (replaceRegistrationOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", replaceRegistrationOptions.xKmsKeyRing());
    }
    if (replaceRegistrationOptions.ifMatch() != null) {
      builder.header("If-Match", replaceRegistrationOptions.ifMatch());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceRegistrationOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRegistrationOptions.metadata()));
    }
    if (replaceRegistrationOptions.resources() != null) {
      contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRegistrationOptions.resources()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Registration> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Registration>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a registration.
   *
   * **Service to service calls only.** Deletes an existing registration between a root key and a cloud resource.
   *
   * This action permanently removes the registration from the Key Protect database.
   *
   * @param deleteRegistrationOptions the {@link DeleteRegistrationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Registration}
   */
  public ServiceCall<Registration> deleteRegistration(DeleteRegistrationOptions deleteRegistrationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteRegistrationOptions,
      "deleteRegistrationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteRegistrationOptions.id());
    pathParamsMap.put("urlEncodedResourceCRN", deleteRegistrationOptions.urlEncodedResourceCrn());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/registrations/{urlEncodedResourceCRN}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "deleteRegistration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", deleteRegistrationOptions.bluemixInstance());
    if (deleteRegistrationOptions.correlationId() != null) {
      builder.header("Correlation-Id", deleteRegistrationOptions.correlationId());
    }
    if (deleteRegistrationOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", deleteRegistrationOptions.xKmsKeyRing());
    }
    if (deleteRegistrationOptions.prefer() != null) {
      builder.header("Prefer", deleteRegistrationOptions.prefer());
    }
    ResponseConverter<Registration> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Registration>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deactivate a registration.
   *
   * **Deprecated.** Invokes an action, such as a deactivate operation, on a registration with the specified key ID and
   * CRN.
   *
   * When a customer deletes a root key that is associated with a cloud resource, the registration between the resources
   * moves to the
   * `Suspended` state. As an integrated service, use
   * `POST /keys/{id}/registrations?action=deactivate` to acknowledge the deletion. This action moves the registration
   * to a `Deactivated` state.
   *
   * @param actionOnRegistrationOptions the {@link ActionOnRegistrationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ActionOnRegistrationResponse}
   * @deprecated this method is deprecated and may be removed in a future release
   */
   @Deprecated
  public ServiceCall<ActionOnRegistrationResponse> actionOnRegistration(ActionOnRegistrationOptions actionOnRegistrationOptions) {
    LOGGER.warning("A deprecated operation has been invoked: actionOnRegistration");
    com.ibm.cloud.sdk.core.util.Validator.notNull(actionOnRegistrationOptions,
      "actionOnRegistrationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", actionOnRegistrationOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/registrations", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "actionOnRegistration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", actionOnRegistrationOptions.bluemixInstance());
    if (actionOnRegistrationOptions.correlationId() != null) {
      builder.header("Correlation-Id", actionOnRegistrationOptions.correlationId());
    }
    if (actionOnRegistrationOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", actionOnRegistrationOptions.xKmsKeyRing());
    }
    if (actionOnRegistrationOptions.prefer() != null) {
      builder.header("Prefer", actionOnRegistrationOptions.prefer());
    }
    builder.query("action", String.valueOf(actionOnRegistrationOptions.action()));
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(actionOnRegistrationOptions.registrationActionOneOf()), "application/json");
    ResponseConverter<ActionOnRegistrationResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ActionOnRegistrationResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List registrations for a key.
   *
   * Retrieves a list of registrations that are associated with a specified root key.
   *
   * When you use a root key to protect an IBM Cloud resource, such as a Cloud Object Storage bucket, Key Protect
   * creates a registration between the resource and root key. You can use `GET /keys/{id}/registrations` to understand
   * which cloud resources are protected by the key that you specify.
   *
   * @param getRegistrationsOptions the {@link GetRegistrationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RegistrationWithTotalCount}
   */
  public ServiceCall<RegistrationWithTotalCount> getRegistrations(GetRegistrationsOptions getRegistrationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRegistrationsOptions,
      "getRegistrationsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getRegistrationsOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/{id}/registrations", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getRegistrations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getRegistrationsOptions.bluemixInstance());
    if (getRegistrationsOptions.correlationId() != null) {
      builder.header("Correlation-Id", getRegistrationsOptions.correlationId());
    }
    if (getRegistrationsOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getRegistrationsOptions.xKmsKeyRing());
    }
    if (getRegistrationsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getRegistrationsOptions.limit()));
    }
    if (getRegistrationsOptions.offset() != null) {
      builder.query("offset", String.valueOf(getRegistrationsOptions.offset()));
    }
    if (getRegistrationsOptions.urlEncodedResourceCrnQuery() != null) {
      builder.query("urlEncodedResourceCRNQuery", String.valueOf(getRegistrationsOptions.urlEncodedResourceCrnQuery()));
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
   * Retrieves a list of registrations that match the Cloud Resource Name
   * (CRN) query that you specify.
   *
   * When you use a root key to protect an IBM Cloud resource, such as a Cloud Object Storage bucket, Key Protect
   * creates a registration between the resource and root key. You can use `GET /keys/registrations` to understand which
   * cloud resources are protected by keys in your Key Protect service instance.
   *
   * @param getRegistrationsAllKeysOptions the {@link GetRegistrationsAllKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RegistrationWithTotalCount}
   */
  public ServiceCall<RegistrationWithTotalCount> getRegistrationsAllKeys(GetRegistrationsAllKeysOptions getRegistrationsAllKeysOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRegistrationsAllKeysOptions,
      "getRegistrationsAllKeysOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v2/keys/registrations"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_key_protect_api", "v2", "getRegistrationsAllKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("Bluemix-Instance", getRegistrationsAllKeysOptions.bluemixInstance());
    if (getRegistrationsAllKeysOptions.correlationId() != null) {
      builder.header("Correlation-Id", getRegistrationsAllKeysOptions.correlationId());
    }
    if (getRegistrationsAllKeysOptions.xKmsKeyRing() != null) {
      builder.header("X-Kms-Key-Ring", getRegistrationsAllKeysOptions.xKmsKeyRing());
    }
    if (getRegistrationsAllKeysOptions.urlEncodedResourceCrnQuery() != null) {
      builder.query("urlEncodedResourceCRNQuery", String.valueOf(getRegistrationsAllKeysOptions.urlEncodedResourceCrnQuery()));
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

}
