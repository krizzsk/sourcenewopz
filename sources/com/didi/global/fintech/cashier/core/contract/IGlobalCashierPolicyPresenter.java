package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "onConfirmClick", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalCashierPolicyPresenter extends IGlobalBinderCashierPresenter<PayInfoResponse> {
    void onConfirmClick();
}
