package com.sdk.poibase;

import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public abstract class ResultCallback<T> implements RpcService.Callback<T> {
    public abstract void failure(IOException iOException);

    public abstract void success(T t);

    public void onSuccess(T t) {
        success(t);
    }

    public void onFailure(IOException iOException) {
        failure(iOException);
    }
}
