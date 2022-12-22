package com.didichuxing.mas.sdk.quality.report.customevent;

import com.google.gson.annotations.SerializedName;

public class CustomEventUp {
    @SerializedName("key")
    String key;
    @SerializedName("ts")

    /* renamed from: ts */
    long f48289ts;
    @SerializedName("value")
    String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public long getTs() {
        return this.f48289ts;
    }

    public void setTs(long j) {
        this.f48289ts = j;
    }

    public String toString() {
        return "CustomEventUp{key='" + this.key + '\'' + ", value='" + this.value + '\'' + ", ts=" + this.f48289ts + '}';
    }

    public CustomEventUp(String str, String str2, long j) {
        this.key = str;
        this.value = str2;
        this.f48289ts = j;
    }

    public CustomEventUp(CustomEvent customEvent) {
        this.key = customEvent.getKey();
        this.value = customEvent.getValue();
        this.f48289ts = customEvent.getUpdateTime();
    }
}
