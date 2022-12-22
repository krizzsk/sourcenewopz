package com.dmap.navigation.engine.event;

public class MJOEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51923a;

    public MJOEvent(int i) {
        this.f51923a = i;
    }

    public int getUpdateType() {
        return this.f51923a;
    }
}
