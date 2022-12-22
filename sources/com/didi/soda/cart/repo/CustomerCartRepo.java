package com.didi.soda.cart.repo;

import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.cart.manager.task.CartRequestManager;
import com.didi.soda.cart.model.AddCartRequestParamsKt;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020#J\u001e\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0002J\u001c\u0010&\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bJ\u0016\u0010(\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006J\u001e\u0010*\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo175978d2 = {"Lcom/didi/soda/cart/repo/CustomerCartRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "cartContextMap", "", "", "Lcom/didi/soda/cart/repo/CartDataContext;", "mCustomerRpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "cartInfo", "", "shopId", "cartInfoForOneMoreOrder", "orderId", "wineConfirm", "", "createCartDataContext", "getCartDataContext", "getCartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getLiveData", "Lcom/didi/app/nova/skeleton/repo/LiveData;", "getRequestManager", "Lcom/didi/soda/cart/manager/task/CartRequestManager;", "cartId", "getResourceValue", "Lcom/didi/soda/customer/repo/CustomerResource;", "isReleased", "", "releaseCartDataContext", "setItem", "params", "Lcom/didi/soda/cart/model/SetItemParams;", "setItemsAmount", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "setMapValue", "recourse", "setResourceValue", "resource", "setReversion", "reversion", "syncCartItemState", "value", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartRepo.kt */
public final class CustomerCartRepo extends Repo<Object> {

    /* renamed from: a */
    private CustomerRpcService f40097a;

    /* renamed from: b */
    private final Map<String, CartDataContext> f40098b = new LinkedHashMap();

    public CustomerCartRepo() {
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        this.f40097a = customerRpcService;
    }

    public LiveData<Object> getLiveData() {
        LiveData<Object> liveData = super.getLiveData();
        Intrinsics.checkNotNullExpressionValue(liveData, "super.getLiveData()");
        return liveData;
    }

    public final void setReversion(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, "reversion");
        CartDataContext cartDataContext = this.f40098b.get(str);
        if (cartDataContext != null) {
            cartDataContext.setReversion(str2);
        }
    }

    public final CustomerResource<CartInfoEntity> getResourceValue(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        CartDataContext b = m28538b(str);
        if (b.getLoading() == null) {
            return b.getResource();
        }
        return b.getLoading();
    }

    public final void setResourceValue(String str, CustomerResource<CartInfoEntity> customerResource) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(customerResource, "resource");
        m28537a(str, customerResource);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m28537a(String str, CustomerResource<CartInfoEntity> customerResource) {
        CartDataContext b = m28538b(str);
        if (customerResource.status == Resource.Status.LOADING) {
            b.setLoading(customerResource);
        } else {
            b.setResource(customerResource);
            b.setLoading((CustomerResource<CartInfoEntity>) null);
            m28539b(str, customerResource);
        }
        setValue(new Object());
    }

    /* renamed from: b */
    private final void m28539b(String str, CustomerResource<CartInfoEntity> customerResource) {
        Unit unit;
        List<CartItemEntity> items;
        CartInfoEntity cartInfoEntity = (CartInfoEntity) customerResource.data;
        if (cartInfoEntity == null || (items = cartInfoEntity.getItems()) == null) {
            unit = null;
        } else {
            if (!items.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (CartItemEntity next : items) {
                    ItemState itemState = new ItemState();
                    itemState.itemId = next.getItemId();
                    itemState.itemUniKey = next.getItemUniqKey();
                    itemState.amount = next.getAmount();
                    itemState.mduType = next.getMduType();
                    itemState.mduId = next.getMduId();
                    arrayList.add(itemState);
                }
                ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).setState(str, arrayList);
            } else {
                ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).setState(str, (ArrayList<ItemState>) null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CustomerCartRepo customerCartRepo = this;
            ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).setState(str, (ArrayList<ItemState>) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final CartInfoEntity m28536a(String str) {
        CustomerResource<CartInfoEntity> resource;
        CartDataContext cartDataContext = this.f40098b.get(str);
        if (cartDataContext == null || (resource = cartDataContext.getResource()) == null) {
            return null;
        }
        return (CartInfoEntity) resource.data;
    }

    public final void cartInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        CustomerResource loading = CustomerResource.loading();
        Intrinsics.checkNotNullExpressionValue(loading, "loading()");
        m28537a(str, (CustomerResource<CartInfoEntity>) loading);
        this.f40097a.getCartInfo(str, new CustomerCartRepo$cartInfo$1(this, str));
    }

    public final void cartInfoForOneMoreOrder(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, "orderId");
        CustomerResource loading = CustomerResource.loading();
        Intrinsics.checkNotNullExpressionValue(loading, "loading()");
        m28537a(str, (CustomerResource<CartInfoEntity>) loading);
        this.f40097a.getCartInfoForOneMoreOrder(str, str2, i, new CustomerCartRepo$cartInfoForOneMoreOrder$1(this, str));
    }

    public final void setItem(SetItemParams setItemParams) {
        Intrinsics.checkNotNullParameter(setItemParams, "params");
        CartDataContext b = m28538b(setItemParams.getShopId());
        b.getLoadingTrack().addTime(setItemParams.getItemId());
        if (AddCartRequestParamsKt.reversionToLong(b.getReversion()) > AddCartRequestParamsKt.reversionToLong(setItemParams.getRevision())) {
            setItemParams.setRevision(b.getReversion());
        }
        String shopId = setItemParams.getShopId();
        CustomerResource loading = CustomerResource.loading();
        Intrinsics.checkNotNullExpressionValue(loading, "loading()");
        m28537a(shopId, (CustomerResource<CartInfoEntity>) loading);
        m28535a(setItemParams.getShopId(), setItemParams.getCartId()).requestSetItem(setItemParams, this.f40097a);
    }

    public final void setItemsAmount(SetItemAmountParams setItemAmountParams) {
        Intrinsics.checkNotNullParameter(setItemAmountParams, "params");
        CartDataContext b = m28538b(setItemAmountParams.getShopId());
        b.getLoadingTrack().addTime(setItemAmountParams.getItemId());
        if (AddCartRequestParamsKt.reversionToLong(b.getReversion()) > AddCartRequestParamsKt.reversionToLong(setItemAmountParams.getRevision())) {
            setItemAmountParams.setRevision(b.getReversion());
        }
        String shopId = setItemAmountParams.getShopId();
        CustomerResource loading = CustomerResource.loading();
        Intrinsics.checkNotNullExpressionValue(loading, "loading()");
        m28537a(shopId, (CustomerResource<CartInfoEntity>) loading);
        m28535a(setItemAmountParams.getShopId(), setItemAmountParams.getCartId()).requestSetAmountItem(setItemAmountParams, this.f40097a);
    }

    /* renamed from: a */
    private final CartRequestManager m28535a(String str, String str2) {
        return m28538b(str).getCartRequestManager(new CustomerCartRepo$getRequestManager$1(this, str, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final CartDataContext m28538b(String str) {
        Map<String, CartDataContext> map = this.f40098b;
        CartDataContext cartDataContext = map.get(str);
        if (cartDataContext == null) {
            cartDataContext = new CartDataContext();
            map.put(str, cartDataContext);
        }
        return cartDataContext;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final boolean m28540c(String str) {
        return this.f40098b.get(str) == null;
    }

    public final void createCartDataContext(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        LogUtil.m29104i("CustomerCartRepo", "createCartDataContext>>>>> shopId = " + str + "  map = " + this.f40098b);
        CartDataContext cartDataContext = this.f40098b.get(str);
        if (cartDataContext == null) {
            Map<String, CartDataContext> map = this.f40098b;
            CartDataContext cartDataContext2 = new CartDataContext();
            cartDataContext2.retain();
            map.put(str, cartDataContext2);
            return;
        }
        cartDataContext.retain();
    }

    public final void releaseCartDataContext(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        if (m28538b(str).release() <= 0) {
            this.f40098b.remove(str);
        }
    }
}
