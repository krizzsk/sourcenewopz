package com.didi.soda.home.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.home.topgun.manager.HomeFeedParam;

public class ShopCategoryLandingRepo extends Repo<CustomerResource<HomeEntity>> {

    /* renamed from: a */
    private SerialTaskQueue f42687a = new SerialTaskQueue();

    public void fetchFeed(ScopeContext scopeContext, HomeFeedParam homeFeedParam) {
        final int pageIndex = homeFeedParam.getPageIndex();
        this.f42687a.append(new ShopCateLandingTask(new CRpcCallBackWithTraceId<HomeEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                String str;
                if (sFRpcException.getResult() instanceof CRpcResult) {
                    str = ((CRpcResult) sFRpcException.getResult()).getUrl();
                } else {
                    str = "";
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("url", str);
                }
                bundle.putInt(ParamConst.PAGE_NUMBER, pageIndex);
                bundle.putString(ParamConst.TRACE_ID, "");
                ShopCategoryLandingRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage(), sFRpcException.getResult() != null ? (HomeEntity) sFRpcException.getResult().getData() : null, bundle));
            }

            public void onRpcSuccess(HomeEntity homeEntity, long j, String str) {
                Bundle bundle = new Bundle();
                bundle.putInt(ParamConst.PAGE_NUMBER, pageIndex);
                bundle.putString(ParamConst.TRACE_ID, str);
                ShopCategoryLandingRepo.this.setValue(CustomerResource.success(homeEntity, bundle));
            }
        }, homeFeedParam), SerialTaskQueue.AppendMode.ReplaceStrict);
    }
}
