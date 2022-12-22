package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.yanzhenjie.permission.runtime.Permission;

public class NetworkCollector {

    /* renamed from: a */
    private static ConnectivityManager f45553a;

    /* renamed from: b */
    private static Context f45554b;

    /* renamed from: c */
    private static TelephonyManager f45555c;

    public static void init(Context context) {
        f45554b = context;
    }

    public static String getNetworkType() {
        try {
            if (f45553a == null) {
                f45553a = (ConnectivityManager) f45554b.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(f45553a);
            if (activeNetworkInfo == null) {
                return "UNKNOWN";
            }
            if (!activeNetworkInfo.isConnected()) {
                return IStoreCallback.DEFAULT_API_DETAIL_KEY;
            }
            return activeNetworkInfo.getTypeName().toUpperCase();
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }

    public static boolean isAvailable(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static String getIMSI(String str) {
        try {
            if (f45554b.checkCallingOrSelfPermission(Permission.READ_PHONE_STATE) != 0) {
                return str;
            }
            if (f45555c == null) {
                f45555c = (TelephonyManager) f45554b.getSystemService("phone");
            }
            return f45555c.getSubscriberId();
        } catch (Exception unused) {
            return "";
        }
    }
}
