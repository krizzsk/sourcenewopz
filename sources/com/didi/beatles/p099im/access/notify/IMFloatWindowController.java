package com.didi.beatles.p099im.access.notify;

import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.access.notify.IMFloatWindowController */
public final class IMFloatWindowController {

    /* renamed from: a */
    private static final String f8769a = IMFloatWindowController.class.getSimpleName();
    public static boolean mEnableFloatWindow = true;

    public static void setEnableFloatWindow(boolean z) {
        mEnableFloatWindow = z;
        String str = f8769a;
        IMLog.m6631d(str, "[setEnableFloatWindow] enable=" + z);
    }

    public static boolean isEnable() {
        return mEnableFloatWindow;
    }
}
