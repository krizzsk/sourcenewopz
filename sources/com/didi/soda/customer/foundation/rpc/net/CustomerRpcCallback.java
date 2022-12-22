package com.didi.soda.customer.foundation.rpc.net;

import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.foundation.rpc.RpcErrorConsumer;
import com.didi.soda.customer.foundation.util.ErrorHandleUtil;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.lang.ref.WeakReference;

public abstract class CustomerRpcCallback<T> implements RpcService.Callback<SFRpcResult<T>> {
    private static final String TAG = "CustomerRpcCallback";
    private WeakReference<RpcErrorConsumer> mRpcErrorConsumerWr;

    public abstract void onRpcSuccess(T t, long j);

    public CustomerRpcCallback() {
    }

    public CustomerRpcCallback(RpcErrorConsumer rpcErrorConsumer) {
        this.mRpcErrorConsumerWr = new WeakReference<>(rpcErrorConsumer);
    }

    public void onFailure(IOException iOException) {
        onRpcFailure(new SFRpcException((Throwable) iOException));
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        RpcErrorConsumer rpcErrorConsumer;
        if (sFRpcException != null) {
            RecordTracker.Builder.create().setTag(TAG).setLogModule("m-net-fail|").setMessage(sFRpcException.getOriginalMessage()).setLogCategory("c-data|").build().info();
        }
        WeakReference<RpcErrorConsumer> weakReference = this.mRpcErrorConsumerWr;
        if (weakReference == null || ((rpcErrorConsumer = (RpcErrorConsumer) weakReference.get()) != null && !rpcErrorConsumer.doConsumeRpcError(sFRpcException))) {
            ErrorHandleUtil.setError(sFRpcException);
        }
    }

    public void onSuccess(SFRpcResult<T> sFRpcResult) {
        if (sFRpcResult.getCode() == 0) {
            Clock.updateServiceTime(sFRpcResult.getServiceTime());
            onRpcSuccess(sFRpcResult.getData(), sFRpcResult.getServiceTime());
            return;
        }
        onRpcFailure(new SFRpcException((SFRpcResult) sFRpcResult));
    }
}
