package com.didi.global.fintech.cashier.core.viewbinder.policy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyViewBinder.kt */
/* synthetic */ class GlobalCashierPolicyViewBinder$setupView$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    GlobalCashierPolicyViewBinder$setupView$3(Object obj) {
        super(1, obj, GlobalCashierPolicyViewBinder.class, "onLinkClicked", "onLinkClicked(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        ((GlobalCashierPolicyViewBinder) this.receiver).m15769a(str);
    }
}
