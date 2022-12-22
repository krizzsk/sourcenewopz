package com.dmap.navigation.engine.event;

public class DestinationEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51865a;

    /* renamed from: b */
    private final int f51866b;

    /* renamed from: c */
    private final int f51867c;

    /* renamed from: d */
    private final int f51868d;

    /* renamed from: e */
    private final int f51869e;

    public DestinationEvent(int i, int i2, int i3, int i4, int i5) {
        this.f51865a = i;
        this.f51866b = i2;
        this.f51867c = i3;
        this.f51868d = i4;
        this.f51869e = i5;
    }

    public String toString() {
        return "DestinationEvent{index=" + this.f51865a + ", distance=" + this.f51866b + ", time=" + this.f51867c + ", totalDistance=" + this.f51868d + ", totalTime=" + this.f51869e + '}';
    }

    public int getIndex() {
        return this.f51865a;
    }

    public int getDistance() {
        return this.f51866b;
    }

    public int getTime() {
        return this.f51867c;
    }

    public int getTotalDistance() {
        return this.f51868d;
    }

    public int getTotalTime() {
        return this.f51869e;
    }
}
