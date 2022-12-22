package com.didichuxing.omega.sdk.common.collector;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.datadog.android.core.internal.net.DataOkHttpUploader;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Collections;

public class DeviceCollector {
    private static String deviceId = "";
    private static Boolean isDebug = null;
    private static Context mContext = null;
    private static int mIsRoot = -1;

    public static void init(Context context) {
        mContext = context;
        syncIsDebug();
    }

    public static String getDeviceId() {
        if (TextUtils.isEmpty(deviceId)) {
            try {
                deviceId = ((TelephonyManager) mContext.getSystemService("phone")).getDeviceId();
            } catch (Throwable unused) {
            }
        }
        return deviceId;
    }

    public static String getUserAgent() {
        if (Build.VERSION.SDK_INT < 17) {
            return System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        }
        try {
            return WebSettings.getDefaultUserAgent(mContext);
        } catch (Exception unused) {
            return System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        }
    }

    private static String getMacFromHardware() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String getAndroidId() {
        try {
            return Settings.Secure.getString(mContext.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getIsRoot() {
        if (mIsRoot == -1) {
            mIsRoot = (checkRootMethod2() || checkRootMethod3()) ? 1 : 0;
        }
        return mIsRoot;
    }

    private static boolean checkRootMethod2() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i = 0; i < 9; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                if (exec != null) {
                    exec.destroy();
                }
                return true;
            }
            if (exec != null) {
                exec.destroy();
            }
            return false;
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public static int getEmulatorType() {
        try {
            if (Build.FINGERPRINT.startsWith("generic")) {
                return 1;
            }
            if (Build.FINGERPRINT.toLowerCase().contains("vbox")) {
                return 2;
            }
            if (Build.FINGERPRINT.toLowerCase().contains("test-keys")) {
                return 3;
            }
            if (Build.MODEL.toLowerCase().equals("sdk")) {
                return 4;
            }
            if (Build.MODEL.toLowerCase().contains("google_sdk")) {
                return 5;
            }
            if (Build.MODEL.toLowerCase().contains("emulator")) {
                return 6;
            }
            if (Build.MODEL.toLowerCase().contains("android sdk built for x86")) {
                return 7;
            }
            if (Build.HARDWARE.toLowerCase().contains("goldfish")) {
                return 8;
            }
            if (Build.HOST.toLowerCase().contains("android-test")) {
                return 9;
            }
            if (Build.MANUFACTURER.toLowerCase().contains("genymotion")) {
                return 12;
            }
            if (Build.PRODUCT.toLowerCase().equals("google_sdk")) {
                return 13;
            }
            if (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) {
                return 14;
            }
            if ("000000000000000".equals(getDeviceId())) {
                return 16;
            }
            if ("012345678912345".equals(getDeviceId())) {
                return 17;
            }
            return "android".equals(NetworkCollector.getNetworkOperator()) ? 18 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isDebug() {
        Boolean bool = isDebug;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void syncIsDebug() {
        try {
            if (isDebug == null) {
                isDebug = Boolean.valueOf((mContext.getApplicationInfo() == null || (mContext.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
        } catch (Throwable unused) {
        }
    }
}
