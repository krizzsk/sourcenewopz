package com.didi.soda.cart.listener;

import com.didi.soda.cart.model.CartItemModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/cart/listener/OnFloatingCartItemListener;", "", "toBusinessSkuPage", "", "cartItemModel", "Lcom/didi/soda/cart/model/CartItemModel;", "updateSku", "action", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OnFloatingCartItemListener.kt */
public interface OnFloatingCartItemListener {
    void toBusinessSkuPage(CartItemModel cartItemModel);

    void updateSku(CartItemModel cartItemModel, boolean z);
}
