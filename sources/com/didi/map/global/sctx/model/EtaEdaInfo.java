package com.didi.map.global.sctx.model;

public class EtaEdaInfo {

    /* renamed from: a */
    private int f27640a;

    /* renamed from: b */
    private int f27641b;

    /* renamed from: c */
    private int f27642c = -1;

    public EtaEdaInfo(int i, int i2, int i3) {
        this.f27640a = i;
        this.f27641b = i2;
        this.f27642c = i3;
    }

    public int getEta() {
        return this.f27640a;
    }

    public void setEta(int i) {
        this.f27640a = i;
    }

    public int getEda() {
        return this.f27641b;
    }

    public void setEda(int i) {
        this.f27641b = i;
    }

    public int getLastOrderEda() {
        return this.f27642c;
    }

    public void setLastOrderEda(int i) {
        this.f27642c = i;
    }

    public String toString() {
        return "EtaEdaInfo{eta=" + this.f27640a + ", eda=" + this.f27641b + ", lastOrderEda" + this.f27642c + '}';
    }
}
