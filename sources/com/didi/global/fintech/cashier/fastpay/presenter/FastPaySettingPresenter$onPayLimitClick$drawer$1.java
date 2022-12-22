package com.didi.global.fintech.cashier.fastpay.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingPresenter.kt */
/* synthetic */ class FastPaySettingPresenter$onPayLimitClick$drawer$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    FastPaySettingPresenter$onPayLimitClick$drawer$1(Object obj) {
        super(1, obj, FastPaySettingPresenter.class, "onPayLimitBack", "onPayLimitBack(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        ((FastPaySettingPresenter) this.receiver).onPayLimitBack(str);
    }
}
