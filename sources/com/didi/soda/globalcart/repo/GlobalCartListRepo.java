package com.didi.soda.globalcart.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eJ\u0016\u0010\u0010\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/globalcart/repo/GlobalCartListRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/customer/repo/CustomerResource;", "Lcom/didi/soda/globalcart/entity/BillListInfoEntity;", "()V", "mCustomerRpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "needRefreshGlobalCartList", "", "clearGlobalCartItem", "", "cartId", "", "callback", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "", "fetchGlobalCartListInfo", "isGlobalCartListEmpty", "triggerRefreshGlobalCartList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartListRepo.kt */
public final class GlobalCartListRepo extends Repo<CustomerResource<BillListInfoEntity>> {

    /* renamed from: a */
    private CustomerRpcService f42303a;

    /* renamed from: b */
    private boolean f42304b;

    public GlobalCartListRepo() {
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        this.f42303a = customerRpcService;
    }

    public final void fetchGlobalCartListInfo(CustomerRpcCallback<BillListInfoEntity> customerRpcCallback) {
        if (LoginUtil.isLogin()) {
            this.f42303a.fetchGlobalCartListInfo(new GlobalCartListRepo$fetchGlobalCartListInfo$1(this, customerRpcCallback));
            this.f42304b = false;
        }
    }

    public final void clearGlobalCartItem(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        Intrinsics.checkNotNullParameter(str, Const.BundleKey.CART_ID);
        this.f42303a.clearGlobalCartItem(str, customerRpcCallback);
    }

    public final boolean isGlobalCartListEmpty() {
        BillListInfoEntity billListInfoEntity;
        if (getValue() != null) {
            CustomerResource customerResource = (CustomerResource) getValue();
            ArrayList<BillInfoEntity> arrayList = null;
            if ((customerResource == null ? null : (BillListInfoEntity) customerResource.data) != null) {
                CustomerResource customerResource2 = (CustomerResource) getValue();
                if (!(customerResource2 == null || (billListInfoEntity = (BillListInfoEntity) customerResource2.data) == null)) {
                    arrayList = billListInfoEntity.getBills();
                }
                Collection collection = arrayList;
                return collection == null || collection.isEmpty();
            }
        }
    }

    public final void triggerRefreshGlobalCartList() {
        this.f42304b = true;
    }

    public final boolean needRefreshGlobalCartList() {
        return this.f42304b;
    }
}
