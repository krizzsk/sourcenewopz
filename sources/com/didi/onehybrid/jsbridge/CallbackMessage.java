package com.didi.onehybrid.jsbridge;

import org.json.JSONArray;

public class CallbackMessage {

    /* renamed from: a */
    private String f29605a;

    /* renamed from: b */
    private Object[] f29606b;

    public void setCallbackId(String str) {
        this.f29605a = str;
    }

    public void setCallbackArguments(Object[] objArr) {
        this.f29606b = objArr;
    }

    public String getCallbackId() {
        return this.f29605a;
    }

    public JSONArray getArgumentsAsJSONArray() {
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = this.f29606b;
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public String toString() {
        return "CallbackId:" + this.f29605a + "; Data:" + getArgumentsAsJSONArray().toString();
    }
}
