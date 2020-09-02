package com.ibm.cloud.ibm_key_protect_api.v2.model;

import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.Map;
import okhttp3.Response;

public class KeyProtectException extends ServiceResponseException {
    private String correlationId;
    private static final Logger LOG = Logger.getLogger(KeyProtectException.class.getName());
    public KeyProtectException(int statusCode, Response response) {
        super(statusCode, response);
        correlationId = this.getHeaders().values("Correlation-Id").get(0);
        ArrayList list = (ArrayList) this.getDebuggingInfo().get("resources");
        String errorMsg = ((Map) list.get(0)).get("errorMsg").toString();
        this.setMessage(errorMsg);
        LOG.info("Key Protect Exception thrown correlationId: " + correlationId + ", status code: "
                + statusCode + ", Error Message: " + errorMsg);
    }
    public String getCorrelationId() {
        return correlationId;
    }
}
