package com.didiglobal.dittoview.callback;

public interface CDNCallback {
    void onCDNCached();

    void onCDNCachedFailed(String str);
}
