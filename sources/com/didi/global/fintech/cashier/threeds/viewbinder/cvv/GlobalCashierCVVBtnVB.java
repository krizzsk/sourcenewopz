package com.didi.global.fintech.cashier.threeds.viewbinder.cvv;

import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVBtnViewHolder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCCVBtnViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCVVBtnVB;", "Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCCVBaseVB;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVBtnViewHolder;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCCVBtnViewBinder;", "presenter", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "(Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;)V", "onBtnClick", "", "setupView", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "updateBtn", "clickable", "", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVBtnVB.kt */
public final class GlobalCashierCVVBtnVB extends GlobalCashierCCVBaseVB<IGlobalCashierCVVBtnViewHolder> implements IGlobalCashierCCVBtnViewBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCVVBtnVB(IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter) {
        super(iGlobalCashierCVVPresenter);
        Intrinsics.checkNotNullParameter(iGlobalCashierCVVPresenter, "presenter");
    }

    public void setupView(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "data");
        super.setupView(cVVInfoResponse);
        IGlobalCashierCVVBtnViewHolder iGlobalCashierCVVBtnViewHolder = (IGlobalCashierCVVBtnViewHolder) getViewHolder();
        if (iGlobalCashierCVVBtnViewHolder != null) {
            iGlobalCashierCVVBtnViewHolder.updateBrandInfo(cVVInfoResponse.getBrandLogo());
        }
        IGlobalCashierCVVBtnViewHolder iGlobalCashierCVVBtnViewHolder2 = (IGlobalCashierCVVBtnViewHolder) getViewHolder();
        if (iGlobalCashierCVVBtnViewHolder2 != null) {
            iGlobalCashierCVVBtnViewHolder2.updateBtn(false, (String) null, new GlobalCashierCVVBtnVB$setupView$1(this));
        }
    }

    public void updateBtn(boolean z) {
        IGlobalCashierCVVBtnViewHolder iGlobalCashierCVVBtnViewHolder = (IGlobalCashierCVVBtnViewHolder) getViewHolder();
        if (iGlobalCashierCVVBtnViewHolder != null) {
            iGlobalCashierCVVBtnViewHolder.updateBtn(z, (String) null, new GlobalCashierCVVBtnVB$updateBtn$1(this));
        }
    }

    public void onBtnClick() {
        getPresenter().onConfirmClick();
    }
}
