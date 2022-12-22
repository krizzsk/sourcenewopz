package com.sdk.poibase.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class Utils {

    /* renamed from: a */
    private static final Logger f56026a = LoggerFactory.getLogger("poi-base-lib");

    /* renamed from: b */
    private static final String f56027b = "com.linkee.global";

    public static void logInfo(String str) {
        f56026a.info(str, new Object[0]);
    }

    public static void logWarn(String str) {
        f56026a.warn(str, new Object[0]);
    }

    public static boolean isValidLocation(Address address) {
        return (address == null || Double.compare(address.latitude, 0.0d) == 0 || Double.compare(address.longitude, 0.0d) == 0) ? false : true;
    }

    public static boolean isCanoeApp(Context context) {
        return f56027b.equals(m40362a(context));
    }

    /* renamed from: a */
    private static String m40362a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getPackageName();
    }

    public static boolean isNetworkConnect(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
