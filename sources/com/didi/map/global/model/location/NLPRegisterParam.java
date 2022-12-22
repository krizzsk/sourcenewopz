package com.didi.map.global.model.location;

public class NLPRegisterParam {

    /* renamed from: a */
    private String f27335a;

    /* renamed from: b */
    private int f27336b;

    /* renamed from: c */
    private int f27337c;

    public NLPRegisterParam(String str, int i, int i2) {
        this.f27335a = str;
        this.f27336b = i;
        this.f27337c = i2;
    }

    public String getmCallFrom() {
        return this.f27335a;
    }

    public void setmCallFrom(String str) {
        this.f27335a = str;
    }

    public int getmConnectTimeOut() {
        return this.f27336b;
    }

    public void setmConnectTimeOut(int i) {
        this.f27336b = i;
    }

    public int getFrequency() {
        return this.f27337c;
    }

    public void setFrequency(int i) {
        this.f27337c = i;
    }

    public String toString() {
        return "NLPRegisterParam{mCallFrom='" + this.f27335a + '\'' + ", mConnectTimeOut=" + this.f27336b + ", frequency=" + this.f27337c + '}';
    }
}
