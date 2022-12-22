package com.didi.hawaii.utils;

public final class Objects {
    private Objects() {
    }

    public static boolean isNotNull(Object... objArr) {
        if (objArr == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }
}
