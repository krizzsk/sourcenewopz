package com.didi.payment.wallet.global.riskcontrol;

import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/RiskControlHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiskControlHandler.kt */
public final class RiskControlHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        RiskControlManager.INSTANCE.startRiskControl(request.getContext(), request.getString("type"), request.getString("face_session_id"), request.getString("biz_code"), request.getString("scene"), request.getString("session_id"), new RiskControlHandler$handle$1(result, request));
    }
}
