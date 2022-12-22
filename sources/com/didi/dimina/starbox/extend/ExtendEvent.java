package com.didi.dimina.starbox.extend;

public abstract class ExtendEvent {

    /* renamed from: a */
    private final String f17995a;

    /* renamed from: b */
    private final String f17996b;

    public abstract void executeEvent();

    public ExtendEvent(String str, String str2) {
        this.f17995a = str;
        this.f17996b = str2;
    }

    public String getEventName() {
        return this.f17995a;
    }

    public String getEventType() {
        return this.f17996b;
    }
}
