package com.didi.dimina.container.service;

import android.content.Context;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;

public interface PermissionService {
    boolean hasPermissionOperated(Context context, String str);

    boolean hasPermissions(Context context, String... strArr);

    void openSetting(Context context, int i);

    void requestPermission(Context context, String str, PermissionDescInfo permissionDescInfo, boolean z, SinglePermissionCallBack singlePermissionCallBack);
}
