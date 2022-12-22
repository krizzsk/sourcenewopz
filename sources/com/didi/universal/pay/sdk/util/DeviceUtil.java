package com.didi.universal.pay.sdk.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Process;
import com.didi.sdk.apm.SystemUtils;
import java.net.URLDecoder;
import java.util.List;

public class DeviceUtil {
    public static String getPackageName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    public static boolean isCMBAppInstalled(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), "cmb.pb", 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean isSchemeSupport(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(URLDecoder.decode(str)));
            intent.setAction("android.intent.action.VIEW");
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            LogUtil.m32408d("isSchemeSupport", e.toString());
            return false;
        }
    }
}
