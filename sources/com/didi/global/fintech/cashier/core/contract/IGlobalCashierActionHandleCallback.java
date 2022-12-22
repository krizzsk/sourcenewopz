package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH&J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "", "onAdyenThreeDSSuccess", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onCardBind", "cardIndex", "", "onCardVerify", "onCashierClose", "payResult", "", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onThreeDSCancel", "error", "type", "onThreeDSFailed", "onTopUp", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierActionHandleCallback.kt */
public interface IGlobalCashierActionHandleCallback {
    void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel);

    void onCardBind(String str);

    void onCardVerify(String str);

    void onCashierClose(int i);

    void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str);

    void onPasswordFailed(String str, String str2);

    void onPasswordSuccess(String str);

    void onPixPaid();

    void onThreeDSCancel(String str, String str2);

    void onThreeDSFailed(String str, String str2);

    void onTopUp();
}
