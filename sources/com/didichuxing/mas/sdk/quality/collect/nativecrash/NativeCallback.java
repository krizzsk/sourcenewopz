package com.didichuxing.mas.sdk.quality.collect.nativecrash;

import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public class NativeCallback {

    /* renamed from: a */
    private static boolean f48153a = false;

    public static void nativeCrashed() {
        OLog.m34420i("native crashed!");
        if (!f48153a) {
            f48153a = true;
        }
    }

    public static void makeNativeCrashReport(String str, String str2, int i) {
        OLog.m34420i("receive native crash signal!");
        OmegaSDKAdapter.trackMasEvent("omega_native_signal", (String) null, (Map<String, Object>) null);
    }

    public static void nativeCrashedMakePoint() {
        OLog.m34420i("receiver native crash signal!!");
        OmegaSDKAdapter.trackMasEvent("omg_native_signal", (String) null, (Map<String, Object>) null);
    }
}
