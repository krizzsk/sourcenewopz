package com.didi.rfusion.utils;

public class RFUtils {
    public static boolean isPadFlavor() {
        return false;
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
