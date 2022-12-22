package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.SetItemParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "old", "Lcom/didi/soda/cart/model/SetItemParams;", "cur"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
final class CartRequestMergeKt$createSetItemMerge$predicate$1 extends Lambda implements Function2<SetItemParams, SetItemParams, Boolean> {
    public static final CartRequestMergeKt$createSetItemMerge$predicate$1 INSTANCE = new CartRequestMergeKt$createSetItemMerge$predicate$1();

    CartRequestMergeKt$createSetItemMerge$predicate$1() {
        super(2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r5 != false) goto L_0x0009;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(com.didi.soda.cart.model.SetItemParams r5, com.didi.soda.cart.model.SetItemParams r6) {
        /*
            r4 = this;
            java.lang.String r0 = "cur"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r1 = 1
            if (r5 != 0) goto L_0x000b
        L_0x0009:
            r0 = 1
            goto L_0x0051
        L_0x000b:
            java.lang.String r2 = r5.getItemUniKey()
            java.lang.String r3 = r6.getItemUniKey()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            java.lang.String r3 = r5.getItemUniKey()
            if (r3 == 0) goto L_0x0023
            java.lang.String r3 = r6.getItemUniKey()
            if (r3 != 0) goto L_0x002f
        L_0x0023:
            java.lang.String r2 = r5.getItemId()
            java.lang.String r3 = r6.getItemId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
        L_0x002f:
            java.lang.String r5 = r5.getMduId()
            java.lang.String r3 = r6.getMduId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r3)
            if (r5 == 0) goto L_0x0045
            java.lang.String r5 = r6.getMduId()
            if (r5 == 0) goto L_0x0045
            r5 = 1
            goto L_0x0046
        L_0x0045:
            r5 = 0
        L_0x0046:
            boolean r6 = r6.isMultiContents()
            if (r6 != 0) goto L_0x0051
            if (r2 != 0) goto L_0x0009
            if (r5 == 0) goto L_0x0051
            goto L_0x0009
        L_0x0051:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.manager.task.CartRequestMergeKt$createSetItemMerge$predicate$1.invoke(com.didi.soda.cart.model.SetItemParams, com.didi.soda.cart.model.SetItemParams):java.lang.Boolean");
    }
}
