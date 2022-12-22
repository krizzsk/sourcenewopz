package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBasePresenter;", "agreePolicy", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "changePayInfo", "changePayInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "getCvvInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "getPayInfo", "getPayInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "getPayStatus", "getPayStatusRequest", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "getSuccessInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetSuccessInfoRequest;", "initNet", "payment3DSDetails", "Lcom/didi/global/fintech/cashier/model/net/request/PaymentThreeDSDetailsRequest;", "prePay", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "API", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalCashierNetPresenter extends IGlobalCashierBasePresenter {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "", "(Ljava/lang/String;I)V", "GET_PAY_INFO", "CHANGE_PAY_INFO", "PRE_PAY", "GET_PAY_STATUS", "GET_PAY_SUCCESS_INFO", "PAYMENT_3DS_DETAILS", "GET_CVV_INFO", "AGREE_POLICY", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPresenters.kt */
    public enum API {
        GET_PAY_INFO,
        CHANGE_PAY_INFO,
        PRE_PAY,
        GET_PAY_STATUS,
        GET_PAY_SUCCESS_INFO,
        PAYMENT_3DS_DETAILS,
        GET_CVV_INFO,
        AGREE_POLICY
    }

    void agreePolicy(AgreePolicyRequest agreePolicyRequest);

    void changePayInfo(ChangePayInfoRequest changePayInfoRequest);

    void getCvvInfo(GetCVVInfoRequest getCVVInfoRequest);

    void getPayInfo(GetPayInfoRequest getPayInfoRequest);

    void getPayStatus(GetPayStatusRequest getPayStatusRequest);

    void getSuccessInfo(GetSuccessInfoRequest getSuccessInfoRequest);

    void initNet();

    void payment3DSDetails(PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest);

    void prePay(PrepayRequest prepayRequest);
}
