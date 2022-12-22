package com.didi.entrega.customer.foundation.rpc.task;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcResult;
import com.didi.nova.assembly.serial.Task;

public abstract class CustomerAsyncTask<T> extends Task {

    /* renamed from: a */
    private static final String f20026a = "CustomerAsyncTask";

    /* renamed from: b */
    private CustomerRpcCallback<T> f20027b;

    /* renamed from: c */
    private CRpcResult<T> f20028c;

    /* renamed from: d */
    private Exception f20029d;

    /* access modifiers changed from: protected */
    public abstract CRpcResult<T> execute() throws Exception;

    public void onCancel() {
    }

    public CustomerAsyncTask(CustomerRpcCallback<T> customerRpcCallback) {
        this.f20027b = customerRpcCallback;
    }

    public void onMainThread() {
        CustomerRpcCallback<T> customerRpcCallback = this.f20027b;
        if (customerRpcCallback != null) {
            CRpcResult<T> cRpcResult = this.f20028c;
            if (cRpcResult != null) {
                customerRpcCallback.onSuccess((SFRpcResult<T>) cRpcResult);
                return;
            }
            this.f20027b.onRpcFailure(new SFRpcException((Throwable) this.f20029d));
        }
    }

    public void onWorkThread() {
        try {
            CRpcResult<T> execute = execute();
            this.f20028c = execute;
            LogUtil.m14765i(f20026a, execute.toString());
        } catch (Exception e) {
            this.f20029d = e;
            LogUtil.m14765i(f20026a, e.toString());
        }
    }
}
