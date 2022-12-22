package com.android.didi.safetoolkit.activity.permisstion.callback;

import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import java.util.List;

public interface PermissionCallback {
    void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest);

    void onGranted(List<AuthorizationInfo> list);

    void onRefuse(List<AuthorizationInfo> list);
}
