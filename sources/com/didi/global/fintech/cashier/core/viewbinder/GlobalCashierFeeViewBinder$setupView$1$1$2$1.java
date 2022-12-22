package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierFeeViewBinder.kt */
final class GlobalCashierFeeViewBinder$setupView$1$1$2$1 extends Lambda implements Function1<FeeHelpInfo, Unit> {
    final /* synthetic */ FeeHelpInfo $helpInfo;
    final /* synthetic */ GlobalCashierFeeViewBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierFeeViewBinder$setupView$1$1$2$1(GlobalCashierFeeViewBinder globalCashierFeeViewBinder, FeeHelpInfo feeHelpInfo) {
        super(1);
        this.this$0 = globalCashierFeeViewBinder;
        this.$helpInfo = feeHelpInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FeeHelpInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FeeHelpInfo feeHelpInfo) {
        ((IGlobalMainCashierPresenter) this.this$0.getPresenter()).onHelpIconClick(this.$helpInfo);
    }
}
