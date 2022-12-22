package com.facebook.jni;

import com.facebook.soloader.SoLoader;

public class Countable {
    private long mInstance = 0;

    public native void dispose();

    static {
        SoLoader.loadLibrary("fb");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        dispose();
        super.finalize();
    }
}
