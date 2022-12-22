package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.rpc.RpcMessage;
import java.lang.reflect.Method;

public interface RpcRequest extends RpcMessage {

    public interface Builder extends RpcMessage.Builder<RpcRequest> {
        RpcRequest build();

        Builder setRpcClient(RpcClient<? extends RpcRequest, ? extends RpcResponse> rpcClient);

        Builder setRpcService(Class<? extends RpcService> cls, Method method, Object... objArr);

        Builder setTag(Object obj);

        Builder setUrl(String str);
    }

    public interface Parameter {
        String getName();

        Object getValue();
    }

    Object getTag();

    String getUrl();
}
