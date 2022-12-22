package com.android.didi.safetoolkit.activity.permisstion.callback;

import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import java.util.List;

public abstract class SimplePermissionCallback implements PermissionCallback {
    public void onGranted(List<AuthorizationInfo> list) {
    }

    public void onRefuse(List<AuthorizationInfo> list) {
    }
}
