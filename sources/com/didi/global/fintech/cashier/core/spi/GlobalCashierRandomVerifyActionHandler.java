package com.didi.global.fintech.cashier.core.spi;

import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierRandomVerifyActionHandler;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier_random_verify", value = {IGlobalCashierRandomVerifyActionHandler.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierRandomVerifyActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierRandomVerifyActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierRandomVerifyActionHandler.kt */
public final class GlobalCashierRandomVerifyActionHandler implements IGlobalCashierRandomVerifyActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        GlobalCashierRandomVerifyActionHandler globalCashierRandomVerifyActionHandler = this;
        CashierActionData cashierActionData = null;
        if (((cashierAction != null && cashierAction.randomVerify()) && cashierAction.getActionData() != null ? this : null) == null) {
            return false;
        }
        if (cashierAction != null) {
            cashierActionData = cashierAction.getActionData();
        }
        if (cashierActionData != null) {
            DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
            String cardIndex = cashierActionData.getCardIndex();
            String str = "";
            if (cardIndex == null) {
                cardIndex = str;
            }
            verifyCardParam.cardIndex = cardIndex;
            String cardNo = cashierActionData.getCardNo();
            if (cardNo != null) {
                str = cardNo;
            }
            verifyCardParam.cardNo = str;
            DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(fragmentActivity, 6, verifyCardParam);
        }
        return true;
    }
}
