package com.didi.sdk.util.permission;

public interface PermissionCallback {
    void onPermissionGranted();

    void onPermissionReject(String str);
}
