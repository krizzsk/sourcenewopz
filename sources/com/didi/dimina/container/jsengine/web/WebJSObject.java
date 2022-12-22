package com.didi.dimina.container.jsengine.web;

import android.text.TextUtils;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class WebJSObject implements JSObject {

    /* renamed from: a */
    private final JSONObject f16845a;

    /* renamed from: b */
    private String f16846b;

    public void release() {
    }

    public WebJSObject(JSONObject jSONObject, String str) {
        this.f16845a = jSONObject;
        this.f16846b = str;
    }

    public WebJSObject(JSONObject jSONObject) {
        this.f16845a = jSONObject;
    }

    public String[] getKeys() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.f16845a.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public Object get(String str) {
        try {
            return this.f16845a.get(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getInteger(String str) {
        return Integer.valueOf(this.f16845a.optInt(str));
    }

    public Boolean getBoolean(String str) {
        return Boolean.valueOf(this.f16845a.optBoolean(str));
    }

    public Double getDouble(String str) {
        return Double.valueOf(this.f16845a.optDouble(str));
    }

    public String getString(String str) {
        return this.f16845a.optString(str);
    }

    public JSArray getArray(String str) {
        try {
            return new WebJSArray(this.f16845a.getJSONArray(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSObject getObject(String str) {
        try {
            return new WebJSObject(this.f16845a.getJSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject toJSONObject() {
        return this.f16845a;
    }

    public String toJSONString() {
        if (TextUtils.isEmpty(this.f16846b)) {
            this.f16846b = this.f16845a.toString();
        }
        return this.f16846b;
    }
}
