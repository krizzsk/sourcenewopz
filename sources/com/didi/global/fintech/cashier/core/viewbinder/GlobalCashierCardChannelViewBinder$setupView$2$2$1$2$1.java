package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "vo", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCardChannelViewBinder.kt */
final class GlobalCashierCardChannelViewBinder$setupView$2$2$1$2$1 extends Lambda implements Function1<InstallmentVo, Unit> {
    final /* synthetic */ ChannelItemViewHolderData $itemVo;
    final /* synthetic */ GlobalCashierCardChannelViewBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierCardChannelViewBinder$setupView$2$2$1$2$1(GlobalCashierCardChannelViewBinder globalCashierCardChannelViewBinder, ChannelItemViewHolderData channelItemViewHolderData) {
        super(1);
        this.this$0 = globalCashierCardChannelViewBinder;
        this.$itemVo = channelItemViewHolderData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InstallmentVo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InstallmentVo installmentVo) {
        Intrinsics.checkNotNullParameter(installmentVo, "vo");
        ((IGlobalMainCashierPresenter) this.this$0.getPresenter()).onPlansClick(this.$itemVo.getCardIndex(), installmentVo);
    }
}
