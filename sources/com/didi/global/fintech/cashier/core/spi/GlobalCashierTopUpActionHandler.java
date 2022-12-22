package com.didi.global.fintech.cashier.core.spi;

import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierTopUpActionHandler;
import com.didi.global.fintech.cashier.core.consts.RouterConstKt;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "top_up", value = {IGlobalCashierTopUpActionHandler.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierTopUpActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierTopUpActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierTopUpActionHandler.kt */
public final class GlobalCashierTopUpActionHandler implements IGlobalCashierTopUpActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction) {
        CashierActionData actionData;
        CashierActionData actionData2;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        if (CashierFacade.Companion.getInstance().getTheme().latour()) {
            ((Request) DRouter.build(RouterConstKt.WALLET_BALANCE_TOP_UP).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 8)).start(fragmentActivity);
            return true;
        }
        String str = null;
        if (CashierFacade.Companion.getInstance().getTheme().global()) {
            if (WalletApolloUtil.getTopUpIsNew()) {
                if (!(cashierAction == null || (actionData2 = cashierAction.getActionData()) == null)) {
                    str = actionData2.getPubSource();
                }
                ((Request) DRouter.build(Intrinsics.stringPlus("GuaranaOneTravel://one/ddw_top_up?pub_source=cashier_topup&source=", str)).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 8)).start(fragmentActivity);
                return true;
            }
            ((Request) DRouter.build(RouterConstKt.GLOBAL_BALANCE_TOP_UP).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 8)).start(fragmentActivity);
            return true;
        } else if (!CashierFacade.Companion.getInstance().getTheme().brazil()) {
            return true;
        } else {
            if (WalletApolloUtil.getTopUpIsNew()) {
                if (!(cashierAction == null || (actionData = cashierAction.getActionData()) == null)) {
                    str = actionData.getPubSource();
                }
                ((Request) DRouter.build(Intrinsics.stringPlus("GuaranaOneTravel://one/ddw_top_up?pub_source=cashier_topup&source=", str)).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 8)).start(fragmentActivity);
                return true;
            }
            WalletRouter.gotoTopupOnlinePay(fragmentActivity, 8);
            return true;
        }
    }
}
