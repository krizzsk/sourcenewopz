package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;

class RpcServiceProxy$4 implements RpcInterceptor<RpcRequest, RpcResponse> {
    final /* synthetic */ C15585c this$0;
    final /* synthetic */ int val$max;

    RpcServiceProxy$4(C15585c cVar, int i) {
        this.this$0 = cVar;
        this.val$max = i;
    }

    public RpcResponse intercept(RpcInterceptor.RpcChain<RpcRequest, RpcResponse> rpcChain) throws IOException {
        RpcRequest request = rpcChain.getRequest();
        RpcResponse proceed = rpcChain.proceed(request);
        int i = 0;
        while (!proceed.isSuccessful() && i < this.val$max) {
            proceed = rpcChain.proceed(request);
            i++;
        }
        return proceed;
    }
}
