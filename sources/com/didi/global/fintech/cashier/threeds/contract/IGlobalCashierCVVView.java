package com.didi.global.fintech.cashier.threeds.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierHeaderViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "btnView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVBtnViewHolder;", "cvvView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "headerView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "setupView", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierThreeDSViews.kt */
public interface IGlobalCashierCVVView extends IGlobalCashierPayView {
    IGlobalCashierCVVBtnViewHolder btnView();

    IGlobalCashierCVVViewHolder cvvView();

    IGlobalCashierHeaderViewHolder headerView();

    void setupView(CVVInfoResponse cVVInfoResponse);
}
