package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.route.IRouteTag;
import com.dmap.navigation.jni.swig.NaviRouteTag;
import com.dmap.navigation.simple.SimpleLatlng;

/* renamed from: com.dmap.navigation.engine.a.h */
/* compiled from: SimpleRouteTag */
public final class C17395h implements IRouteTag {

    /* renamed from: a */
    private String f51807a;

    /* renamed from: b */
    private String f51808b;

    /* renamed from: c */
    private LatLng f51809c;

    public C17395h(NaviRouteTag naviRouteTag) {
        this.f51807a = naviRouteTag.getKey();
        this.f51808b = naviRouteTag.getValue();
        this.f51809c = new SimpleLatlng(naviRouteTag.getPosition().getLat(), naviRouteTag.getPosition().getLng());
    }

    public final String toString() {
        return "SimpleRouteTag{key='" + this.f51807a + '\'' + ", value='" + this.f51808b + '\'' + ", position=" + this.f51809c + '}';
    }

    public final String getKey() {
        return this.f51807a;
    }

    public final String getValue() {
        return this.f51808b;
    }

    public final LatLng getPosition() {
        return this.f51809c;
    }
}
