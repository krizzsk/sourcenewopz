package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class IllegalParkEvent extends NaviEvent {
    public static final int HIDE_START = 3;

    /* renamed from: a */
    private final int f51889a;

    /* renamed from: b */
    private final int f51890b;

    /* renamed from: c */
    private final int f51891c;

    /* renamed from: d */
    private final String f51892d;

    /* renamed from: e */
    private final String f51893e;

    /* renamed from: f */
    private final LatLng f51894f;

    /* renamed from: g */
    private final LatLng f51895g;

    public IllegalParkEvent(int i, int i2, int i3, String str, String str2, NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        this.f51889a = i;
        this.f51890b = i2;
        this.f51891c = i3;
        this.f51892d = str;
        this.f51893e = str2;
        this.f51894f = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f51895g = new SimpleLatlng(naviLatLng2.getLat(), naviLatLng2.getLng());
    }

    public String toString() {
        return "IllegalParkEvent{updateType=" + this.f51889a + ", state=" + this.f51890b + ", induceState=" + this.f51891c + ", topContent='" + this.f51892d + '\'' + ", bottomContent='" + this.f51893e + '\'' + ", startPos=" + this.f51894f + ", endPos=" + this.f51895g + '}';
    }

    public int getUpdateType() {
        return this.f51889a;
    }

    public int getState() {
        return this.f51890b;
    }

    public int getInduceState() {
        return this.f51891c;
    }

    public String getTopContent() {
        return this.f51892d;
    }

    public String getBottomContent() {
        return this.f51893e;
    }

    public LatLng getStartPos() {
        return this.f51894f;
    }

    public LatLng getEndPos() {
        return this.f51895g;
    }
}
