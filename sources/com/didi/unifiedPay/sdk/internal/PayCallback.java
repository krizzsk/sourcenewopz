package com.didi.unifiedPay.sdk.internal;

import android.content.Intent;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SignObj;
import global.didi.pay.model.LoadingState;

public interface PayCallback extends PasswordCallBack, ThreeDSAdyenCallBack, ThreeDSCybsCallBack {
    void gotoSignPay(int i, int i2, SignObj signObj);

    void onNewPixCode(String str);

    void onPayFail(PayError payError, String str);

    void onPaySuccess(int i, String str);

    void onPrePayFail(int i, String str);

    void onPrePaySuccess(PrepayInfo prepayInfo);

    void onQueryPayResult(boolean z, LoadingState loadingState, int i);

    void onStartPayRequest(int i, String str);

    void onStartPrepayRequest();

    void startActivityForResult(Intent intent, int i);

    void startBindPayPal(int i, int i2);

    void startBindVisaCard(int i);

    void startQueryPayStatus();
}
