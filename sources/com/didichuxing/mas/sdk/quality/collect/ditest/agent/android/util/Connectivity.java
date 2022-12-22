package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import java.text.MessageFormat;

public final class Connectivity {

    /* renamed from: a */
    private static final String f48063a = "Android";

    /* renamed from: b */
    private static AgentLog f48064b = AgentLogManager.getAgentLog();

    /* renamed from: a */
    private static String m34284a(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO rev 0";
            case 6:
                return "EVDO rev A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO rev B";
            case 13:
                return "LTE";
            case 14:
                return "HRPD";
            case 15:
                return "HSPAP";
            default:
                return "unknown";
        }
    }

    public static String carrierNameFromContext(Context context) {
        try {
            NetworkInfo a = m34283a(context);
            if (!m34285a(a)) {
                return "none";
            }
            if (m34287b(a)) {
                return m34286b(context);
            }
            if (m34288c(a)) {
                return "wifi";
            }
            f48064b.warning(MessageFormat.format("Unknown network type: {0} [{1}]", new Object[]{a.getTypeName(), Integer.valueOf(a.getType())}));
            return "unknown";
        } catch (SecurityException unused) {
        }
    }

    public static String wanType(Context context) {
        try {
            NetworkInfo a = m34283a(context);
            if (!m34285a(a)) {
                return "none";
            }
            if (m34288c(a)) {
                return "wifi";
            }
            if (m34287b(a)) {
                return m34284a(a.getSubtype());
            }
            return "unknown";
        } catch (SecurityException unused) {
            return "unknown";
        }
    }

    /* renamed from: a */
    private static boolean m34285a(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    /* renamed from: b */
    private static boolean m34287b(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 0 || type == 2 || type == 3 || type == 4 || type == 5;
    }

    /* renamed from: c */
    private static boolean m34288c(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 1 || type == 9 || type == 6 || type == 7;
    }

    /* renamed from: a */
    private static NetworkInfo m34283a(Context context) throws SecurityException {
        try {
            return SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (SecurityException e) {
            f48064b.warning("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
            throw e;
        }
    }

    /* renamed from: b */
    private static String m34286b(Context context) {
        String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        return (!networkOperatorName.equals(f48063a) || !(Build.PRODUCT.equals("google_sdk") || Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("sdk_x86") || Build.FINGERPRINT.startsWith("generic"))) ? networkOperatorName : "wifi";
    }

    public static String getCarrierName(Context context) {
        try {
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            if (networkOperatorName == null) {
                return "unknown";
            }
            return networkOperatorName;
        } catch (SecurityException unused) {
            return "unknown";
        }
    }
}
