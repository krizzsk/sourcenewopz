package com.didi.soda.customer.foundation.rpc;

import com.didichuxing.foundation.rpc.RpcService;

public abstract class BaseRpcManager<T extends RpcService> {
    /* access modifiers changed from: protected */
    public abstract T getRpcService();
}
