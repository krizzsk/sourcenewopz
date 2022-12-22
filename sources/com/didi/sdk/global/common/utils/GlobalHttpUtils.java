package com.didi.sdk.global.common.utils;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.Map;

public class GlobalHttpUtils {

    /* renamed from: a */
    private static final String f36099a = "Balance";

    public static String appendQueryParams(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (map.isEmpty()) {
            SystemUtils.log(6, "Balance", "Trying to add an empty parameters map", (Throwable) null, "com.didi.sdk.global.common.utils.GlobalHttpUtils", 31);
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append(ParamKeys.SIGN_AND);
            sb.append(next.getKey());
            sb.append("=");
            sb.append(next.getValue());
        }
        return appendQueryParam(str, sb.toString());
    }

    public static String appendQueryParam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str2.isEmpty()) {
            SystemUtils.log(6, "Balance", "Trying to add empty parameter key", (Throwable) null, "com.didi.sdk.global.common.utils.GlobalHttpUtils", 64);
            return str;
        }
        return appendQueryParam(str, ParamKeys.SIGN_AND + str2 + "=" + str3);
    }

    public static String appendQueryParam(String str, String str2) {
        if (str.contains("?")) {
            return str + str2;
        }
        return str + str2.replaceFirst(ParamKeys.SIGN_AND, "?");
    }
}
