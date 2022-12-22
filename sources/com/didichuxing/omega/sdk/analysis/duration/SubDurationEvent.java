package com.didichuxing.omega.sdk.analysis.duration;

public class SubDurationEvent {
    private long startTime = System.currentTimeMillis();
    private String subEventName;
    private long subEventTime;

    public SubDurationEvent(String str) {
        this.subEventName = str;
    }

    public void end() {
        this.subEventTime = System.currentTimeMillis() - this.startTime;
    }

    public String getSubEventName() {
        return this.subEventName;
    }

    public long getSubEventTime() {
        return this.subEventTime;
    }
}
