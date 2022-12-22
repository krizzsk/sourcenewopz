package com.didi.component.common.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String getNum(String str) {
        return str.replaceAll("[^\\d]+", "");
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Math.max(16, (str.length() + 1) * strArr.length));
        char charAt = str.length() == 1 ? str.charAt(0) : 0;
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                if (charAt != 0) {
                    sb.append(charAt);
                } else {
                    sb.append(str);
                }
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}
