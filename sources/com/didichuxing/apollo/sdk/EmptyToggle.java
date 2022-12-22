package com.didichuxing.apollo.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public class EmptyToggle implements IToggle {

    /* renamed from: a */
    private boolean f45599a = false;

    public String getName() {
        return "";
    }

    public boolean allow() {
        return this.f45599a;
    }

    public void setDefaultAllow(boolean z) {
        this.f45599a = z;
    }

    public IExperiment getExperiment() {
        return new EmptyExperiment();
    }

    public Integer getLogRate() {
        return 0;
    }

    public Integer getCachePlan() {
        return 0;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("allow", allow());
            jSONObject.put("experiment", new EmptyExperiment().toJsonObject());
            jSONObject.put("logRate", getLogRate());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof EmptyToggle);
    }

    public int hashCode() {
        int hashCode = (((getName().hashCode() * 31) + new Boolean(allow()).hashCode()) * 31) + getExperiment().hashCode();
        return getLogRate() != null ? (hashCode * 31) + getLogRate().hashCode() : hashCode;
    }

    public String toString() {
        return "EmptyToggle{defaultAllow=" + this.f45599a + '}';
    }
}
