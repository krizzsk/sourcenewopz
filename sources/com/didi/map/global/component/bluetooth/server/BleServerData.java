package com.didi.map.global.component.bluetooth.server;

import com.didi.common.map.model.LatLng;

public class BleServerData {

    /* renamed from: a */
    private LatLng f24807a;

    /* renamed from: b */
    private float f24808b;

    /* renamed from: c */
    private long f24809c;

    public LatLng getDriverPos() {
        return this.f24807a;
    }

    public void setDriverPos(LatLng latLng) {
        this.f24807a = latLng;
    }

    public float getDriverAcc() {
        return this.f24808b;
    }

    public void setDriverAcc(float f) {
        this.f24808b = f;
    }

    public long getDriverTime() {
        return this.f24809c;
    }

    public void setDriverTime(long j) {
        this.f24809c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleServerData{driverLoc=");
        LatLng latLng = this.f24807a;
        sb.append(latLng == null ? "null" : latLng.toString());
        sb.append(", driverAcc=");
        sb.append(this.f24808b);
        sb.append(", driverTime=");
        sb.append(this.f24809c);
        sb.append('}');
        return sb.toString();
    }
}
