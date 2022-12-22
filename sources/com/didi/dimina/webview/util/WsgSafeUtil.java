package com.didi.dimina.webview.util;

import android.content.Context;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class WsgSafeUtil {
    public static String getAppName(Context context) {
        return WsgSecInfo.appName(context);
    }

    public static String getPackageName(Context context) {
        return WsgSecInfo.packageName(context);
    }

    public static int getAppVersionCode(Context context) {
        return WsgSecInfo.appVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return WsgSecInfo.appVersionName(context);
    }

    public static String getAppVersionIssue(Context context) {
        return WsgSecInfo.appVersionIssue(context);
    }

    public static String getOsType(Context context) {
        return WsgSecInfo.osType(context);
    }

    public static String getOsVersion(Context context) {
        return WsgSecInfo.osVersion(context);
    }

    public static String getModel(Context context) {
        return WsgSecInfo.model(context);
    }

    public static String getBrand(Context context) {
        return WsgSecInfo.brand(context);
    }

    public static String getCpu(Context context) {
        return WsgSecInfo.cpu(context);
    }

    public static String getCpuSerialno(Context context) {
        return WsgSecInfo.cpuSerialNo(context);
    }

    public static String getPixels(Context context) {
        return WsgSecInfo.pixels(context);
    }

    public static String getTotalSpace(Context context) {
        return WsgSecInfo.totalSpace(context);
    }

    public static boolean isRoot(Context context) {
        return WsgSecInfo.isRootBoolean(context);
    }

    public static String getAndroidId(Context context) {
        return WsgSecInfo.androidId(context);
    }

    public static String getDeviceId(Context context) {
        return WsgSecInfo.customId(context);
    }

    public static String getImsi(Context context) {
        return WsgSecInfo.imsi(context);
    }

    public static String getScreenSize(Context context) {
        return WsgSecInfo.screenSize(context);
    }

    public static int getEmulatorType(Context context) {
        return WsgSecInfo.emulatorType(context);
    }

    public static int getUtcOffset(Context context) {
        return WsgSecInfo.utcOffset(context);
    }

    public static String getCountryCode(Context context) {
        return WsgSecInfo.countryCode(context);
    }

    public static String getLocale(Context context) {
        return WsgSecInfo.locale(context);
    }

    public static String getMcc(Context context) {
        return WsgSecInfo.mcc(context);
    }

    public static String getMnc(Context context) {
        return WsgSecInfo.mnc(context);
    }

    public static String getSimCarrier(Context context) {
        return WsgSecInfo.simCarrier(context);
    }

    public static String getNetworkType(Context context) {
        return WsgSecInfo.networkType(context);
    }

    public static String getLocalIp(Context context) {
        return WsgSecInfo.localIp(context);
    }

    public static String getBatteryLevel(Context context) {
        return WsgSecInfo.batteryLevel(context);
    }

    public static String getPhoneTime(Context context) {
        return WsgSecInfo.phoneTime(context);
    }

    public static boolean isDebug(Context context) {
        return WsgSecInfo.isDebugBoolean(context);
    }

    public static boolean isBackground(Context context) {
        return WsgSecInfo.isBackgroundBoolean(context);
    }
}
