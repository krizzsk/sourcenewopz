package com.didi.hawaii.utils;

public class ObjectUtil {
    public static boolean isEqual(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }
}
