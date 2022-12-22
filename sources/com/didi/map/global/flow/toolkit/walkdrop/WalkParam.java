package com.didi.map.global.flow.toolkit.walkdrop;

import com.didi.common.map.model.LatLng;
import com.didichuxing.routesearchsdk.CallFrom;

public class WalkParam {

    /* renamed from: a */
    private LatLng f27248a;

    /* renamed from: b */
    private long f27249b;

    /* renamed from: c */
    private String f27250c;

    /* renamed from: d */
    private String f27251d;

    /* renamed from: e */
    private CallFrom f27252e;

    /* renamed from: f */
    private boolean f27253f;

    /* renamed from: g */
    private String f27254g;

    /* renamed from: h */
    private long f27255h;

    public LatLng getEndPoint() {
        return this.f27248a;
    }

    public long getDriverId() {
        return this.f27249b;
    }

    public String getOrderId() {
        return this.f27250c;
    }

    public String getProductId() {
        return this.f27251d;
    }

    public void setEndPoint(LatLng latLng) {
        this.f27248a = latLng;
    }

    public void setDriverId(long j) {
        this.f27249b = j;
    }

    public void setOrderId(String str) {
        this.f27250c = str;
    }

    public void setProductId(String str) {
        this.f27251d = str;
    }

    public CallFrom getCallFromm() {
        return this.f27252e;
    }

    public void setCallFromm(CallFrom callFrom) {
        this.f27252e = callFrom;
    }

    public boolean isAnimate() {
        return this.f27253f;
    }

    public void setAnimate(boolean z) {
        this.f27253f = z;
    }

    public String getSrcTag() {
        return this.f27254g;
    }

    public void setSrcTag(String str) {
        this.f27254g = str;
    }

    public long getPushInterval() {
        return this.f27255h;
    }

    public void setPushInterval(long j) {
        this.f27255h = j;
    }
}
