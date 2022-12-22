package com.didichuxing.security.safecollector;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* renamed from: com.didichuxing.security.safecollector.e */
/* compiled from: NetworkCollector */
final class C16450e {

    /* renamed from: a */
    private static volatile boolean f49012a = false;

    /* renamed from: b */
    private static volatile boolean f49013b = false;

    C16450e() {
    }

    /* renamed from: a */
    public static String m35260a(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m35261b(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m35262c(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: d */
    public static String m35263d(Context context) {
        try {
            if (C16448c.f49000b == null) {
                C16448c.f49000b = (TelephonyManager) context.getSystemService("phone");
            }
            return C16448c.f49000b.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
