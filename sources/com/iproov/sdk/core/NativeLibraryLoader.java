package com.iproov.sdk.core;

import com.iproov.sdk.logging.IPLog;

class NativeLibraryLoader {

    /* renamed from: a */
    static boolean f54084a = true;

    static {
        try {
            System.loadLibrary("native-lib");
        } catch (UnsatisfiedLinkError unused) {
            IPLog.m39305w("NativeLib", "Not loaded");
        }
    }

    NativeLibraryLoader() {
    }

    public native int performance();

    public native int suNativeCheck(String[] strArr);
}
