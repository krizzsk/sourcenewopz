package com.didi.payment.wallet.global.riskcontrol;

import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/riskcontrol/RiskControlHandler$handle$1", "Lcom/didi/payment/wallet/global/riskcontrol/IRiskControlCallback;", "onResult", "", "rel", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiskControlHandler.kt */
public final class RiskControlHandler$handle$1 implements IRiskControlCallback {
    final /* synthetic */ Request $request;
    final /* synthetic */ Result $result;

    RiskControlHandler$handle$1(Result result, Request request) {
        this.$result = result;
        this.$request = request;
    }

    public void onResult(int i) {
        this.$result.putExtra("result", i);
        RouterHelper.release(this.$request);
    }
}
