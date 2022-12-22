package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class LimitSpeedCameraEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51918a;

    /* renamed from: b */
    private final int f51919b;

    /* renamed from: c */
    private final int f51920c;

    /* renamed from: d */
    private final LatLng f51921d;

    /* renamed from: e */
    private final String f51922e;

    public LimitSpeedCameraEvent(int i, int i2, int i3, NaviLatLng naviLatLng, String str) {
        this.f51918a = i;
        this.f51919b = i2;
        this.f51920c = i3;
        this.f51921d = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f51922e = str;
    }

    public String toString() {
        return "LimitSpeedCameraEvent{updateType=" + this.f51918a + ", type=" + this.f51919b + ", speed=" + this.f51920c + ", location=" + this.f51921d + ", describe='" + this.f51922e + '\'' + '}';
    }

    public int getUpdateType() {
        return this.f51918a;
    }

    public int getType() {
        return this.f51919b;
    }

    public int getSpeed() {
        return this.f51920c;
    }

    public LatLng getLocation() {
        return this.f51921d;
    }

    public String getDescribe() {
        return this.f51922e;
    }
}
