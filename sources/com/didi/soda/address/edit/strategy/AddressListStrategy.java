package com.didi.soda.address.edit.strategy;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;

public class AddressListStrategy implements IAddressStrategy {
    public ScopeContext mScopeContext;

    public int getPromptScene() {
        return 0;
    }

    public void handleAddressClick(EditAddressModel editAddressModel) {
    }

    public boolean isAddressClickAble() {
        return false;
    }

    AddressListStrategy(ScopeContext scopeContext) {
        this.mScopeContext = scopeContext;
    }

    public void saveAddressSuccess(AddressEntity addressEntity, boolean z) {
        if (z) {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress(addressEntity, true, 1);
        }
        this.mScopeContext.getNavigator().finish();
    }

    public int getBottomHeight() {
        return DisplayUtils.dip2px(GlobalContext.getContext(), 20.0f);
    }
}
