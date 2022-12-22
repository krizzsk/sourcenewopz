package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.p117ui.viewholder.MerchantButtonData;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "onBottomBtnClick", "", "button", "Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalCashierResultPresenter extends IGlobalBinderCashierPresenter<SuccessInfoResponse> {
    void onBottomBtnClick(MerchantButtonData merchantButtonData);
}
