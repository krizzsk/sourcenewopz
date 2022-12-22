package com.didi.soda.manager.base;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartComponent;
import com.didi.soda.customer.component.provider.ICartProvider;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.globalcart.entity.BillListInfoEntity;

public class ICustomerCartManagerDefault implements ICustomerCartManager {
    public void clearGlobalCartItem(String str, CustomerRpcCallback<Object> customerRpcCallback) {
    }

    public void createCartDataContext(String str) {
    }

    public IFloatingCartComponent createFloatingCartComponent(ViewGroup viewGroup, String str) {
        return null;
    }

    public ICartProvider createGlobalMiniCartComponent(ViewGroup viewGroup) {
        return null;
    }

    public void fetchCartInfo(String str) {
    }

    public void fetchCartInfoForOneMoreOrder(String str, String str2, int i) {
    }

    public void fetchGlobalCartList(CustomerRpcCallback<BillListInfoEntity> customerRpcCallback) {
    }

    public LiveData<Object> getLiveData() {
        return null;
    }

    public String getManagerName() {
        return null;
    }

    public CustomerResource<CartInfoEntity> getValue(String str) {
        return null;
    }

    public boolean isGlobalCartListEmpty() {
        return false;
    }

    public boolean needRefreshGlobalCartList() {
        return false;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void releaseCartDataContext(String str) {
    }

    public void setItem(SetItemParams setItemParams) {
    }

    public void setItemAmount(SetItemAmountParams setItemAmountParams) {
    }

    public void setReversion(String str, String str2) {
    }

    public void setValue(String str, CustomerResource<CartInfoEntity> customerResource) {
    }

    public Subscription subscribe(ScopeContext scopeContext, Action1<CustomerResource<BillListInfoEntity>> action1) {
        return null;
    }

    public Subscription subscribe(ScopeContext scopeContext, String str, Action1<CustomerResource<CartInfoEntity>> action1) {
        return null;
    }

    public Subscription subscribe(ScopeContext scopeContext, String str, Action2<CustomerResource<CartInfoEntity>> action2) {
        return null;
    }

    public void triggerRefreshGlobalCartList() {
    }
}
