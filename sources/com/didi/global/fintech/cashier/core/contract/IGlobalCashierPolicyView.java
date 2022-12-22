package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierHeaderViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "btnView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "headerView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "policyView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "setupView", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "showUncheckTip", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViews.kt */
public interface IGlobalCashierPolicyView extends IGlobalCashierPayView {
    IGlobalCashierPayBtnViewHolder btnView();

    IGlobalCashierHeaderViewHolder headerView();

    IGlobalCashierPolicyViewHolder policyView();

    void setupView(PayInfoResponse payInfoResponse);

    void showUncheckTip();
}
