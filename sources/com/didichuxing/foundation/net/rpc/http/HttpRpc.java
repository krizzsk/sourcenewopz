package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.rpc.Rpc;

public interface HttpRpc extends Rpc<HttpRpcRequest, HttpRpcResponse> {

    public interface Callback extends Rpc.Callback<HttpRpcRequest, HttpRpcResponse> {
    }

    Object enqueue(Callback callback);

    HttpRpcRequest getRequest();
}
