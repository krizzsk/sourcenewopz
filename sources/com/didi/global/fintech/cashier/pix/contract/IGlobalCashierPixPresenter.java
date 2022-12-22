package com.didi.global.fintech.cashier.pix.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayPresenter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayPresenter;", "onCancelClick", "", "onConfirmClick", "onPaidClick", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPixPresenter.kt */
public interface IGlobalCashierPixPresenter extends IGlobalCashierPayPresenter {
    void onCancelClick();

    void onConfirmClick();

    void onPaidClick();
}
