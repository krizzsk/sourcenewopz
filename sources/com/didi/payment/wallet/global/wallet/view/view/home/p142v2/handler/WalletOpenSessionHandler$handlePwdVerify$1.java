package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler.WalletOpenSessionHandler;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletOpenSessionHandler$handlePwdVerify$1", "Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "token", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handlePwdVerify$1 */
/* compiled from: WalletOpenSessionHandler.kt */
public final class WalletOpenSessionHandler$handlePwdVerify$1 implements PayPwdResultListener {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ WalletOpenSessionHandler.IPwdVerify $callback;
    final /* synthetic */ WalletPageModel $netModel;

    WalletOpenSessionHandler$handlePwdVerify$1(WalletOpenSessionHandler.IPwdVerify iPwdVerify, FragmentActivity fragmentActivity, Bundle bundle, WalletPageModel walletPageModel) {
        this.$callback = iPwdVerify;
        this.$activity = fragmentActivity;
        this.$bundle = bundle;
        this.$netModel = walletPageModel;
    }

    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        WalletOpenSessionHandler.IPwdVerify iPwdVerify = this.$callback;
        if (iPwdVerify != null) {
            iPwdVerify.onFail();
        }
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        LifecycleOwnerKt.getLifecycleScope(this.$activity).launchWhenResumed(new WalletOpenSessionHandler$handlePwdVerify$1$onSuccess$1(this.$bundle, this.$callback, this.$activity, this.$netModel, str, (Continuation<? super WalletOpenSessionHandler$handlePwdVerify$1$onSuccess$1>) null));
    }
}
