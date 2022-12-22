package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.core.INaviTrafficUpdater;
import com.dmap.navigation.jni.swig.IntList;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.jni.swig.NaviLatLngList;
import com.dmap.navigation.jni.swig.TrafficResponse;
import com.dmap.navigation.simple.SimpleLatlng;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.dmap.navigation.engine.a.j */
/* compiled from: SimpleTrafficResponse */
public final class C17397j implements INaviTrafficUpdater.ITrafficResponse {

    /* renamed from: a */
    private final int f51812a;

    /* renamed from: b */
    private final long f51813b;

    /* renamed from: c */
    private final byte[] f51814c;

    /* renamed from: d */
    private final byte[] f51815d;

    /* renamed from: e */
    private final byte[] f51816e;

    /* renamed from: f */
    private final ArrayList<Integer> f51817f;

    /* renamed from: g */
    private final ArrayList<Integer> f51818g;

    /* renamed from: h */
    private final ArrayList<LatLng> f51819h;

    public C17397j(TrafficResponse trafficResponse) {
        int expireTime = trafficResponse.getExpireTime();
        if (expireTime <= 5000) {
            this.f51812a = INaviTrafficUpdater.PUSH_RECONNECT_TIME;
        } else {
            this.f51812a = expireTime;
        }
        this.f51813b = trafficResponse.getServerTimestamp().longValue();
        this.f51814c = C17400m.m37040a(trafficResponse.getTrafficEvent(), trafficResponse.getTrafficEventSize());
        this.f51815d = C17400m.m37040a(trafficResponse.getExtendData(), trafficResponse.getExtendDataSize());
        this.f51816e = C17400m.m37040a(trafficResponse.getNaviEvents(), trafficResponse.getNaviEventsSize());
        IntList trafficIndexs = trafficResponse.getTrafficIndexs();
        this.f51817f = new ArrayList<>((int) trafficIndexs.size());
        for (int i = 0; ((long) i) < trafficIndexs.size(); i++) {
            this.f51817f.add(Integer.valueOf(trafficIndexs.get(i)));
        }
        NaviLatLngList trafficPoints = trafficResponse.getTrafficPoints();
        this.f51819h = new ArrayList<>((int) trafficPoints.size());
        for (int i2 = 0; ((long) i2) < trafficPoints.size(); i2++) {
            NaviLatLng naviLatLng = trafficPoints.get(i2);
            this.f51819h.add(new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng()));
        }
        IntList etas = trafficResponse.getEtas();
        this.f51818g = new ArrayList<>((int) etas.size());
        for (int i3 = 0; ((long) i3) < etas.size(); i3++) {
            this.f51818g.add(Integer.valueOf(etas.get(i3)));
        }
    }

    public final String toString() {
        return "SimpleTrafficResponse{expireTime=" + this.f51812a + ", serverTimestamp=" + this.f51813b + ", trafficEvent=" + Arrays.toString(this.f51814c) + ", extendData=" + Arrays.toString(this.f51815d) + ", naviEvents=" + Arrays.toString(this.f51816e) + ", trafficIndex=" + this.f51817f + ", etas=" + this.f51818g + ", trafficInsertPoint=" + this.f51819h + '}';
    }

    public final int getExpireTime() {
        return this.f51812a;
    }

    public final long getServerTimestamp() {
        return this.f51813b;
    }

    public final byte[] getTrafficEvent() {
        return this.f51814c;
    }

    public final byte[] getExtendData() {
        return this.f51815d;
    }

    public final byte[] getNaviEvents() {
        return this.f51816e;
    }

    public final ArrayList<Integer> getTrafficIndex() {
        return this.f51817f;
    }

    public final ArrayList<LatLng> getTrafficInsertPoint() {
        return this.f51819h;
    }

    public final ArrayList<Integer> getEtas() {
        return this.f51818g;
    }
}
