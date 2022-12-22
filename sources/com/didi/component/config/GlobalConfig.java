package com.didi.component.config;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalConfig {

    /* renamed from: b */
    private static final String f12597b = "data";

    /* renamed from: c */
    private static final String f12598c = "baseConf";

    /* renamed from: a */
    final Map<Object, C5268a> f12599a = new LinkedHashMap();

    public static GlobalConfig fromJSON(String str) throws WrongConfigException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m8584a(new JSONObject(str));
        } catch (JSONException e) {
            WrongConfigException wrongConfigException = new WrongConfigException(e.getMessage());
            wrongConfigException.setStackTrace(e.getStackTrace());
            throw wrongConfigException;
        }
    }

    /* renamed from: a */
    static GlobalConfig m8584a(JSONObject jSONObject) throws JSONException {
        Map<Object, C5268a> map = null;
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray(f12598c);
        if (optJSONArray != null) {
            map = m8585a(optJSONArray);
        }
        GlobalConfig globalConfig = new GlobalConfig();
        if (map != null && !map.isEmpty()) {
            globalConfig.f12599a.putAll(map);
        }
        return globalConfig;
    }

    /* renamed from: b */
    private static Map<String, String> m8586b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String string = jSONObject.getString(next);
            if (TextUtils.isEmpty(next) || TextUtils.isEmpty(string)) {
                throw new JSONException("Unknown plugin info, key=" + next + ", value=" + string);
            }
            linkedHashMap.put(next, string);
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private static Map<Object, C5268a> m8585a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            C5268a a = C5268a.m8592a(jSONArray.getJSONObject(i));
            if (a != null) {
                if (a.f12625a > 0) {
                    linkedHashMap.put(Integer.valueOf(a.f12625a), a);
                } else if (!TextUtils.isEmpty(a.f12626b)) {
                    linkedHashMap.put(a.f12626b, a);
                }
            }
        }
        return linkedHashMap;
    }

    public static class WrongConfigException extends Exception {
        public WrongConfigException(String str) {
            super(str);
        }
    }
}
