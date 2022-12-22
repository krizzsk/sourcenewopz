package com.didichuxing.mas.sdk.quality.collect.duration;

public class SubDurationEvent {

    /* renamed from: a */
    private String f48081a;

    /* renamed from: b */
    private long f48082b = System.currentTimeMillis();

    /* renamed from: c */
    private long f48083c;

    public SubDurationEvent(String str) {
        this.f48081a = str;
    }

    public void end() {
        this.f48083c = System.currentTimeMillis() - this.f48082b;
    }

    public String getSubEventName() {
        return this.f48081a;
    }

    public long getSubEventTime() {
        return this.f48083c;
    }
}
