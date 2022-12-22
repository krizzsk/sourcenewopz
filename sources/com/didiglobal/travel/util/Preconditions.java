package com.didiglobal.travel.util;

public class Preconditions {
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean nonNull(Object obj) {
        return obj != null;
    }

    public static void require(boolean z) {
        require(z, "Failed requirement.");
    }

    public static void require(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(obj.toString());
        }
    }

    public static void check(boolean z) {
        check(z, "Check failed.");
    }

    public static void check(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(obj.toString());
        }
    }

    public static void checkNotNull(Object obj) {
        checkNotNull(obj, "Required value was null.");
    }

    public static void checkNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalStateException(obj2.toString());
        }
    }

    public static void error(Object obj) {
        throw new IllegalStateException(obj.toString());
    }
}
