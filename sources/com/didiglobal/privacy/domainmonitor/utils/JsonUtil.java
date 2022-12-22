package com.didiglobal.privacy.domainmonitor.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtil {

    /* renamed from: a */
    private static final Gson f50557a = m36330a(true);

    public static Map<String, Object> json2Map(String str) {
        try {
            Object nextValue = new JSONTokener(str).nextValue();
            if (nextValue instanceof JSONObject) {
                return m36332a((JSONObject) nextValue);
            }
            return null;
        } catch (Throwable th) {
            SystemUtils.log(5, DomainMonitor.TAG, "json2Map: error!", th, "com.didiglobal.privacy.domainmonitor.utils.JsonUtil", 30);
            return null;
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m36332a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    hashMap.put(next, (String) obj);
                } else if (obj instanceof Integer) {
                    hashMap.put(next, (Integer) obj);
                } else if (obj instanceof Long) {
                    hashMap.put(next, (Long) obj);
                } else if (obj instanceof Float) {
                    hashMap.put(next, (Float) obj);
                } else if (obj instanceof Double) {
                    hashMap.put(next, (Double) obj);
                } else if (obj instanceof JSONObject) {
                    hashMap.put(next, m36332a((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    hashMap.put(next, m36331a((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    hashMap.put(next, Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                } else {
                    SystemUtils.log(6, DomainMonitor.TAG, "jo2Map: Unexpected value type:" + obj + ".", (Throwable) null, "com.didiglobal.privacy.domainmonitor.utils.JsonUtil", 60);
                }
            } catch (JSONException e) {
                SystemUtils.log(5, DomainMonitor.TAG, "jo2Map: error!", e, "com.didiglobal.privacy.domainmonitor.utils.JsonUtil", 63);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<Object> m36331a(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    linkedList.add((String) obj);
                } else if (obj instanceof Integer) {
                    linkedList.add((Integer) obj);
                } else if (obj instanceof Long) {
                    linkedList.add((Long) obj);
                } else if (obj instanceof Float) {
                    linkedList.add((Float) obj);
                } else if (obj instanceof Double) {
                    linkedList.add((Double) obj);
                } else if (obj instanceof JSONObject) {
                    linkedList.add(m36332a((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    linkedList.add(m36331a((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    linkedList.add(Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                } else {
                    SystemUtils.log(6, DomainMonitor.TAG, "ja2List: Unexpected value type:" + obj + ".", (Throwable) null, "com.didiglobal.privacy.domainmonitor.utils.JsonUtil", 94);
                }
            } catch (JSONException e) {
                SystemUtils.log(5, DomainMonitor.TAG, "ja2List: error!", e, "com.didiglobal.privacy.domainmonitor.utils.JsonUtil", 97);
            }
        }
        return linkedList;
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return f50557a.fromJson(str, cls);
    }

    /* renamed from: a */
    private static Gson m36330a(boolean z) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (z) {
            gsonBuilder.serializeNulls();
        }
        return gsonBuilder.create();
    }
}
