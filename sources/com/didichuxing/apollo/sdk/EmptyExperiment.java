package com.didichuxing.apollo.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public class EmptyExperiment implements IExperiment {
    public String getHitGroup() {
        return "";
    }

    public <T> T getParam(String str, T t) {
        return t;
    }

    public String getStringParam(String str, String str2) {
        return str2;
    }

    public String getTestKey() {
        return "";
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("testKey", getTestKey());
            jSONObject.put("params", new JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public int getIntParam(String str, Integer num) {
        return num.intValue();
    }

    public double getDoubleParam(String str, Double d) {
        return d.doubleValue();
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof EmptyExperiment);
    }

    public int hashCode() {
        return getClass().hashCode() * 31;
    }
}
