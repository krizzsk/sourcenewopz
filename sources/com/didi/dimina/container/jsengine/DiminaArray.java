package com.didi.dimina.container.jsengine;

import android.text.TextUtils;
import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Function;
import com.didi.dimina.p108v8.V8ResultUndefined;
import com.didi.dimina.p108v8.V8Value;
import org.json.JSONArray;

public class DiminaArray implements JSArray {

    /* renamed from: a */
    private static final String f16805a = "JSON";

    /* renamed from: b */
    private static final String f16806b = "stringify";

    /* renamed from: c */
    private V8Array f16807c;

    /* renamed from: d */
    private JSONArray f16808d;

    /* renamed from: e */
    private String f16809e;

    /* renamed from: f */
    private C7781V8 f16810f;

    public DiminaArray(C7781V8 v8, V8Array v8Array) {
        this.f16810f = v8;
        this.f16807c = v8Array;
    }

    public int length() {
        m12452a();
        return this.f16807c.length();
    }

    public Object get(int i) {
        m12452a();
        return this.f16807c.get(i);
    }

    public Integer getInteger(int i) {
        m12452a();
        return Integer.valueOf(this.f16807c.getInteger(i));
    }

    public Boolean getBoolean(int i) {
        m12452a();
        return Boolean.valueOf(this.f16807c.getBoolean(i));
    }

    public Double getDouble(int i) {
        m12452a();
        return Double.valueOf(this.f16807c.getDouble(i));
    }

    public String getString(int i) {
        m12452a();
        try {
            return this.f16807c.getString(i);
        } catch (V8ResultUndefined unused) {
            return "";
        }
    }

    public JSArray getArray(int i) {
        m12452a();
        return new DiminaArray(this.f16810f, this.f16807c.getArray(i));
    }

    public JSObject getObject(int i) {
        m12452a();
        return new DiminaObject(this.f16810f, this.f16807c.getObject(i));
    }

    public JSONArray toJSONArray() {
        JSONArray jSONArray = this.f16808d;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            this.f16808d = new JSONArray(toJSONString());
        } catch (Exception unused) {
        }
        return this.f16808d;
    }

    public String toJSONString() {
        V8Function v8Function;
        if (TextUtils.isEmpty(this.f16809e) && (v8Function = this.f16810f.getV8Function(f16805a, f16806b)) != null) {
            V8Array push = new V8Array(this.f16810f).push((V8Value) this.f16807c);
            this.f16809e = (String) v8Function.call(this.f16810f.getV8Object(f16805a), push);
            push.close();
        }
        return this.f16809e;
    }

    public void release() {
        V8Array v8Array = this.f16807c;
        if (v8Array != null) {
            v8Array.close();
        }
    }

    /* renamed from: a */
    private void m12452a() {
        if (this.f16807c == null) {
            throw new IllegalArgumentException("V8Array 为空");
        }
    }
}
