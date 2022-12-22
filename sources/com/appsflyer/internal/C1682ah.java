package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* renamed from: com.appsflyer.internal.ah */
public final class C1682ah {

    /* renamed from: Ι */
    private static String f1909;

    /* renamed from: ι */
    private static String f1910;

    C1682ah() {
    }

    /* renamed from: ǃ */
    public static void m1628(String str) {
        f1909 = str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                sb.append(str.charAt(i));
            } else {
                sb.append("*");
            }
        }
        f1910 = sb.toString();
    }

    /* renamed from: Ι */
    public static void m1629(String str) {
        if (f1909 == null) {
            m1628(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        }
        String str2 = f1909;
        if (str2 != null && str.contains(str2)) {
            AFLogger.afInfoLog(str.replace(f1909, f1910));
        }
    }
}
