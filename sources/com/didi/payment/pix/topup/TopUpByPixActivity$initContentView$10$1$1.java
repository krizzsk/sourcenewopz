package com.didi.payment.pix.topup;

import com.didi.payment.commonsdk.widget.WalletAmountEditText;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/topup/TopUpByPixActivity$initContentView$10$1$1", "Lcom/didiglobal/pay/paysecure/SetPwdResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "token", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixActivity.kt */
public final class TopUpByPixActivity$initContentView$10$1$1 implements SetPwdResultListener {
    final /* synthetic */ TopUpByPixActivity this$0;

    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
    }

    TopUpByPixActivity$initContentView$10$1$1(TopUpByPixActivity topUpByPixActivity) {
        this.this$0 = topUpByPixActivity;
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        TopUpByPixViewModel access$getVm = TopUpByPixActivity.access$getVm(this.this$0);
        WalletAmountEditText access$getEtAmount$p = this.this$0.f31211b;
        if (access$getEtAmount$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etAmount");
            access$getEtAmount$p = null;
        }
        access$getVm.topUp(Double.parseDouble(access$getEtAmount$p.getAmountValue()), str);
    }
}
