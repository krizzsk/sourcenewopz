package com.didi.dimina.container.secondparty.permission.runtime.setting;

import com.didi.dimina.container.secondparty.permission.source.Source;

public class AllRequest implements SettingRequest {

    /* renamed from: a */
    private final Source f17403a;

    public AllRequest(Source source) {
        this.f17403a = source;
    }

    public void start(int i) {
        new SettingPage(this.f17403a).start(i);
    }
}
