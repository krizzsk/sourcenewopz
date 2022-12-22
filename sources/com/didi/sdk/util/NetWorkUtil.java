package com.didi.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;
import java.util.logging.Handler;

public class NetWorkUtil {

    /* renamed from: a */
    private static final String f37663a = NetWorkUtil.class.getSimpleName();

    /* renamed from: b */
    private static final int f37664b = 1048576;

    /* renamed from: c */
    private static final double f37665c = 0.0078125d;

    /* renamed from: d */
    private static final double f37666d = 9.765625E-4d;

    /* renamed from: e */
    private static Handler f37667e;
    public static int timer;

    public static class SpeedInfo {
        public double downspeed = 0.0d;
        public double kilobits = 0.0d;
        public double megabits = 0.0d;
    }

    public enum netType {
        wifi,
        CMNET,
        CMWAP,
        noneNet
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo state : allNetworkInfo) {
                if (state.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static int getConnectedType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"))) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static netType getAPNType(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null) {
            return netType.noneNet;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            if (activeNetworkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
                return netType.CMNET;
            }
            return netType.CMWAP;
        } else if (type == 1) {
            return netType.wifi;
        } else {
            return netType.noneNet;
        }
    }

    /* renamed from: a */
    private static SpeedInfo m26719a(long j, long j2) {
        SpeedInfo speedInfo = new SpeedInfo();
        double d = (double) ((j2 / j) * 1000);
        double d2 = f37665c * d;
        double d3 = f37666d * d2;
        speedInfo.downspeed = d;
        speedInfo.kilobits = d2;
        speedInfo.megabits = d3;
        return speedInfo;
    }
}
