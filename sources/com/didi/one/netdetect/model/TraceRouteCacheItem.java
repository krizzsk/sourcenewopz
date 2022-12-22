package com.didi.one.netdetect.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TraceRouteCacheItem implements Serializable {
    @SerializedName("fail_count")
    private int failCount;
    private String host;
    private TraceRouteReportInfo info;

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public TraceRouteReportInfo getInfo() {
        return this.info;
    }

    public void setInfo(TraceRouteReportInfo traceRouteReportInfo) {
        this.info = traceRouteReportInfo;
    }

    public int getFailCount() {
        return this.failCount;
    }

    public void setFailCount(int i) {
        this.failCount = i;
    }
}
