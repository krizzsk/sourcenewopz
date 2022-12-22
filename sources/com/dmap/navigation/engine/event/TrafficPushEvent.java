package com.dmap.navigation.engine.event;

public class TrafficPushEvent extends NaviEvent {

    /* renamed from: a */
    private final long f51969a;

    /* renamed from: b */
    private final byte[] f51970b;

    public TrafficPushEvent(long j, byte[] bArr) {
        this.f51969a = j;
        this.f51970b = bArr;
    }

    public long getTime() {
        return this.f51969a;
    }

    public byte[] getData() {
        return this.f51970b;
    }
}
