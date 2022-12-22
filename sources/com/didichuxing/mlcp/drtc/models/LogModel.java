package com.didichuxing.mlcp.drtc.models;

import java.io.Serializable;
import java.util.Date;

public class LogModel implements Serializable {
    private String devIp;
    private String deviceId;
    private String logCtx;
    private long logTime = 0;
    private String sdkType = "0.0.0.2.9";
    private String sessionId;

    private LogModel(String str) {
        this.sessionId = str;
        this.logTime = new Date().getTime();
    }

    /* renamed from: d */
    public static LogModel m34537d(String str) {
        return new LogModel(str);
    }

    /* renamed from: a */
    public LogModel mo118969a(String str) {
        this.logCtx = str;
        return this;
    }

    /* renamed from: b */
    public LogModel mo118970b(String str) {
        this.deviceId = str;
        return this;
    }

    /* renamed from: c */
    public LogModel mo118971c(String str) {
        this.devIp = str;
        return this;
    }
}
