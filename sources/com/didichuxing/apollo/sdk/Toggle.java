package com.didichuxing.apollo.sdk;

import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

public class Toggle implements IToggle {
    @SerializedName("allow")
    public boolean mAllow = false;
    @SerializedName("cache_plan")
    public Integer mCachePlan;
    @SerializedName("assign")
    public Experiment mExperiment;
    @SerializedName("log_rate")
    public Integer mLogRate;
    @SerializedName("name")
    public String mName = "";

    public String getName() {
        String str = this.mName;
        return str == null ? "" : str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.mName);
            jSONObject.put("allow", this.mAllow);
            jSONObject.put("experiment", (this.mExperiment == null ? new EmptyExperiment() : this.mExperiment).toJsonObject());
            jSONObject.put("logRate", this.mLogRate);
            jSONObject.put("cachePlan", this.mCachePlan);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean allow() {
        return this.mAllow;
    }

    public IExperiment getExperiment() {
        Experiment experiment = this.mExperiment;
        return experiment == null ? new EmptyExperiment() : experiment;
    }

    public Integer getLogRate() {
        return this.mLogRate;
    }

    public Integer getCachePlan() {
        Integer num = this.mCachePlan;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Toggle)) {
            return false;
        }
        Toggle toggle = (Toggle) obj;
        if (toggle.mLogRate == null) {
            toggle.mLogRate = 0;
        }
        if (getLogRate() == null) {
            this.mLogRate = 0;
        }
        if (!toggle.mName.equals(this.mName) || toggle.mAllow != this.mAllow || !toggle.getExperiment().equals(getExperiment()) || !toggle.mLogRate.equals(this.mLogRate) || !toggle.mCachePlan.equals(this.mCachePlan)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((this.mName.hashCode() * 31) + new Boolean(this.mAllow).hashCode()) * 31) + getExperiment().hashCode();
        return getLogRate() != null ? (hashCode * 31) + getLogRate().hashCode() : hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(120);
        sb.append("{Toggle: [name=");
        sb.append(this.mName);
        sb.append("][allow=");
        sb.append(this.mAllow);
        sb.append("][experiment=");
        sb.append(this.mExperiment);
        sb.append("]}");
        return sb.toString();
    }
}
