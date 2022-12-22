package com.didi.map.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.didi.sdk.apm.SystemUtils;

public class NetTypeUtil {
    public static final String CMWAP = "cmwap";
    public static final String CTWAP = "ctwap";
    public static final String NET_3G = "3gnet";
    public static Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    public static final int TYPE_3GWAP = 3;
    public static final int TYPE_CMWAP = 1;
    public static final int TYPE_CTWAP = 4;
    public static final int TYPE_NET_WORK_DISABLED = 0;
    public static final int TYPE_OTHER_NET = 6;
    public static final int TYPE_UNIWAP = 2;
    public static final int TYPE_WIFI = 5;
    public static final String UNIWAP = "uniwap";
    public static final String WAP_3G = "3gwap";
    public static final String WIFI = "wifi";

    public static boolean isMobileWap(int i) {
        return i == 3 || i == 2 || i == 1 || i == 4;
    }

    public static boolean isNetDisable(int i) {
        return i == 0;
    }

    public static String getNetTypeStr(Context context) {
        int netType = getNetType(context);
        if (netType == 1) {
            return CMWAP;
        }
        if (netType == 2) {
            return UNIWAP;
        }
        if (netType == 3) {
            return WAP_3G;
        }
        if (netType != 4) {
            return netType != 5 ? "unknown" : "wifi";
        }
        return CTWAP;
    }

    public static int getNetType(Context context) {
        String extraInfo;
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 5;
        }
        if (type == 0 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && !extraInfo.equals("")) {
            if (extraInfo.equalsIgnoreCase(CMWAP)) {
                return 1;
            }
            if (extraInfo.equalsIgnoreCase(WAP_3G)) {
                return 3;
            }
            if (extraInfo.equalsIgnoreCase(UNIWAP)) {
                return 2;
            }
            if (extraInfo.equalsIgnoreCase(CTWAP)) {
                return 4;
            }
        }
        return 6;
    }

    public static boolean isMobileWap(Context context) {
        return isMobileWap(getNetType(context));
    }

    public static boolean isNetDisable(Context context) {
        return isNetDisable(getNetType(context));
    }
}
