package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.api.ICashier3DSProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$onPayStatusResponse$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayStatusResponse $response;
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$onPayStatusResponse$1(GlobalCashierPayPresenter globalCashierPayPresenter, PayStatusResponse payStatusResponse) {
        super(0);
        this.this$0 = globalCashierPayPresenter;
        this.$response = payStatusResponse;
    }

    public final void invoke() {
        GlobalCashierPayPresenter globalCashierPayPresenter = this.this$0;
        CashierAction nextStep = this.$response.getNextStep();
        boolean z = false;
        if (nextStep != null && nextStep.threeDS()) {
            z = true;
        }
        GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel = null;
        if (!z) {
            globalCashierPayPresenter = null;
        }
        if (globalCashierPayPresenter != null) {
            PayStatusResponse payStatusResponse = this.$response;
            ICashier3DSProcessor iCashier3DSProcessor = (ICashier3DSProcessor) globalCashierPayPresenter.m15739a(ICashier3DSProcessor.class);
            if (iCashier3DSProcessor != null) {
                CashierAction nextStep2 = payStatusResponse.getNextStep();
                if (nextStep2 != null) {
                    globalCashierAdyen3DSModel = nextStep2.threeDSData();
                }
                iCashier3DSProcessor.adyenActionHandle(globalCashierAdyen3DSModel);
            }
        }
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) this.this$0.m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
    }
}
