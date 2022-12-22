package com.didi.dimina.container.jsengine.web;

import android.text.TextUtils;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSObject;
import org.json.JSONArray;

public class WebJSArray implements JSArray {

    /* renamed from: a */
    private final JSONArray f16843a;

    /* renamed from: b */
    private String f16844b;

    public void release() {
    }

    public WebJSArray(JSONArray jSONArray, String str) {
        this.f16843a = jSONArray;
        this.f16844b = str;
    }

    public WebJSArray(JSONArray jSONArray) {
        this.f16843a = jSONArray;
    }

    public int length() {
        return this.f16843a.length();
    }

    public Object get(int i) {
        return this.f16843a.opt(i);
    }

    public Integer getInteger(int i) {
        return Integer.valueOf(this.f16843a.optInt(i));
    }

    public Boolean getBoolean(int i) {
        return Boolean.valueOf(this.f16843a.optBoolean(i));
    }

    public Double getDouble(int i) {
        return Double.valueOf(this.f16843a.optDouble(i));
    }

    public String getString(int i) {
        return this.f16843a.optString(i);
    }

    public JSArray getArray(int i) {
        return new WebJSArray(this.f16843a.optJSONArray(i));
    }

    public JSObject getObject(int i) {
        return new WebJSObject(this.f16843a.optJSONObject(i));
    }

    public JSONArray toJSONArray() {
        return this.f16843a;
    }

    public String toJSONString() {
        if (TextUtils.isEmpty(this.f16844b)) {
            this.f16844b = this.f16843a.toString();
        }
        return this.f16844b;
    }
}
