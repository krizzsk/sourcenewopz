package com.didi.common.map.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;

public class NetworkUtils {
    public static boolean checkNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
