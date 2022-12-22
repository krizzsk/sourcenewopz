package com.didi.global.fintech.cashier.fastpay.viewbinder.order;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderPresenter;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ShowInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderContentVB.kt */
final class FastPayOrderContentVB$setupView$12 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FastPayOrderResponse $data;
    final /* synthetic */ FastPayOrderContentVB this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPayOrderContentVB$setupView$12(FastPayOrderContentVB fastPayOrderContentVB, FastPayOrderResponse fastPayOrderResponse) {
        super(0);
        this.this$0 = fastPayOrderContentVB;
        this.$data = fastPayOrderResponse;
    }

    public final void invoke() {
        String last_one_toast;
        IFastPayOrderPresenter iFastPayOrderPresenter = (IFastPayOrderPresenter) this.this$0.getPresenter();
        ShowInfo showInfo = this.$data.getShowInfo();
        String str = "";
        if (!(showInfo == null || (last_one_toast = showInfo.getLast_one_toast()) == null)) {
            str = last_one_toast;
        }
        iFastPayOrderPresenter.showLastMethodToast(str);
    }
}
