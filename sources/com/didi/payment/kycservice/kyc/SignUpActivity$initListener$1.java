package com.didi.payment.kycservice.kyc;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/SignUpActivity$initListener$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpActivity.kt */
public final class SignUpActivity$initListener$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ SignUpActivity this$0;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SignUpPageScene.values().length];
            iArr[SignUpPageScene.SIGN_UP_99PAY.ordinal()] = 1;
            iArr[SignUpPageScene.FULL_KYC_EXTRA.ordinal()] = 2;
            iArr[SignUpPageScene.CHOOSE_ID_TYPE.ordinal()] = 3;
            iArr[SignUpPageScene.CHOOSE_KEY_TYPE.ordinal()] = 4;
            iArr[SignUpPageScene.GUIDE.ordinal()] = 5;
            iArr[SignUpPageScene.CHOOSE_ID_TYPE_JUMIO.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpActivity$initListener$1(SignUpActivity signUpActivity) {
        super(800);
        this.this$0 = signUpActivity;
    }

    public void doClick(View view) {
        SignUpPageScene value = SignUpActivity.access$getVm(this.this$0).getPageSceneLD().getValue();
        switch (value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                if (!Intrinsics.areEqual((Object) OmegaComParams.Companion.getPUB_PAGE(), (Object) OmegaComParams.FACE_GUIDE)) {
                    KycOmega.Companion.trackEvent("fin_primarykycinformation_back_ck");
                    break;
                } else {
                    KycOmega.Companion.trackButtonEvent("fin_faceguide_button_ck", 5);
                    break;
                }
            case 2:
                KycOmega.Companion.trackEvent("fin_fullkycinformation_back_ck");
                break;
            case 3:
                KycOmega.Companion.trackEvent("fin_fullkycverification_back_ck");
                break;
            case 4:
                KycOmega.Companion.trackEvent("fin_pixkeyregistration_back_ck");
                break;
            case 5:
                KycOmega.Companion.trackEvent("fin_kycguide_back_ck");
                break;
            case 6:
                KycOmega.Companion.trackButtonEvent("fin_fullkycverification_button_ck", 5);
                break;
        }
        if (!this.this$0.m21610d()) {
            this.this$0.finish();
        }
    }
}
