package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import java.io.IOException;

public interface RpcInterceptor<Request extends RpcRequest, Response extends RpcResponse> {

    public interface RpcChain<Request, Response> {
        Request getRequest();

        Response proceed(Request request) throws IOException;
    }

    Response intercept(RpcChain<Request, Response> rpcChain) throws IOException;
}
