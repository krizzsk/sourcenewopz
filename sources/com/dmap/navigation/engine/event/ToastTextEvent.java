package com.dmap.navigation.engine.event;

public class ToastTextEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51966a;

    /* renamed from: b */
    private final String f51967b;

    public ToastTextEvent(int i, String str) {
        this.f51966a = i;
        this.f51967b = str;
    }

    public String toString() {
        return "ToastTextEvent{type=" + this.f51966a + ", content='" + this.f51967b + '\'' + '}';
    }

    public int getType() {
        return this.f51966a;
    }

    public String getContent() {
        return this.f51967b;
    }
}
