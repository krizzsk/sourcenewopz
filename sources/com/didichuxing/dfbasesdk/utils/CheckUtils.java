package com.didichuxing.dfbasesdk.utils;

public class CheckUtils {
    private CheckUtils() {
    }

    public static void checkAssert(boolean z, String str) {
        if (!z) {
            throwExceptionIfDebug((Error) new AssertionError(str));
        }
    }

    public static void throwExceptionIfDebug(RuntimeException runtimeException) {
        if (DebugUtils.isDebug()) {
            throw runtimeException;
        }
    }

    public static void throwExceptionIfDebug(Error error) {
        if (DebugUtils.isDebug()) {
            throw error;
        }
    }
}
