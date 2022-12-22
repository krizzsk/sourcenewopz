package com.didi.global.fintech.cashier.core.spi;

import android.content.Intent;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.fintech.cashier.user.facade.CashierResultListener;
import com.didi.global.fintech.cashier.user.model.CashierResult;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/spi/GlobalCashierProcessorImpl$launchForResult$2", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierProcessorImpl.kt */
public final class GlobalCashierProcessorImpl$launchForResult$2 extends RouterCallback.ActivityCallback {
    final /* synthetic */ CashierResultListener $listener;

    GlobalCashierProcessorImpl$launchForResult$2(CashierResultListener cashierResultListener) {
        this.$listener = cashierResultListener;
    }

    public void onActivityResult(int i, Intent intent) {
        String str;
        CashierResult cashierResult = new CashierResult();
        int i2 = 3;
        if (intent != null) {
            i2 = intent.getIntExtra("code", 3);
        }
        cashierResult.setStatus(i2);
        if (intent == null) {
            str = null;
        } else {
            str = intent.getStringExtra("return_url");
        }
        cashierResult.putExtra("return_url", str);
        CashierResultListener cashierResultListener = this.$listener;
        if (cashierResultListener != null) {
            cashierResultListener.onCashierResult(cashierResult);
        }
    }
}
