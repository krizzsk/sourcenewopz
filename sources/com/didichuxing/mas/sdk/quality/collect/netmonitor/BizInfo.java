package com.didichuxing.mas.sdk.quality.collect.netmonitor;

public class BizInfo {

    /* renamed from: a */
    private int f48155a;

    /* renamed from: b */
    private String f48156b;

    /* renamed from: c */
    private long f48157c;

    public BizInfo(int i, String str) {
        this.f48155a = i;
        this.f48156b = str;
    }

    public int getBizId() {
        return this.f48155a;
    }

    public void setBizId(int i) {
        this.f48155a = i;
    }

    public String getUrl() {
        return this.f48156b;
    }

    public void setUrl(String str) {
        this.f48156b = str;
    }

    public long getReqTime() {
        return this.f48157c;
    }

    public void setReqTime(long j) {
        this.f48157c = j;
    }
}
