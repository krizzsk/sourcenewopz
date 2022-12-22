package com.didi.payment.wallet.global.wallet.delegate;

import com.didi.drouter.api.DRouter;
import com.didi.payment.commonsdk.global.WalletGlobal;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.scan.delegate.ViewClickDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "pixcode", value = {ViewClickDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/delegate/ScanClickDelegateImpl;", "Lcom/didiglobal/scan/delegate/ViewClickDelegate;", "()V", "onEnterPinClick", "", "scheme", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScanClickDelegateImpl.kt */
public final class ScanClickDelegateImpl implements ViewClickDelegate {
    public void onEnterPinClick(String str) {
        Intrinsics.checkNotNullParameter(str, "scheme");
        DRouter.build(str).start(WalletGlobal.getAppContext());
    }
}
