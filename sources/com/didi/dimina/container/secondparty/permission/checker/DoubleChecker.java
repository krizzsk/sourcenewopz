package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import java.util.List;

public final class DoubleChecker implements PermissionChecker {

    /* renamed from: a */
    private static final PermissionChecker f17349a = new StandardChecker();

    public boolean hasPermission(Context context, String... strArr) {
        return f17349a.hasPermission(context, strArr);
    }

    public boolean hasPermission(Context context, List<String> list) {
        return f17349a.hasPermission(context, list);
    }
}
