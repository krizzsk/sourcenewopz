package com.dmap.navigation.engine.event;

public class CongestionEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51859a;

    /* renamed from: b */
    private final int f51860b;

    /* renamed from: c */
    private final int f51861c;

    /* renamed from: d */
    private final int f51862d;

    /* renamed from: e */
    private final int f51863e;

    /* renamed from: f */
    private final int f51864f;

    public CongestionEvent(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f51859a = i;
        this.f51860b = i2;
        this.f51861c = i3;
        this.f51862d = i4;
        this.f51863e = i5;
        this.f51864f = i6;
    }

    public String toString() {
        return "CongestionEvent{updateType=" + this.f51859a + ", distance=" + this.f51860b + ", time=" + this.f51861c + ", startNum=" + this.f51862d + ", endNum=" + this.f51863e + ", eventId=" + this.f51864f + '}';
    }

    public int getUpdateType() {
        return this.f51859a;
    }

    public int getDistance() {
        return this.f51860b;
    }

    public int getTime() {
        return this.f51861c;
    }

    public int getStartNum() {
        return this.f51862d;
    }

    public int getEndNum() {
        return this.f51863e;
    }

    public int getEventId() {
        return this.f51864f;
    }
}
