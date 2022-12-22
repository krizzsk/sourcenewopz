package com.cardinalcommerce.cardinalmobilesdk.models;

import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.p060a.CardinalEnvironment;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class ValidateResponse implements Serializable {
    private boolean Cardinal;
    private String cca_continue;
    private int configure;
    private CardinalActionCode getInstance;
    private Payment init;

    public ValidateResponse(CardinalActionCode cardinalActionCode, CardinalError cardinalError) {
        this.Cardinal = false;
        this.getInstance = cardinalActionCode;
        this.configure = cardinalError.Cardinal;
        this.cca_continue = cardinalError.init;
    }

    public ValidateResponse(String str) throws UnsupportedOperationException, JSONException {
        String[] split = str.split("\\.");
        String optString = new JSONObject(split.length > 1 ? CardinalEnvironment.cca_continue(split[1]) : null).optString("Payload", "");
        if (!optString.isEmpty()) {
            JSONObject jSONObject = new JSONObject(optString);
            String optString2 = jSONObject.optString("Payment", "");
            this.Cardinal = jSONObject.optBoolean("Validated", false);
            if (!optString2.isEmpty()) {
                this.init = new Payment(optString2);
            }
            this.getInstance = CardinalActionCode.getActionCode(jSONObject.optString("ActionCode", ""));
            this.configure = jSONObject.optInt("ErrorNumber", 0);
            this.cca_continue = jSONObject.optString("ErrorDescription", "");
        }
    }

    public boolean isValidated() {
        return this.Cardinal;
    }

    public Payment getPayment() {
        return this.init;
    }

    public CardinalActionCode getActionCode() {
        return this.getInstance;
    }

    public int getErrorNumber() {
        return this.configure;
    }

    public String getErrorDescription() {
        return this.cca_continue;
    }
}
