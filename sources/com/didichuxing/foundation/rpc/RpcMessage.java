package com.didichuxing.foundation.rpc;

public interface RpcMessage {

    public interface Builder<T extends RpcMessage> {
        T build();
    }

    RpcProtocol getProtocol();

    String getUrl();
}
