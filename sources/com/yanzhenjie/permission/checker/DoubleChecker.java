package com.yanzhenjie.permission.checker;

import android.content.Context;
import java.util.List;

public final class DoubleChecker implements PermissionChecker {

    /* renamed from: a */
    private static final PermissionChecker f56172a = new StandardChecker();

    /* renamed from: b */
    private static final PermissionChecker f56173b = new StrictChecker();

    public boolean hasPermission(Context context, String... strArr) {
        return f56173b.hasPermission(context, strArr) && f56172a.hasPermission(context, strArr);
    }

    public boolean hasPermission(Context context, List<String> list) {
        return f56173b.hasPermission(context, list) && f56172a.hasPermission(context, list);
    }
}
