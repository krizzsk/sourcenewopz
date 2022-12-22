package com.didi.unifiedPay.sdk.internal;

import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;

public interface PayServiceResponseCallback<T> extends PayServiceCallback<T> {
    void setResponse(HttpRpcResponse httpRpcResponse);
}
