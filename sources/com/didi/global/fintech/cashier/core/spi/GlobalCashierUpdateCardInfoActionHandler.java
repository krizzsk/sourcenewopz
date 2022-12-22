package com.didi.global.fintech.cashier.core.spi;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierUpdateCardInfoActionHandler;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier_update_card_info", value = {IGlobalCashierUpdateCardInfoActionHandler.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierUpdateCardInfoActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierUpdateCardInfoActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierUpdateCardInfoActionHandler.kt */
public final class GlobalCashierUpdateCardInfoActionHandler implements IGlobalCashierUpdateCardInfoActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction) {
        CashierActionData cashierActionData;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        GlobalCashierUpdateCardInfoActionHandler globalCashierUpdateCardInfoActionHandler = this;
        if (((cashierAction != null && cashierAction.updateCardInfo()) && cashierAction.getActionData() != null ? this : null) == null) {
            return false;
        }
        if (cashierAction == null) {
            cashierActionData = null;
        } else {
            cashierActionData = cashierAction.getActionData();
        }
        if (cashierActionData != null) {
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = 4;
            addCardParam.isSignAfterOrder = true;
            String productId = cashierActionData.getProductId();
            String str = "";
            if (productId == null) {
                productId = str;
            }
            addCardParam.productLine = productId;
            addCardParam.orderId = null;
            String cardNo = cashierActionData.getCardNo();
            if (cardNo != null) {
                str = cardNo;
            }
            addCardParam.cardNo = str;
            DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, 2, addCardParam);
        }
        return true;
    }
}
