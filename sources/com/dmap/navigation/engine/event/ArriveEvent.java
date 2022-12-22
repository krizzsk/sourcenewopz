package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class ArriveEvent extends NaviEvent {

    /* renamed from: a */
    private final boolean f51850a;

    /* renamed from: b */
    private final LatLng f51851b;

    /* renamed from: c */
    private final LatLng f51852c;

    /* renamed from: d */
    private final LatLng f51853d;

    /* renamed from: e */
    private final int f51854e;

    /* renamed from: f */
    private final int f51855f;

    public ArriveEvent(boolean z, NaviLatLng naviLatLng, NaviLatLng naviLatLng2, NaviLatLng naviLatLng3, int i, int i2) {
        this.f51850a = z;
        this.f51851b = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f51852c = new SimpleLatlng(naviLatLng2.getLat(), naviLatLng2.getLng());
        this.f51853d = new SimpleLatlng(naviLatLng3.getLat(), naviLatLng3.getLng());
        this.f51854e = i;
        this.f51855f = i2;
    }

    public String toString() {
        return "ArriveEvent{isTerminal=" + this.f51850a + ", originalPoint=" + this.f51851b + ", matchedPoint=" + this.f51852c + ", destPoint=" + this.f51853d + ", destNo=" + this.f51854e + ", callBackType=" + this.f51855f + '}';
    }

    public boolean isTerminal() {
        return this.f51850a;
    }

    public LatLng getOriginalPoint() {
        return this.f51851b;
    }

    public LatLng getMatchedPoint() {
        return this.f51852c;
    }

    public LatLng getDestPoint() {
        return this.f51853d;
    }

    public int getDestNo() {
        return this.f51854e;
    }

    public int getCallBackType() {
        return this.f51855f;
    }
}
