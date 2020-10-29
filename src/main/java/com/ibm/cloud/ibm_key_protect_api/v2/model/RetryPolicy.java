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
package com.ibm.cloud.ibm_key_protect_api.v2.model;

/**
 * Retry Policy to retry failed Http requests for particular response codes.
 */
public class RetryPolicy {
    private int maxRetry;
    private int retriesRemain;
    private long waitTime;
    private long retryMaxInterval;
    public RetryPolicy(int maxRetry, long retryMaxInterval) {
        this.maxRetry = maxRetry;
        this.retryMaxInterval = retryMaxInterval;
        retriesRemain = maxRetry;
    }

    public boolean allowRetry(int responseCode) {
        // retry for following error codes
        return retriesRemain > 0
                && (responseCode == 429 || responseCode == 502 || responseCode == 503 || responseCode == 504) ;
    }

    public void decreaseRetryCount() {
        retriesRemain = retriesRemain - 1;
    }

    public long waitTime() {
        waitTime = (long) (1 * Math.pow(2, maxRetry - retriesRemain));
        return Math.min(waitTime, retryMaxInterval);
    }
}
