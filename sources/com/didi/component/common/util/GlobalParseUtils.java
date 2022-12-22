package com.didi.component.common.util;

import android.text.TextUtils;

public class GlobalParseUtils {
    /* renamed from: b */
    private static void m7979b(String str) {
    }

    public static double parseDouble(String str) {
        if (TextUtils.isEmpty(str)) {
            m7978a("parseDouble err while text is null!");
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            m7978a(e.toString());
            m7979b(e.toString());
            return 0.0d;
        }
    }

    /* renamed from: a */
    private static void m7978a(String str) {
        GLog.m7967e(str);
    }
}
