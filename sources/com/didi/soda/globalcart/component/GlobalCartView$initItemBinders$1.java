package com.didi.soda.globalcart.component;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.globalcart.binder.GlobalCartItemBinder;
import com.didi.soda.globalcart.component.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J1\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, mo175978d2 = {"com/didi/soda/globalcart/component/GlobalCartView$initItemBinders$1", "Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder;", "onCartItemCheckoutClick", "", "shopId", "", "cartId", "onCartItemRemoveClick", "onCartItemShopClick", "businessType", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartView.kt */
public final class GlobalCartView$initItemBinders$1 extends GlobalCartItemBinder {
    final /* synthetic */ GlobalCartView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCartView$initItemBinders$1(GlobalCartView globalCartView, ScopeContext scopeContext, ItemDecorator itemDecorator) {
        super(scopeContext, itemDecorator);
        this.this$0 = globalCartView;
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
    }

    public void onCartItemRemoveClick(String str) {
        Intrinsics.checkNotNullParameter(str, Const.BundleKey.CART_ID);
        ((Contract.AbsGlobalCartPresenter) this.this$0.getPresenter()).onCartItemRemoveClick(str);
    }

    public void onCartItemShopClick(String str, String str2, Integer num, String str3) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        ((Contract.AbsGlobalCartPresenter) this.this$0.getPresenter()).onCartItemShopClick(str, str2, num, str3);
    }

    public void onCartItemCheckoutClick(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        ((Contract.AbsGlobalCartPresenter) this.this$0.getPresenter()).onCartItemCheckoutClick(str, str2);
    }
}
