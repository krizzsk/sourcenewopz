package com.didichuxing.dfbasesdk.http;

import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;

public class BizAccessInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public static final String WSG_NOT_COLLECT_WSGENV = "not-collect-wsgenv";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        return rpcChain.proceed(m33432a(rpcChain.getRequest()));
    }

    /* renamed from: a */
    private HttpRpcRequest m33432a(HttpRpcRequest httpRpcRequest) {
        try {
            HttpRpcRequest.Builder newBuilder = httpRpcRequest.newBuilder();
            newBuilder.removeHeaders(WSG_NOT_COLLECT_WSGENV);
            newBuilder.addHeader(WSG_NOT_COLLECT_WSGENV, "1");
            return newBuilder.build();
        } catch (Throwable unused) {
            return httpRpcRequest;
        }
    }
}
