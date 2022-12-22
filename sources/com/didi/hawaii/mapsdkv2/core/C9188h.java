package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.common.MapLog;

/* renamed from: com.didi.hawaii.mapsdkv2.core.h */
/* compiled from: ShareGLContext */
final class C9188h {

    /* renamed from: a */
    private static final String f24044a = "ShareGLContext";

    /* renamed from: b */
    private static boolean f24045b = false;

    C9188h() {
    }

    /* renamed from: a */
    static boolean m17100a() {
        return f24045b;
    }

    /* renamed from: a */
    static void m17099a(boolean z) {
        MapLog.m16914d(f24044a, "ShareContext support: " + z);
        f24045b = z;
    }
}
