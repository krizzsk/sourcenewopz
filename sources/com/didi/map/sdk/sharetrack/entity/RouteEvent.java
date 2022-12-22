package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class RouteEvent {

    /* renamed from: a */
    private NaviRoute f28649a;

    /* renamed from: b */
    private int f28650b;

    /* renamed from: c */
    private int f28651c;

    /* renamed from: d */
    private List<OrderPoint> f28652d;

    /* renamed from: e */
    private LatLng f28653e;

    public void updateRoute(NaviRoute naviRoute) {
        this.f28649a = naviRoute;
    }

    public void setPickUpPoint(LatLng latLng) {
        this.f28653e = latLng;
    }

    public LatLng getPickUpPoint() {
        return this.f28653e;
    }

    public void setWayList(List<OrderPoint> list) {
        this.f28652d = list;
    }

    public List<OrderPoint> getWayList() {
        return this.f28652d;
    }

    public void updateEdaEta(int i, int i2) {
        this.f28650b = i;
        this.f28651c = i2;
    }

    public NaviRoute getNavRoute() {
        return this.f28649a;
    }

    public int getEdaMeter() {
        return this.f28650b;
    }

    public int getEtaMinutes() {
        return this.f28651c;
    }
}
