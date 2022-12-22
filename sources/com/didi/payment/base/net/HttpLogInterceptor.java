package com.didi.payment.base.net;

import com.didi.payment.base.net.HttpConstant;
import com.didi.payment.base.tracker.PayTracker;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import java.util.HashMap;

public class HttpLogInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcResponse proceed = rpcChain.proceed(request);
        try {
            m20983a(request, proceed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proceed;
    }

    /* renamed from: a */
    private void m20983a(HttpRpcRequest httpRpcRequest, HttpRpcResponse httpRpcResponse) {
        if (httpRpcRequest != null && httpRpcResponse != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", httpRpcRequest.getUrl());
            hashMap.put("status", Integer.valueOf(httpRpcResponse.getStatus()));
            PayTracker.getTracker().trackEvent(HttpConstant.HttpName.HTTP_LOG_EVENT, hashMap);
        }
    }
}
