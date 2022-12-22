package com.microblink.blinkbarcode.util;

import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public final class LoggingSettings {
    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    public static final void disableMicroblinkLogging() {
        Log.setLogLevel(Log.LogLevel.LOG_QUIET);
        logEnabledNativeSet(false);
    }

    private static native void logEnabledNativeSet(boolean z);
}
