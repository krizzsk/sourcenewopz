package com.didiglobal.privacy.domainmonitor.utils;

import java.util.HashMap;
import java.util.Map;

public class ParseUrlParamUtil {
    /* renamed from: a */
    private static String m36334a(String str) {
        if (str != null && str.length() > 0) {
            String[] split = str.trim().split("[?]");
            if (split.length > 1 && split[1] != null) {
                return split[1];
            }
        }
        return null;
    }

    public static Map<String, String> getParams(String str) {
        HashMap hashMap = new HashMap();
        String a = m36334a(str);
        if (a == null) {
            return hashMap;
        }
        for (String split : a.split("[&]")) {
            String[] split2 = split.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }
}
