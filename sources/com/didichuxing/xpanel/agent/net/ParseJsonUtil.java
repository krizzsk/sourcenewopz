package com.didichuxing.xpanel.agent.net;

import org.json.JSONObject;

public class ParseJsonUtil {
    public static String optString(JSONObject jSONObject, String str, String str2) {
        return (jSONObject == null || jSONObject.isNull(str)) ? str2 : jSONObject.optString(str, str2);
    }
}
