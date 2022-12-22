package com.didi.map.global.component.bluetooth.client;

public class RssiInfoResult {

    /* renamed from: a */
    private int f24791a;

    /* renamed from: b */
    private double f24792b;

    public int getRssi() {
        return this.f24791a;
    }

    public void setRssi(int i) {
        this.f24791a = i;
    }

    public double getDistance() {
        return this.f24792b;
    }

    public void setDistance(double d) {
        this.f24792b = d;
    }

    public String toString() {
        return "RssiInfoResult{rssi=" + this.f24791a + ", distance=" + this.f24792b + '}';
    }
}
