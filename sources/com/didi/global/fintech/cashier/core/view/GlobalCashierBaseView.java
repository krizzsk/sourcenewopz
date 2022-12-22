package com.didi.global.fintech.cashier.core.view;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IPresenter;
import com.didi.global.fintech.cashier.core.contract.IView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\r\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "T", "Lcom/didi/global/fintech/cashier/core/contract/IPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "()V", "mPresenter", "bindPresenter", "", "presenter", "getPresenter", "()Lcom/didi/global/fintech/cashier/core/contract/IPresenter;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierBaseView.kt */
public abstract class GlobalCashierBaseView<T extends IPresenter<? extends IView>> implements IGlobalCashierBaseView {

    /* renamed from: a */
    private IPresenter<? extends IView> f21498a;

    public void bindPresenter(IPresenter<? extends IView> iPresenter) {
        Intrinsics.checkNotNullParameter(iPresenter, "presenter");
        this.f21498a = iPresenter;
        if (iPresenter != null) {
            iPresenter.onBind();
        }
    }

    public final T getPresenter() {
        T t = this.f21498a;
        if (t instanceof IPresenter) {
            return t;
        }
        return null;
    }
}
