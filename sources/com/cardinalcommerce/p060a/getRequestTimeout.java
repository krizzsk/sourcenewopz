package com.cardinalcommerce.p060a;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.getRequestTimeout */
public class getRequestTimeout implements Serializable {
    public getRequestTimeout(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        jSONObject.optString("CAVV", "");
        jSONObject.optString("ECIFlag", "");
        jSONObject.optString("XID", "");
        jSONObject.optString("PAResStatus", "");
        jSONObject.optString("SignatureVerification", "");
        jSONObject.optString("Enrolled", "");
    }
}
