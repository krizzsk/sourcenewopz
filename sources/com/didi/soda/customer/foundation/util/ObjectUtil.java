package com.didi.soda.customer.foundation.util;

public final class ObjectUtil {
    private ObjectUtil() {
    }

    public static boolean isObjectEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
