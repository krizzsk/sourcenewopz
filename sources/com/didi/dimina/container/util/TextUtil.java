package com.didi.dimina.container.util;

public class TextUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0 || "null".equals(str);
    }
}
