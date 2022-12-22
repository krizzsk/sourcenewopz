package com.didi.hawaii.utils;

import com.didi.hawaii.log.HWLog;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcNetworkInterceptor;
import java.io.IOException;

public class HawaiiNetRpcInterceptor implements RpcNetworkInterceptor<HttpRpcRequest, HttpRpcResponse> {
    private static RpcNetworkListener mListener;

    public interface RpcNetworkListener {
        void onRequest(HttpRpcRequest httpRpcRequest);
    }

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        String header = request.getHeader("didi-header-rid");
        HWLog.m16761i("hw", "traceId = " + header);
        RpcNetworkListener rpcNetworkListener = mListener;
        if (rpcNetworkListener != null) {
            rpcNetworkListener.onRequest(request);
        }
        return rpcChain.proceed(request);
    }

    public static void setRpcNetworkListener(RpcNetworkListener rpcNetworkListener) {
        mListener = rpcNetworkListener;
    }
}
