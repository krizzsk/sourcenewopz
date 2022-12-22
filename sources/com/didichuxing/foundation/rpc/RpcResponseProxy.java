package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.net.http.HttpHeader;
import java.io.IOException;
import java.util.List;

public class RpcResponseProxy<T> {

    /* renamed from: a */
    private final T f47617a;

    /* renamed from: b */
    private final RpcResponse f47618b;

    RpcResponseProxy(RpcResponse rpcResponse) throws IOException {
        this.f47617a = rpcResponse.getContent();
        this.f47618b = rpcResponse;
    }

    public RpcRequest getRequest() {
        return this.f47618b.getRequest();
    }

    public T getContent() {
        return this.f47617a;
    }

    public RpcProtocol getProtocol() {
        return this.f47618b.getProtocol();
    }

    public int getStatus() {
        return this.f47618b.getStatus();
    }

    public boolean isSuccessful() {
        return this.f47618b.isSuccessful();
    }

    public List<HttpHeader> getHeaders() {
        return this.f47618b.getHeaders();
    }
}
