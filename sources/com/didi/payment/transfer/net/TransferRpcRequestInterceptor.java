package com.didi.payment.transfer.net;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;

public class TransferRpcRequestInterceptor extends RequestMonitorInterceptor {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain rpcChain) throws IOException {
        return super.intercept((RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse>) rpcChain);
    }
}
