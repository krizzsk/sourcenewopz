package com.sdk.poibase.util;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;

public class UrlParseUtils {
    /* renamed from: b */
    private static String m40361b(String str) {
        return "";
    }

    public static HashMap<String, String> getUrlParams(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        String a = m40360a(str);
        if (a.contains(ParamKeys.SIGN_AND)) {
            for (String str2 : a.split("[&]")) {
                if (!TextUtils.isEmpty(str2) && str2.contains("=") && (split = str2.split("[=]")) != null) {
                    if (split.length > 1) {
                        if (!(split[0] == null || split[1] == null)) {
                            hashMap.put(split[0].trim(), split[1].trim());
                        }
                    } else if (split[0] != null) {
                        hashMap.put(split[0].trim(), "");
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r2 = r2.trim().split("\\?");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m40360a(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = "?"
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x0025
            java.lang.String r2 = r2.trim()
            java.lang.String r0 = "\\?"
            java.lang.String[] r2 = r2.split(r0)
            if (r2 == 0) goto L_0x0025
            int r0 = r2.length
            r1 = 1
            if (r0 <= r1) goto L_0x0025
            r0 = r2[r1]
            if (r0 == 0) goto L_0x0025
            r2 = r2[r1]
            return r2
        L_0x0025:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.poibase.util.UrlParseUtils.m40360a(java.lang.String):java.lang.String");
    }
}
