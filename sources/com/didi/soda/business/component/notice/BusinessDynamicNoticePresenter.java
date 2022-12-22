package com.didi.soda.business.component.notice;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.business.component.notice.Contract;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.repo.CustomerResource;

public class BusinessDynamicNoticePresenter extends Contract.IDynamicNoticePresenter {

    /* renamed from: a */
    private BusinessOmegaHelper f39622a;

    /* renamed from: b */
    private String f39623b;

    /* renamed from: c */
    private int f39624c;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        BusinessRepo.get(getScopeContext()).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessDynamicNoticePresenter.this.m28187a((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28187a(CustomerResource customerResource) {
        if (customerResource == null || customerResource.status != Resource.Status.SUCCESS || customerResource.data == null || ((BusinessEntity) customerResource.data).alertInfo == null || TextUtils.isEmpty(((BusinessEntity) customerResource.data).alertInfo.content)) {
            ((Contract.IDynamicNoticeView) getLogicView()).updateView((String) null);
            return;
        }
        ((Contract.IDynamicNoticeView) getLogicView()).updateView(((BusinessEntity) customerResource.data).alertInfo.content);
        this.f39623b = ((BusinessEntity) customerResource.data).shopInfo.shopId;
        this.f39624c = ((BusinessEntity) customerResource.data).shopInfo.cShopStatus;
        if (((BusinessEntity) customerResource.data).shopInfo.isDeliveryPriceAdjusted == 1) {
            m28186a().onDemandMessageShow(2);
        } else {
            m28186a().onDemandMessageShow(1);
        }
    }

    /* renamed from: a */
    private BusinessOmegaHelper m28186a() {
        if (this.f39622a == null) {
            this.f39622a = new BusinessOmegaHelper(getScopeContext(), this.f39623b, this.f39624c);
        }
        return this.f39622a;
    }
}
