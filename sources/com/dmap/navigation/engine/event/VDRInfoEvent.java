package com.dmap.navigation.engine.event;

import java.math.BigInteger;

public class VDRInfoEvent extends NaviEvent {

    /* renamed from: a */
    private final BigInteger f51973a;

    /* renamed from: b */
    private final double f51974b;

    /* renamed from: c */
    private final double f51975c;

    /* renamed from: d */
    private final float f51976d;

    /* renamed from: e */
    private final int f51977e;

    /* renamed from: f */
    private final int f51978f;

    public VDRInfoEvent(BigInteger bigInteger, double d, double d2, float f, int i, int i2) {
        this.f51973a = bigInteger;
        this.f51974b = d;
        this.f51975c = d2;
        this.f51976d = f;
        this.f51977e = i;
        this.f51978f = i2;
    }

    public String toString() {
        return "VDRInfoEvent{planLinkID=" + this.f51973a + ", planProjLon=" + this.f51974b + ", pLanProjLat=" + this.f51975c + ", planDirection=" + this.f51976d + ", planGeoCoorIndex=" + this.f51977e + ", tunnelFlag=" + this.f51978f + '}';
    }

    public BigInteger getPlanLinkID() {
        return this.f51973a;
    }

    public double getPlanProjLon() {
        return this.f51974b;
    }

    public double getpLanProjLat() {
        return this.f51975c;
    }

    public float getPlanDirection() {
        return this.f51976d;
    }

    public int getPlanGeoCoorIndex() {
        return this.f51977e;
    }

    public int getTunnelFlag() {
        return this.f51978f;
    }
}
