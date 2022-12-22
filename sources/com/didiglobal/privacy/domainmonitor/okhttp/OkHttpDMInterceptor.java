package com.didiglobal.privacy.domainmonitor.okhttp;

import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.interceptor.UrlInterceptorManager;
import com.didiglobal.privacy.domainmonitor.model.OmegaReportParams;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpDMInterceptor implements Interceptor {
    private static final String TAG = "DomainMonitor_OkHttpDMInterceptor";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String httpUrl = request.url().toString();
        UrlInterceptorManager.dispatchUrl(new OmegaReportParams(UrlUtil.getAbsoluteUrl(httpUrl), request.url().host(), UrlUtil.getRequestSources(httpUrl), request.header("didi-header-rid")));
        if (DomainMonitor.isRedirect()) {
            String replaceUrl = UrlUtil.replaceUrl(request.url());
            if (!replaceUrl.isEmpty()) {
                request = redirectUrl(request, replaceUrl);
            }
        }
        return chain.proceed(request);
    }

    private Request redirectUrl(Request request, String str) {
        return request.newBuilder().url(str).build();
    }
}
