package com.didi.global.fintech.cashier.core.spi;

import com.didi.global.fintech.cashier.core.action.IGlobalCashierCloseCashierActionHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider(alias = "close_cashier", value = {IGlobalCashierCloseCashierActionHandler.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierCloseCashierActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierCloseCashierActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCloseCashierActionHandler.kt */
public final class GlobalCashierCloseCashierActionHandler implements IGlobalCashierCloseCashierActionHandler {
    public void onDestroy() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r5 = r5.getActionData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(androidx.fragment.app.FragmentActivity r4, com.didi.global.fintech.cashier.model.net.request.CashierAction r5) {
        /*
            r3 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            if (r5 != 0) goto L_0x000a
        L_0x0008:
            r5 = r0
            goto L_0x0015
        L_0x000a:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r5 = r5.getActionData()
            if (r5 != 0) goto L_0x0011
            goto L_0x0008
        L_0x0011:
            java.lang.String r5 = r5.getCallbackStatus()
        L_0x0015:
            java.lang.String r1 = "success"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            r1 = 1
            if (r5 == 0) goto L_0x0021
            r5 = 1
            goto L_0x0022
        L_0x0021:
            r5 = 2
        L_0x0022:
            boolean r2 = r4 instanceof com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback
            if (r2 == 0) goto L_0x0029
            r0 = r4
            com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback r0 = (com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback) r0
        L_0x0029:
            if (r0 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            r0.onCashierClose(r5)
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.spi.GlobalCashierCloseCashierActionHandler.handle(androidx.fragment.app.FragmentActivity, com.didi.global.fintech.cashier.model.net.request.CashierAction):boolean");
    }
}
