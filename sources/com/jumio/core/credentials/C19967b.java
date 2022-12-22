package com.jumio.core.credentials;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jumio.core.credentials.b */
/* compiled from: JCredentialCapabilities */
public enum C19967b {
    UNKNOWN,
    STORAGE,
    EXTRACTION,
    AUTHENTICATION,
    SIMILARITY,
    FRAUD_LOOKUPS;

    /* renamed from: a */
    public static C19967b m39537a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("name");
        if ("STORAGE".equals(string)) {
            return STORAGE;
        }
        if ("EXTRACTION".equals(string)) {
            return EXTRACTION;
        }
        if ("AUTHENTICATION".equals(string)) {
            return AUTHENTICATION;
        }
        if ("SIMILARITY".equals(string)) {
            return SIMILARITY;
        }
        if ("FRAUD_LOOKUPS".equals(string)) {
            return FRAUD_LOOKUPS;
        }
        return UNKNOWN;
    }
}
