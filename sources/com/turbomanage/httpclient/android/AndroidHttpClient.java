package com.turbomanage.httpclient.android;

import android.os.Build;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.turbomanage.httpclient.AsyncHttpClient;
import com.turbomanage.httpclient.RequestHandler;

public class AndroidHttpClient extends AsyncHttpClient {
    static {
        disableConnectionReuseIfNecessary();
        try {
            if (Build.VERSION.SDK_INT > 8) {
                ensureCookieManager();
            }
        } catch (Throwable unused) {
        }
    }

    public AndroidHttpClient() {
        this("");
    }

    public AndroidHttpClient(String str) {
        super(new AsyncTaskFactory(), str);
    }

    public AndroidHttpClient(String str, RequestHandler requestHandler) {
        super(new AsyncTaskFactory(), str, requestHandler);
    }

    private static void disableConnectionReuseIfNecessary() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", SDKConsts.BOOLEAN_FALSE);
        }
    }
}
