package com.didi.payment.wallet.global.prepaidcard;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/prepaidcard/VerifyPwdUtil$Companion$handlePwdVerify$1", "Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "token", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VerifyPwdUtil.kt */
public final class VerifyPwdUtil$Companion$handlePwdVerify$1 implements PayPwdResultListener {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ IPwdVerify $callback;
    final /* synthetic */ WalletPageModel $netModel;

    VerifyPwdUtil$Companion$handlePwdVerify$1(IPwdVerify iPwdVerify, FragmentActivity fragmentActivity, Bundle bundle, WalletPageModel walletPageModel) {
        this.$callback = iPwdVerify;
        this.$activity = fragmentActivity;
        this.$bundle = bundle;
        this.$netModel = walletPageModel;
    }

    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        IPwdVerify iPwdVerify = this.$callback;
        if (iPwdVerify != null) {
            iPwdVerify.onFail();
        }
    }

    public void onSuccess(String str) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(str, "token");
        FragmentActivity fragmentActivity = this.$activity;
        if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
            lifecycleScope.launchWhenResumed(new VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1(this.$bundle, this.$callback, this.$activity, this.$netModel, str, (Continuation<? super VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1>) null));
        }
    }
}
