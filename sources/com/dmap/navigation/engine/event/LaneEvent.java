package com.dmap.navigation.engine.event;

import android.graphics.Bitmap;
import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;
import java.math.BigInteger;

public class LaneEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51908a;

    /* renamed from: b */
    private final String f51909b;

    /* renamed from: c */
    private final String f51910c;

    /* renamed from: d */
    private final String f51911d;

    /* renamed from: e */
    private final int f51912e;

    /* renamed from: f */
    private final int f51913f;

    /* renamed from: g */
    private final BigInteger f51914g;

    /* renamed from: h */
    private final LatLng f51915h;

    /* renamed from: i */
    private final int f51916i;

    /* renamed from: j */
    private Bitmap f51917j;

    public LaneEvent(int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, NaviLatLng naviLatLng, int i4) {
        this.f51908a = i;
        this.f51909b = str;
        this.f51910c = str2;
        this.f51911d = str3;
        this.f51912e = i2;
        this.f51913f = i3;
        this.f51914g = bigInteger;
        this.f51915h = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f51916i = i4;
    }

    public String toString() {
        return "LaneEvent{updateType=" + this.f51908a + ", lane='" + this.f51909b + '\'' + ", flag='" + this.f51910c + '\'' + ", property='" + this.f51911d + '\'' + ", emptyCout=" + this.f51913f + ", linkId=" + this.f51914g + ", position=" + this.f51915h + ", index=" + this.f51916i + '}';
    }

    public int getUpdateType() {
        return this.f51908a;
    }

    public String getLane() {
        return this.f51909b;
    }

    public String getProperty() {
        return this.f51911d;
    }

    public String getFlag() {
        return this.f51910c;
    }

    public int getEmptyCount() {
        return this.f51913f;
    }

    public BigInteger getLinkId() {
        return this.f51914g;
    }

    public LatLng getPosition() {
        return this.f51915h;
    }

    public int getIndex() {
        return this.f51916i;
    }

    public int getTotalCount() {
        return this.f51912e;
    }

    public Bitmap getBitmap() {
        return this.f51917j;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f51917j = bitmap;
    }
}
