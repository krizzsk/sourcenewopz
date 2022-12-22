package com.didi.dimina.container.jsengine;

import android.text.TextUtils;
import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Function;
import com.didi.dimina.p108v8.V8Object;
import com.didi.dimina.p108v8.V8Value;
import org.json.JSONObject;

public class DiminaObject implements JSObject {

    /* renamed from: a */
    private static final String f16811a = "JSON";

    /* renamed from: b */
    private static final String f16812b = "stringify";

    /* renamed from: c */
    private V8Object f16813c;

    /* renamed from: d */
    private JSONObject f16814d;

    /* renamed from: e */
    private String f16815e;

    /* renamed from: f */
    private C7781V8 f16816f;

    public DiminaObject(C7781V8 v8, V8Object v8Object) {
        this.f16816f = v8;
        this.f16813c = v8Object;
    }

    public String[] getKeys() {
        m12453a();
        return this.f16813c.getKeys();
    }

    public Object get(String str) {
        m12453a();
        return this.f16813c.get(str);
    }

    public Integer getInteger(String str) {
        m12453a();
        return Integer.valueOf(this.f16813c.getInteger(str));
    }

    public Boolean getBoolean(String str) {
        m12453a();
        return Boolean.valueOf(this.f16813c.getBoolean(str));
    }

    public Double getDouble(String str) {
        m12453a();
        return Double.valueOf(this.f16813c.getDouble(str));
    }

    public String getString(String str) {
        m12453a();
        return this.f16813c.getString(str);
    }

    public JSArray getArray(String str) {
        m12453a();
        return new DiminaArray(this.f16816f, this.f16813c.getArray(str));
    }

    public JSObject getObject(String str) {
        m12453a();
        return new DiminaObject(this.f16816f, this.f16813c.getObject(str));
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = this.f16814d;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            this.f16814d = new JSONObject(toJSONString());
        } catch (Exception unused) {
        }
        return this.f16814d;
    }

    public String toJSONString() {
        V8Function v8Function;
        if (TextUtils.isEmpty(this.f16815e) && (v8Function = this.f16816f.getV8Function(f16811a, f16812b)) != null) {
            V8Array push = new V8Array(this.f16816f).push((V8Value) this.f16813c);
            this.f16815e = (String) v8Function.call(this.f16816f.getV8Object(f16811a), push);
            push.close();
        }
        return this.f16815e;
    }

    public void release() {
        V8Object v8Object = this.f16813c;
        if (v8Object != null) {
            v8Object.close();
        }
    }

    /* renamed from: a */
    private void m12453a() {
        if (this.f16813c == null) {
            throw new IllegalArgumentException("V8Object 为空");
        }
    }
}
