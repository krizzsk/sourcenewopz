package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBasePresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBasePresenter;", "()V", "mView", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "getMView", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "setMView", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;)V", "IView", "bindView", "", "view", "unBind", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierBasePresenter.kt */
public abstract class GlobalCashierBasePresenter implements IGlobalCashierBasePresenter {

    /* renamed from: a */
    private IGlobalCashierBaseView f21438a;

    /* access modifiers changed from: protected */
    public final IGlobalCashierBaseView getMView() {
        return this.f21438a;
    }

    /* access modifiers changed from: protected */
    public final void setMView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        this.f21438a = iGlobalCashierBaseView;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        this.f21438a = iGlobalCashierBaseView;
        if (iGlobalCashierBaseView != null) {
            iGlobalCashierBaseView.bindPresenter(this);
        }
        SystemUtils.log(4, "Arirus", "GlobalCashierBasePresenter bindView: ", (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierBasePresenter", 15);
    }

    public IGlobalCashierBaseView IView() {
        return this.f21438a;
    }

    public void unBind() {
        this.f21438a = null;
    }
}
