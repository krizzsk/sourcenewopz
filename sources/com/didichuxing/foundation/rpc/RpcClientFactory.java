package com.didichuxing.foundation.rpc;

import android.content.Context;

public interface RpcClientFactory {
    String[] getSupportedSchemes();

    boolean isSchemeSupported(String str);

    RpcClient<? extends RpcRequest, ? extends RpcResponse> newRpcClient(Context context);
}
