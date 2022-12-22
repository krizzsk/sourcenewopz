package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter;", "changePayLimit", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "changePayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "getFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "getPayOrder", "setFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "submitOffQuiz", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "API", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayPresenters.kt */
public interface IFastPayNetPresenter extends IGlobalCashierNetPresenter {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter$API;", "", "(Ljava/lang/String;I)V", "GET_FAST_PAY_INFO", "GET_FAST_PAY_ORDER", "UPDATE_CHANNEL_ORDER", "ON_OR_OFF", "ADJUST_PAY_LIMIT", "SUBMIT_QUIZ", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IFastPayPresenters.kt */
    public enum API {
        GET_FAST_PAY_INFO,
        GET_FAST_PAY_ORDER,
        UPDATE_CHANNEL_ORDER,
        ON_OR_OFF,
        ADJUST_PAY_LIMIT,
        SUBMIT_QUIZ
    }

    void changePayLimit(ChangePayLimitRequest changePayLimitRequest);

    void changePayOrder(ChangePayOrderRequest changePayOrderRequest);

    void getFastPayInfo(FastPayInfoRequest fastPayInfoRequest);

    void getPayOrder(FastPayInfoRequest fastPayInfoRequest);

    void setFastPayStatus(FastPayStatusRequest fastPayStatusRequest);

    void submitOffQuiz(FastPaySubmitQuizRequest fastPaySubmitQuizRequest);
}
