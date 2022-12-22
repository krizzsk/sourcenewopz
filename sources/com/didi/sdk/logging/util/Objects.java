package com.didi.sdk.logging.util;

public class Objects {
    public static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
