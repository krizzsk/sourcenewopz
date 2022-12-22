package com.didi.soda.bill.view.item;

import com.didi.soda.cart.model.CartTyingItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "ele", "Lcom/didi/soda/cart/model/CartTyingItemModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TyingItemView.kt */
final class TyingItemView$handleOmegaEvent$itemList$1 extends Lambda implements Function1<CartTyingItemModel, String> {
    public static final TyingItemView$handleOmegaEvent$itemList$1 INSTANCE = new TyingItemView$handleOmegaEvent$itemList$1();

    TyingItemView$handleOmegaEvent$itemList$1() {
        super(1);
    }

    public final String invoke(CartTyingItemModel cartTyingItemModel) {
        Intrinsics.checkNotNullParameter(cartTyingItemModel, "ele");
        return cartTyingItemModel.getItemId();
    }
}
