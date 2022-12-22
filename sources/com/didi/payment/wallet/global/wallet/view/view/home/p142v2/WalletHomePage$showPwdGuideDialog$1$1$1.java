package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import com.didi.raven.config.RavenKey;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomePage$showPwdGuideDialog$1$1$1", "Lcom/didiglobal/pay/paysecure/SetPwdResultListener;", "onFailure", "", "s", "", "s1", "onSuccess", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage$showPwdGuideDialog$1$1$1 */
/* compiled from: WalletHomePage.kt */
public final class WalletHomePage$showPwdGuideDialog$1$1$1 implements SetPwdResultListener {
    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, RavenKey.STACK);
        Intrinsics.checkNotNullParameter(str2, "s1");
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, RavenKey.STACK);
    }

    WalletHomePage$showPwdGuideDialog$1$1$1() {
    }
}
