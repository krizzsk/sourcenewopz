package com.yanzhenjie.permission.runtime.setting;

import com.yanzhenjie.permission.source.Source;

public class AllRequest implements SettingRequest {

    /* renamed from: a */
    private Source f56243a;

    public AllRequest(Source source) {
        this.f56243a = source;
    }

    public void start(int i) {
        new SettingPage(this.f56243a).start(i);
    }
}
