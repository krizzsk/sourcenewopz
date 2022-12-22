package com.didi.dimina.webview.jsbridge;

import org.json.JSONArray;

public class CallbackMessage {

    /* renamed from: a */
    private String f18269a;

    /* renamed from: b */
    private Object[] f18270b;

    public void setCallbackId(String str) {
        this.f18269a = str;
    }

    public void setCallbackArguments(Object[] objArr) {
        this.f18270b = objArr;
    }

    public String getCallbackId() {
        return this.f18269a;
    }

    public JSONArray getArgumentsAsJSONArray() {
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = this.f18270b;
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public String toString() {
        return "CallbackId:" + this.f18269a + "; Data:" + getArgumentsAsJSONArray().toString();
    }
}
