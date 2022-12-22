package com.didi.soda.cart.repo;

import com.didi.soda.customer.repo.model.ItemState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, mo175978d2 = {"getCartAllGiftNum", "", "Lcom/didi/soda/cart/repo/CartItemStateRepo;", "shopId", "", "getCartAllNum", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartItemStateRepo.kt */
public final class CartItemStateRepoKt {
    public static final int getCartAllNum(CartItemStateRepo cartItemStateRepo, String str) {
        Intrinsics.checkNotNullParameter(cartItemStateRepo, "<this>");
        Intrinsics.checkNotNullParameter(str, "shopId");
        ArrayList<ItemState> value = cartItemStateRepo.getValue(str);
        int i = 0;
        if (value != null) {
            Iterator<ItemState> it = value.iterator();
            while (it.hasNext()) {
                i += it.next().amount;
            }
        }
        return i;
    }

    public static final int getCartAllGiftNum(CartItemStateRepo cartItemStateRepo, String str) {
        Intrinsics.checkNotNullParameter(cartItemStateRepo, "<this>");
        Intrinsics.checkNotNullParameter(str, "shopId");
        ArrayList<ItemState> value = cartItemStateRepo.getValue(str);
        int i = 0;
        if (value != null) {
            Iterator<ItemState> it = value.iterator();
            while (it.hasNext()) {
                ItemState next = it.next();
                if (next.mduType == 2) {
                    i += next.amount;
                }
            }
        }
        return i;
    }
}
