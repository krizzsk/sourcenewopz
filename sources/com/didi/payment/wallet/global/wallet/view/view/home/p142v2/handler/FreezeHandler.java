package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import com.didi.drouter.router.IRouterHandler;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/FreezeHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.FreezeHandler */
/* compiled from: FreezeHandler.kt */
public final class FreezeHandler implements IRouterHandler {
    /* JADX WARNING: type inference failed for: r4v1, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handle(com.didi.drouter.router.Request r4, com.didi.drouter.router.Result r5) {
        /*
            r3 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r5 = "key"
            java.io.Serializable r5 = r4.getSerializable(r5)
            boolean r0 = r5 instanceof com.didi.payment.commonsdk.basemodel.account.AccountFreezeData
            r1 = 0
            if (r0 == 0) goto L_0x0018
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r5 = (com.didi.payment.commonsdk.basemodel.account.AccountFreezeData) r5
            goto L_0x0019
        L_0x0018:
            r5 = r1
        L_0x0019:
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData$Builder r5 = com.didi.payment.commonsdk.basemodel.account.AccountFreezeData.Builder.from(r5)
            android.content.Context r0 = r4.getContext()
            r2 = 2131952608(0x7f1303e0, float:1.9541664E38)
            java.lang.String r0 = com.didi.sdk.util.ResourcesHelper.getString(r0, r2)
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData$Builder r5 = r5.btnPos((java.lang.String) r0)
            android.content.Context r0 = r4.getContext()
            r2 = 2131952970(0x7f13054a, float:1.9542398E38)
            java.lang.String r0 = com.didi.sdk.util.ResourcesHelper.getString(r0, r2)
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData$Builder r5 = r5.btnNeg((java.lang.String) r0)
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r5 = r5.build()
            android.content.Context r4 = r4.getContext()
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L_0x004a
            r1 = r4
            android.app.Activity r1 = (android.app.Activity) r1
        L_0x004a:
            com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler.FreezeHandler.handle(com.didi.drouter.router.Request, com.didi.drouter.router.Result):void");
    }
}
