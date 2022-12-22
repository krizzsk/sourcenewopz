package com.dmap.navigation.engine.event;

public class DynamicSelectedEvent extends NaviEvent {

    /* renamed from: a */
    private int f51883a;

    /* renamed from: b */
    private int f51884b;

    public DynamicSelectedEvent(int i, int i2) {
        this.f51883a = i;
        this.f51884b = i2;
    }

    public int getAbTest() {
        return this.f51883a;
    }

    public int getType() {
        return this.f51884b;
    }
}
