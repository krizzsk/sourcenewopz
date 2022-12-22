package com.didi.global.fintech.cashier.core.viewbinder.policy;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.PolicyInfo;
import com.didi.global.fintech.cashier.p117ui.viewholder.AcceptContent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyViewBinder.kt */
/* synthetic */ class GlobalCashierPolicyViewBinder$setupView$2 extends FunctionReferenceImpl implements Function1<PolicyInfo.PolicyAcceptContent, AcceptContent> {
    GlobalCashierPolicyViewBinder$setupView$2(Object obj) {
        super(1, obj, ViewBinderDataParser.Companion.class, "PolicyAcceptContentToAcceptContent", "PolicyAcceptContentToAcceptContent(Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo$PolicyAcceptContent;)Lcom/didi/global/fintech/cashier/ui/viewholder/AcceptContent;", 0);
    }

    public final AcceptContent invoke(PolicyInfo.PolicyAcceptContent policyAcceptContent) {
        Intrinsics.checkNotNullParameter(policyAcceptContent, "p0");
        return ((ViewBinderDataParser.Companion) this.receiver).PolicyAcceptContentToAcceptContent(policyAcceptContent);
    }
}
