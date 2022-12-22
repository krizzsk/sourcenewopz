package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.ping;

public class PingResult {

    /* renamed from: a */
    private String f47782a;

    /* renamed from: b */
    private float f47783b;

    /* renamed from: c */
    private float f47784c;

    /* renamed from: d */
    private String f47785d;

    public String getDetectIp() {
        return this.f47782a;
    }

    public String getPingResponse() {
        return this.f47785d;
    }

    public float getPingTime() {
        return this.f47783b;
    }

    public float getPingErrorRadio() {
        return this.f47784c;
    }

    PingResult(String str, float f, float f2, String str2) {
        this.f47782a = str;
        this.f47783b = f;
        this.f47784c = f2;
        this.f47785d = str2;
    }
}
