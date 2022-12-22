package com.didichuxing.sofa.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didichuxing.sofa.permission.f */
/* compiled from: SpecialPermissionCompat */
final class C16483f {

    /* renamed from: a */
    private static final String f49154a = "SpecialPermissionCompat";

    private C16483f() {
    }

    /* renamed from: a */
    static void m35444a(Activity activity, String str, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent b = m35448b(activity, str);
            if (b == null) {
                SystemUtils.log(6, f49154a, "requestPermission " + str + " failed.", (Throwable) null, "com.didichuxing.sofa.permission.SpecialPermissionCompat", 30);
                return;
            }
            activity.startActivityForResult(b, i);
        }
    }

    /* renamed from: a */
    static void m35445a(Fragment fragment, String str, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent b = m35448b(fragment.getContext(), str);
            if (b == null) {
                SystemUtils.log(6, f49154a, "requestPermission " + str + " failed.", (Throwable) null, "com.didichuxing.sofa.permission.SpecialPermissionCompat", 40);
                return;
            }
            fragment.startActivityForResult(b, i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Intent m35448b(android.content.Context r7, java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r1 = -2078357533(0xffffffff841ec7e3, float:-1.8664594E-36)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = -1561629405(0xffffffffa2eb6d23, float:-6.381243E-18)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x002f
            if (r0 == r2) goto L_0x002c
            java.lang.String r0 = ""
            goto L_0x0031
        L_0x002c:
            java.lang.String r0 = "android.settings.action.MANAGE_WRITE_SETTINGS"
            goto L_0x0031
        L_0x002f:
            java.lang.String r0 = "android.settings.action.MANAGE_OVERLAY_PERMISSION"
        L_0x0031:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0055
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "getIntent: Can't resolve permission: "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r3 = r7.toString()
            r1 = 6
            r4 = 0
            r6 = 62
            java.lang.String r2 = "SpecialPermissionCompat"
            java.lang.String r5 = "com.didichuxing.sofa.permission.SpecialPermissionCompat"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            r7 = 0
            return r7
        L_0x0055:
            android.content.Intent r8 = new android.content.Intent
            r8.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "package:"
            r0.append(r1)
            java.lang.String r7 = r7.getPackageName()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            android.net.Uri r7 = android.net.Uri.parse(r7)
            android.content.Intent r7 = r8.setData(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sofa.permission.C16483f.m35448b(android.content.Context, java.lang.String):android.content.Intent");
    }

    /* renamed from: a */
    static boolean m35447a(String str) {
        return str.equals("android.permission.SYSTEM_ALERT_WINDOW") || str.equals("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: a */
    static boolean m35446a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -2078357533) {
            if (hashCode == -1561629405 && str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                c = 0;
            }
        } else if (str.equals("android.permission.WRITE_SETTINGS")) {
            c = 1;
        }
        if (c == 0) {
            return Settings.canDrawOverlays(context);
        }
        if (c != 1) {
            return true;
        }
        return Settings.System.canWrite(context);
    }
}
