package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.route.IMarkerSection;
import com.dmap.navigation.jni.swig.MarkerSection;
import com.dmap.navigation.simple.SimpleLatlng;

/* renamed from: com.dmap.navigation.engine.a.e */
/* compiled from: SimpleMarkerSection */
final class C17392e implements IMarkerSection {

    /* renamed from: a */
    private final int f51765a;

    /* renamed from: b */
    private final int f51766b;

    /* renamed from: c */
    private final LatLng f51767c;

    /* renamed from: d */
    private final LatLng f51768d;

    public C17392e(MarkerSection markerSection) {
        this.f51765a = markerSection.getStartNum();
        this.f51766b = markerSection.getEndNum();
        this.f51767c = new SimpleLatlng(markerSection.getStartPoint().getLat(), markerSection.getStartPoint().getLng());
        this.f51768d = new SimpleLatlng(markerSection.getEndPoint().getLat(), markerSection.getEndPoint().getLng());
    }

    public final int getStartIndex() {
        return this.f51765a;
    }

    public final int getEndIndex() {
        return this.f51766b;
    }

    public final LatLng getStart() {
        return this.f51767c;
    }

    public final LatLng getEnd() {
        return this.f51768d;
    }
}
