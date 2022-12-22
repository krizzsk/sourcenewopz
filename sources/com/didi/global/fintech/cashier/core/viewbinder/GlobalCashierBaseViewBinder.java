package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalBinderCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00050\u0007B\r\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0017\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0017\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u001fJ#\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010!R\u0013\u0010\b\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00018\u0002X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "VH", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "P", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "D", "", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;)V", "getPresenter", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "srcData", "getSrcData", "()Ljava/lang/Object;", "setSrcData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "viewHolder", "getViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "setViewHolder", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)V", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "defaultVisible", "", "setupView", "", "data", "validate", "(Ljava/lang/Object;)Z", "viewBind", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierBaseViewBinder.kt */
public abstract class GlobalCashierBaseViewBinder<VH extends IGlobalCashierBaseViewHolder, P extends IGlobalBinderCashierPresenter<D>, D> implements IGlobalCashierBaseViewBinder<VH, D> {

    /* renamed from: a */
    private final P f21525a;

    /* renamed from: b */
    private VH f21526b;

    /* renamed from: c */
    private D f21527c;

    public boolean defaultVisible() {
        return false;
    }

    public boolean validate(D d) {
        return d != null;
    }

    public GlobalCashierBaseViewBinder(P p) {
        Intrinsics.checkNotNullParameter(p, "presenter");
        this.f21525a = p;
    }

    public final P getPresenter() {
        return this.f21525a;
    }

    public final VH getViewHolder() {
        return this.f21526b;
    }

    public final void setViewHolder(VH vh) {
        this.f21526b = vh;
    }

    public final D getSrcData() {
        return this.f21527c;
    }

    public final void setSrcData(D d) {
        this.f21527c = d;
    }

    public IGlobalCashierBaseViewBinder<VH, D> viewBind(VH vh) {
        IGlobalCashierBaseViewBinder<VH, D> iGlobalCashierBaseViewBinder = this;
        this.f21525a.addViewBinder(iGlobalCashierBaseViewBinder);
        this.f21526b = vh;
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onViewBind: ", getClass()), (Throwable) null, "com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierBaseViewBinder", 24);
        if (vh != null) {
            vh.updateVisible(defaultVisible());
        }
        return iGlobalCashierBaseViewBinder;
    }

    public void setupView(D d) {
        this.f21527c = d;
        VH vh = this.f21526b;
        if (vh != null) {
            vh.updateVisible(validate(d));
        }
    }
}
