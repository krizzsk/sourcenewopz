package com.didi.global.globalresource.utils;

import android.net.Uri;
import android.text.TextUtils;

public class GRUtils {
    public static String getResourceNameWithSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getLastPathSegment();
    }

    public static String getResourceNameWithoutSuffix(String str) {
        return getResourceRealName(getResourceNameWithSuffix(str));
    }

    public static String getResourceRealName(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("\\.")) != null && split.length > 0) {
            String str2 = split[0];
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return str;
    }

    public static String hasResource(String[] strArr, String str) {
        String[] split;
        if (!(strArr == null || strArr.length == 0)) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && (split = str2.split("\\.")) != null && split.length > 0) {
                    String str3 = split[0];
                    if (!TextUtils.isEmpty(str3) && str3.equals(str)) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }
}
