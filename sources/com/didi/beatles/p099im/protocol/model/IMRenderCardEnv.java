package com.didi.beatles.p099im.protocol.model;

import java.util.Map;

/* renamed from: com.didi.beatles.im.protocol.model.IMRenderCardEnv */
public class IMRenderCardEnv {

    /* renamed from: a */
    private String f9571a;

    /* renamed from: b */
    private Map<String, String> f9572b;
    public final long sessionId;

    public IMRenderCardEnv(long j, String str, Map<String, String> map) {
        this.sessionId = j;
        this.f9571a = str;
        this.f9572b = map;
    }

    public void setOrderId(String str) {
        this.f9571a = str;
    }

    public String getOrderId() {
        return this.f9571a;
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f9572b = map;
    }

    public Map<String, String> getExtraTraceMap() {
        return this.f9572b;
    }
}
