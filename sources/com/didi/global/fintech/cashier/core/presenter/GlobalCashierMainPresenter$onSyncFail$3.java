package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.FailedInfo;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.PaymentSuggest;
import com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierMainPresenter.kt */
final class GlobalCashierMainPresenter$onSyncFail$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaymentSuggest $firstSuggest;
    final /* synthetic */ PayStatusResponse $response;
    final /* synthetic */ GlobalCashierMainPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierMainPresenter$onSyncFail$3(GlobalCashierMainPresenter globalCashierMainPresenter, PayStatusResponse payStatusResponse, PaymentSuggest paymentSuggest) {
        super(0);
        this.this$0 = globalCashierMainPresenter;
        this.$response = payStatusResponse;
        this.$firstSuggest = paymentSuggest;
    }

    public final void invoke() {
        List<BasicPayment> channels;
        GlobalCashierMainPresenter globalCashierMainPresenter = this.this$0;
        Map linkedHashMap = new LinkedHashMap();
        PayStatusResponse payStatusResponse = this.$response;
        GlobalCashierMainPresenter globalCashierMainPresenter2 = this.this$0;
        PaymentSuggest paymentSuggest = this.$firstSuggest;
        FailedInfo failedInfo = payStatusResponse.getFailedInfo();
        String str = null;
        linkedHashMap.put("error_code", failedInfo == null ? null : failedInfo.getCode());
        linkedHashMap.put("pay_method", JsonKtxKt.toJson$default(globalCashierMainPresenter2.getMSelectPayments(), (Type) null, 1, (Object) null));
        if (!(paymentSuggest == null || (channels = paymentSuggest.getChannels()) == null)) {
            str = JsonKtxKt.toJson$default(channels, (Type) null, 1, (Object) null);
        }
        linkedHashMap.put("rcmd_method", str);
        Unit unit = Unit.INSTANCE;
        globalCashierMainPresenter.omegaFailDrawerOtherCk(linkedHashMap);
    }
}
