package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;

public interface RpcNetworkInterceptor<Request extends RpcRequest, Response extends RpcResponse> extends RpcInterceptor<Request, Response> {
}
