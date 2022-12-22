package com.didi.payment.kycservice.kyc.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.IDTypeVM;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/IDTypeFragment$onEvent$1", "Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM$CheckListener;", "onSuccess", "", "resultEntryFormat", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IDTypeFragment.kt */
public final class IDTypeFragment$onEvent$1 implements IDTypeVM.CheckListener {
    final /* synthetic */ IDTypeFragment this$0;

    IDTypeFragment$onEvent$1(IDTypeFragment iDTypeFragment) {
        this.this$0 = iDTypeFragment;
    }

    public void onSuccess(ResultPageData resultPageData) {
        FragmentActivity activity;
        if (resultPageData == null) {
            SignUpVM access$getPixSignUpVM$p = this.this$0.f30806f;
            if (access$getPixSignUpVM$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p = null;
            }
            if (access$getPixSignUpVM$p.updatePageSceneByStepList() && (activity = this.this$0.getActivity()) != null) {
                activity.finish();
                return;
            }
            return;
        }
        KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(this.this$0.getContext(), resultPageData);
    }
}
