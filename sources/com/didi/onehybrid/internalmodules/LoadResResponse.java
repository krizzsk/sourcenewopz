package com.didi.onehybrid.internalmodules;

import org.json.JSONException;
import org.json.JSONObject;

public class LoadResResponse {

    /* renamed from: a */
    private int f29590a;

    /* renamed from: b */
    private String f29591b;

    /* renamed from: c */
    private String f29592c;

    /* renamed from: d */
    private String f29593d;

    public void setCode(int i) {
        this.f29590a = i;
    }

    public void setVersion(String str) {
        this.f29591b = str;
    }

    public void setMimeType(String str) {
        this.f29592c = str;
    }

    public void setData(String str) {
        this.f29593d = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f29590a);
            jSONObject.put("version", this.f29591b);
            jSONObject.put("mimeType", this.f29592c);
            jSONObject.put("data", this.f29593d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
