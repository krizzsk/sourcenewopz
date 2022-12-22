package com.didi.unifiedPay.sdk.net.service;

import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.ConfirmTipsInfo;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PaymentThreeDSDetailsInfo;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.AdyenActionComponentData;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;

public interface IUnipayService {

    public interface Interceptor<T> {
        void onSuccess(T t);
    }

    void billConfirm(int i, PayServiceCallback<Object> payServiceCallback);

    void changeCoupon(String str);

    void changeEnterprisePayType(int i);

    void changeInstallmentNumber(String str);

    void changePayChannel(int i, String str);

    void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback);

    void changePayWithBalance(String str, String str2);

    void getBasicPayInfo(PayServiceCallback<BasicPayInfo> payServiceCallback);

    void getConfirmInfo(int i, long j, String str, PayServiceCallback<ConfirmTipsInfo> payServiceCallback);

    void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback);

    void getPayStatus(PayServiceCallback<PayStatus> payServiceCallback);

    void onDestroy();

    void paymentThreeDSDetails(Adyen3DSModel adyen3DSModel, AdyenActionComponentData adyenActionComponentData, PayServiceCallback<PaymentThreeDSDetailsInfo> payServiceCallback);

    void prepay(String str, String str2, PayServiceCallback<PrepayInfo> payServiceCallback);

    void setCybs3DSData(ThreedsCybsDataResponse threedsCybsDataResponse);

    void setPassword(String str);
}
