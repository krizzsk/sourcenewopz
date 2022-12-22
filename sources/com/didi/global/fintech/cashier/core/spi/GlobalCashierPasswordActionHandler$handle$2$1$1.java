package com.didi.global.fintech.cashier.core.spi;

import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/spi/GlobalCashierPasswordActionHandler$handle$2$1$1", "Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "token", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPasswordActionHandler.kt */
public final class GlobalCashierPasswordActionHandler$handle$2$1$1 implements PayPwdResultListener {
    final /* synthetic */ FragmentActivity $activity;

    GlobalCashierPasswordActionHandler$handle$2$1$1(FragmentActivity fragmentActivity) {
        this.$activity = fragmentActivity;
    }

    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        FragmentActivity fragmentActivity = this.$activity;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            if (str2 == null) {
                str2 = "";
            }
            iGlobalCashierActionHandleCallback.onPasswordFailed(str, str2);
        }
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        FragmentActivity fragmentActivity = this.$activity;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPasswordSuccess(str);
        }
    }
}
