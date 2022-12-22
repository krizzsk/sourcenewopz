package com.didi.sdk.util;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;

public class UrlUtils {
    public static String addParam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        String str4 = str2 + "=" + str3;
        if (str.endsWith("?")) {
            return str + str4;
        } else if (!str.contains("?")) {
            return str + "?" + str4;
        } else if (str.endsWith(ParamKeys.SIGN_AND)) {
            return str + str4;
        } else {
            return str + ParamKeys.SIGN_AND + str4;
        }
    }
}
