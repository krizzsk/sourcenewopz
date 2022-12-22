package com.didi.global.fintech.cashier.fastpay.viewbinder.order;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderHeaderViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderPresenter;
import com.didi.global.fintech.cashier.fastpay.viewbinder.FastPayBaseVB;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.p117ui.IFastPayHeaderViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/viewbinder/order/FastPayOrderHeaderVB;", "Lcom/didi/global/fintech/cashier/fastpay/viewbinder/FastPayBaseVB;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;", "Lcom/didi/global/fintech/cashier/ui/IFastPayHeaderViewHolder;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderHeaderViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;)V", "onBackClick", "", "setupView", "data", "updateHeader", "content", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderHeaderVB.kt */
public final class FastPayOrderHeaderVB extends FastPayBaseVB<FastPayOrderResponse, IFastPayOrderPresenter, IFastPayHeaderViewHolder> implements IFastPayOrderHeaderViewBinder<FastPayOrderResponse> {
    public void setupView(FastPayOrderResponse fastPayOrderResponse) {
        Intrinsics.checkNotNullParameter(fastPayOrderResponse, "data");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayOrderHeaderVB(IFastPayOrderPresenter iFastPayOrderPresenter) {
        super(iFastPayOrderPresenter);
        Intrinsics.checkNotNullParameter(iFastPayOrderPresenter, "presenter");
    }

    public void onBackClick() {
        ((IFastPayOrderPresenter) getPresenter()).onBackPressed();
    }

    public void updateHeader(String str) {
        IFastPayHeaderViewHolder iFastPayHeaderViewHolder = (IFastPayHeaderViewHolder) getViewHolder();
        if (iFastPayHeaderViewHolder != null) {
            iFastPayHeaderViewHolder.updateHeaderInfo(new FastPayOrderHeaderVB$updateHeader$1(this), str);
        }
    }
}
