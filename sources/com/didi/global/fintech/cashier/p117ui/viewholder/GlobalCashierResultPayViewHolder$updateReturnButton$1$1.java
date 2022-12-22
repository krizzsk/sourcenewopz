package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierResultPayViewHolder$updateReturnButton$1$1 */
/* compiled from: GlobalCashierResultPayViewHolder.kt */
final class GlobalCashierResultPayViewHolder$updateReturnButton$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ MerchantButtonData $buttonData;
    final /* synthetic */ Function1<MerchantButtonData, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierResultPayViewHolder$updateReturnButton$1$1(Function1<? super MerchantButtonData, Unit> function1, MerchantButtonData merchantButtonData) {
        super(1);
        this.$onClick = function1;
        this.$buttonData = merchantButtonData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        this.$onClick.invoke(this.$buttonData);
    }
}
