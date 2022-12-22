package com.didi.global.fintech.cashier.fastpay.presenter;

import com.didi.global.fintech.cashier.fastpay.api.IFastPaySettingProcessor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayCorePresenter.kt */
final class FastPayCorePresenter$onFastPayStatusResponse$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FastPayCorePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPayCorePresenter$onFastPayStatusResponse$4(FastPayCorePresenter fastPayCorePresenter) {
        super(0);
        this.this$0 = fastPayCorePresenter;
    }

    public final void invoke() {
        IFastPaySettingProcessor iFastPaySettingProcessor = (IFastPaySettingProcessor) this.this$0.m15779a(IFastPaySettingProcessor.class);
        if (iFastPaySettingProcessor != null) {
            iFastPaySettingProcessor.onPasswordInterpreted(IFastPaySettingProcessor.PasswordInterpreted.TYPE_SWITCH);
        }
    }
}
