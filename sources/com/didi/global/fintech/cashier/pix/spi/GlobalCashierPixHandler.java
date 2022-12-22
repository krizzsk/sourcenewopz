package com.didi.global.fintech.cashier.pix.spi;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierPixActionHandler;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.pix.GlobalCashierPixDialog;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixView;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {IGlobalCashierPixActionHandler.class})
@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/spi/GlobalCashierPixHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierPixActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "uniqueId", "", "onDestroy", "", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPixHandler.kt */
public final class GlobalCashierPixHandler implements IGlobalCashierPixActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction, CashierParam cashierParam, String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        GlobalCashierPixHandler globalCashierPixHandler = this;
        if (((cashierAction != null && cashierAction.pix()) && cashierParam != null ? this : null) == null) {
            return false;
        }
        GlobalCashierPixDialog.Companion companion = GlobalCashierPixDialog.Companion;
        IGlobalCashierPixView.Type type = IGlobalCashierPixView.Type.Normal;
        Intrinsics.checkNotNull(cashierAction);
        Intrinsics.checkNotNull(cashierParam);
        GlobalCashierPixDialog newInstance = companion.newInstance(type, cashierAction, cashierParam, str);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        newInstance.show(supportFragmentManager, GlobalCashierPixDialog.class.getSimpleName());
        return true;
    }
}
