package com.didi.map.global.component.line.pax.walkanddropoff.newversion;

import com.didi.common.map.model.LatLng;

public class NewWalkParam {

    /* renamed from: a */
    private LatLng f25946a;

    /* renamed from: b */
    private long f25947b;

    /* renamed from: c */
    private String f25948c;

    /* renamed from: d */
    private String f25949d;

    /* renamed from: e */
    private long f25950e;

    public NewWalkParam(LatLng latLng, long j, String str, String str2, long j2) {
        this.f25946a = latLng;
        this.f25947b = j;
        this.f25948c = str;
        this.f25949d = str2;
        this.f25950e = j2;
    }

    public LatLng getEndPoint() {
        return this.f25946a;
    }

    public long getDriverId() {
        return this.f25947b;
    }

    public String getOrderId() {
        return this.f25948c;
    }

    public String getProductId() {
        return this.f25949d;
    }

    public void setEndPoint(LatLng latLng) {
        this.f25946a = latLng;
    }

    public void setProductId(String str) {
        this.f25949d = str;
    }

    public long getPushInterval() {
        return this.f25950e;
    }
}
