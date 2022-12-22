package com.didi.soda.cart.component;

import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartPresenter.kt */
final class CustomerFloatingCartPresenter$addSku$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CartTyingItemModel $cartItemModel;
    final /* synthetic */ CustomerFloatingCartPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerFloatingCartPresenter$addSku$1(CartTyingItemModel cartTyingItemModel, CustomerFloatingCartPresenter customerFloatingCartPresenter) {
        super(0);
        this.$cartItemModel = cartTyingItemModel;
        this.this$0 = customerFloatingCartPresenter;
    }

    public final void invoke() {
        String cartId;
        List arrayList = new ArrayList();
        ItemNodeEntity node = this.$cartItemModel.getNode();
        ItemNodeEntity copy = node == null ? null : node.copy();
        if (copy != null) {
            copy.amount = 1;
        }
        if (copy != null) {
            arrayList.add(copy);
        }
        String shopId = this.$cartItemModel.getShopId();
        String itemId = this.$cartItemModel.getItemId();
        String itemUniqKey = this.$cartItemModel.getItemUniqKey();
        CartInfoModel access$getCartInfoModel$p = this.this$0.f39901c;
        String str = "";
        if (!(access$getCartInfoModel$p == null || (cartId = access$getCartInfoModel$p.getCartId()) == null)) {
            str = cartId;
        }
        SetItemParams setItemParams = new SetItemParams(shopId, itemId, itemUniqKey, false, 1, arrayList, str, (String) null, 0, String.valueOf(this.this$0.f39900b), this.this$0.f39909k, ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getActInfo(), 1);
        setItemParams.setCallback(new CustomerRpcCallback<CartInfoEntity>() {
            public void onRpcSuccess(CartInfoEntity cartInfoEntity, long j) {
                if (cartInfoEntity == null) {
                }
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                Intrinsics.checkNotNullParameter(sFRpcException, "ex");
                super.onRpcFailure(sFRpcException);
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
    }
}
