package com.didi.soda.address.edit.strategy;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.address.edit.EditAddressInfoPageKt;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class AddressSearchStrategy implements IAddressStrategy {

    /* renamed from: a */
    private boolean f38773a;
    public ScopeContext mScopeContext;

    public int getPromptScene() {
        return 0;
    }

    public void handleAddressClick(EditAddressModel editAddressModel) {
    }

    public boolean isAddressClickAble() {
        return false;
    }

    AddressSearchStrategy(ScopeContext scopeContext, boolean z) {
        this.mScopeContext = scopeContext;
        this.f38773a = z;
    }

    public void saveAddressSuccess(AddressEntity addressEntity, boolean z) {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressEntity, this.f38773a ? 9 : 1);
        if (!EditAddressInfoPageKt.needInterceptPopRoot(this.mScopeContext)) {
            this.mScopeContext.getNavigator().popToRoot();
        }
    }

    public int getBottomHeight() {
        return DisplayUtils.dip2px(GlobalContext.getContext(), 20.0f);
    }
}
