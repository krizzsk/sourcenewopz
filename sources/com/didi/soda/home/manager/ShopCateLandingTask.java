package com.didi.soda.home.manager;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import com.didi.soda.home.topgun.manager.HomeFeedParam;

public class ShopCateLandingTask extends CustomerAsyncTask<HomeEntity> {

    /* renamed from: a */
    private static final String f42683a = "ShopCateLandingTask";

    /* renamed from: d */
    private static final int f42684d = 20;

    /* renamed from: b */
    private CustomerRpcService f42685b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private HomeFeedParam f42686c;

    public ShopCateLandingTask(CRpcCallBackWithTraceId cRpcCallBackWithTraceId, HomeFeedParam homeFeedParam) {
        super(cRpcCallBackWithTraceId);
        this.f42686c = homeFeedParam;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m29104i(f42683a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m29104i(f42683a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m29104i(f42683a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<HomeEntity> execute() {
        return this.f42685b.getCateIndex(this.f42686c.getFilterParam(), this.f42686c.getCateId(), this.f42686c.getPageIndex(), 20, this.f42686c.getRecId());
    }
}
