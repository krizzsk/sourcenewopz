package com.cardinalcommerce.cardinalmobilesdk.models;

import com.cardinalcommerce.p060a.getRequestTimeout;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class Payment implements Serializable {
    private String cca_continue;
    private String configure;
    private getRequestTimeout init;

    public Payment(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.configure = jSONObject.optString("Type", "");
        this.cca_continue = jSONObject.optString("ProcessorTransactionId", "");
        String optString = jSONObject.optString("ExtendedData", "");
        if (optString != null && !optString.isEmpty()) {
            this.init = new getRequestTimeout(optString);
        }
    }

    public String getType() {
        return this.configure;
    }

    public String getProcessorTransactionId() {
        return this.cca_continue;
    }

    public getRequestTimeout getExtendedData() {
        return this.init;
    }
}
