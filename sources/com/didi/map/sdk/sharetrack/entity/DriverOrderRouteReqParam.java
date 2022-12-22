package com.didi.map.sdk.sharetrack.entity;

public class DriverOrderRouteReqParam {
    public static final int STAGE_ON_TRIP = 4;
    public static final int STAGE_PICKUP = 1;

    /* renamed from: a */
    private String f28633a = "";

    /* renamed from: b */
    private int f28634b = 1;

    /* renamed from: c */
    private int f28635c = 260;

    /* renamed from: d */
    private int f28636d = 0;

    /* renamed from: e */
    private long f28637e = 0;

    /* renamed from: f */
    private long f28638f;

    /* renamed from: g */
    private String f28639g;

    public DriverOrderRouteReqParam() {
    }

    public DriverOrderRouteReqParam(String str, int i, int i2, int i3, long j, long j2) {
        this.f28633a = str;
        this.f28634b = i;
        this.f28635c = i2;
        this.f28636d = i3;
        this.f28637e = j;
        this.f28638f = j2;
    }

    public String getOrderId() {
        return this.f28633a;
    }

    public int getOrderStage() {
        return this.f28634b;
    }

    public int getBizType() {
        return this.f28635c;
    }

    public int getEventType() {
        return this.f28636d;
    }

    public long getTimestamp() {
        return this.f28637e;
    }

    public long getDriverId() {
        return this.f28638f;
    }

    public void setOrderId(String str) {
        this.f28633a = str;
    }

    public void setOrderStage(int i) {
        this.f28634b = i;
    }

    public void setBizType(int i) {
        this.f28635c = i;
    }

    public void setEventType(int i) {
        this.f28636d = i;
    }

    public void setTimestamp(long j) {
        this.f28637e = j;
    }

    public void setDriverId(long j) {
        this.f28638f = j;
    }

    public String getCountryId() {
        return this.f28639g;
    }

    public void setCountryId(String str) {
        this.f28639g = str;
    }
}
