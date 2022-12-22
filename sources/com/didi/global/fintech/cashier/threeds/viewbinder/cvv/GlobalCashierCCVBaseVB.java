package com.didi.global.fintech.cashier.threeds.viewbinder.cvv;

import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCCVBaseVB;", "T", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "presenter", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "(Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;)V", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "getData", "()Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "setData", "(Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;)V", "getPresenter", "()Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "viewHolder", "getViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "setViewHolder", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)V", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "setupView", "", "validate", "", "viewBind", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCCVBaseVB.kt */
public abstract class GlobalCashierCCVBaseVB<T extends IGlobalCashierBaseViewHolder> implements IGlobalCashierCVVBaseViewBinder<T> {

    /* renamed from: a */
    private final IGlobalCashierCVVPresenter f21697a;

    /* renamed from: b */
    private CVVInfoResponse f21698b;

    /* renamed from: c */
    private T f21699c;

    public boolean validate() {
        return true;
    }

    public GlobalCashierCCVBaseVB(IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter) {
        Intrinsics.checkNotNullParameter(iGlobalCashierCVVPresenter, "presenter");
        this.f21697a = iGlobalCashierCVVPresenter;
    }

    public final IGlobalCashierCVVPresenter getPresenter() {
        return this.f21697a;
    }

    public final CVVInfoResponse getData() {
        return this.f21698b;
    }

    public final void setData(CVVInfoResponse cVVInfoResponse) {
        this.f21698b = cVVInfoResponse;
    }

    public final T getViewHolder() {
        return this.f21699c;
    }

    public final void setViewHolder(T t) {
        this.f21699c = t;
    }

    public IGlobalCashierCVVBaseViewBinder<T> viewBind(T t) {
        IGlobalCashierCVVBaseViewBinder<T> iGlobalCashierCVVBaseViewBinder = this;
        this.f21697a.addViewBinder(iGlobalCashierCVVBaseViewBinder);
        this.f21699c = t;
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onViewBind: ", getClass()), (Throwable) null, "com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCCVBaseVB", 22);
        return iGlobalCashierCVVBaseViewBinder;
    }

    public void setupView(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "data");
        this.f21698b = cVVInfoResponse;
        T t = this.f21699c;
        if (t != null) {
            t.updateVisible(validate());
        }
    }
}
