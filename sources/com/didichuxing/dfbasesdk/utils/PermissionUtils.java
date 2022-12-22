package com.didichuxing.dfbasesdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PermissionUtils {
    private PermissionUtils() {
    }

    public static boolean checkGranted(Context context, String[] strArr) {
        for (String hasPermission : strArr) {
            if (!hasPermission(context, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasPermission(Context context, String str) {
        return m33573a(context, str) && m33576b(context, str);
    }

    /* renamed from: a */
    private static boolean m33573a(Context context, String str) {
        int i;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                i = ContextCompat.checkSelfPermission(context, str);
            } else {
                i = PermissionChecker.checkSelfPermission(context, str);
            }
            if (i == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m33576b(Context context, String str) {
        AppOpsManager appOpsManager;
        int i;
        if (Build.VERSION.SDK_INT < 19 || (appOpsManager = (AppOpsManager) context.getSystemService("appops")) == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            i = m33571a(appOpsManager, str, WsgSecInfo.packageName(context));
        } else {
            i = m33574b(appOpsManager, str, WsgSecInfo.packageName(context));
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m33571a(AppOpsManager appOpsManager, String str, String str2) {
        try {
            return appOpsManager.checkOp(m33575b(str), Binder.getCallingUid(), str2);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static int m33574b(AppOpsManager appOpsManager, String str, String str2) {
        try {
            Field declaredField = AppOpsManager.class.getDeclaredField(m33572a(str));
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(appOpsManager)).intValue();
            Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appOpsManager, new Object[]{Integer.valueOf(intValue), Integer.valueOf(Binder.getCallingUid()), str2})).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m33572a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 1365911975(0x516a29a7, float:6.2857572E10)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 1831139720(0x6d24f988, float:3.1910754E27)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "android.permission.RECORD_AUDIO"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x002e
            if (r0 == r2) goto L_0x002b
            r0 = 0
            goto L_0x0030
        L_0x002b:
            java.lang.String r0 = "OP_WRITE_EXTERNAL_STORAGE"
            goto L_0x0030
        L_0x002e:
            java.lang.String r0 = "OP_RECORD_AUDIO"
        L_0x0030:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0037
            return r0
        L_0x0037:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to convert permission to AppOps field name. "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.PermissionUtils.m33572a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m33575b(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1561629405(0xffffffffa2eb6d23, float:-6.381243E-18)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1365911975(0x516a29a7, float:6.2857572E10)
            if (r0 == r1) goto L_0x0020
            r1 = 1831139720(0x6d24f988, float:3.1910754E27)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "android.permission.RECORD_AUDIO"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0043
            if (r0 == r3) goto L_0x0040
            if (r0 == r2) goto L_0x003d
            r0 = 0
            goto L_0x0045
        L_0x003d:
            java.lang.String r0 = "android:system_alert_window"
            goto L_0x0045
        L_0x0040:
            java.lang.String r0 = "android:write_external_storage"
            goto L_0x0045
        L_0x0043:
            java.lang.String r0 = "android:record_audio"
        L_0x0045:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x004c
            return r0
        L_0x004c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to convert permission to AppOps string. "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.PermissionUtils.m33575b(java.lang.String):java.lang.String");
    }

    @Deprecated
    public static boolean checkPermissionsGranted(Context context, String[] strArr) {
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }
}
