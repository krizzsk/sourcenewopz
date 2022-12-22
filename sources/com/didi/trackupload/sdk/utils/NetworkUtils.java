package com.didi.trackupload.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;

public class NetworkUtils {
    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String[] getNetWorkInfo(Context context) {
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
}
