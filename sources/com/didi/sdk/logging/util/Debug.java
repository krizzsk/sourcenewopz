package com.didi.sdk.logging.util;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;

public class Debug {

    /* renamed from: a */
    private static final String f36652a = "logging";

    public static boolean isDebuggable() {
        return LoggerFactory.getConfig().isDebuggable();
    }

    /* renamed from: d */
    public static void m25980d(String str) {
        if (isDebuggable()) {
            Log.d(f36652a, str);
        }
    }

    /* renamed from: i */
    public static void m25983i(String str) {
        if (isDebuggable()) {
            Log.i(f36652a, str);
        }
    }

    /* renamed from: e */
    public static void m25981e(String str) {
        if (isDebuggable()) {
            Log.e(f36652a, str);
        }
    }

    /* renamed from: e */
    public static void m25982e(String str, Throwable th) {
        if (isDebuggable()) {
            Log.e(f36652a, str, th);
        }
    }

    public static void logOrThrow(String str, Throwable th) {
        if (!isDebuggable()) {
            Log.e(f36652a, str, th);
            return;
        }
        throw new RuntimeException(str, th);
    }
}
