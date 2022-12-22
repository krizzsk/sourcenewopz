package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.manager.task.CartRequestMerge;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0003*8\u0010\u0006\u001a\u0004\b\u0000\u0010\u0007\"\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u0007\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\t0\b2\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u0007\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\t0\b*<\u0010\n\u001a\u0004\b\u0000\u0010\u0007\"\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0007\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0007\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b¨\u0006\u000b"}, mo175978d2 = {"createSetAmountMerge", "Lcom/didi/soda/cart/manager/task/CartRequestMerge;", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "Lcom/didi/soda/cart/manager/task/CartRequestMerge$Companion;", "createSetItemMerge", "Lcom/didi/soda/cart/model/SetItemParams;", "MergePredicate", "T", "Lkotlin/Function2;", "", "RunMerge", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
public final class CartRequestMergeKt {
    public static final CartRequestMerge<SetItemParams> createSetItemMerge(CartRequestMerge.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CartRequestMerge<>(CartRequestMergeKt$createSetItemMerge$predicate$1.INSTANCE, new CartRequestMergeKt$createSetItemMerge$runMerge$1(CartRequestMergeKt$createSetItemMerge$compareItemUniKey$1.INSTANCE));
    }

    public static final CartRequestMerge<SetItemAmountParams> createSetAmountMerge(CartRequestMerge.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CartRequestMerge<>(CartRequestMergeKt$createSetAmountMerge$predicate$1.INSTANCE, CartRequestMergeKt$createSetAmountMerge$runMerge$1.INSTANCE);
    }
}
