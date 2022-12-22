package com.didi.soda.address.component.search;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.address.SearchPoiEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;

public class SearchAddressTask extends CustomerAsyncTask<SearchPoiEntity> {

    /* renamed from: a */
    private static final String f38687a = "SearchAddressTask";

    /* renamed from: b */
    private CustomerRpcService f38688b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private String f38689c;

    public SearchAddressTask(CustomerRpcCallback customerRpcCallback, String str) {
        super(customerRpcCallback);
        this.f38689c = str;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m29104i(f38687a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m29104i(f38687a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m29104i(f38687a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<SearchPoiEntity> execute() {
        return this.f38688b.getTextSearch(this.f38689c);
    }
}
