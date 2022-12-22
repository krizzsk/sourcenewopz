package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class IntersectionEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51896a;

    /* renamed from: b */
    private final String f51897b;

    /* renamed from: c */
    private final String f51898c;

    /* renamed from: d */
    private final int f51899d;

    /* renamed from: e */
    private final int f51900e;

    /* renamed from: f */
    private final String f51901f;

    /* renamed from: g */
    private final boolean f51902g;

    /* renamed from: h */
    private final int f51903h;

    /* renamed from: i */
    private final int f51904i;

    /* renamed from: j */
    private final int f51905j;

    /* renamed from: k */
    private final LatLng f51906k;

    /* renamed from: l */
    private final int f51907l;

    public IntersectionEvent(int i, String str, String str2, int i2, int i3, int i4, NaviLatLng naviLatLng, int i5, int i6, String str3, boolean z, int i7) {
        this.f51896a = i;
        this.f51897b = str;
        this.f51898c = str2;
        this.f51899d = i2;
        this.f51900e = i3;
        this.f51905j = i4;
        this.f51903h = i5;
        this.f51904i = i6;
        this.f51901f = str3;
        this.f51902g = z;
        this.f51906k = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f51907l = i7;
    }

    public String toString() {
        return "IntersectionEvent{updateType=" + this.f51896a + ", roadName='" + this.f51897b + '\'' + ", nextRoadName='" + this.f51898c + '\'' + ", leftDistance=" + this.f51899d + ", intersection=" + this.f51900e + ", highWayNumber='" + this.f51901f + '\'' + ", inHighWay=" + this.f51902g + ", actionLength=" + this.f51903h + ", connectLength=" + this.f51904i + ", index=" + this.f51905j + ", targetPos=" + this.f51906k + ", nextIntersection=" + this.f51907l + '}';
    }

    public int getUpdateType() {
        return this.f51896a;
    }

    public String getRoadName() {
        return this.f51897b;
    }

    public String getNextRoadName() {
        return this.f51898c;
    }

    public int getLeftDistance() {
        return this.f51899d;
    }

    public int getIntersection() {
        return this.f51900e;
    }

    public String getHighWayNumber() {
        return this.f51901f;
    }

    public boolean isInHighWay() {
        return this.f51902g;
    }

    public int getActionLength() {
        return this.f51903h;
    }

    public int getConnectLength() {
        return this.f51904i;
    }

    public int getIndex() {
        return this.f51905j;
    }

    public LatLng getTargetPos() {
        return this.f51906k;
    }

    public int getNextIntersection() {
        return this.f51907l;
    }
}
