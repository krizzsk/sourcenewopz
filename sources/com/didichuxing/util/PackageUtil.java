package com.didichuxing.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;

public final class PackageUtil {
    public static int getVersionCode(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private PackageUtil() {
    }
}
