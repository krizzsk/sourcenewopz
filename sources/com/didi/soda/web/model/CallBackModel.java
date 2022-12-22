package com.didi.soda.web.model;

import org.json.JSONObject;

public class CallBackModel {
    public static final int CANCEL = 2;
    public static final int FAIL = 1;
    public static final int SUCCESS = 0;
    public JSONObject data;
    public String errmsg;
    public int errno;

    public CallBackModel(int i, String str, JSONObject jSONObject) {
        this.errno = i;
        this.errmsg = str;
        this.data = jSONObject;
    }

    public CallBackModel(int i, JSONObject jSONObject) {
        this.errno = i;
        this.data = jSONObject;
    }

    public CallBackModel(JSONObject jSONObject) {
        this.errno = 0;
        this.data = jSONObject;
    }
}
