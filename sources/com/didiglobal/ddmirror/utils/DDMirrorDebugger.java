package com.didiglobal.ddmirror.utils;

import android.content.pm.ApplicationInfo;

public class DDMirrorDebugger {
    private static boolean isDebuggable = false;

    public static boolean isDebuggable() {
        return isDebuggable;
    }

    public static void setIsDebuggable(ApplicationInfo applicationInfo) {
        isDebuggable = (applicationInfo.flags & 2) != 0;
    }
}
