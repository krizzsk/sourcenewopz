package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.api.route.ITunnelGeoPoint;
import com.dmap.navigation.jni.swig.TunnelGeoPoint;

/* renamed from: com.dmap.navigation.engine.a.k */
/* compiled from: SimpleTunnelGeoPoint */
public final class C17398k implements ITunnelGeoPoint {

    /* renamed from: a */
    private final int f51820a;

    /* renamed from: b */
    private final int f51821b;

    /* renamed from: c */
    private final int f51822c;

    /* renamed from: d */
    private final int f51823d;

    /* renamed from: e */
    private final int f51824e;

    public C17398k(TunnelGeoPoint tunnelGeoPoint) {
        this.f51820a = tunnelGeoPoint.getLat();
        this.f51821b = tunnelGeoPoint.getLng();
        this.f51822c = tunnelGeoPoint.getEnd();
        this.f51823d = tunnelGeoPoint.getIndex();
        this.f51824e = tunnelGeoPoint.getDefaultSpeed();
    }

    public final int getLat() {
        return this.f51820a;
    }

    public final int getLng() {
        return this.f51821b;
    }

    public final int getEnd() {
        return this.f51822c;
    }

    public final int getIndex() {
        return this.f51823d;
    }

    public final int getDefaultSpeed() {
        return this.f51824e;
    }
}
