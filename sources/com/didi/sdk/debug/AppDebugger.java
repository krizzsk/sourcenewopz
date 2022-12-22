package com.didi.sdk.debug;

import android.content.pm.ApplicationInfo;

public class AppDebugger {

    /* renamed from: a */
    private static boolean f35788a = false;

    public static boolean isDebuggable() {
        return f35788a;
    }

    public static void setIsDebuggable(ApplicationInfo applicationInfo) {
        f35788a = (applicationInfo.flags & 2) != 0;
    }
}
