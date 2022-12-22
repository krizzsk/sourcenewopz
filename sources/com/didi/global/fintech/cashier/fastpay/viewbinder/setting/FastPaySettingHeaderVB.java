package com.didi.global.fintech.cashier.fastpay.viewbinder.setting;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingHeaderViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingPresenter;
import com.didi.global.fintech.cashier.fastpay.viewbinder.FastPayBaseVB;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IFastPayHeaderViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/viewbinder/setting/FastPaySettingHeaderVB;", "Lcom/didi/global/fintech/cashier/fastpay/viewbinder/FastPayBaseVB;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;", "Lcom/didi/global/fintech/cashier/ui/IFastPayHeaderViewHolder;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingHeaderViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;)V", "onBackClick", "", "setupView", "data", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingHeaderVB.kt */
public final class FastPaySettingHeaderVB extends FastPayBaseVB<FastPayInfoResponse, IFastPaySettingPresenter, IFastPayHeaderViewHolder> implements IFastPaySettingHeaderViewBinder<FastPayInfoResponse> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySettingHeaderVB(IFastPaySettingPresenter iFastPaySettingPresenter) {
        super(iFastPaySettingPresenter);
        Intrinsics.checkNotNullParameter(iFastPaySettingPresenter, "presenter");
    }

    public void onBackClick() {
        ((IFastPaySettingPresenter) getPresenter()).onBackPressed();
    }

    public void setupView(FastPayInfoResponse fastPayInfoResponse) {
        Intrinsics.checkNotNullParameter(fastPayInfoResponse, "data");
        IFastPayHeaderViewHolder iFastPayHeaderViewHolder = (IFastPayHeaderViewHolder) getViewHolder();
        if (iFastPayHeaderViewHolder != null) {
            iFastPayHeaderViewHolder.updateHeaderInfo(new FastPaySettingHeaderVB$setupView$1(this), "");
        }
    }
}
