package com.didichuxing.dfbasesdk.utils;

@Deprecated
public class AES {
    public static native String stringFromJNI(String str);

    static {
        LibraryUtils.loadLibrary("dfbasenative");
    }
}
