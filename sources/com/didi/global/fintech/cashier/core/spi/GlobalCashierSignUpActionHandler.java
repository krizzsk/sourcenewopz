package com.didi.global.fintech.cashier.core.spi;

import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierSignUpActionHandler;
import com.didi.global.fintech.cashier.core.consts.RouterConstKt;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "sign_up", value = {IGlobalCashierSignUpActionHandler.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierSignUpActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierSignUpActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierSignUpActionHandler.kt */
public final class GlobalCashierSignUpActionHandler implements IGlobalCashierSignUpActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        if (CashierFacade.Companion.getInstance().getTheme().latour()) {
            ((Request) DRouter.build(RouterConstKt.WALLET_BALANCE_SIGN_UP).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 10)).start(fragmentActivity);
            return true;
        }
        WalletRouter.gotoTopUpChannelPage(fragmentActivity, 10);
        return true;
    }
}
