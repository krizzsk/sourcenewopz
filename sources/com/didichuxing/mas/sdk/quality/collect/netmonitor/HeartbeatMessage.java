package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import com.didichuxing.mas.sdk.quality.report.utils.ApiSigner;
import didihttpdns.p230db.DnsConstants;
import java.util.HashMap;

public class HeartbeatMessage {

    /* renamed from: a */
    private int f48164a;

    /* renamed from: b */
    private String f48165b;

    /* renamed from: c */
    private int f48166c;

    /* renamed from: d */
    private int f48167d;

    /* renamed from: e */
    private double f48168e;

    /* renamed from: f */
    private double f48169f;

    /* renamed from: g */
    private long f48170g;

    /* renamed from: h */
    private int f48171h;

    /* renamed from: i */
    private String f48172i;

    /* renamed from: j */
    private String f48173j;

    /* renamed from: k */
    private int f48174k;

    /* renamed from: l */
    private int f48175l;

    /* renamed from: m */
    private int f48176m;

    public void setCityId(int i) {
        this.f48164a = i;
    }

    public void setUid(String str) {
        this.f48165b = str;
    }

    public void setNetMode(int i) {
        this.f48166c = i;
    }

    public void setCarrier(int i) {
        this.f48167d = i;
    }

    public void setLat(double d) {
        this.f48168e = d;
    }

    public void setLng(double d) {
        this.f48169f = d;
    }

    public void setReqTime(long j) {
        this.f48170g = j;
    }

    public void setBizId(int i) {
        this.f48171h = i;
    }

    public void setPackageName(String str) {
        this.f48172i = str;
    }

    public void setLac(int i) {
        this.f48174k = i;
    }

    public void setCellId(int i) {
        this.f48175l = i;
    }

    public void setDns(String str) {
        this.f48173j = str;
    }

    public int getCityId() {
        return this.f48164a;
    }

    public String getUid() {
        return this.f48165b;
    }

    public int getNetMode() {
        return this.f48166c;
    }

    public int getCarrier() {
        return this.f48167d;
    }

    public double getLat() {
        return this.f48168e;
    }

    public double getLng() {
        return this.f48169f;
    }

    public int getErrCount() {
        return this.f48176m;
    }

    public void setErrCount(int i) {
        this.f48176m = i;
    }

    public String generatorQueryString() {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", this.f48165b);
        hashMap.put("cityId", Integer.valueOf(this.f48164a));
        hashMap.put("netMode", Integer.valueOf(this.f48166c));
        hashMap.put("os", 1);
        hashMap.put("lac", Integer.valueOf(this.f48174k));
        hashMap.put("cellId", Integer.valueOf(this.f48175l));
        hashMap.put("lat", Double.valueOf(this.f48168e));
        hashMap.put("lng", Double.valueOf(this.f48169f));
        hashMap.put("timeCost", Long.valueOf(this.f48170g));
        hashMap.put(DnsConstants.DNS_TABLE_NAME, this.f48173j);
        hashMap.put("packageName", this.f48172i);
        hashMap.put("bizId", Integer.valueOf(this.f48171h));
        hashMap.put("carrier", Integer.valueOf(this.f48167d));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("errCount", Integer.valueOf(this.f48176m));
        return ApiSigner.sign(hashMap);
    }
}
