package com.dmap.navigation.engine.event;

public class SlopeInfoEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51958a;

    public SlopeInfoEvent(int i) {
        this.f51958a = i;
    }

    public String toString() {
        return "SlopeInfoEvent{slopeStatus=" + this.f51958a + '}';
    }

    public int getSlopeStatus() {
        return this.f51958a;
    }
}
