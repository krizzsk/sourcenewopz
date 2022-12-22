package com.didi.foundation.sdk.net;

import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public abstract class SFRpcCallback<T> implements RpcService.Callback<SFRpcResult<T>> {
    public abstract void onRpcFailure(SFRpcException sFRpcException);

    public abstract void onRpcSuccess(T t, long j);

    public void onSuccess(SFRpcResult<T> sFRpcResult) {
        if (sFRpcResult.getCode() == 0) {
            try {
                onRpcSuccess(sFRpcResult.getData(), sFRpcResult.getServiceTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            onRpcFailure(new SFRpcException((SFRpcResult) sFRpcResult));
        }
    }

    public void onFailure(IOException iOException) {
        onRpcFailure(new SFRpcException((Throwable) iOException));
    }
}
