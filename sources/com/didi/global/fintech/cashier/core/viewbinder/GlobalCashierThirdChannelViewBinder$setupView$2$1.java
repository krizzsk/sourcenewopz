package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierThirdChannelViewBinder.kt */
/* synthetic */ class GlobalCashierThirdChannelViewBinder$setupView$2$1 extends FunctionReferenceImpl implements Function1<Payment, ChannelItemViewHolderData> {
    GlobalCashierThirdChannelViewBinder$setupView$2$1(Object obj) {
        super(1, obj, ViewBinderDataParser.Companion.class, "paymentTransToCardBinderData", "paymentTransToCardBinderData(Lcom/didi/global/fintech/cashier/model/net/response/Payment;)Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", 0);
    }

    public final ChannelItemViewHolderData invoke(Payment payment) {
        Intrinsics.checkNotNullParameter(payment, "p0");
        return ((ViewBinderDataParser.Companion) this.receiver).paymentTransToCardBinderData(payment);
    }
}
