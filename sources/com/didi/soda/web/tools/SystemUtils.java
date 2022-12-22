package com.didi.soda.web.tools;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class SystemUtils {

    /* renamed from: a */
    private static final String f43931a = "unknown";

    /* renamed from: b */
    private static final String f43932b = "ethernet";

    /* renamed from: c */
    private static final String f43933c = "wifi";

    /* renamed from: d */
    private static final String f43934d = "2G";

    /* renamed from: e */
    private static final String f43935e = "3G";

    /* renamed from: f */
    private static final String f43936f = "4G";

    public static String getModel() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int getVersionCode(Context context) {
        try {
            return com.didi.sdk.apm.SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return com.didi.sdk.apm.SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isNetWorkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static String getNetworkTypeString(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(connectivityManager);
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return "wifi";
                    }
                    if (type == 9) {
                        return "ethernet";
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "unknown";
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "unknown";
        }
    }
}
