package com.didichuxing.dfbasesdk.algomodel;

import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;

public class AlgoModelConfigInterceptor implements HttpRpcInterceptor {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        int status;
        HttpRpcResponse proceed = rpcChain.proceed(rpcChain.getRequest());
        if (proceed == null || 200 == (status = proceed.getStatus())) {
            return proceed;
        }
        throw new IOException("https response code is " + status);
    }
}
