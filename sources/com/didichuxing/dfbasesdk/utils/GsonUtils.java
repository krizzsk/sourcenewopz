package com.didichuxing.dfbasesdk.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import org.json.JSONObject;

public class GsonUtils {

    /* renamed from: a */
    private static Gson f46736a = new GsonBuilder().serializeSpecialFloatingPointValues().create();

    /* renamed from: b */
    private static Gson f46737b = new GsonBuilder().serializeSpecialFloatingPointValues().disableHtmlEscaping().create();

    public static Gson ofGson() {
        return f46736a;
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return f46736a.fromJson(str, cls);
    }

    public static <T> T fromJson(String str, Type type) {
        return f46736a.fromJson(str, type);
    }

    public static <T> T fromJson(JSONObject jSONObject, Class<T> cls) {
        return fromJson(jSONObject.toString(), cls);
    }

    @Deprecated
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return f46736a.toJson(obj);
    }

    public static String toJson(Object obj, boolean z) {
        if (!z) {
            return toJson(obj);
        }
        if (obj == null) {
            return null;
        }
        return f46737b.toJson(obj);
    }

    @Deprecated
    public static String toJsonStr(Object obj) {
        return toJson(obj);
    }

    public static String toJsonStr(Object obj, boolean z) {
        return toJson(obj, z);
    }

    public static <T> T parseSafely(String str, Class<T> cls) {
        try {
            return fromJson(str, cls);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return null;
        }
    }

    public static <T> T parseSafely(String str, Type type) {
        try {
            return fromJson(str, type);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return null;
        }
    }

    public static String getAsString(String str, String str2) {
        try {
            return new JSONObject(str).optString(str2);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return "";
        }
    }

    public static <T> T fromJson(String str, String str2, Class<T> cls) {
        try {
            return fromJson(getAsString(str, str2), cls);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return null;
        }
    }
}
