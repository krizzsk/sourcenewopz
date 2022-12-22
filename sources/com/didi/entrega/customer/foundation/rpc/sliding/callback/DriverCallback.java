package com.didi.entrega.customer.foundation.rpc.sliding.callback;

import com.didi.entrega.customer.foundation.rpc.sliding.entity.BaseObjectEntity;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public abstract class DriverCallback<T extends BaseObjectEntity> implements RpcService.Callback<String> {
    T mObject;

    public void onFailure(IOException iOException) {
    }

    public abstract void onSuccess(T t);

    public DriverCallback(T t) {
        this.mObject = t;
    }

    public final void onSuccess(String str) {
        this.mObject.parse(str);
        onSuccess(this.mObject);
    }
}
