package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FullKycExtraFragment.kt */
final class FullKycExtraFragment$initListener$13 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $phone;
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$initListener$13(FullKycExtraFragment fullKycExtraFragment, String str) {
        super(0);
        this.this$0 = fullKycExtraFragment;
        this.$phone = str;
    }

    public final void invoke() {
        Context context = this.this$0.getContext();
        if (context != null) {
            String str = this.$phone;
            FullKycExtraFragment fullKycExtraFragment = this.this$0;
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            NewPixInputView access$getMStreetInput$p = fullKycExtraFragment.f30778h;
            if (access$getMStreetInput$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                access$getMStreetInput$p = null;
            }
            companion.putStreet(context, str, access$getMStreetInput$p.getInputStr());
        }
    }
}
