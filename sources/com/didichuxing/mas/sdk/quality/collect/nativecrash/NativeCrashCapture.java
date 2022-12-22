package com.didichuxing.mas.sdk.quality.collect.nativecrash;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class NativeCrashCapture {

    /* renamed from: a */
    private static boolean f48154a = false;

    private static native int nativeCrashInit(String str, int i);

    static {
        try {
            System.loadLibrary("omgcrashcapture");
            f48154a = true;
        } catch (Throwable th) {
            f48154a = false;
            th.printStackTrace();
        }
    }

    public static int init() {
        return initNewBP();
    }

    public static int initNewBP() {
        if (!f48154a) {
            return -2;
        }
        int i = 0;
        f48154a = false;
        try {
            String nativeCrashPath = RecordStorage.getNativeCrashPath();
            if (MASConfig.NATIVE_CRASH_SAVE_LOGCAT) {
                i = 1;
            }
            return nativeCrashInit(nativeCrashPath, i);
        } catch (Throwable unused) {
            OLog.m34418e("native crash so load failed! new bp");
            return -1;
        }
    }

    /* renamed from: a */
    private static String m34337a() {
        return PackageCollector.getVN();
    }
}
