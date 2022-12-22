package com.didichuxing.alpha.nativecrash;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.utils.OLog;

public class NativeCrashCapture {
    private static boolean sInitOmgNativeCrashCapture = false;

    private static native int nativeCrashInit(String str, int i);

    static {
        try {
            System.loadLibrary("omgcrashcapture");
            sInitOmgNativeCrashCapture = true;
        } catch (Throwable th) {
            sInitOmgNativeCrashCapture = false;
            th.printStackTrace();
        }
    }

    public static int init() {
        return initNewBP();
    }

    public static int initNewBP() {
        if (!sInitOmgNativeCrashCapture) {
            return -2;
        }
        int i = 0;
        sInitOmgNativeCrashCapture = false;
        try {
            String nativeCrashPath = RecordStorage.getNativeCrashPath();
            if (OmegaConfig.NATIVE_CRASH_SAVE_LOGCAT) {
                i = 1;
            }
            return nativeCrashInit(nativeCrashPath, i);
        } catch (Throwable unused) {
            OLog.m34763e("native crash so load failed! new bp");
            return -1;
        }
    }

    private static String getVersion() {
        return PackageCollector.getVN();
    }
}
