package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierFeeViewHolder$updateAdditionalInfo$1 */
/* compiled from: GlobalCashierFeeViewHolder.kt */
final class GlobalCashierFeeViewHolder$updateAdditionalInfo$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function1<FeeHelpInfo, Unit> $click;
    final /* synthetic */ FeeHelpInfo $helpInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierFeeViewHolder$updateAdditionalInfo$1(Function1<? super FeeHelpInfo, Unit> function1, FeeHelpInfo feeHelpInfo) {
        super(1);
        this.$click = function1;
        this.$helpInfo = feeHelpInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        this.$click.invoke(this.$helpInfo);
    }
}
