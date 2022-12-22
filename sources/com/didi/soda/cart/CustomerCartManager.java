package com.didi.soda.cart;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.cart.component.CustomerFloatingCartComponent;
import com.didi.soda.cart.component.globalmini.CustomerGlobalMiniCartComponent;
import com.didi.soda.cart.component.globalmini.lazy.CustomerGlobalMiniCartLazyComponent;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.cart.omega.CartGuideDataManager;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.cart.repo.CustomerCartRepo;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartComponent;
import com.didi.soda.customer.component.provider.ICartProvider;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.globalcart.repo.GlobalCartListRepo;
import com.didi.soda.manager.base.ICustomerCartManager;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerCartManager implements ICustomerCartManager {

    /* renamed from: a */
    private final String f39891a = "CustomerCartManager";

    public String getManagerName() {
        return ErrorConst.ModuleName.CART;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public ICartProvider createGlobalMiniCartComponent(ViewGroup viewGroup) {
        if (FallbackController.isOpenLazyComponent()) {
            return new CustomerGlobalMiniCartLazyComponent(viewGroup);
        }
        return new CustomerGlobalMiniCartComponent(viewGroup);
    }

    public IFloatingCartComponent createFloatingCartComponent(ViewGroup viewGroup, String str) {
        return new CustomerFloatingCartComponent(viewGroup, str);
    }

    public LiveData<Object> getLiveData() {
        return ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).getLiveData();
    }

    public void setReversion(String str, String str2) {
        ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).setReversion(str, str2);
    }

    public CustomerResource<CartInfoEntity> getValue(String str) {
        return ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).getResourceValue(str);
    }

    public void setValue(String str, CustomerResource<CartInfoEntity> customerResource) {
        CustomerCartRepo customerCartRepo = (CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class);
        customerCartRepo.setResourceValue(str, customerResource);
        customerCartRepo.setValue(new Object());
    }

    public Subscription subscribe(ScopeContext scopeContext, String str, Action1<CustomerResource<CartInfoEntity>> action1) {
        CustomerCartRepo customerCartRepo = (CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class);
        return customerCartRepo.getLiveData().from().shutViscidityNotice().subscribe(scopeContext, new Action1(customerCartRepo, str) {
            public final /* synthetic */ CustomerCartRepo f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void call(Object obj) {
                Action1.this.call(this.f$1.getResourceValue(this.f$2));
            }
        });
    }

    public Subscription subscribe(ScopeContext scopeContext, String str, Action2<CustomerResource<CartInfoEntity>> action2) {
        CustomerCartRepo customerCartRepo = (CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class);
        return customerCartRepo.getLiveData().from().shutViscidityNotice().subscribe(scopeContext, new Action2(customerCartRepo, str) {
            public final /* synthetic */ CustomerCartRepo f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void call(Object obj, Subscription subscription) {
                Action2.this.call(this.f$1.getResourceValue(this.f$2), subscription);
            }
        });
    }

    public void setItemAmount(SetItemAmountParams setItemAmountParams) {
        m28449a(setItemAmountParams.getShopId(), setItemAmountParams.getContent().getAmount(), setItemAmountParams.getContent().getMduId(), setItemAmountParams.getItemId(), setItemAmountParams.getItemUniKey());
        ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).setItemsAmount(setItemAmountParams);
    }

    public void setItem(SetItemParams setItemParams) {
        CartGuideDataManager.Companion.getInstance().getCartGuideParams(setItemParams.getShopId(), setItemParams.getItemId());
        m28449a(setItemParams.getShopId(), setItemParams.getAmount(), setItemParams.getMduId(), setItemParams.getItemId(), setItemParams.getItemUniKey());
        ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).setItem(setItemParams);
    }

    /* renamed from: a */
    private void m28449a(String str, int i, String str2, String str3, String str4) {
        String str5 = str;
        int i2 = i;
        String str6 = str4;
        ArrayList<ItemState> value = ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).getValue(str5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!CollectionsUtil.isEmpty(value)) {
            for (ItemState next : value) {
                if (arrayList3.contains(next.itemUniKey) && next.mduType == 1) {
                    arrayList3.remove(next.itemUniKey);
                }
                if (!arrayList3.contains(next.itemUniKey) || next.mduType != 2) {
                    ItemState itemState = new ItemState();
                    itemState.itemId = next.itemId;
                    itemState.itemUniKey = next.itemUniKey;
                    itemState.mduType = next.mduType;
                    itemState.mduId = next.mduId;
                    if (str6 == null || !str6.equals(next.itemUniKey) || next.mduType != 1) {
                        String str7 = str2;
                        itemState.amount = next.amount;
                    } else {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.equals(next.mduId)) {
                                itemState.amount = i2;
                            }
                        } else {
                            String str8 = str2;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            itemState.amount = next.amount + i2;
                        } else {
                            itemState.amount = next.amount;
                        }
                    }
                    LogUtil.m29104i("CustomerCartManager", "setCartItemState  itemStateList itemId= " + itemState.itemId + ",amount = " + itemState.amount);
                    if (itemState.amount == 0 && !arrayList3.contains(itemState.itemUniKey)) {
                        arrayList3.add(itemState.itemUniKey);
                    }
                    arrayList.add(itemState);
                    arrayList2.add(next.itemUniKey);
                } else {
                    ItemState itemState2 = new ItemState();
                    itemState2.itemId = next.itemId;
                    itemState2.itemUniKey = next.itemUniKey;
                    itemState2.mduType = next.mduType;
                    itemState2.mduId = next.mduId;
                    itemState2.amount = 0;
                    arrayList.add(itemState2);
                }
            }
        }
        if (!arrayList2.contains(str6) && i2 > 0) {
            ItemState itemState3 = new ItemState();
            itemState3.itemId = str3;
            itemState3.itemUniKey = str6;
            itemState3.mduType = 1;
            itemState3.amount = i2;
            arrayList.add(itemState3);
            LogUtil.m29104i("CustomerCartManager", "setCartItemState  null itemId= " + itemState3.itemId + ",amount = " + itemState3.amount);
        }
        ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).setState(str5, arrayList);
    }

    public void fetchCartInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).cartInfo(str);
        }
    }

    public void fetchCartInfoForOneMoreOrder(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).cartInfoForOneMoreOrder(str, str2, i);
        }
    }

    public Subscription subscribe(ScopeContext scopeContext, Action1<CustomerResource<BillListInfoEntity>> action1) {
        return ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).from().shutViscidityNotice().subscribe(scopeContext, action1);
    }

    public void fetchGlobalCartList(CustomerRpcCallback<BillListInfoEntity> customerRpcCallback) {
        ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).fetchGlobalCartListInfo(customerRpcCallback);
    }

    public void clearGlobalCartItem(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).clearGlobalCartItem(str, customerRpcCallback);
    }

    public boolean isGlobalCartListEmpty() {
        return ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).isGlobalCartListEmpty();
    }

    public void triggerRefreshGlobalCartList() {
        ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).triggerRefreshGlobalCartList();
    }

    public boolean needRefreshGlobalCartList() {
        return ((GlobalCartListRepo) RepoFactory.getRepo(GlobalCartListRepo.class)).needRefreshGlobalCartList();
    }

    public void createCartDataContext(String str) {
        ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).createCartDataContext(str);
    }

    public void releaseCartDataContext(String str) {
        ((CustomerCartRepo) RepoFactory.getRepo(CustomerCartRepo.class)).releaseCartDataContext(str);
        HashMap hashMap = (HashMap) ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).getValue();
        if (hashMap != null && !hashMap.isEmpty()) {
            hashMap.remove(str);
        }
    }
}
