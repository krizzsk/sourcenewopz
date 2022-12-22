package com.didiglobal.privacy.domainmonitor.RPC;

import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.interceptor.UrlInterceptorManager;
import com.didiglobal.privacy.domainmonitor.model.OmegaReportParams;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@ServiceProvider(priority = Integer.MAX_VALUE, value = {RpcInterceptor.class})
public class DomainMonitorInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        String str;
        HttpRpcRequest request = rpcChain.getRequest();
        String url = request.getUrl();
        URL url2 = new URL(url);
        if (DomainMonitor.isMonitor()) {
            if (request.getEntity() == null || !url.contains("ability")) {
                str = "";
            } else {
                InputStream content = request.getEntity().getContent();
                str = UrlUtil.getBFFAbilityName(content);
                content.close();
            }
            String requestSources = UrlUtil.getRequestSources(url);
            String traceId = UrlUtil.getTraceId(request);
            UrlInterceptorManager.dispatchUrl(new OmegaReportParams(UrlUtil.getAbsoluteUrl(url), url2.getHost(), requestSources, traceId, str, "OKNet"));
        }
        if (DomainMonitor.isRedirect()) {
            String replaceUrl = UrlUtil.replaceUrl(url2);
            if (!replaceUrl.isEmpty()) {
                request = request.newBuilder().setUrl(replaceUrl).build();
            }
        }
        return rpcChain.proceed(request);
    }
}
