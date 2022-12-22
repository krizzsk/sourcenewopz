package com.didi.safetoolkit.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class SfAppUtils {
    public static final String BRZ_DRIVER_PACKAGE_NAME = "com.app99.driver";
    public static final String BRZ_PACKAGE_NAME = "com.taxis99";

    public static String getAppName() {
        try {
            return SfContextHelper.getContext().getResources().getString(SfContextHelper.getContext().getApplicationInfo().labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isBrazilPackage(Context context) {
        Object obj;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        if ("com.taxis99".equals(packageName) || BRZ_DRIVER_PACKAGE_NAME.equals(packageName)) {
            return true;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, context.getPackageName(), 16512);
            if (packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (obj = packageInfo.applicationInfo.metaData.get("origin_id")) == null) {
                return false;
            }
            return TextUtils.equals(obj.toString(), "5");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
