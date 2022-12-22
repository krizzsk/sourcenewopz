package com.yanzhenjie.permission.checker;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public final class StandardChecker implements PermissionChecker {

    /* renamed from: a */
    private static final int f56174a = 4;

    public boolean hasPermission(Context context, String... strArr) {
        return hasPermission(context, (List<String>) Arrays.asList(strArr));
    }

    public boolean hasPermission(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        AppOpsManager appOpsManager = null;
        for (String next : list) {
            if (context.checkPermission(next, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(next);
            if (!TextUtils.isEmpty(permissionToOp)) {
                if (appOpsManager == null) {
                    appOpsManager = (AppOpsManager) context.getSystemService("appops");
                }
                int checkOpNoThrow = appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                if (!(checkOpNoThrow == 0 || checkOpNoThrow == 4)) {
                    return false;
                }
            }
        }
        return true;
    }
}
