package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.ReturnButton;
import com.didi.global.fintech.cashier.p117ui.viewholder.MerchantButtonData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierResultPayViewBinder.kt */
/* synthetic */ class GlobalCashierResultPayViewBinder$setupView$3$1 extends FunctionReferenceImpl implements Function1<ReturnButton, MerchantButtonData> {
    GlobalCashierResultPayViewBinder$setupView$3$1(Object obj) {
        super(1, obj, ViewBinderDataParser.Companion.class, "transferReturnButtonData", "transferReturnButtonData(Lcom/didi/global/fintech/cashier/model/net/response/ReturnButton;)Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", 0);
    }

    public final MerchantButtonData invoke(ReturnButton returnButton) {
        Intrinsics.checkNotNullParameter(returnButton, "p0");
        return ((ViewBinderDataParser.Companion) this.receiver).transferReturnButtonData(returnButton);
    }
}
