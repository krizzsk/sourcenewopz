package com.didi.sdk.webview.image;

public interface ImageCallback {
    void onCancel();

    void onFail();

    void onPermissionFail();

    void onSuccess(String str);

    void onSuccess(String str, String str2, String str3);
}
