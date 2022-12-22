package com.didi.trackupload.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;

public class EquipmentAppUtils {
    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static String getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
