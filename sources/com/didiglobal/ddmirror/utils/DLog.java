package com.didiglobal.ddmirror.utils;

import com.didi.sdk.apm.SystemUtils;

public class DLog {
    /* renamed from: d */
    public static void m35950d(String str, String str2) {
        if (DDMirrorDebugger.isDebuggable()) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didiglobal.ddmirror.utils.DLog", 15);
        }
    }
}
