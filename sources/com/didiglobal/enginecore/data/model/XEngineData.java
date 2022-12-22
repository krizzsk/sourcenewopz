package com.didiglobal.enginecore.data.model;

import com.google.gson.JsonObject;

public class XEngineData {
    public boolean isCache;
    public JsonObject jsonObject;
    public String requestKey;
    public String traceId;

    public XEngineData(String str, JsonObject jsonObject2) {
        this.requestKey = str;
        this.jsonObject = jsonObject2;
    }

    public XEngineData(String str, JsonObject jsonObject2, String str2) {
        this.requestKey = str;
        this.jsonObject = jsonObject2;
        this.traceId = str2;
    }

    public String toString() {
        return "XEngineData{requestKey='" + this.requestKey + '\'' + ", jsonObject=" + this.jsonObject + ", traceId='" + this.traceId + '\'' + ", isCache=" + this.isCache + '}';
    }
}
