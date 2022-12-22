package com.didi.payment.base.view.webview;

public interface PermissionCallback {
    void onPermissionGranted();

    void onPermissionReject(String str);
}
