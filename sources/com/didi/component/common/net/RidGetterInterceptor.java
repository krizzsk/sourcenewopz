package com.didi.component.common.net;

import android.text.TextUtils;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcNetworkInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import didihttp.internal.trace.IdGenrator;
import java.io.IOException;
import java.net.InetAddress;

@ServiceProvider({RpcInterceptor.class})
public class RidGetterInterceptor implements RpcNetworkInterceptor<HttpRpcRequest, HttpRpcResponse> {
    static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        if (request == null || request.getUrl() == null || !TextUtils.isEmpty(request.getHeader("didi-header-rid"))) {
            threadLocal.set(rpcChain.getRequest().getHeader("didi-header-rid"));
        } else {
            HttpRpcRequest.Builder newBuilder = rpcChain.getRequest().newBuilder();
            String generate = IdGenrator.generate((InetAddress) null);
            newBuilder.addHeader("didi-header-rid", generate);
            request = newBuilder.build();
            threadLocal.set(generate);
        }
        return rpcChain.proceed(request);
    }
}
