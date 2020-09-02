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
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
 * Retry Interceptor which intercepts the http response and checks if it needs to retry based on response code
 */
public class RetryInterceptor implements Interceptor {
    private int maxRetry;
    private long retryMaxInterval;
    private static final Logger LOG = Logger.getLogger(RetryInterceptor.class.getName());

    public RetryInterceptor(int maxRetry, long retryMaxInterval) {
        this.maxRetry = maxRetry;
        this.retryMaxInterval = retryMaxInterval;
    }

    @Override public Response intercept(Interceptor.Chain chain)  throws IOException {
        RetryPolicy retryPolicy = new RetryPolicy(maxRetry, retryMaxInterval);
        Request request = chain.request();
        Response response = chain.proceed(request);
        try {
            while (retryPolicy.allowRetry(response.code())) {
                response.close();
                LOG.info("retrying after recieved http reponse : " + response.code());
                //exponential wait time between HTTP retries
                TimeUnit.SECONDS.sleep(retryPolicy.waitTime());
                Request newRequest = chain.request();
                response = chain.proceed(newRequest);
                retryPolicy.decreaseRetryCount();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return response;
    }
}

