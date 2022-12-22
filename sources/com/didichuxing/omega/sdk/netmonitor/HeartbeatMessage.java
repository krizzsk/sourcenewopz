package com.didichuxing.omega.sdk.netmonitor;

import com.didichuxing.omega.sdk.common.utils.ApiSigner;
import didihttpdns.p230db.DnsConstants;
import java.util.HashMap;

public class HeartbeatMessage {
    private int bizId;
    private int carrier;
    private int cellId;
    private int cityId;
    private String dns;
    private int errCount;
    private int lac;
    private double lat;
    private double lng;
    private int netMode;
    private String packageName;
    private long reqTime;
    private String uid;

    public void setCityId(int i) {
        this.cityId = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setNetMode(int i) {
        this.netMode = i;
    }

    public void setCarrier(int i) {
        this.carrier = i;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setReqTime(long j) {
        this.reqTime = j;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setLac(int i) {
        this.lac = i;
    }

    public void setCellId(int i) {
        this.cellId = i;
    }

    public void setDns(String str) {
        this.dns = str;
    }

    public int getCityId() {
        return this.cityId;
    }

    public String getUid() {
        return this.uid;
    }

    public int getNetMode() {
        return this.netMode;
    }

    public int getCarrier() {
        return this.carrier;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public int getErrCount() {
        return this.errCount;
    }

    public void setErrCount(int i) {
        this.errCount = i;
    }

    public String generatorQueryString() {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", this.uid);
        hashMap.put("cityId", Integer.valueOf(this.cityId));
        hashMap.put("netMode", Integer.valueOf(this.netMode));
        hashMap.put("os", 1);
        hashMap.put("lac", Integer.valueOf(this.lac));
        hashMap.put("cellId", Integer.valueOf(this.cellId));
        hashMap.put("lat", Double.valueOf(this.lat));
        hashMap.put("lng", Double.valueOf(this.lng));
        hashMap.put("timeCost", Long.valueOf(this.reqTime));
        hashMap.put(DnsConstants.DNS_TABLE_NAME, this.dns);
        hashMap.put("packageName", this.packageName);
        hashMap.put("bizId", Integer.valueOf(this.bizId));
        hashMap.put("carrier", Integer.valueOf(this.carrier));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("errCount", Integer.valueOf(this.errCount));
        return ApiSigner.sign(hashMap);
    }
}
