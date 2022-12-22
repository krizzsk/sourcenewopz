package com.dmap.navigation.engine.event;

public class PassPointVerifyEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51950a;

    public PassPointVerifyEvent(int i) {
        this.f51950a = i;
    }

    public String toString() {
        return "PassPointVerifyEvent{updateType=" + this.f51950a + '}';
    }

    public int getUpdateType() {
        return this.f51950a;
    }
}
