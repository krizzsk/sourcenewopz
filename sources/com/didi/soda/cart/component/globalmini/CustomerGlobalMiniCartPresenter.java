package com.didi.soda.cart.component.globalmini;

import android.view.View;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.cart.component.globalmini.Contract;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.router.DiRouter;

public class CustomerGlobalMiniCartPresenter extends Contract.AbsGlobalMiniCartPresenter {

    /* renamed from: a */
    private static final String f39972a = "CustomerGlobalMiniCartPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Boolean f39973b = false;

    public boolean isCanShow() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), new Action1<CustomerResource<BillListInfoEntity>>() {
            public void call(CustomerResource<BillListInfoEntity> customerResource) {
                if (customerResource != null) {
                    LogUtil.m29104i(CustomerGlobalMiniCartPresenter.f39972a, "CustomerResource<BillListInfoEntity> resource = " + customerResource.toString());
                }
                if (!LoginUtil.isLogin() || customerResource == null || customerResource.status != Resource.Status.SUCCESS || customerResource.data == null || ((BillListInfoEntity) customerResource.data).getBills() == null || ((BillListInfoEntity) customerResource.data).getBills().size() <= 0) {
                    ((Contract.AbsGlobalMiniCartView) CustomerGlobalMiniCartPresenter.this.getLogicView()).hide();
                    return;
                }
                ((Contract.AbsGlobalMiniCartView) CustomerGlobalMiniCartPresenter.this.getLogicView()).show();
                if (CustomerGlobalMiniCartPresenter.this.f39973b.booleanValue()) {
                    OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_HOME_GUIDE_SW).build().track();
                }
            }
        });
        ((Contract.AbsGlobalMiniCartView) getLogicView()).setOnClickListener(C13529xe4dcad18.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m28499a(View view) {
        DiRouter.request().path(RoutePath.GLOBAL_CART).open();
        OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_HOME_GUIDE_CK).build().track();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f39973b = true;
        Boolean valueOf = Boolean.valueOf(((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).needRefreshGlobalCartList());
        LogUtil.m29104i(f39972a, "needRefreshGlobalCartList = " + valueOf);
        if (valueOf.booleanValue()) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchGlobalCartList((CustomerRpcCallback<BillListInfoEntity>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f39973b = false;
    }
}
