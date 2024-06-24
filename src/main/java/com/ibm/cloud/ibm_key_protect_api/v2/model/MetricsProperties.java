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
 * User defined metadata that is associated with the `metrics` instance policy type.
 */
public class MetricsProperties extends GenericModel {

  protected Boolean enabled;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;

    /**
     * Instantiates a new Builder from an existing MetricsProperties instance.
     *
     * @param metricsProperties the instance to initialize the Builder with
     */
    private Builder(MetricsProperties metricsProperties) {
      this.enabled = metricsProperties.enabled;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enabled the enabled
     */
    public Builder(Boolean enabled) {
      this.enabled = enabled;
    }

    /**
     * Builds a MetricsProperties.
     *
     * @return the new MetricsProperties instance
     */
    public MetricsProperties build() {
      return new MetricsProperties(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the MetricsProperties builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }
  }

  protected MetricsProperties() { }

  protected MetricsProperties(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    enabled = builder.enabled;
  }

  /**
   * New builder.
   *
   * @return a MetricsProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * If set to `true`, Key Protect will send service instance metrics to your [Cloud Monitoring With
   * Sysdig](/docs/Monitoring-with-Sysdig?topic=Monitoring-with-Sysdig-getting-started) monitoring instance. By default,
   * sending metrics to your [Cloud Monitoring With
   * Sysdig](/docs/Monitoring-with-Sysdig?topic=Monitoring-with-Sysdig-getting-started) monitoring instance is disabled.
   * **Note:** A metrics policy will add an additional metrics source to your [Cloud Monitoring With
   * Sysdig](/docs/Monitoring-with-Sysdig?topic=Monitoring-with-Sysdig-getting-started) monitoring instance. For more
   * information, see [Enabling Platform
   * Metrics](/docs/Monitoring-with-Sysdig?topic=Monitoring-with-Sysdig-platform_metrics_enabling) for more information.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }
}

