package com.didi.permission;

public interface OnPermissionCallback {
    void onPermissionDenied(String str, int i, boolean z);

    void onPermissionGranted(int i);
}
