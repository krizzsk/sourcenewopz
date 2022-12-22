package com.didi.map.global.component.bluetooth.client;

import com.didi.common.map.model.LatLng;

public class DriverInfoResult {

    /* renamed from: a */
    private LatLng f24789a;

    /* renamed from: b */
    private float f24790b;

    public LatLng getDriverPos() {
        return this.f24789a;
    }

    public void setDriverPos(LatLng latLng) {
        this.f24789a = latLng;
    }

    public float getDriverAcc() {
        return this.f24790b;
    }

    public void setDriverAcc(float f) {
        this.f24790b = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DriverInfoResult{driverLoc=");
        LatLng latLng = this.f24789a;
        sb.append(latLng == null ? "null" : latLng.toString());
        sb.append(", driverAcc=");
        sb.append(this.f24790b);
        sb.append('}');
        return sb.toString();
    }
}
