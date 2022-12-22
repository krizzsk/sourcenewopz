package com.didi.dimina.container.bridge.permission;

public interface SinglePermissionCallBack {
    void onDenied(String str);

    void onGranted(String str);
}
