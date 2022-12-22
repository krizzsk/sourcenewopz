package com.didi.global.fintech.cashier.threeds.viewbinder.cvv;

import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierHeaderViewHolder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCCVHeaderViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCVVHeaderVB;", "Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCCVBaseVB;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCCVHeaderViewBinder;", "presenter", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "(Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;)V", "onBackClick", "", "setupView", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVHeaderVB.kt */
public final class GlobalCashierCVVHeaderVB extends GlobalCashierCCVBaseVB<IGlobalCashierHeaderViewHolder> implements IGlobalCashierCCVHeaderViewBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCVVHeaderVB(IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter) {
        super(iGlobalCashierCVVPresenter);
        Intrinsics.checkNotNullParameter(iGlobalCashierCVVPresenter, "presenter");
    }

    public void setupView(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "data");
        super.setupView(cVVInfoResponse);
        IGlobalCashierHeaderViewHolder iGlobalCashierHeaderViewHolder = (IGlobalCashierHeaderViewHolder) getViewHolder();
        if (iGlobalCashierHeaderViewHolder != null) {
            iGlobalCashierHeaderViewHolder.updateHeaderInfo(new GlobalCashierCVVHeaderVB$setupView$1(this));
        }
    }

    public void onBackClick() {
        getPresenter().onBackPressed();
    }
}
