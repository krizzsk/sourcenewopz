package com.didichuxing.dfbasesdk.utils;

public class LibraryUtils {
    public static void loadLibrary(String str) {
        try {
            System.loadLibrary(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
