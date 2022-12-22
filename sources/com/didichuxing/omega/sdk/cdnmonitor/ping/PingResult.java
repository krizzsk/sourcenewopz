package com.didichuxing.omega.sdk.cdnmonitor.ping;

public class PingResult {
    private String detectIp;
    private float pingErrorRadio;
    private String pingResponse;
    private float pingTime;

    public String getDetectIp() {
        return this.detectIp;
    }

    public String getPingResponse() {
        return this.pingResponse;
    }

    public float getPingTime() {
        return this.pingTime;
    }

    public float getPingErrorRadio() {
        return this.pingErrorRadio;
    }

    PingResult(String str, float f, float f2, String str2) {
        this.detectIp = str;
        this.pingTime = f;
        this.pingErrorRadio = f2;
        this.pingResponse = str2;
    }
}
