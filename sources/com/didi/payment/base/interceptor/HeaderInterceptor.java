package com.didi.payment.base.interceptor;

import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HeaderInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HashMap<String, String> httpHeaders = PayBaseParamUtil.getHttpHeaders();
        if (httpHeaders != null && !httpHeaders.isEmpty()) {
            HttpRpcRequest.Builder newBuilder = request.newBuilder();
            for (Map.Entry next : httpHeaders.entrySet()) {
                newBuilder.addHeader((String) next.getKey(), (String) next.getValue());
            }
            request = newBuilder.build();
        }
        return rpcChain.proceed(request);
    }
}
