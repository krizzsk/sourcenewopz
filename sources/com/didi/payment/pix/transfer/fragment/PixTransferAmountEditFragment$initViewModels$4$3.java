package com.didi.payment.pix.transfer.fragment;

import com.didi.payment.wallet.password.PasswordDataVo;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment$initViewModels$4$3", "Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "token", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment$initViewModels$4$3 implements PayPwdResultListener {
    final /* synthetic */ PasswordDataVo $vo;
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
    }

    PixTransferAmountEditFragment$initViewModels$4$3(PixTransferAmountEditFragment pixTransferAmountEditFragment, PasswordDataVo passwordDataVo) {
        this.this$0 = pixTransferAmountEditFragment;
        this.$vo = passwordDataVo;
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        PixTransferAmountEditFragment.access$getVm(this.this$0).createPixTransferOrder(99996, this.$vo.getData(), str);
    }
}
