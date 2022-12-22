package com.pay99.diff_passenger;

import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/pay99/diff_passenger/PassengerDiff;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerDiff.kt */
public final class PassengerDiff implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!DiffUtil.INSTANCE.isInit()) {
            DiffUtil.INSTANCE.putDiffValue(DiffConstants.DIFF_WALLET_TOAST, new PassengerToast());
            DiffUtil.INSTANCE.putDiffValue(DiffConstants.DIFF_WALLET_GUIDE, new PassengerKycGuideRule());
            DiffUtil.INSTANCE.putDiffValue(DiffConstants.DIFF_WALLET_TRACK, new PassengerTrackEvent());
            DiffUtil.INSTANCE.putDiffValue(DiffConstants.DIFF_WALLET_TRANSFER_AMOUNT_TIP, new PassengerTransferAmountTip());
            DiffUtil.INSTANCE.putDiffValue(DiffConstants.DIFF_WALLET_THEME, new PassengerTheme());
            DiffUtil.INSTANCE.putDiffValue(DiffConstants.DIFF_WALLET_DCRYPTO, new PassengerDcrypto());
            DiffUtil.INSTANCE.setInit(true);
        }
    }
}
