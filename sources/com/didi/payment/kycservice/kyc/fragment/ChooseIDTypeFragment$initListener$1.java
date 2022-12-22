package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.fragment.SignUpRvAdapter;
import com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment$initListener$1", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;", "onItemClick", "", "item", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseIDTypeFragment.kt */
public final class ChooseIDTypeFragment$initListener$1 implements SignUpRvAdapter.ItemClickListener {
    final /* synthetic */ ChooseIDTypeFragment this$0;

    ChooseIDTypeFragment$initListener$1(ChooseIDTypeFragment chooseIDTypeFragment) {
        this.this$0 = chooseIDTypeFragment;
    }

    public void onItemClick(PixChooseTypeListResp.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SignUpVM signUpVM = null;
        if (item.getType() == 2001) {
            ChooseIDTypeFragment.access$getVm(this.this$0).setSource(item.getSource());
            ChooseIDTypeFragment.access$getVm(this.this$0).setVerifyFaceType(2001);
            ChooseIDTypeVM access$getVm = ChooseIDTypeFragment.access$getVm(this.this$0);
            SignUpVM access$getPixSignUpVM$p = this.this$0.f30754b;
            if (access$getPixSignUpVM$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p = null;
            }
            String pageSource = access$getPixSignUpVM$p.getPageSource();
            SignUpVM access$getPixSignUpVM$p2 = this.this$0.f30754b;
            if (access$getPixSignUpVM$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            } else {
                signUpVM = access$getPixSignUpVM$p2;
            }
            access$getVm.reqDoorGodInitInfo(2001, pageSource, signUpVM.getFromPrimary());
            this.this$0.f30755c = 2001;
            KycOmega.Companion.trackEvent("ibt_didipay_verification_cnh_ck");
        } else if (item.getType() == 2002) {
            ChooseIDTypeFragment.access$getVm(this.this$0).setSource(item.getSource());
            ChooseIDTypeFragment.access$getVm(this.this$0).setVerifyFaceType(2002);
            ChooseIDTypeVM access$getVm2 = ChooseIDTypeFragment.access$getVm(this.this$0);
            SignUpVM access$getPixSignUpVM$p3 = this.this$0.f30754b;
            if (access$getPixSignUpVM$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p3 = null;
            }
            String pageSource2 = access$getPixSignUpVM$p3.getPageSource();
            SignUpVM access$getPixSignUpVM$p4 = this.this$0.f30754b;
            if (access$getPixSignUpVM$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            } else {
                signUpVM = access$getPixSignUpVM$p4;
            }
            access$getVm2.reqDoorGodInitInfo(2002, pageSource2, signUpVM.getFromPrimary());
            this.this$0.f30755c = 2002;
            KycOmega.Companion.trackEvent("ibt_didipay_verification_rg_ck");
        }
    }
}
