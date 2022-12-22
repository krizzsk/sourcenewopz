package com.didi.global.fintech.cashier.threeds.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter;
import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\bH&J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "addViewBinder", "", "binder", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "onBackPressed", "", "onCVVDrawerClick", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "onConfirmClick", "updateCardInfo", "cardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierThreeDSPresenters.kt */
public interface IGlobalCashierCVVPresenter extends IGlobalBizCashierPresenter {
    boolean addViewBinder(IGlobalCashierCVVBaseViewBinder<? extends IGlobalCashierBaseViewHolder> iGlobalCashierCVVBaseViewBinder);

    void onBackPressed();

    void onCVVDrawerClick(CVVDrawerData cVVDrawerData);

    void onConfirmClick();

    void updateCardInfo(CVVCardInfo cVVCardInfo);
}
