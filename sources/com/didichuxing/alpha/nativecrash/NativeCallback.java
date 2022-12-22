package com.didichuxing.alpha.nativecrash;

import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.util.Map;

public class NativeCallback {
    private static boolean mNativeCrashHandled = false;

    public static void nativeCrashed() {
        OLog.m34765i("native crashed!");
        if (!mNativeCrashHandled) {
            mNativeCrashHandled = true;
        }
    }

    public static void makeNativeCrashReport(String str, String str2, int i) {
        OLog.m34765i("receive native crash signal!");
        Tracker.trackEvent("omega_native_signal", (String) null, (Map<String, Object>) null);
    }

    public static void nativeCrashedMakePoint() {
        OLog.m34765i("receiver native crash signal!!");
        Tracker.trackEvent("omg_native_signal", (String) null, (Map<String, Object>) null);
    }
}
