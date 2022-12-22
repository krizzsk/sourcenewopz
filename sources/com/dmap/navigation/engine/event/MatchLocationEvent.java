package com.dmap.navigation.engine.event;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.engine.simple.SimpleLocation;
import com.dmap.navigation.jni.swig.NaviLocation;
import java.math.BigInteger;

public final class MatchLocationEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51928a;

    /* renamed from: b */
    private final int f51929b;

    /* renamed from: c */
    private final double f51930c;

    /* renamed from: d */
    private final int f51931d;

    /* renamed from: e */
    private final INaviLocation f51932e;

    /* renamed from: f */
    private final BigInteger f51933f;

    public MatchLocationEvent(BigInteger bigInteger, NaviLocation naviLocation, int i, int i2, double d, int i3) {
        this.f51933f = bigInteger;
        this.f51932e = new SimpleLocation(naviLocation);
        this.f51928a = i;
        this.f51929b = i2;
        this.f51930c = d;
        this.f51931d = i3;
    }

    public final String toString() {
        return "MatchLocationEvent{matchIndex=" + this.f51928a + ", matchedStatus=" + this.f51929b + ", shapeOffset=" + this.f51930c + ", navigationType=" + this.f51931d + ", location=" + this.f51932e + ", routeId=" + this.f51933f + '}';
    }

    public final int getMatchIndex() {
        return this.f51928a;
    }

    public final int getMatchedStatus() {
        return this.f51929b;
    }

    public final double getShapeOffset() {
        return this.f51930c;
    }

    public final int getNavigationType() {
        return this.f51931d;
    }

    public final INaviLocation getLocation() {
        return this.f51932e;
    }

    public final BigInteger getRouteId() {
        return this.f51933f;
    }
}
