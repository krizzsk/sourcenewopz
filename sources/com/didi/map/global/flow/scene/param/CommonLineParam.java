package com.didi.map.global.flow.scene.param;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class CommonLineParam {

    /* renamed from: a */
    private MapElementId f27017a;

    /* renamed from: b */
    private int f27018b;

    /* renamed from: c */
    private int f27019c;

    /* renamed from: d */
    private int f27020d;

    /* renamed from: e */
    private LatLng f27021e;

    /* renamed from: f */
    private LatLng f27022f;

    /* renamed from: g */
    private List<LatLng> f27023g;

    /* renamed from: h */
    private int f27024h;

    /* renamed from: i */
    private boolean f27025i;

    public CommonLineParam(MapElementId mapElementId, int i, int i2, int i3, LatLng latLng, LatLng latLng2, List<LatLng> list) {
        this.f27017a = mapElementId;
        this.f27018b = i;
        this.f27019c = i2;
        this.f27020d = i3;
        this.f27021e = latLng;
        this.f27022f = latLng2;
        this.f27023g = list;
    }

    public MapElementId getId() {
        return this.f27017a;
    }

    public LatLng getStartPoint() {
        return this.f27021e;
    }

    public LatLng getEndPoint() {
        return this.f27022f;
    }

    public List<LatLng> getWayPoints() {
        return this.f27023g;
    }

    public int getLineColor() {
        return this.f27018b;
    }

    public void setLineColor(int i) {
        this.f27018b = i;
    }

    public int getLineWidth() {
        return this.f27019c;
    }

    public void setLineWidth(int i) {
        this.f27019c = i;
    }

    public int getLineSpace() {
        return this.f27024h;
    }

    public void setLineSpace(int i) {
        this.f27024h = i;
    }

    public int getLineMode() {
        return this.f27020d;
    }

    public void setLineMode(int i) {
        this.f27020d = i;
    }

    public void setId(MapElementId mapElementId) {
        this.f27017a = mapElementId;
    }

    public void setStartPoint(LatLng latLng) {
        this.f27021e = latLng;
    }

    public void setEndPoint(LatLng latLng) {
        this.f27022f = latLng;
    }

    public void setWayPoints(List<LatLng> list) {
        this.f27023g = list;
    }

    public boolean getAnimate() {
        return this.f27025i;
    }

    public void setAnimate(boolean z) {
        this.f27025i = z;
    }

    public String toString() {
        return "CommonLineParam{id='" + this.f27017a + '\'' + ", lineColor=" + this.f27018b + ", lineWidth=" + this.f27019c + ", lineMode=" + this.f27020d + ", startPoint=" + this.f27021e + ", endPoint=" + this.f27022f + ", wayPoints=" + this.f27023g + '}';
    }
}
