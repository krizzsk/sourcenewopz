package com.didi.soda.customer.foundation.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;

public final class NetWorkUtils {

    /* renamed from: a */
    private static final String f41246a = "http";

    /* renamed from: b */
    private static final String f41247b = "https";

    /* renamed from: c */
    private static final String f41248c = "ethernet";

    /* renamed from: d */
    private static final String f41249d = "wifi";

    /* renamed from: e */
    private static final String f41250e = "unknown";

    /* renamed from: f */
    private static final String f41251f = "2G";

    /* renamed from: g */
    private static final String f41252g = "3G";

    /* renamed from: h */
    private static final String f41253h = "4G";

    private NetWorkUtils() {
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static int getConnectedType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static int getAPNType(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
            return 4;
        }
        if (subtype == 3 || subtype == 8 || (subtype == 5 && !telephonyManager.isNetworkRoaming())) {
            return 3;
        }
        if (!(subtype == 1 || subtype == 2 || subtype != 4)) {
            boolean isNetworkRoaming = telephonyManager.isNetworkRoaming();
        }
        return 2;
    }

    public static boolean isNetAvailable() {
        if (isNetworkConnected(GlobalContext.getContext())) {
            return true;
        }
        if (GlobalContext.getContext() == null) {
            return false;
        }
        ToastUtil.makeText(GlobalContext.getContext().getResources().getString(R.string.customer_net_error_tip));
        return false;
    }

    public static boolean isHttpUri(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return true;
        }
        return false;
    }

    public static boolean isHttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isHttpUri(Uri.parse(str));
    }

    public static String getNetworkType(Context context) {
        String str = "4G";
        if (context == null) {
            return "unknown";
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                if (1 == activeNetworkInfo.getType()) {
                    return "wifi";
                }
                if (9 == activeNetworkInfo.getType()) {
                    return "ethernet";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
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
                            return str;
                        default:
                            return "unknown";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "unknown";
            }
            int i = 0;
            if (ActivityCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) == 0) {
                if (Build.VERSION.SDK_INT >= 24) {
                    i = telephonyManager.getDataNetworkType();
                } else {
                    i = telephonyManager.getNetworkType();
                }
            }
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    str = "2G";
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    str = "3G";
                    break;
                case 13:
                    break;
                default:
                    str = "unknown";
                    break;
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "unknown";
        }
    }
}
