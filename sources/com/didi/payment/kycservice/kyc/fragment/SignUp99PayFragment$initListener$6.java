package com.didi.payment.kycservice.kyc.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUp99PayFragment.kt */
final class SignUp99PayFragment$initListener$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $phone;
    final /* synthetic */ SignUp99PayFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUp99PayFragment$initListener$6(SignUp99PayFragment signUp99PayFragment, String str) {
        super(0);
        this.this$0 = signUp99PayFragment;
        this.$phone = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r7 = this;
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r0 = r7.this$0
            boolean r0 = r0.m21714h()
            r1 = 0
            java.lang.String r2 = "mCPFInput"
            if (r0 != 0) goto L_0x0047
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r0 = r7.this$0
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r0.f30814d
            if (r0 != 0) goto L_0x0017
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x0017:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x0029
            goto L_0x0047
        L_0x0029:
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r0 = r7.this$0
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r0.f30814d
            if (r0 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x0035:
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r3 = r7.this$0
            r4 = 2131951765(0x7f130095, float:1.9539954E38)
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "getString(R.string.Finte…ization_Please_fill_zqsp)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.showErrorInfo(r3)
            goto L_0x0056
        L_0x0047:
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r0 = r7.this$0
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r0.f30814d
            if (r0 != 0) goto L_0x0053
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x0053:
            r0.hideErrorInfo()
        L_0x0056:
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r0 = r7.this$0
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x005f
            goto L_0x007c
        L_0x005f:
            java.lang.String r3 = r7.$phone
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r4 = r7.this$0
            com.didi.payment.kycservice.utils.KycSPUtils$Companion r5 = com.didi.payment.kycservice.utils.KycSPUtils.Companion
            java.lang.String r6 = "phone"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            com.didi.payment.kycservice.widget.NewPixInputView r4 = r4.f30814d
            if (r4 != 0) goto L_0x0074
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0075
        L_0x0074:
            r1 = r4
        L_0x0075:
            java.lang.String r1 = r1.getInputStr()
            r5.putCPF(r0, r3, r1)
        L_0x007c:
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r0 = r7.this$0
            r0.m21710f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment$initListener$6.invoke():void");
    }
}
