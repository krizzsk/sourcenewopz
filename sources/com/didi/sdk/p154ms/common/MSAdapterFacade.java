package com.didi.sdk.p154ms.common;

/* renamed from: com.didi.sdk.ms.common.MSAdapterFacade */
public class MSAdapterFacade {
    private static boolean isDebug = false;

    public static void init(boolean z) {
        isDebug = z;
    }

    public static boolean isDebug() {
        return isDebug;
    }
}
