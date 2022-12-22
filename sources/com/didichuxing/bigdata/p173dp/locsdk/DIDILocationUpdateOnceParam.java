package com.didichuxing.bigdata.p173dp.locsdk;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationUpdateOnceParam */
public class DIDILocationUpdateOnceParam {

    /* renamed from: a */
    private String f45685a;

    /* renamed from: b */
    private String f45686b;

    /* renamed from: c */
    private String f45687c;

    /* renamed from: d */
    private int f45688d = 1000;

    public String getModuleKey() {
        return this.f45685a;
    }

    public void setModuleKey(String str) {
        this.f45685a = str;
    }

    public void setCallFrom(String str) {
        this.f45686b = str;
    }

    public void setEntrance(String str) {
        this.f45687c = str;
    }

    public String getCallFrom() {
        return this.f45686b;
    }

    public String getEntrance() {
        return this.f45687c;
    }

    public int getTimeOut() {
        return this.f45688d;
    }

    public void setTimeOut(int i) {
        this.f45688d = i;
    }
}
