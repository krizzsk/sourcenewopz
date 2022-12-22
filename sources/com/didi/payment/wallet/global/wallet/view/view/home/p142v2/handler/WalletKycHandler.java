package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt;
import com.didi.sdk.apm.SystemUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletKycHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletKycHandler */
/* compiled from: WalletKycHandler.kt */
public final class WalletKycHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Integer num;
        String kycStatus;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        SystemUtils.log(3, "kyc_test", "page = WalletKycHandler.handle  url={" + request.getUri() + '}', (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletKycHandler", 19);
        Serializable serializable = request.getSerializable("accountSection");
        AccountSection accountSection = serializable instanceof AccountSection ? (AccountSection) serializable : null;
        boolean z = false;
        if (accountSection == null || (kycStatus = accountSection.getKycStatus()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(WalletHomeModelKt.toDefaultInt$default(kycStatus, 0, 1, (Object) null));
        }
        if (num != null && num.intValue() == 0) {
            DRouter.build("99pay://one/register").start(request.getContext());
        } else if (num != null && num.intValue() == 3) {
            WalletRouter.gotoFailedReasonPage(request.getContext(), accountSection.getAccountStatus());
        } else if (num != null && num.intValue() == 2) {
            WalletRouter.gotoSignUpWaitingPage(request.getContext(), accountSection.getAccountStatus());
        } else if (num != null && num.intValue() == 1 && Intrinsics.areEqual((Object) accountSection.getSupportFullKyc(), (Object) true)) {
            String fullKycStatus = accountSection.getFullKycStatus();
            if (fullKycStatus != null && WalletHomeModelKt.toDefaultInt$default(fullKycStatus, 0, 1, (Object) null) == 1) {
                z = true;
            }
            if (!z) {
                WalletRouter.gotoFullKycRegisterPage(request.getContext(), 1);
            }
        }
    }
}
