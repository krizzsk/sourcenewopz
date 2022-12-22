package com.didi.soda.business.manager;

import com.didi.soda.business.component.search.helper.SearchMenuPageInfo;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;

public class BusinessSearchMenuTask extends CustomerAsyncTask<BusinessSearchResultEntity> {

    /* renamed from: a */
    private static final String f39710a = "BusinessSearchMenuTask";

    /* renamed from: b */
    private CustomerRpcService f39711b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private SearchMenuPageInfo f39712c;

    public BusinessSearchMenuTask(CustomerRpcCallback customerRpcCallback, SearchMenuPageInfo searchMenuPageInfo) {
        super(customerRpcCallback);
        this.f39712c = searchMenuPageInfo;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m29104i(f39710a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m29104i(f39710a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m29104i(f39710a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<BusinessSearchResultEntity> execute() {
        return this.f39711b.getShopSearchMenu(this.f39712c.getShopId(), this.f39712c.mKeyWord, this.f39712c.mKeyWordType, this.f39712c.mRecId, this.f39712c.mTraceCnt, CustomerApolloUtil.getNewBusinessFeedType());
    }
}
