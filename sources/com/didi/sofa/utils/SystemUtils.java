package com.didi.sofa.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class SystemUtils {

    /* renamed from: a */
    private static final String f43962a = "gps";

    public static String getIp(Context context) {
        NetworkInfo.State state;
        NetworkInfo.State state2;
        WifiInfo connectionInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo == null) {
            state = null;
        } else {
            state = networkInfo.getState();
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 == null) {
            state2 = null;
        } else {
            state2 = networkInfo2.getState();
        }
        String a = state == NetworkInfo.State.CONNECTED ? m31299a() : null;
        if (state2 != NetworkInfo.State.CONNECTED) {
            return a;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return m31300a(connectionInfo.getIpAddress());
    }

    /* renamed from: a */
    private static String m31300a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* renamed from: a */
    private static String m31299a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean hasGPSDevice(Context context) {
        List<String> allProviders;
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null || (allProviders = locationManager.getAllProviders()) == null || !allProviders.contains("gps")) {
            return false;
        }
        return true;
    }

    public static boolean isWifiEnabled(Context context) {
        return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).isWifiEnabled();
    }

    public static String getWifiName(Context context) {
        WifiInfo connectionInfo;
        if (context == null || (connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) == null) {
            return "";
        }
        return connectionInfo.getSSID();
    }

    public static String getOperationName(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null) {
            return "unknow";
        }
        if (simOperator.startsWith("46000") || simOperator.startsWith("46002")) {
            return "中国移动";
        }
        if (simOperator.startsWith("46001")) {
            return "中国联通";
        }
        return simOperator.startsWith("46003") ? "中国电信" : simOperator;
    }

    public static boolean isGpsEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 15) {
            try {
                return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String string = Settings.System.getString(context.getContentResolver(), "location_providers_allowed");
        return !TextUtils.isEmpty(string) && string.contains("gps");
    }

    public static boolean isNetWorkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static int getWindowHeight(Activity activity) {
        return ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int getTitleBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static boolean isCalling(Context context) {
        ComponentName a = m31298a(context);
        return a != null && a.getPackageName().equalsIgnoreCase("com.android.phone") && a.getClassName().contains("InCallScreen");
    }

    public static String getBriefPhoneNumber(String str) {
        return getBriefPhoneNumber(str, 4);
    }

    public static String getBriefPhoneNumber(String str, int i) {
        if (str == null) {
            return "";
        }
        return str.length() >= i ? str.substring(str.length() - i) : str;
    }

    public static String getFormatPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /* renamed from: a */
    private static ComponentName m31298a(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() < 1) {
            return null;
        }
        return runningTasks.get(0).topActivity;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null || !activeNetworkInfo.isConnected()) {
            return "UNKNOWN";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "UNKNOWN";
        }
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
                return "4G";
            default:
                return "UNKNOWN";
        }
    }
}
