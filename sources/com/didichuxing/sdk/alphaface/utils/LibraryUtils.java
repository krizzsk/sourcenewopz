package com.didichuxing.sdk.alphaface.utils;

import com.didichuxing.sdk.alphaface.AlphaFace;

public class LibraryUtils {
    public static void loadLibrary(String str) {
        try {
            System.loadLibrary(str);
        } catch (Throwable th) {
            th.printStackTrace();
            AlphaFace.throwable(th);
        }
    }
}
