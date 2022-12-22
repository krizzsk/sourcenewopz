package com.facebook.jni;

import com.facebook.soloader.SoLoader;

public class ThreadScopeSupport {
    private static native void runStdFunctionImpl(long j);

    static {
        SoLoader.loadLibrary("fb");
    }

    private static void runStdFunction(long j) {
        runStdFunctionImpl(j);
    }
}
