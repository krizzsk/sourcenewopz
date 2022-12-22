package com.didi.soda.bill.component.bill;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenterV2.kt */
final class CustomerBillPresenterV2$getItemListForTracker$6 extends Lambda implements Function1<CartItemEntity, CharSequence> {
    public static final CustomerBillPresenterV2$getItemListForTracker$6 INSTANCE = new CustomerBillPresenterV2$getItemListForTracker$6();

    CustomerBillPresenterV2$getItemListForTracker$6() {
        super(1);
    }

    public final CharSequence invoke(CartItemEntity cartItemEntity) {
        Intrinsics.checkNotNullParameter(cartItemEntity, "it");
        return cartItemEntity.getItemId() + '_' + cartItemEntity.getAmount();
    }
}
