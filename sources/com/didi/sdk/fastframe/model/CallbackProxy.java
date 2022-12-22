package com.didi.sdk.fastframe.model;

import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class CallbackProxy<T> implements RpcService.Callback<T> {

    /* renamed from: a */
    private RpcService.Callback<T> f35887a;

    public CallbackProxy(RpcService.Callback<T> callback) {
        this.f35887a = callback;
    }

    public void onSuccess(T t) {
        this.f35887a.onSuccess(t);
    }

    public void onFailure(IOException iOException) {
        this.f35887a.onFailure(iOException);
    }
}
