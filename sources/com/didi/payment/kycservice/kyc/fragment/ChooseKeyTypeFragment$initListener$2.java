package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.fragment.SignUpRvAdapter;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/ChooseKeyTypeFragment$initListener$2", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;", "onItemClick", "", "item", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseKeyTypeFragment.kt */
public final class ChooseKeyTypeFragment$initListener$2 implements SignUpRvAdapter.ItemClickListener {
    final /* synthetic */ ChooseKeyTypeFragment this$0;

    ChooseKeyTypeFragment$initListener$2(ChooseKeyTypeFragment chooseKeyTypeFragment) {
        this.this$0 = chooseKeyTypeFragment;
    }

    public void onItemClick(PixChooseTypeListResp.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.this$0.m21642a(item);
        int type = item.getType();
        KycOmega.Companion.trackEvent(type != 1 ? type != 2 ? type != 3 ? type != 4 ? "" : "ibt_didipay_registration_random_key_ck" : "ibt_didipay_registration_mobile_ck" : "ibt_didipay_registration_email_ck" : "ibt_didipay_registration_cpf_ck");
    }
}
