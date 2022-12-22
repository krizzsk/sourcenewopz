package com.didi.map.sdk.navtracker;

import com.google.gson.annotations.SerializedName;

public class TrackerNavInfo {
    @SerializedName("app_name")
    public String appName;
    @SerializedName("app_version")
    public String appVersion;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("dt")

    /* renamed from: dt */
    public String f28556dt = String.valueOf(System.currentTimeMillis() / 1000);
    @SerializedName("method_type")
    String methodType;
    @SerializedName("order_id")
    public String orderId;
    @SerializedName("os")

    /* renamed from: os */
    public String f28557os = "1";
    @SerializedName("phone_num")
    public String phoneNumber;
    @SerializedName("transaction_id")
    public String transactionId;

    public String toString() {
        return String.format("nav_info|transactionId:%s, orderId:%s, dt:%s, os:%s, appVersion:%s, appName:%s, countryCode:%s, methodType:%s, phoneNumber:%s", new Object[]{this.transactionId, this.orderId, this.f28556dt, this.f28557os, this.appVersion, this.appName, this.countryCode, this.methodType, this.phoneNumber});
    }
}
