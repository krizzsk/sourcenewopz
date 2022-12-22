package com.didi.bike.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.File;
import java.util.List;

public class SystemUtil {

    /* renamed from: a */
    private static final String f10667a = "SystemUtil";

    /* renamed from: b */
    private static String f10668b;

    /* renamed from: c */
    private static String f10669c;

    public static String getVersionName(Context context) {
        return com.didi.sdk.util.SystemUtil.getVersionName(context);
    }

    public static int getVersionCode(Context context) {
        if (context != null) {
            return WsgSecInfo.appVersionCode(context);
        }
        return WsgSecInfo.appVersionCode();
    }

    public static String getUUID(Context context) {
        if (!TextUtils.isEmpty(f10668b)) {
            return f10668b;
        }
        String androidID = getAndroidID(context);
        String cPUSerialNo = getCPUSerialNo();
        String md5 = MD5Util.md5("1_" + androidID + "2_" + getIMEI(context) + "3_" + cPUSerialNo);
        f10668b = md5;
        return md5;
    }

    public static String getCPUSerialNo() {
        return WsgSecInfo.cpuSerialNo();
    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str = f10669c;
        if (telephonyManager != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    String deviceId = telephonyManager.getDeviceId();
                    f10669c = deviceId;
                    str = deviceId;
                }
            } catch (Throwable th) {
                Log.w(f10667a, th);
            }
        }
        if (str == null || str.length() == 0 || str.equals("null")) {
            String model = getModel();
            String brand = getBrand();
            str = DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (brand.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (model.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        }
        return str + m7281a();
    }

    /* renamed from: a */
    private static final String m7281a() {
        return MD5Util.md5(Long.valueOf(new File("/system/build.prop").lastModified()).toString());
    }

    public static String getAndroidID(Context context) {
        if (context != null) {
            return WsgSecInfo.androidId(context);
        }
        return WsgSecInfo.androidId();
    }

    public static boolean isDebuggable(Context context) {
        return CommonUtil.isDebugBuild(context);
    }

    public static String getModel() {
        return WsgSecInfo.model();
    }

    public static String getBrand() {
        return WsgSecInfo.brand();
    }

    public static String getOSVersion() {
        return WsgSecInfo.osVersion();
    }

    public static String getDeviceId(Context context) {
        if (context != null) {
            return WsgSecInfo.customId(context);
        }
        return WsgSecInfo.customId();
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static String networkType(Context context) {
        if (context != null) {
            return WsgSecInfo.networkType(context);
        }
        return WsgSecInfo.networkType();
    }

    public static String getPackageName(Context context) {
        if (context != null) {
            return WsgSecInfo.packageName(context);
        }
        return WsgSecInfo.packageName();
    }

    public static boolean isAppTopFront(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (context == null || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.isEmpty()) {
            return false;
        }
        return runningTasks.get(0).topActivity.getPackageName().equals(getPackageName(context));
    }
}
