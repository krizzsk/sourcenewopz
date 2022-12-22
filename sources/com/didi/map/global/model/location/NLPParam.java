package com.didi.map.global.model.location;

public class NLPParam {

    /* renamed from: a */
    private String f27332a;

    /* renamed from: b */
    private int f27333b;

    /* renamed from: c */
    private boolean f27334c;

    public NLPParam(String str, int i) {
        this.f27332a = str;
        this.f27333b = i;
    }

    public NLPParam(String str, int i, boolean z) {
        this.f27332a = str;
        this.f27333b = i;
        this.f27334c = z;
    }

    public NLPParam(String str) {
        this.f27332a = str;
    }

    public String getCallFrom() {
        return this.f27332a;
    }

    public int getTimeOut() {
        return this.f27333b;
    }

    public boolean isNlpEnable() {
        return this.f27334c;
    }

    public String toString() {
        return "NLPParam{mCallFrom=" + this.f27332a + ", mTimeOut=" + this.f27333b + ", isNlpEnable=" + this.f27334c + '}';
    }
}
