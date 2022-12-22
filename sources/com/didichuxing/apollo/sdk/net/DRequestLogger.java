package com.didichuxing.apollo.sdk.net;

import com.didichuxing.apollo.sdk.log.LogUtils;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.RequestLogger;
import java.io.IOException;
import java.net.HttpURLConnection;

public class DRequestLogger implements RequestLogger {
    public boolean isLoggingEnabled() {
        return true;
    }

    public void logRequest(HttpURLConnection httpURLConnection, Object obj) throws IOException {
    }

    public void logResponse(HttpResponse httpResponse) {
    }

    public void log(String str) {
        LogUtils.m32691d("apollo_net", str);
    }
}
