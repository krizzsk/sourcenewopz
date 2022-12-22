package com.didichuxing.ditest.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import java.text.MessageFormat;

public final class Connectivity {
    private static final String ANDROID = "Android";
    private static AgentLog log = AgentLogManager.getAgentLog();

    private static String connectionNameFromNetworkSubtype(int i) {
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
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (!isConnected(networkInfo)) {
                return "none";
            }
            if (isWan(networkInfo)) {
                return carrierNameFromTelephonyManager(context);
            }
            if (isWifi(networkInfo)) {
                return "wifi";
            }
            log.warning(MessageFormat.format("Unknown network type: {0} [{1}]", new Object[]{networkInfo.getTypeName(), Integer.valueOf(networkInfo.getType())}));
            return "unknown";
        } catch (SecurityException unused) {
        }
    }

    public static String wanType(Context context) {
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (!isConnected(networkInfo)) {
                return "none";
            }
            if (isWifi(networkInfo)) {
                return "wifi";
            }
            if (isWan(networkInfo)) {
                return connectionNameFromNetworkSubtype(networkInfo.getSubtype());
            }
            return "unknown";
        } catch (SecurityException unused) {
            return "unknown";
        }
    }

    private static boolean isConnected(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean isWan(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 0 || type == 2 || type == 3 || type == 4 || type == 5;
    }

    private static boolean isWifi(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 1 || type == 9 || type == 6 || type == 7;
    }

    private static NetworkInfo getNetworkInfo(Context context) throws SecurityException {
        try {
            return SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (SecurityException e) {
            log.warning("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
            throw e;
        }
    }

    private static String carrierNameFromTelephonyManager(Context context) {
        String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        return (!networkOperatorName.equals(ANDROID) || !(Build.PRODUCT.equals("google_sdk") || Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("sdk_x86") || Build.FINGERPRINT.startsWith("generic"))) ? networkOperatorName : "wifi";
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
