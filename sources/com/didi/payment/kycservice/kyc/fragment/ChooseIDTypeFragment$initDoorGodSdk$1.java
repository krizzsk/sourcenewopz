package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.safety.god.IClientAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment$initDoorGodSdk$1", "Lcom/didi/safety/god/IClientAppInfo;", "getA3", "", "getLat", "", "getLng", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseIDTypeFragment.kt */
public final class ChooseIDTypeFragment$initDoorGodSdk$1 implements IClientAppInfo {
    final /* synthetic */ ChooseIDTypeFragment this$0;

    ChooseIDTypeFragment$initDoorGodSdk$1(ChooseIDTypeFragment chooseIDTypeFragment) {
        this.this$0 = chooseIDTypeFragment;
    }

    public double getLat() {
        try {
            String stringParam = PayBaseParamUtil.getStringParam(this.this$0.getContext(), "lat");
            Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.LATITUDE)");
            return Double.parseDouble(stringParam);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getLng() {
        try {
            String stringParam = PayBaseParamUtil.getStringParam(this.this$0.getContext(), "lng");
            Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.LONGITUDE)");
            return Double.parseDouble(stringParam);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public String getA3() {
        String stringParam = PayBaseParamUtil.getStringParam(this.this$0.getContext(), "a3");
        Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.A3)");
        return stringParam;
    }
}
