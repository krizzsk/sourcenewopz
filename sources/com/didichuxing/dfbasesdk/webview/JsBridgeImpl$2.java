package com.didichuxing.dfbasesdk.webview;

import android.webkit.ValueCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;

class JsBridgeImpl$2 implements ValueCallback<String> {
    JsBridgeImpl$2() {
    }

    public void onReceiveValue(String str) {
        LogUtils.m33564d("Webview", "onReceive js Value, value====" + str);
    }
}
