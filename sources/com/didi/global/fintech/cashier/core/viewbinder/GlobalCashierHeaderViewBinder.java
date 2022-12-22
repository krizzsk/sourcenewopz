package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalBinderCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierHeaderViewBinder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierHeaderViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0012\u0004\u0012\u0002H\u00030\u0007B\r\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0017\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierHeaderViewBinder;", "P", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "D", "", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierHeaderViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;)V", "defaultVisible", "", "onBackClick", "", "setupView", "data", "(Ljava/lang/Object;)V", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierHeaderViewBinder.kt */
public final class GlobalCashierHeaderViewBinder<P extends IGlobalBinderCashierPresenter<D>, D> extends GlobalCashierBaseViewBinder<IGlobalCashierHeaderViewHolder, P, D> implements IGlobalCashierHeaderViewBinder<D> {
    public boolean defaultVisible() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierHeaderViewBinder(P p) {
        super(p);
        Intrinsics.checkNotNullParameter(p, "presenter");
    }

    public void onBackClick() {
        getPresenter().onBackPressed("header");
    }

    public void setupView(D d) {
        super.setupView(d);
        IGlobalCashierHeaderViewHolder iGlobalCashierHeaderViewHolder = (IGlobalCashierHeaderViewHolder) getViewHolder();
        if (iGlobalCashierHeaderViewHolder != null) {
            iGlobalCashierHeaderViewHolder.updateHeaderInfo(new GlobalCashierHeaderViewBinder$setupView$1(this));
        }
    }
}
