package com.didi.dimina.container.jsengine;

import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.utils.V8ObjectUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DiminaObjectAdapter {
    public static Object toV8Object(C7781V8 v8, Object obj) {
        if (obj instanceof Map) {
            return V8ObjectUtils.toV8Object(v8, (Map<String, ? extends Object>) (Map) obj);
        }
        if (obj instanceof List) {
            return V8ObjectUtils.toV8Array(v8, (List<? extends Object>) (List) obj);
        }
        if (obj instanceof JSONObject) {
            return V8ObjectUtils.toV8Object(v8, (JSONObject) obj);
        }
        return obj instanceof JSONArray ? V8ObjectUtils.toV8Array(v8, (JSONArray) obj) : obj;
    }
}
