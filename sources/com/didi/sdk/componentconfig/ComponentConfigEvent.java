package com.didi.sdk.componentconfig;

import com.didi.sdk.event.Event;

public class ComponentConfigEvent implements Event {

    /* renamed from: a */
    private String f35679a;

    public ComponentConfigEvent(String str) {
        this.f35679a = str;
    }

    public String getEvent() {
        return this.f35679a;
    }

    public void setEvent(String str) {
        this.f35679a = str;
    }
}
