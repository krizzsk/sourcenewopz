package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "paySuccessView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierResultPayViewHolder;", "setupView", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViews.kt */
public interface IGlobalCashierResultView extends IGlobalCashierPayView {
    IGlobalCashierResultPayViewHolder paySuccessView();

    void setupView(SuccessInfoResponse successInfoResponse);
}
