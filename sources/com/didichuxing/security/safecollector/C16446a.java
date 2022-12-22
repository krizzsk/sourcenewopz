package com.didichuxing.security.safecollector;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didichuxing.security.safecollector.a */
/* compiled from: AppInfoCollector */
final class C16446a {
    C16446a() {
    }

    /* renamed from: a */
    public static String m35224a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getString(SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m35225b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static int m35226c(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    /* renamed from: d */
    public static String m35227d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getApplicationInfo().packageName, 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static String m35228e(Context context) {
        try {
            return SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.getString("issue");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m35223a() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
