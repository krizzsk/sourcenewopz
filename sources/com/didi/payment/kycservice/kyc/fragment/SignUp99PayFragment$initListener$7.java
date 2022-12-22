package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.widget.CompoundButton;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.utils.KycSPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment$initListener$7", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUp99PayFragment.kt */
public final class SignUp99PayFragment$initListener$7 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ String $phone;
    final /* synthetic */ SignUp99PayFragment this$0;

    SignUp99PayFragment$initListener$7(SignUp99PayFragment signUp99PayFragment, String str) {
        this.this$0 = signUp99PayFragment;
        this.$phone = str;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AutoTrackHelper.trackViewOnClick(compoundButton, z);
        this.this$0.m21710f();
        KycOmega.Companion.trackEvent("gp_99pay_information_clause_ck");
        Context context = this.this$0.getContext();
        if (context != null) {
            String str = this.$phone;
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            companion.setCheckedTc(context, str, z);
        }
    }
}
