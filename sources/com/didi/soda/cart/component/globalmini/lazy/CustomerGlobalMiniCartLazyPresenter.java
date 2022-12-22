package com.didi.soda.cart.component.globalmini.lazy;

import android.view.View;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.cart.component.globalmini.lazy.Contract;
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

public class CustomerGlobalMiniCartLazyPresenter extends Contract.AbsGlobalMiniCartPresenter {

    /* renamed from: a */
    private static final String f39984a = "CustomerGlobalMiniCartPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Boolean f39985b = false;

    public boolean isCanShow() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        super.onAttach();
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), new Action1<CustomerResource<BillListInfoEntity>>() {
            public void call(CustomerResource<BillListInfoEntity> customerResource) {
                if (customerResource != null) {
                    LogUtil.m29104i(CustomerGlobalMiniCartLazyPresenter.f39984a, "CustomerResource<BillListInfoEntity> resource = " + customerResource.toString());
                }
                if (!LoginUtil.isLogin() || customerResource == null || customerResource.status != Resource.Status.SUCCESS || customerResource.data == null || ((BillListInfoEntity) customerResource.data).getBills() == null || ((BillListInfoEntity) customerResource.data).getBills().size() <= 0) {
                    ((Contract.AbsGlobalMiniCartView) CustomerGlobalMiniCartLazyPresenter.this.getLogicView()).hide();
                    return;
                }
                ((Contract.AbsGlobalMiniCartView) CustomerGlobalMiniCartLazyPresenter.this.getLogicView()).show();
                if (CustomerGlobalMiniCartLazyPresenter.this.f39985b.booleanValue()) {
                    OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_HOME_GUIDE_SW).build().track();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsGlobalMiniCartView) getLogicView()).setOnClickListener(C13532xd78d0893.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m28502a(View view) {
        DiRouter.request().path(RoutePath.GLOBAL_CART).open();
        OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_HOME_GUIDE_CK).build().track();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f39985b = true;
        Boolean valueOf = Boolean.valueOf(((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).needRefreshGlobalCartList());
        LogUtil.m29104i(f39984a, "needRefreshGlobalCartList = " + valueOf);
        if (valueOf.booleanValue()) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchGlobalCartList((CustomerRpcCallback<BillListInfoEntity>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f39985b = false;
    }
}
