package com.didi.hawaii.utils;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static String getString(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static int getInt(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return 0;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static Long getLong(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return Long.valueOf(jSONObject.getLong(str));
            } catch (JSONException unused) {
            }
        }
        return 0L;
    }

    public static double getDouble(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return 0.0d;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0d;
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Object getObject(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.get(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean getBoolean(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return false;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static String filterWebString(String str) {
        return str.startsWith("var") ? str.substring(str.indexOf(Const.joLeft)) : str;
    }
}
