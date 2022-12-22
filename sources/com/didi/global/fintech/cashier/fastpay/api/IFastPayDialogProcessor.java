package com.didi.global.fintech.cashier.fastpay.api;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayDialogProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "netError", "", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter$API;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayDialogProcessor.kt */
public interface IFastPayDialogProcessor extends IFastPayBaseProcessor {
    void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api);

    void netError(CashierError cashierError, IFastPayNetPresenter.API api);
}
