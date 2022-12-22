package com.didichuxing.omega.sdk.netmonitor;

public class BizInfo {
    private int bizId;
    private long reqTime;
    private String url;

    public BizInfo(int i, String str) {
        this.bizId = i;
        this.url = str;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public long getReqTime() {
        return this.reqTime;
    }

    public void setReqTime(long j) {
        this.reqTime = j;
    }
}
