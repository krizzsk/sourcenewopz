package com.didichuxing.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpgradeSystemUtil {

    /* renamed from: a */
    private static final String f49264a = "UpgradeSDK_SystemUtil";

    /* renamed from: b */
    private static String f49265b = null;

    /* renamed from: c */
    private static boolean f49266c = false;

    /* renamed from: d */
    private static String f49267d = null;

    /* renamed from: e */
    private static int f49268e = -1;

    /* renamed from: f */
    private static final Pattern f49269f = Pattern.compile("(\\d+\\.\\d+\\.\\d+)\\-*.*");

    public static String getVersion() {
        String str = Build.VERSION.SDK;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getCPUSerialno() {
        if (!TextUtils.isEmpty(f49265b)) {
            return f49265b;
        }
        String str = "";
        if (f49266c) {
            f49265b = str;
            return str;
        }
        try {
            f49266c = true;
            Process exec = Runtime.getRuntime().exec("cat /proc/cpuinfo");
            if (exec == null) {
                return null;
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                if (str != null) {
                    str = lineNumberReader.readLine();
                    if (str != null) {
                        f49265b = str.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
            return f49265b;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String getScreenInfo(Context context) {
        int screenWidth = getScreenWidth(context);
        int screenHeight = getScreenHeight(context);
        return screenWidth + "x" + screenHeight;
    }

    public static String getVersionName(Context context) {
        if (!TextUtils.isEmpty(f49267d)) {
            return f49267d;
        }
        try {
            String str = SystemUtils.getPackageInfo(context.getPackageManager(), context.getApplicationInfo().packageName, 0).versionName;
            if (str == null || str.length() <= 0) {
                return str;
            }
            Matcher matcher = f49269f.matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            f49267d = group;
            return group;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        int i = f49268e;
        if (i != -1) {
            return i;
        }
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384);
            if (packageInfo == null) {
                return 1;
            }
            int i2 = packageInfo.versionCode;
            f49268e = i2;
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static String getNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "UNKNOWN";
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
                return "WIFI";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "UNKNOWN";
            }
            switch (telephonyManager.getNetworkType()) {
                case 0:
                    return "UNKNOWN";
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
                    return "UNKNOWN";
            }
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
}
