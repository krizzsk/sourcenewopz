package com.didi.beatles.p099im;

import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.IMEnvironment */
public final class IMEnvironment {

    /* renamed from: a */
    private static volatile boolean f8699a = false;

    public static void setInitStatus(boolean z) {
        f8699a = z;
        IMLog.m6631d("IMEnvironment", "[setInitStatus] -> " + z);
    }

    public static boolean isInit() {
        return f8699a;
    }
}
