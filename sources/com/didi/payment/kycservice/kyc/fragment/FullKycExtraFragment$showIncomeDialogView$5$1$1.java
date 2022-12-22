package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment$showIncomeDialogView$5$1$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FullKycExtraFragment.kt */
public final class FullKycExtraFragment$showIncomeDialogView$5$1$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ FullKycExtraFragment this$0;

    FullKycExtraFragment$showIncomeDialogView$5$1$1(FullKycExtraFragment fullKycExtraFragment, Context context) {
        this.this$0 = fullKycExtraFragment;
        this.$context = context;
    }

    public void doClick(View view) {
        KycOmega.Companion.trackButtonEvent("fin_primarykycinformation_incomebutton_ck", 1);
        TextView access$getMIncomeText$p = this.this$0.f30775e;
        String str = null;
        if (access$getMIncomeText$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIncomeText");
            access$getMIncomeText$p = null;
        }
        GuidesInfoResp.Income access$getIncomeSelect$p = this.this$0.f30789s;
        if (access$getIncomeSelect$p != null) {
            str = access$getIncomeSelect$p.getDisplay();
        }
        access$getMIncomeText$p.setText(String.valueOf(str));
        WalletDialog access$getMConfirmDrawer$p = this.this$0.f30788r;
        if (access$getMConfirmDrawer$p != null) {
            access$getMConfirmDrawer$p.dismiss();
        }
        GuidesInfoResp.Income access$getIncomeSelect$p2 = this.this$0.f30789s;
        if (access$getIncomeSelect$p2 != null) {
            Context context = this.$context;
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.putIncome(context, access$getIncomeSelect$p2);
        }
        this.this$0.m21666e();
    }
}
