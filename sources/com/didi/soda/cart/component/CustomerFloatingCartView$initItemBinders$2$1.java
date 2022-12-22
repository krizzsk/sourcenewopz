package com.didi.soda.cart.component;

import com.didi.soda.cart.binder.CustomerTyingItemAdapter;
import com.didi.soda.cart.component.Contract;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/cart/component/CustomerFloatingCartView$initItemBinders$2$1", "Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter$OnItemClickListener;", "onItemAddClick", "", "itemModel", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "onItemClick", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartView.kt */
public final class CustomerFloatingCartView$initItemBinders$2$1 implements CustomerTyingItemAdapter.OnItemClickListener {
    final /* synthetic */ CustomerFloatingCartView this$0;

    CustomerFloatingCartView$initItemBinders$2$1(CustomerFloatingCartView customerFloatingCartView) {
        this.this$0 = customerFloatingCartView;
    }

    public void onItemClick(CartTyingItemModel cartTyingItemModel) {
        if (cartTyingItemModel != null) {
            CustomerFloatingCartView customerFloatingCartView = this.this$0;
            FloatingCartOmegaHelper.Companion.trackTyingItemCK("1", cartTyingItemModel);
            ((Contract.AbsFloatingCartPresenter) customerFloatingCartView.getPresenter()).toSkuPage(cartTyingItemModel);
        }
    }

    public void onItemAddClick(CartTyingItemModel cartTyingItemModel) {
        if (cartTyingItemModel != null) {
            CustomerFloatingCartView customerFloatingCartView = this.this$0;
            FloatingCartOmegaHelper.Companion.trackTyingItemAdd("1", cartTyingItemModel);
            ((Contract.AbsFloatingCartPresenter) customerFloatingCartView.getPresenter()).addSku(cartTyingItemModel, true);
        }
    }
}
