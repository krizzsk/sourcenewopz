package com.didi.soda.home.component.titlebar;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.component.titlebar.Contract;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class HomeTitleBarPresenter extends Contract.AbsTitleBarPresenter {
    public void onAvatarClick() {
    }

    public void onAddressClick() {
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 2).open();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddress(getScopeContext(), new Action1<AddressEntity>() {
            public void call(AddressEntity addressEntity) {
                if (AddressUtil.checkAddressValid(addressEntity)) {
                    ((Contract.AbsTitleBarView) HomeTitleBarPresenter.this.getLogicView()).updateAddress(addressEntity.poi.displayName);
                } else {
                    ((Contract.AbsTitleBarView) HomeTitleBarPresenter.this.getLogicView()).updateAddress(ResourceHelper.getString(R.string.customer_address_load_none));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
