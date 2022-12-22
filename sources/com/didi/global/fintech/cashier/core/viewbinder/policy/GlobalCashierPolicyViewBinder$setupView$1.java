package com.didi.global.fintech.cashier.core.viewbinder.policy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyViewBinder.kt */
/* synthetic */ class GlobalCashierPolicyViewBinder$setupView$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    GlobalCashierPolicyViewBinder$setupView$1(Object obj) {
        super(1, obj, GlobalCashierPolicyViewBinder.class, "onCheckBoxChanged", "onCheckBoxChanged(Z)V", 0);
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((GlobalCashierPolicyViewBinder) this.receiver).m15770a(z);
    }
}
