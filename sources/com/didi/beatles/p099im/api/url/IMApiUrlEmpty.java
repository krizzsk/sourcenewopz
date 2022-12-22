package com.didi.beatles.p099im.api.url;

import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.api.url.IMApiUrlEmpty */
public class IMApiUrlEmpty extends IMBaseUrl {

    /* renamed from: a */
    private static final String f9131a = "IMApiUrlEmpty";

    public IMApiUrlEmpty() {
        IMLog.m6632e(f9131a, " api url use empty , please set it !!!");
    }

    public String getCommonHost(int i) {
        IMLog.m6632e(f9131a, " api url use empty , please set it !!!");
        return "";
    }

    public String getProfileHost() {
        IMLog.m6632e(f9131a, " api url use empty , please set it !!!");
        return "";
    }
}
