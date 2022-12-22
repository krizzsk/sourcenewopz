package com.didichuxing.foundation.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.didi.sdk.apm.SystemUtils;

public abstract class PackageUtil {
    public static int getVersionCode(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMetaData(Context context, String str) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 128);
            if (packageInfo == null || packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null) {
                return null;
            }
            return packageInfo.applicationInfo.metaData.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private PackageUtil() {
    }
}
