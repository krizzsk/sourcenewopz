package com.didi.universal.pay.sdk.net;

import com.didi.universal.pay.sdk.method.internal.PayServiceCallback;
import com.didi.universal.pay.sdk.method.model.BasicPayInfo;
import com.didi.universal.pay.sdk.method.model.PayBillDetail;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.method.model.PayStatus;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;

public interface IUniversalPayHttp {

    public interface Interceptor<T> {
        void onSuccess(T t);
    }

    void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback);

    void getBasicInfo(PayServiceCallback<BasicPayInfo> payServiceCallback);

    void getBillDetail(PayServiceCallback<PayBillDetail> payServiceCallback);

    void getDepositInfo(String str, String str2, String str3, PayServiceCallback<PayInfo> payServiceCallback);

    void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback);

    void getPayStatus(PayServiceCallback<PayStatus> payServiceCallback);

    void onDestroy();

    void prepay(String str, String str2, PayServiceCallback<PrepayInfo> payServiceCallback);

    void setCouponID(String str);

    void setEnterprisePayType(int i);

    void setMonthlyCardIDandDeduction(String str, int i);

    void setPayMethod(int i, String str);
}
