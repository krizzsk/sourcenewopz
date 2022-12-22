package com.didi.soda.customer.foundation.rpc.task;

import com.didi.nova.assembly.serial.Task;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.SFRpcResult;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public abstract class CustomerAsyncTask<T> extends Task {

    /* renamed from: a */
    private static final String f41062a = "CustomerAsyncTask";

    /* renamed from: b */
    private RpcService.Callback<SFRpcResult<T>> f41063b;

    /* renamed from: c */
    private CRpcResult<T> f41064c;

    /* renamed from: d */
    private Exception f41065d;

    /* access modifiers changed from: protected */
    public abstract CRpcResult<T> execute() throws Exception;

    public void onCancel() {
    }

    public CustomerAsyncTask(RpcService.Callback<SFRpcResult<T>> callback) {
        this.f41063b = callback;
    }

    public void onMainThread() {
        RpcService.Callback<SFRpcResult<T>> callback = this.f41063b;
        if (callback != null) {
            CRpcResult<T> cRpcResult = this.f41064c;
            if (cRpcResult != null) {
                callback.onSuccess(cRpcResult);
                return;
            }
            this.f41063b.onFailure(new IOException(this.f41065d));
        }
    }

    public void onWorkThread() {
        try {
            CRpcResult<T> execute = execute();
            this.f41064c = execute;
            LogUtil.m29104i(f41062a, execute.toString());
        } catch (Exception e) {
            this.f41065d = e;
            LogUtil.m29104i(f41062a, e.toString());
        }
    }
}
