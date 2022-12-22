package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FullKycExtraFragment.kt */
final class FullKycExtraFragment$initListener$11 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $phone;
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$initListener$11(FullKycExtraFragment fullKycExtraFragment, String str) {
        super(0);
        this.this$0 = fullKycExtraFragment;
        this.$phone = str;
    }

    public final void invoke() {
        NewPixInputView access$getMZipCodeInput$p = this.this$0.f30776f;
        NewPixInputView newPixInputView = null;
        if (access$getMZipCodeInput$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            access$getMZipCodeInput$p = null;
        }
        int length = access$getMZipCodeInput$p.getInputStr().length();
        boolean z = false;
        if (1 <= length && length <= 7) {
            z = true;
        }
        if (z) {
            NewPixInputView access$getMZipCodeInput$p2 = this.this$0.f30776f;
            if (access$getMZipCodeInput$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                access$getMZipCodeInput$p2 = null;
            }
            String string = this.this$0.getString(R.string.Fintech_Payment_Optimization_Please_fill_ZYvG);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Finte…ization_Please_fill_ZYvG)");
            access$getMZipCodeInput$p2.showErrorInfo(string);
        } else {
            NewPixInputView access$getMZipCodeInput$p3 = this.this$0.f30776f;
            if (access$getMZipCodeInput$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                access$getMZipCodeInput$p3 = null;
            }
            access$getMZipCodeInput$p3.hideErrorInfo();
        }
        Context context = this.this$0.getContext();
        if (context != null) {
            String str = this.$phone;
            FullKycExtraFragment fullKycExtraFragment = this.this$0;
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            NewPixInputView access$getMZipCodeInput$p4 = fullKycExtraFragment.f30776f;
            if (access$getMZipCodeInput$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            } else {
                newPixInputView = access$getMZipCodeInput$p4;
            }
            companion.putZipCode(context, str, newPixInputView.getInputStr());
        }
        this.this$0.m21666e();
    }
}
