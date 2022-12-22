package com.didi.sdk.fastframe.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.NetworkSubJSBridge;
import com.didi.sdk.apm.SystemUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemUtil {
    public static String CLIENT_TYPE = "2";
    public static String DEVICE_ID;
    public static String MOBILE_TYPE = Build.MODEL;
    public static String OS_VERSION = Build.VERSION.RELEASE;
    public static int SDK = Build.VERSION.SDK_INT;

    /* renamed from: a */
    private static String f35892a = null;

    public static String getVersionName(Context context) {
        if (!TextUtils.isEmpty(f35892a) || context == null) {
            return f35892a;
        }
        f35892a = null;
        try {
            String str = SystemUtils.getPackageInfo(context.getPackageManager(), context.getApplicationInfo().packageName, 0).versionName;
            f35892a = str;
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+)\\-*.*").matcher(f35892a);
                if (matcher.matches()) {
                    f35892a = matcher.group(1);
                }
            }
        } catch (Exception unused) {
        }
        return f35892a;
    }

    public static String getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                return "wifi";
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return NetworkSubJSBridge.NetworkType.TYPE_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return NetworkSubJSBridge.NetworkType.TYPE_3G;
                    case 13:
                        return NetworkSubJSBridge.NetworkType.TYPE_4G;
                }
            }
        }
        return "";
    }
}
