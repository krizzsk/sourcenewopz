package com.didi.global.fintech.cashier.network.api;

import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH&J6\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\nH&J6\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH&J6\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH&J6\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\nH&J6\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00172\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\nH&¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/api/FastPayApi;", "", "changePayLimit", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "callback", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "processor", "Lkotlin/Function1;", "changePayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "getFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "getPayOrder", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "setFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "submitQuestionnaire", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayApi.kt */
public interface FastPayApi {
    void changePayLimit(ChangePayLimitRequest changePayLimitRequest, CashierNetCallback<ChangePayLimitResponse> cashierNetCallback, Function1<? super ChangePayLimitRequest, ChangePayLimitRequest> function1);

    void changePayOrder(ChangePayOrderRequest changePayOrderRequest, CashierNetCallback<ChangePayOrderResponse> cashierNetCallback, Function1<? super ChangePayOrderRequest, ChangePayOrderRequest> function1);

    void getFastPayInfo(FastPayInfoRequest fastPayInfoRequest, CashierNetCallback<FastPayInfoResponse> cashierNetCallback, Function1<? super FastPayInfoRequest, FastPayInfoRequest> function1);

    void getPayOrder(FastPayInfoRequest fastPayInfoRequest, CashierNetCallback<FastPayOrderResponse> cashierNetCallback, Function1<? super FastPayInfoRequest, FastPayInfoRequest> function1);

    void setFastPayStatus(FastPayStatusRequest fastPayStatusRequest, CashierNetCallback<FastPayStatusResponse> cashierNetCallback, Function1<? super FastPayStatusRequest, FastPayStatusRequest> function1);

    void submitQuestionnaire(FastPaySubmitQuizRequest fastPaySubmitQuizRequest, CashierNetCallback<FastPaySubmitQuizResponse> cashierNetCallback, Function1<? super FastPaySubmitQuizRequest, FastPaySubmitQuizRequest> function1);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFastPayInfo$default(FastPayApi fastPayApi, FastPayInfoRequest fastPayInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                fastPayApi.getFastPayInfo(fastPayInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFastPayInfo");
        }

        public static /* synthetic */ void getPayOrder$default(FastPayApi fastPayApi, FastPayInfoRequest fastPayInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                fastPayApi.getPayOrder(fastPayInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPayOrder");
        }

        public static /* synthetic */ void changePayOrder$default(FastPayApi fastPayApi, ChangePayOrderRequest changePayOrderRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                fastPayApi.changePayOrder(changePayOrderRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePayOrder");
        }

        public static /* synthetic */ void setFastPayStatus$default(FastPayApi fastPayApi, FastPayStatusRequest fastPayStatusRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                fastPayApi.setFastPayStatus(fastPayStatusRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFastPayStatus");
        }

        public static /* synthetic */ void changePayLimit$default(FastPayApi fastPayApi, ChangePayLimitRequest changePayLimitRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                fastPayApi.changePayLimit(changePayLimitRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePayLimit");
        }

        public static /* synthetic */ void submitQuestionnaire$default(FastPayApi fastPayApi, FastPaySubmitQuizRequest fastPaySubmitQuizRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                fastPayApi.submitQuestionnaire(fastPaySubmitQuizRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitQuestionnaire");
        }
    }
}
