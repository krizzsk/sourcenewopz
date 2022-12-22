package com.didi.component.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class ApkUtils {
    public static boolean checkApkExist(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (SystemUtils.getPackageInfo(context.getPackageManager(), str, 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.getPackageManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isPackageCanBeLaunched(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            android.content.Intent r3 = r2.getLaunchIntentForPackage(r3)
            if (r3 != 0) goto L_0x000f
            return r0
        L_0x000f:
            r1 = 65536(0x10000, float:9.18355E-41)
            java.util.List r2 = r2.queryIntentActivities(r3, r1)
            if (r2 == 0) goto L_0x001e
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x001e
            r0 = 1
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.util.ApkUtils.isPackageCanBeLaunched(android.content.Context, java.lang.String):boolean");
    }

    public static Drawable getAppLauncherIcon(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return packageManager.getApplicationIcon(SystemUtils.getApplicationInfo(packageManager, context.getPackageName(), 0));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
