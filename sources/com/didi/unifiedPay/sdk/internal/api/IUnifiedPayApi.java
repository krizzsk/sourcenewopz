package com.didi.unifiedPay.sdk.internal.api;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.internal.PayCallback;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.internal.ThreeDSAdyenCallBack;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import global.didi.pay.model.LoadingState;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.AdyenActionComponentData;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;

public interface IUnifiedPayApi extends IUnifiedMerchantPayApi {
    public static final int SYS_MAX_TIMES = 15;

    void billConfirm(int i, PayServiceCallback<Object> payServiceCallback);

    void cancelSyncPayResult();

    void changeCoupon(String str);

    void changeEnterprisePayType(int i);

    void changeInstallmentNumber(String str);

    void changePayChannel(int i, String str);

    void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback);

    void changePayWithBalance(String str, String str2);

    void doPay(FragmentActivity fragmentActivity, PayParamObject payParamObject, PayCallback payCallback);

    void doPixPay(FragmentActivity fragmentActivity, PayCallback payCallback, LoadingState loadingState, int i);

    void getBasicPayInfo(PayServiceCallback<BasicPayInfo> payServiceCallback);

    void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback, int i);

    void init(int i, String str, FragmentManager fragmentManager);

    void onDestroy();

    void paymentThreeDSDetails(Adyen3DSModel adyen3DSModel, AdyenActionComponentData adyenActionComponentData, ThreeDSAdyenCallBack threeDSAdyenCallBack);

    void registerCallback(PayCallback payCallback);

    void removeCallback();

    void setCybs3DSData(ThreedsCybsDataResponse threedsCybsDataResponse);

    void setPassword(String str);

    void setPayParam(PayParam payParam);

    void startSyncPayResult(int i, long j);

    void startSyncPayResult(int i, long j, int i2);

    void startSyncPayResult(int i, long j, LoadingState loadingState, int i2);

    void stopSyncPayResult();

    boolean syncPayInfo();
}
