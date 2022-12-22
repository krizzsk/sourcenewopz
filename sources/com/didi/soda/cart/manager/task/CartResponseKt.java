package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo175978d2 = {"getServerRevision", "", "Lcom/didi/soda/cart/manager/task/CartResponse;", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartResponse.kt */
public final class CartResponseKt {
    public static final long getServerRevision(CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "<this>");
        try {
            CartInfoEntity cartInfoEntity = cartResponse.getCartInfoEntity();
            if (cartInfoEntity == null) {
                return 0;
            }
            return Long.parseLong(cartInfoEntity.getRevision());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
