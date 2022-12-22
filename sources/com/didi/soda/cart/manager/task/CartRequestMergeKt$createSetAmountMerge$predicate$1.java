package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.SetItemAmountParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "old", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "cur"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
final class CartRequestMergeKt$createSetAmountMerge$predicate$1 extends Lambda implements Function2<SetItemAmountParams, SetItemAmountParams, Boolean> {
    public static final CartRequestMergeKt$createSetAmountMerge$predicate$1 INSTANCE = new CartRequestMergeKt$createSetAmountMerge$predicate$1();

    CartRequestMergeKt$createSetAmountMerge$predicate$1() {
        super(2);
    }

    public final Boolean invoke(SetItemAmountParams setItemAmountParams, SetItemAmountParams setItemAmountParams2) {
        Intrinsics.checkNotNullParameter(setItemAmountParams2, "cur");
        return Boolean.valueOf(setItemAmountParams == null || (Intrinsics.areEqual((Object) setItemAmountParams.getCartId(), (Object) setItemAmountParams2.getCartId()) && Intrinsics.areEqual((Object) setItemAmountParams.getRevision(), (Object) setItemAmountParams2.getRevision())));
    }
}
