package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayBtnViewBinder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "disableBtn", "", "onPayClick", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViewBinders.kt */
public interface IGlobalCashierPayBtnViewBinder extends IGlobalCashierBaseViewBinder<IGlobalCashierPayBtnViewHolder, PayInfoResponse> {
    void disableBtn();

    void onPayClick();
}
