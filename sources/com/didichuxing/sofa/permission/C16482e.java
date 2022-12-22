package com.didichuxing.sofa.permission;

import android.app.Activity;
import android.app.AppOpsManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

/* renamed from: com.didichuxing.sofa.permission.e */
/* compiled from: PermissionChecker */
final class C16482e {

    /* renamed from: a */
    private static AppOpsManager f49153a;

    /* renamed from: a */
    private static boolean m35438a(int i) {
        return i == 0;
    }

    private C16482e() {
    }

    /* renamed from: a */
    static boolean m35440a(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (C16483f.m35447a(str)) {
                if (!C16483f.m35446a(activity, str)) {
                    return false;
                }
            } else if (!m35439a(activity, str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m35439a(Activity activity, String str) {
        if (!m35438a(ContextCompat.checkSelfPermission(activity, str))) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (f49153a == null) {
                f49153a = (AppOpsManager) activity.getApplicationContext().getSystemService("appops");
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (f49153a == null || TextUtils.isEmpty(permissionToOp) || f49153a.checkOp(permissionToOp, Process.myUid(), activity.getPackageName()) == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: b */
    static boolean m35443b(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (!C16483f.m35447a(str) && ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static String[] m35442a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (!m35438a(iArr[i])) {
                arrayList.add(strArr[i]);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    /* renamed from: a */
    static boolean m35441a(int[] iArr) {
        for (int a : iArr) {
            if (!m35438a(a)) {
                return false;
            }
        }
        return true;
    }
}
