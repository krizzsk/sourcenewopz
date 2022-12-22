package com.didichuxing.comp.telecom.core.request;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.comp.telecom.core.CallManagerAssist;

public class NetworkUtil {
    public static int getNetworkType() {
        Context appContext = CallManagerAssist.getInstance().getAppContext();
        if (appContext == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) appContext.getSystemService("connectivity"));
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 10;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 3;
        }
        if (activeNetworkInfo.getType() != 0) {
            return 10;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 13 || subtype == 18) {
            return 1;
        }
        return subtype != 20 ? 10 : 2;
    }
}
