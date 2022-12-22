package com.dmap.navigation.engine.event;

public class MoreRouteEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51944a;

    /* renamed from: b */
    private final String f51945b;

    public MoreRouteEvent(int i, String str) {
        this.f51944a = i;
        this.f51945b = str;
    }

    public String toString() {
        return "MoreRouteEvent{passfork=" + this.f51944a + ", scene='" + this.f51945b + '\'' + '}';
    }

    public int getPassfork() {
        return this.f51944a;
    }

    public String getScene() {
        return this.f51945b;
    }
}
