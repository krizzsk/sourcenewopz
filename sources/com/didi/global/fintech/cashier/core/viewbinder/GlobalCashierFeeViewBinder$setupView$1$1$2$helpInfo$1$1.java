package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.PriceInfo;
import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierFeeViewBinder.kt */
/* synthetic */ class GlobalCashierFeeViewBinder$setupView$1$1$2$helpInfo$1$1 extends FunctionReferenceImpl implements Function1<PriceInfo.AdditionalInfo.HelpInfo, FeeHelpInfo> {
    GlobalCashierFeeViewBinder$setupView$1$1$2$helpInfo$1$1(Object obj) {
        super(1, obj, ViewBinderDataParser.Companion.class, "transferHelpInfoToFeeHelpInfo", "transferHelpInfoToFeeHelpInfo(Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;)Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", 0);
    }

    public final FeeHelpInfo invoke(PriceInfo.AdditionalInfo.HelpInfo helpInfo) {
        Intrinsics.checkNotNullParameter(helpInfo, "p0");
        return ((ViewBinderDataParser.Companion) this.receiver).transferHelpInfoToFeeHelpInfo(helpInfo);
    }
}
