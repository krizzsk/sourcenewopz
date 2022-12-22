package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.safety.god.IClientAppFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment$initDoorGodSdk$2", "Lcom/didi/safety/god/IClientAppFunction;", "openCustomerService", "", "openUrl", "url", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseIDTypeFragment.kt */
public final class ChooseIDTypeFragment$initDoorGodSdk$2 implements IClientAppFunction {
    final /* synthetic */ ChooseIDTypeFragment this$0;

    public void openCustomerService() {
    }

    ChooseIDTypeFragment$initDoorGodSdk$2(ChooseIDTypeFragment chooseIDTypeFragment) {
        this.this$0 = chooseIDTypeFragment;
    }

    public void openUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        WebBrowserUtil.startInternalWebActivity(this.this$0.getContext(), str, "");
    }
}
