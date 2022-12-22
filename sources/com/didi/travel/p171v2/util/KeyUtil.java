package com.didi.travel.p171v2.util;

import android.text.TextUtils;

/* renamed from: com.didi.travel.v2.util.KeyUtil */
public class KeyUtil {
    public static String generateKey(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            sb.append("|");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String generateSessionKey(String str, String str2) {
        return generateKey(str, str2);
    }

    public static String generatePollKey(String str, String str2, String str3) {
        return generateKey(str, str2, str3);
    }

    public static String generateStoreKey(String str, String str2, String str3) {
        return generateKey(str, str2, str3);
    }
}
