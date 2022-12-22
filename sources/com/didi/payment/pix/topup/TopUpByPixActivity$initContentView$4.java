package com.didi.payment.pix.topup;

import android.view.View;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.widget.WalletAmountEditText;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/pix/topup/TopUpByPixActivity$initContentView$4", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixActivity.kt */
public final class TopUpByPixActivity$initContentView$4 extends DoubleCheckOnClickListener {
    final /* synthetic */ TopUpByPixActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopUpByPixActivity$initContentView$4(TopUpByPixActivity topUpByPixActivity) {
        super(1000);
        this.this$0 = topUpByPixActivity;
    }

    public void doClick(View view) {
        WalletAmountEditText access$getEtAmount$p = this.this$0.f31211b;
        if (access$getEtAmount$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etAmount");
            access$getEtAmount$p = null;
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(access$getEtAmount$p.getAmountValue());
        if (doubleOrNull == null) {
            TopUpByPixActivity topUpByPixActivity = this.this$0;
            WalletToastNew.showFailedMsg(topUpByPixActivity, topUpByPixActivity.getString(R.string.pix_amount_error));
            return;
        }
        TopUpByPixViewModel.topUp$default(TopUpByPixActivity.access$getVm(this.this$0), doubleOrNull.doubleValue(), (String) null, 2, (Object) null);
        FinOmegaSDK.trackEvent("ibt_didipay_topup_pix_amount_ck");
    }
}
