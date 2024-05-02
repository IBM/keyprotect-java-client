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
package com.ibm.cloud.ibm_key_protect_api.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CreateKMIPClientCertificateObject.
 */
public class CreateKMIPClientCertificateObject extends GenericModel {

  protected String certificate;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String certificate;
    private String name;

    /**
     * Instantiates a new Builder from an existing CreateKMIPClientCertificateObject instance.
     *
     * @param createKmipClientCertificateObject the instance to initialize the Builder with
     */
    private Builder(CreateKMIPClientCertificateObject createKmipClientCertificateObject) {
      this.certificate = createKmipClientCertificateObject.certificate;
      this.name = createKmipClientCertificateObject.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param certificate the certificate
     */
    public Builder(String certificate) {
      this.certificate = certificate;
    }

    /**
     * Builds a CreateKMIPClientCertificateObject.
     *
     * @return the new CreateKMIPClientCertificateObject instance
     */
    public CreateKMIPClientCertificateObject build() {
      return new CreateKMIPClientCertificateObject(this);
    }

    /**
     * Set the certificate.
     *
     * @param certificate the certificate
     * @return the CreateKMIPClientCertificateObject builder
     */
    public Builder certificate(String certificate) {
      this.certificate = certificate;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateKMIPClientCertificateObject builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected CreateKMIPClientCertificateObject() { }

  protected CreateKMIPClientCertificateObject(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.certificate,
      "certificate cannot be null");
    certificate = builder.certificate;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a CreateKMIPClientCertificateObject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the certificate.
   *
   * The client certificate to be associated with the KMIP Adapter. It should explicitly have the BEGIN CERTIFICATE and
   * END CERTIFICATE tags.
   *
   * @return the certificate
   */
  public String certificate() {
    return certificate;
  }

  /**
   * Gets the name.
   *
   * A human-readable name that uniquely identifies a certificate within the given adapter. If one is  not specified,
   * one will be autogenerated of the format `kmip_certificate_&lt;timestamp&gt;_&lt;random_string&gt;`. To protect your
   * privacy do not use personal data, such as your name or location, as a name for your client certificate. The name
   * must be  alphanumeric and cannot contain spaces or special characters other than `-` or `_`. The name cannot be a
   * UUID and must not be a Key Protect reserved name: `allowed_ip`, `key`,`keys`, `metadata`, `policy`, `policies`,
   * `registration`, `registrations`, `ring`, `rings`, `rotate`, `wrap`, `unwrap`, `rewrap`, `version`, `versions`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

