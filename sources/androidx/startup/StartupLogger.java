package androidx.startup;

import com.didi.sdk.apm.SystemUtils;

public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    /* renamed from: i */
    public static void m101i(String str) {
        SystemUtils.log(4, TAG, str, (Throwable) null, "androidx.startup.StartupLogger", 52);
    }

    /* renamed from: e */
    public static void m100e(String str, Throwable th) {
        SystemUtils.log(6, TAG, str, th, "androidx.startup.StartupLogger", 62);
    }
}
