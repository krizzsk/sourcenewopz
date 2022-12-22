package com.didi.map.sdk.sharetrack.entity;

public class DiDiTimeAndDistance {

    /* renamed from: a */
    private int f28631a;

    /* renamed from: b */
    private int f28632b;

    public DiDiTimeAndDistance() {
    }

    public DiDiTimeAndDistance(int i, int i2) {
        this.f28631a = i;
        this.f28632b = i2;
    }

    public int getEtaMinutes() {
        return this.f28631a;
    }

    public void setEtaMinutes(int i) {
        this.f28631a = i;
    }

    public int getEdaMeters() {
        return this.f28632b;
    }

    public void setEdaMeters(int i) {
        this.f28632b = i;
    }
}
