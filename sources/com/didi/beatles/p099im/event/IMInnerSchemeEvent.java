package com.didi.beatles.p099im.event;

/* renamed from: com.didi.beatles.im.event.IMInnerSchemeEvent */
public class IMInnerSchemeEvent {

    /* renamed from: a */
    private String f9214a;

    /* renamed from: b */
    private Object f9215b;

    public IMInnerSchemeEvent(String str, Object obj) {
        this.f9214a = str;
        this.f9215b = obj;
    }

    public String getAction() {
        return this.f9214a;
    }

    public Object getData() {
        return this.f9215b;
    }
}
