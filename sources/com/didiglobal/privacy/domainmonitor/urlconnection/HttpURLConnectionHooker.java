package com.didiglobal.privacy.domainmonitor.urlconnection;

import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.privacy.domainmonitor.NetworkMonitor;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionHooker {
    private static final String TAG = "HttpURLConnectionHooker";

    public static HttpURLConnection wrapConnection(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        URLConnection proxy = UrlConnectionHooker.proxy(httpURLConnection);
        if (proxy instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) proxy;
            String absoluteUrl = UrlUtil.getAbsoluteUrl(httpURLConnection2);
            if (!NetworkMonitor.isInWhiteList(absoluteUrl)) {
                SystemUtils.log(3, TAG, absoluteUrl + " is not in white list, use hookedHttpURLConnection", (Throwable) null, "com.didiglobal.privacy.domainmonitor.urlconnection.HttpURLConnectionHooker", 41);
                return httpURLConnection2;
            } else if (httpURLConnection2 instanceof HttpsURLConnection) {
                return new MonitorHttpsURLConnection((HttpsURLConnection) httpURLConnection2);
            } else {
                return new MonitorHttpURLConnection(httpURLConnection2);
            }
        } else {
            SystemUtils.log(3, TAG, "unSupported URLConnection scheme type, use original httpURLConnection", (Throwable) null, "com.didiglobal.privacy.domainmonitor.urlconnection.HttpURLConnectionHooker", 45);
            return httpURLConnection;
        }
    }
}
