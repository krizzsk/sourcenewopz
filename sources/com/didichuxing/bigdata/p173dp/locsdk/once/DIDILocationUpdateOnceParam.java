package com.didichuxing.bigdata.p173dp.locsdk.once;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOnceParam */
public class DIDILocationUpdateOnceParam {

    /* renamed from: a */
    private String f46065a;

    /* renamed from: b */
    private String f46066b;

    /* renamed from: c */
    private String f46067c;

    /* renamed from: d */
    private int f46068d = 1000;

    /* renamed from: e */
    private boolean f46069e = false;

    public boolean isNeedExpress() {
        return this.f46069e;
    }

    public void setNeedExpress(boolean z) {
        this.f46069e = z;
    }

    public String getModuleKey() {
        return this.f46065a;
    }

    public void setModuleKey(String str) {
        this.f46065a = str;
    }

    public void setCallFrom(String str) {
        this.f46066b = str;
    }

    public void setEntrance(String str) {
        this.f46067c = str;
    }

    public String getCallFrom() {
        return this.f46066b;
    }

    public String getEntrance() {
        return this.f46067c;
    }

    public int getTimeOut() {
        return this.f46068d;
    }

    public void setTimeOut(int i) {
        this.f46068d = i;
    }
}
