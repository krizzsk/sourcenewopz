package com.didi.soda.cart.component;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.cart.binder.CustomerCartMenuBinder;
import com.didi.soda.cart.component.Contract;
import com.didi.soda.cart.model.CartItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/cart/component/CustomerFloatingCartView$initItemBinders$1", "Lcom/didi/soda/cart/binder/CustomerCartMenuBinder;", "toBusinessSkuPage", "", "cartItemModel", "Lcom/didi/soda/cart/model/CartItemModel;", "updateSku", "action", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartView.kt */
public final class CustomerFloatingCartView$initItemBinders$1 extends CustomerCartMenuBinder {
    final /* synthetic */ CustomerFloatingCartView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerFloatingCartView$initItemBinders$1(CustomerFloatingCartView customerFloatingCartView, ScopeContext scopeContext) {
        super(scopeContext);
        this.this$0 = customerFloatingCartView;
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
    }

    public void updateSku(CartItemModel cartItemModel, boolean z) {
        Intrinsics.checkNotNullParameter(cartItemModel, "cartItemModel");
        ((Contract.AbsFloatingCartPresenter) this.this$0.getPresenter()).updateSku(cartItemModel, z);
    }

    public void toBusinessSkuPage(CartItemModel cartItemModel) {
        Intrinsics.checkNotNullParameter(cartItemModel, "cartItemModel");
        ((Contract.AbsFloatingCartPresenter) this.this$0.getPresenter()).toSkuPage(cartItemModel);
    }
}
