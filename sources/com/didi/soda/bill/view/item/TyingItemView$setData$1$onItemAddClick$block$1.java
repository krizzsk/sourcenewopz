package com.didi.soda.bill.view.item;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillAddTyingEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "scope", "Lcom/didi/app/nova/skeleton/ScopeContext;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TyingItemView.kt */
final class TyingItemView$setData$1$onItemAddClick$block$1 extends Lambda implements Function1<ScopeContext, Unit> {
    final /* synthetic */ ComponentModel $componentModel;
    final /* synthetic */ CartTyingItemModel $itemModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TyingItemView$setData$1$onItemAddClick$block$1(ComponentModel componentModel, CartTyingItemModel cartTyingItemModel) {
        super(1);
        this.$componentModel = componentModel;
        this.$itemModel = cartTyingItemModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScopeContext) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ScopeContext scopeContext) {
        ItemNodeEntity node;
        ItemNodeEntity copy;
        Intrinsics.checkNotNullParameter(scopeContext, "scope");
        BillAddTyingEntity billAddTyingEntity = new BillAddTyingEntity();
        ComponentModel componentModel = this.$componentModel;
        CartTyingItemModel cartTyingItemModel = this.$itemModel;
        billAddTyingEntity.shopId = componentModel.getShopId();
        if (!(cartTyingItemModel == null || (node = cartTyingItemModel.getNode()) == null || (copy = node.copy()) == null)) {
            copy.amount = 1;
            billAddTyingEntity.nodeList = CollectionsKt.listOf(copy);
        }
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billAddTyingEntity);
    }
}
