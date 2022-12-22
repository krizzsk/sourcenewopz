package com.dmap.navigation.engine.event;

public class ParallelYawEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51948a;

    /* renamed from: b */
    private final int f51949b;

    public ParallelYawEvent(int i, int i2) {
        this.f51948a = i;
        this.f51949b = i2;
    }

    public int getType() {
        return this.f51948a;
    }

    public int getConfidence() {
        return this.f51949b;
    }
}
