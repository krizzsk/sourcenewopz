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

public interface ICustomerCartManager extends ICustomerManager {
    void clearGlobalCartItem(String str, CustomerRpcCallback<Object> customerRpcCallback);

    void createCartDataContext(String str);

    IFloatingCartComponent createFloatingCartComponent(ViewGroup viewGroup, String str);

    ICartProvider createGlobalMiniCartComponent(ViewGroup viewGroup);

    void fetchCartInfo(String str);

    void fetchCartInfoForOneMoreOrder(String str, String str2, int i);

    void fetchGlobalCartList(CustomerRpcCallback<BillListInfoEntity> customerRpcCallback);

    LiveData<Object> getLiveData();

    CustomerResource<CartInfoEntity> getValue(String str);

    boolean isGlobalCartListEmpty();

    boolean needRefreshGlobalCartList();

    void releaseCartDataContext(String str);

    void setItem(SetItemParams setItemParams);

    void setItemAmount(SetItemAmountParams setItemAmountParams);

    void setReversion(String str, String str2);

    void setValue(String str, CustomerResource<CartInfoEntity> customerResource);

    Subscription subscribe(ScopeContext scopeContext, Action1<CustomerResource<BillListInfoEntity>> action1);

    Subscription subscribe(ScopeContext scopeContext, String str, Action1<CustomerResource<CartInfoEntity>> action1);

    Subscription subscribe(ScopeContext scopeContext, String str, Action2<CustomerResource<CartInfoEntity>> action2);

    void triggerRefreshGlobalCartList();
}
