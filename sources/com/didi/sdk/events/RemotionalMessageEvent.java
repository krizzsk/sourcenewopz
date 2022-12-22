package com.didi.sdk.events;

import com.didi.sdk.sidebar.model.SidebarResponse;

public class RemotionalMessageEvent {

    /* renamed from: a */
    private String f35883a;

    /* renamed from: b */
    private String f35884b;

    /* renamed from: c */
    private String f35885c;

    /* renamed from: d */
    private SidebarResponse.DidiPassData f35886d;

    public String getText() {
        return this.f35883a;
    }

    public String getNumber() {
        return this.f35884b;
    }

    public String getType() {
        return this.f35885c;
    }

    public SidebarResponse.DidiPassData getDidiPassData() {
        return this.f35886d;
    }

    public RemotionalMessageEvent(String str, String str2, String str3, SidebarResponse.DidiPassData didiPassData) {
        this.f35883a = str;
        this.f35884b = str2;
        this.f35885c = str3;
        this.f35886d = didiPassData;
    }
}
