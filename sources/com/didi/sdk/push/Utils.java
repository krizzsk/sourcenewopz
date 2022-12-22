package com.didi.sdk.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;

public class Utils {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_MOBILE = 5;
    public static final int NETWORK_NONE = 0;
    public static final int NETWORK_WIFI = 1;
    private static final Pattern VERSION_NAME_PATTERN = Pattern.compile("(\\d+\\.\\d+\\.\\d+)\\-*.*");

    @Deprecated
    public static String getWifiSsid(Context context) {
        return "unknown-ssid";
    }

    public static long msgTypeAndpushType2Key(int i, int i2) {
        return ((((long) i) << 32) & -4294967296L) | (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    @Deprecated
    public static String getCurrentVersion(Context context) {
        return WsgSecInfo.appVersionName(context);
    }

    public static String[] getNetworkAndOperator(Context context) {
        NetworkInfo activeNetworkInfo;
        String[] strArr = new String[2];
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null)) {
            if (activeNetworkInfo.getType() == 0) {
                strArr[0] = activeNetworkInfo.getExtraInfo();
                strArr[1] = activeNetworkInfo.getSubtypeName();
            } else if (activeNetworkInfo.getType() == 1) {
                strArr[0] = null;
                strArr[1] = activeNetworkInfo.getTypeName();
            }
        }
        return strArr;
    }

    public static int getNetworkType(Context context) {
        String networkType = WsgSecInfo.networkType(context);
        if (TextUtils.isEmpty(networkType)) {
            return 0;
        }
        if (networkType.contains("2G")) {
            return 2;
        }
        if (networkType.contains("3G")) {
            return 3;
        }
        if (networkType.contains("4G")) {
            return 4;
        }
        if (networkType.contains("5G")) {
            return 5;
        }
        if (networkType.contains("WIFI")) {
            return 1;
        }
        return 0;
    }

    public static String getNetworkTypeName(Context context) {
        return WsgSecInfo.networkType(context);
    }

    public static String getMobileOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return "-1";
        }
        return telephonyManager.getSimOperator();
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static boolean isIpv4(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 7 && str.length() <= 15) {
            try {
                return Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)").matcher(str.trim()).find();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String getUniquePsuedoID() {
        return WsgSecInfo.androidId();
    }
}
