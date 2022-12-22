package com.didiglobal.privacy.domainmonitor.urlconnection;

import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.interceptor.UrlInterceptorManager;
import com.didiglobal.privacy.domainmonitor.model.OmegaReportParams;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionHooker {
    private static final String TAG = "DomainMonitor_UrlConnectionHooker";

    public static URLConnection proxy(URLConnection uRLConnection) {
        try {
            URL url = uRLConnection.getURL();
            if (DomainMonitor.isMonitor()) {
                UrlInterceptorManager.dispatchUrl(new OmegaReportParams(UrlUtil.getAbsoluteUrl(url.toString()), url.getHost(), UrlUtil.getRequestSources(url.toString())));
            }
            if (DomainMonitor.isRedirect()) {
                String replaceUrl = UrlUtil.replaceUrl(url);
                if (!replaceUrl.isEmpty()) {
                    return new URL(replaceUrl).openConnection();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uRLConnection;
    }
}
