package com.appsflyer.internal.model.event;

import android.content.Context;

public class ProxyEvent extends BackgroundEvent {

    /* renamed from: ɪ */
    private String f2006;

    public ProxyEvent() {
        super((String) null, (Boolean) null, Boolean.FALSE, (Boolean) null, (Context) null);
    }

    public BackgroundEvent body(String str) {
        this.f2006 = str;
        return this;
    }

    public String body() {
        return this.f2006;
    }
}
