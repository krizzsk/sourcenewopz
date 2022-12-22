package com.didi.soda.address.edit.strategy;

import android.os.Bundle;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.address.page.SelectAddressPage;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class CartAddressStrategy implements IAddressStrategy {
    public ScopeContext mScopeContext;

    public boolean isAddressClickAble() {
        return true;
    }

    CartAddressStrategy(ScopeContext scopeContext) {
        this.mScopeContext = scopeContext;
    }

    public void handleAddressClick(EditAddressModel editAddressModel) {
        AddressOmegaHelper.clickEditPoi(editAddressModel.isValid() ? editAddressModel.getPoiId() : "");
        Bundle bundle = new Bundle();
        bundle.putSerializable("entity", editAddressModel.getOriginAddressEntity());
        bundle.putInt("from", 4);
        bundle.putBoolean("remove_font_page", true);
        this.mScopeContext.getNavigator().pushForResult((SelectAddressPage) PageFactory.newInstance(SelectAddressPage.class, bundle));
    }

    public void saveAddressSuccess(AddressEntity addressEntity, boolean z) {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressEntity, 2);
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(addressEntity);
        this.mScopeContext.getNavigator().finish();
    }

    public int getBottomHeight() {
        return DisplayUtils.dip2px(GlobalContext.getContext(), 215.5f);
    }

    public int getPromptScene() {
        Bundle bundle = this.mScopeContext.getBundle();
        if (StringUtils.isEmpty(bundle.getSerializable(Const.PageParams.ADDRESS_ENTITY) instanceof AddressEntity ? ((AddressEntity) bundle.getSerializable(Const.PageParams.ADDRESS_ENTITY)).aid : null)) {
            return 2;
        }
        return (!(bundle.getSerializable(Const.PageParams.REC_ADDRESS_ENTITY) != null) || bundle.getInt(Const.PageParams.ADDRESS_STRATEGY) == 3) ? 0 : 1;
    }
}
