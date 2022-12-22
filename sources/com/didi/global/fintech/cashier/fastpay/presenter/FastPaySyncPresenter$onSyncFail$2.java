package com.didi.global.fintech.cashier.fastpay.presenter;

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
/* compiled from: FastPaySyncPresenter.kt */
final class FastPaySyncPresenter$onSyncFail$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaymentSuggest $firstSuggest;
    final /* synthetic */ PayStatusResponse $response;
    final /* synthetic */ FastPaySyncPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPaySyncPresenter$onSyncFail$2(FastPaySyncPresenter fastPaySyncPresenter, PayStatusResponse payStatusResponse, PaymentSuggest paymentSuggest) {
        super(0);
        this.this$0 = fastPaySyncPresenter;
        this.$response = payStatusResponse;
        this.$firstSuggest = paymentSuggest;
    }

    public final void invoke() {
        Integer num;
        String str;
        List<BasicPayment> channels;
        FailedInfo failedInfo;
        FastPaySyncPresenter fastPaySyncPresenter = this.this$0;
        Map linkedHashMap = new LinkedHashMap();
        PayStatusResponse payStatusResponse = this.$response;
        FastPaySyncPresenter fastPaySyncPresenter2 = this.this$0;
        PaymentSuggest paymentSuggest = this.$firstSuggest;
        String str2 = null;
        if (payStatusResponse == null || (failedInfo = payStatusResponse.getFailedInfo()) == null) {
            num = null;
        } else {
            num = failedInfo.getCode();
        }
        linkedHashMap.put("error_code", num);
        linkedHashMap.put("pay_method", JsonKtxKt.toJson$default(fastPaySyncPresenter2.getMSelectPayments(), (Type) null, 1, (Object) null));
        if (paymentSuggest == null || (channels = paymentSuggest.getChannels()) == null) {
            str = null;
        } else {
            str = JsonKtxKt.toJson$default(channels, (Type) null, 1, (Object) null);
        }
        linkedHashMap.put("rcmd_pay_method", str);
        if (paymentSuggest != null) {
            str2 = paymentSuggest.getMessage();
        }
        linkedHashMap.put("button_name", str2);
        Unit unit = Unit.INSTANCE;
        fastPaySyncPresenter.omegaCheckoutPayFailBtnCk(linkedHashMap);
    }
}
