package com.didi.map.global.sctx.model;

public class PushInfo {

    /* renamed from: a */
    private String f27650a;

    /* renamed from: b */
    private String f27651b;

    public String getIp() {
        return this.f27650a;
    }

    public void setIp(String str) {
        this.f27650a = str;
    }

    public String getPort() {
        return this.f27651b;
    }

    public void setPort(String str) {
        this.f27651b = str;
    }

    public String toString() {
        return "PushInfo{ip='" + this.f27650a + '\'' + ", port='" + this.f27651b + '\'' + '}';
    }
}
