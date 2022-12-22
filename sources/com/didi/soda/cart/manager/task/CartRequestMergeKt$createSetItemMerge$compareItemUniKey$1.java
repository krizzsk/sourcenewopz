package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.SetItemParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "old", "Lcom/didi/soda/cart/model/SetItemParams;", "cur"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
final class CartRequestMergeKt$createSetItemMerge$compareItemUniKey$1 extends Lambda implements Function2<SetItemParams, SetItemParams, Boolean> {
    public static final CartRequestMergeKt$createSetItemMerge$compareItemUniKey$1 INSTANCE = new CartRequestMergeKt$createSetItemMerge$compareItemUniKey$1();

    CartRequestMergeKt$createSetItemMerge$compareItemUniKey$1() {
        super(2);
    }

    public final Boolean invoke(SetItemParams setItemParams, SetItemParams setItemParams2) {
        Intrinsics.checkNotNullParameter(setItemParams2, "cur");
        return Boolean.valueOf(((setItemParams == null ? null : setItemParams.getItemUniKey()) == null || setItemParams2.getItemUniKey() == null || !Intrinsics.areEqual((Object) setItemParams.getItemUniKey(), (Object) setItemParams2.getItemUniKey())) ? false : true);
    }
}
