package com.didi.unifiedPay.sdk.internal;

import android.content.Intent;
import com.didi.unifiedPay.sdk.model.PasswordModel;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SignObj;
import global.didi.pay.model.LoadingState;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.Cybs3DSModel;

public abstract class SyncPayResultCallback implements PayCallback {
    public void gotoSignPay(int i, int i2, SignObj signObj) {
    }

    public void onAdyenThreeDSActionHandle(Adyen3DSModel adyen3DSModel) {
    }

    public void onCybsThreeDSActionHandle(Cybs3DSModel cybs3DSModel) {
    }

    public void onNewPixCode(String str) {
    }

    public void onPasswordHandle(PasswordModel passwordModel) {
    }

    public void onPayFail(PayError payError, String str) {
    }

    public void onPaySuccess(int i, String str) {
    }

    public void onPrePayFail(int i, String str) {
    }

    public void onPrePaySuccess(PrepayInfo prepayInfo) {
    }

    public void onQueryPayResult(boolean z, LoadingState loadingState, int i) {
    }

    public void onStartPayRequest(int i, String str) {
    }

    public void onStartPrepayRequest() {
    }

    public void startActivityForResult(Intent intent, int i) {
    }

    public void startBindPayPal(int i, int i2) {
    }

    public void startBindVisaCard(int i) {
    }

    public void startQueryPayStatus() {
    }
}
