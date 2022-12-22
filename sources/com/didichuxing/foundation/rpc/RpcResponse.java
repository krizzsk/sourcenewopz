package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.rpc.RpcMessage;
import java.io.IOException;
import java.util.List;

public interface RpcResponse extends RpcMessage {

    public interface Builder extends RpcMessage.Builder<RpcResponse> {
        RpcResponse build();
    }

    void close() throws IOException;

    <T> T getContent() throws IOException;

    List<HttpHeader> getHeaders();

    RpcProtocol getProtocol();

    RpcRequest getRequest();

    int getStatus();

    boolean isSuccessful();
}
