package com.didi.soda.bill.view.item;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.cart.model.CartTyingItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "scope", "Lcom/didi/app/nova/skeleton/ScopeContext;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TyingItemView.kt */
final class TyingItemView$setData$1$onItemClick$block$1 extends Lambda implements Function1<ScopeContext, Unit> {
    final /* synthetic */ ComponentModel $componentModel;
    final /* synthetic */ CartTyingItemModel $itemModel;
    final /* synthetic */ TyingItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TyingItemView$setData$1$onItemClick$block$1(CartTyingItemModel cartTyingItemModel, TyingItemView tyingItemView, ComponentModel componentModel) {
        super(1);
        this.$itemModel = cartTyingItemModel;
        this.this$0 = tyingItemView;
        this.$componentModel = componentModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScopeContext) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "scope");
        CartTyingItemModel cartTyingItemModel = this.$itemModel;
        if (cartTyingItemModel != null) {
            this.this$0.m27795a(cartTyingItemModel, this.$componentModel.getSource());
        }
    }
}
