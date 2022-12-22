package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.ResultPayments;
import com.didi.global.fintech.cashier.p117ui.viewholder.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierResultPayViewBinder.kt */
/* synthetic */ class GlobalCashierResultPayViewBinder$setupView$2$1 extends FunctionReferenceImpl implements Function1<ResultPayments, PaymentMethod> {
    GlobalCashierResultPayViewBinder$setupView$2$1(Object obj) {
        super(1, obj, ViewBinderDataParser.Companion.class, "transferResultPaymentMethod", "transferResultPaymentMethod(Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments;)Lcom/didi/global/fintech/cashier/ui/viewholder/PaymentMethod;", 0);
    }

    public final PaymentMethod invoke(ResultPayments resultPayments) {
        Intrinsics.checkNotNullParameter(resultPayments, "p0");
        return ((ViewBinderDataParser.Companion) this.receiver).transferResultPaymentMethod(resultPayments);
    }
}
