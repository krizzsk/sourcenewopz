package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayBtnViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.ShowInfo;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierPayBtnViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayBtnViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;)V", "disableBtn", "", "onPayClick", "setupView", "data", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPayBtnViewBinder.kt */
public final class GlobalCashierPayBtnViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierPayBtnViewHolder, IGlobalMainCashierPresenter, PayInfoResponse> implements IGlobalCashierPayBtnViewBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPayBtnViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter) {
        super(iGlobalMainCashierPresenter);
        Intrinsics.checkNotNullParameter(iGlobalMainCashierPresenter, "presenter");
    }

    public void onPayClick() {
        ((IGlobalMainCashierPresenter) getPresenter()).onPayBtnClick();
    }

    public void disableBtn() {
        IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder = (IGlobalCashierPayBtnViewHolder) getViewHolder();
        if (iGlobalCashierPayBtnViewHolder != null) {
            iGlobalCashierPayBtnViewHolder.updateBtn(false, ((IGlobalMainCashierPresenter) getPresenter()).getString(R.string.Wallet_App_V2_Select_Payment_Fbby), new GlobalCashierPayBtnViewBinder$disableBtn$1(this));
        }
    }

    public void setupView(PayInfoResponse payInfoResponse) {
        ShowInfo showInfo;
        ShowInfo showInfo2;
        Boolean payButtonEnable;
        super.setupView(payInfoResponse);
        IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder = (IGlobalCashierPayBtnViewHolder) getViewHolder();
        if (iGlobalCashierPayBtnViewHolder != null) {
            boolean z = false;
            if (!(payInfoResponse == null || (showInfo2 = payInfoResponse.getShowInfo()) == null || (payButtonEnable = showInfo2.getPayButtonEnable()) == null)) {
                z = payButtonEnable.booleanValue();
            }
            String str = null;
            if (!(payInfoResponse == null || (showInfo = payInfoResponse.getShowInfo()) == null)) {
                str = showInfo.getPayButton();
            }
            iGlobalCashierPayBtnViewHolder.updateBtn(z, str, new GlobalCashierPayBtnViewBinder$setupView$1(this));
        }
    }
}
