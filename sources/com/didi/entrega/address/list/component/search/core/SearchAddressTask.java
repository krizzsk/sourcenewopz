package com.didi.entrega.address.list.component.search.core;

import com.didi.entrega.address.list.component.search.model.SearchPoiEntity;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcService;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.task.CustomerAsyncTask;

public class SearchAddressTask extends CustomerAsyncTask<SearchPoiEntity> {

    /* renamed from: a */
    private static final String f19447a = "SearchAddressTask";

    /* renamed from: b */
    private CustomerRpcService f19448b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private String f19449c;

    public SearchAddressTask(CustomerRpcCallback customerRpcCallback, String str) {
        super(customerRpcCallback);
        this.f19449c = str;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m14765i(f19447a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m14765i(f19447a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m14765i(f19447a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<SearchPoiEntity> execute() {
        return this.f19448b.getAddressSearch(this.f19449c);
    }
}
