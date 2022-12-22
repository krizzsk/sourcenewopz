package com.didi.global.fintech.cashier.core.viewbinder.policy;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyBtnViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyPresenter;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PolicyInfo;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/policy/GlobalCashierPolicyBtnViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyBtnViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;)V", "defaultVisible", "", "onConfirmClick", "", "setupView", "data", "updateBtnStatus", "selected", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyBtnViewBinder.kt */
public final class GlobalCashierPolicyBtnViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierPayBtnViewHolder, IGlobalCashierPolicyPresenter, PayInfoResponse> implements IGlobalCashierPolicyBtnViewBinder {
    public boolean defaultVisible() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPolicyBtnViewBinder(IGlobalCashierPolicyPresenter iGlobalCashierPolicyPresenter) {
        super(iGlobalCashierPolicyPresenter);
        Intrinsics.checkNotNullParameter(iGlobalCashierPolicyPresenter, "presenter");
    }

    public void onConfirmClick() {
        ((IGlobalCashierPolicyPresenter) getPresenter()).onConfirmClick();
    }

    public void setupView(PayInfoResponse payInfoResponse) {
        super.setupView(payInfoResponse);
        updateBtnStatus(true);
    }

    public void updateBtnStatus(boolean z) {
        PolicyInfo policyInfo;
        IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder = (IGlobalCashierPayBtnViewHolder) getViewHolder();
        if (iGlobalCashierPayBtnViewHolder != null) {
            PayInfoResponse payInfoResponse = (PayInfoResponse) getSrcData();
            String str = null;
            if (!(payInfoResponse == null || (policyInfo = payInfoResponse.getPolicyInfo()) == null)) {
                str = policyInfo.getAgreeText();
            }
            iGlobalCashierPayBtnViewHolder.updateBtn(z, str, new GlobalCashierPolicyBtnViewBinder$updateBtnStatus$1(this));
        }
    }
}
