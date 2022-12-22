package com.didi.map.sdk.degrade;

public class CrashDetail {
    public String stack;
    public long time;

    public CrashDetail(long j, String str) {
        this.stack = str;
        this.time = j;
    }
}
