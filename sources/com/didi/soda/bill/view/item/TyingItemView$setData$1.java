package com.didi.soda.bill.view.item;

import android.os.Bundle;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2;
import com.didi.soda.cart.binder.CustomerTyingItemAdapter;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/bill/view/item/TyingItemView$setData$1", "Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter$OnItemClickListener;", "onItemAddClick", "", "itemModel", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "onItemClick", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TyingItemView.kt */
public final class TyingItemView$setData$1 implements CustomerTyingItemAdapter.OnItemClickListener {
    final /* synthetic */ ComponentModel $componentModel;
    final /* synthetic */ TyingItemView this$0;

    TyingItemView$setData$1(TyingItemView tyingItemView, ComponentModel componentModel) {
        this.this$0 = tyingItemView;
        this.$componentModel = componentModel;
    }

    public void onItemClick(CartTyingItemModel cartTyingItemModel) {
        if (cartTyingItemModel != null) {
            FloatingCartOmegaHelper.Companion.trackTyingItemCK("2", cartTyingItemModel);
        }
        Function1 tyingItemView$setData$1$onItemClick$block$1 = new TyingItemView$setData$1$onItemClick$block$1(cartTyingItemModel, this.this$0, this.$componentModel);
        ItemViewCommonLogicV2 itemViewCommonLogicV2 = (ItemViewCommonLogicV2) this.this$0.getLogic();
        if (itemViewCommonLogicV2 != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogicV2, this.$componentModel, (Integer) null, (Bundle) null, tyingItemView$setData$1$onItemClick$block$1, 6, (Object) null);
        }
    }

    public void onItemAddClick(CartTyingItemModel cartTyingItemModel) {
        if (cartTyingItemModel != null) {
            FloatingCartOmegaHelper.Companion.trackTyingItemAdd("2", cartTyingItemModel);
        }
        Function1 tyingItemView$setData$1$onItemAddClick$block$1 = new TyingItemView$setData$1$onItemAddClick$block$1(this.$componentModel, cartTyingItemModel);
        ItemViewCommonLogicV2 itemViewCommonLogicV2 = (ItemViewCommonLogicV2) this.this$0.getLogic();
        if (itemViewCommonLogicV2 != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogicV2, this.$componentModel, (Integer) null, (Bundle) null, tyingItemView$setData$1$onItemAddClick$block$1, 6, (Object) null);
        }
    }
}
