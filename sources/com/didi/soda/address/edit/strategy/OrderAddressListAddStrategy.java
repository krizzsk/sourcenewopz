package com.didi.soda.address.edit.strategy;

import android.os.Bundle;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.address.edit.strategy.IAddressStrategy;
import com.didi.soda.address.page.SelectAddressPage;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/address/edit/strategy/OrderAddressListAddStrategy;", "Lcom/didi/soda/address/edit/strategy/IAddressStrategy;", "mScopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getMScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "getBottomHeight", "", "handleAddressClick", "", "editAddressModel", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "isAddressClickAble", "", "saveAddressSuccess", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "isDeliveryAddress", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderAddressListAddStrategy.kt */
public final class OrderAddressListAddStrategy implements IAddressStrategy {

    /* renamed from: a */
    private final ScopeContext f38775a;

    public boolean isAddressClickAble() {
        return true;
    }

    public OrderAddressListAddStrategy(ScopeContext scopeContext) {
        this.f38775a = scopeContext;
    }

    public final ScopeContext getMScopeContext() {
        return this.f38775a;
    }

    public int getPromptScene() {
        return IAddressStrategy.DefaultImpls.getPromptScene(this);
    }

    public void handleAddressClick(EditAddressModel editAddressModel) {
        AddressEntity addressEntity;
        INavigator navigator;
        Bundle bundle = new Bundle();
        if (editAddressModel == null) {
            addressEntity = null;
        } else {
            addressEntity = editAddressModel.getOriginAddressEntity();
        }
        bundle.putSerializable("entity", addressEntity);
        bundle.putInt("from", 9);
        Page newInstance = PageFactory.newInstance(SelectAddressPage.class, bundle);
        ScopeContext scopeContext = this.f38775a;
        if (scopeContext != null && (navigator = scopeContext.getNavigator()) != null) {
            navigator.pushForResult(newInstance);
        }
    }

    public void saveAddressSuccess(AddressEntity addressEntity, boolean z) {
        INavigator navigator;
        Bundle bundle = new Bundle();
        bundle.putSerializable("entity", addressEntity);
        ScopeContext scopeContext = this.f38775a;
        if (scopeContext != null && (navigator = scopeContext.getNavigator()) != null) {
            navigator.finish(bundle);
        }
    }

    public int getBottomHeight() {
        return DisplayUtils.dip2px(GlobalContext.getContext(), 20.0f);
    }
}
