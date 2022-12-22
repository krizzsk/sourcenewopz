package com.didi.payment.wallet.global.riskcontrol;

import com.didi.payment.wallet.global.riskcontrol.FaceVerify;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/riskcontrol/RiskControlManager$verify$1", "Lcom/didi/payment/wallet/global/riskcontrol/FaceVerify$IFaceCallback;", "onResult", "", "result", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiskControlManager.kt */
public final class RiskControlManager$verify$1 implements FaceVerify.IFaceCallback {
    final /* synthetic */ IRiskControlCallback $callback;

    RiskControlManager$verify$1(IRiskControlCallback iRiskControlCallback) {
        this.$callback = iRiskControlCallback;
    }

    public void onResult(int i) {
        this.$callback.onResult(i);
    }
}
