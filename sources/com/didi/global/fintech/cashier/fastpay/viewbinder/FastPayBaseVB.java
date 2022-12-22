package com.didi.global.fintech.cashier.fastpay.viewbinder;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBasePresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBaseViewBinder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003*\b\b\u0002\u0010\u0004*\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00018\u0002X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/viewbinder/FastPayBaseVB;", "D", "P", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "V", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getPresenter", "()Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "viewHolder", "getViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "setViewHolder", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)V", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "setupView", "", "validate", "", "(Ljava/lang/Object;)Z", "viewBind", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayBaseVB.kt */
public abstract class FastPayBaseVB<D, P extends IFastPayBasePresenter<D>, V extends IGlobalCashierBaseViewHolder> implements IFastPayBaseViewBinder<D, V> {

    /* renamed from: a */
    private final P f21607a;

    /* renamed from: b */
    private V f21608b;

    /* renamed from: c */
    private D f21609c;

    public boolean validate(D d) {
        return true;
    }

    public FastPayBaseVB(P p) {
        Intrinsics.checkNotNullParameter(p, "presenter");
        this.f21607a = p;
    }

    public final P getPresenter() {
        return this.f21607a;
    }

    public final V getViewHolder() {
        return this.f21608b;
    }

    public final void setViewHolder(V v) {
        this.f21608b = v;
    }

    public final D getData() {
        return this.f21609c;
    }

    public final void setData(D d) {
        this.f21609c = d;
    }

    public IFastPayBaseViewBinder<D, V> viewBind(V v) {
        IFastPayBaseViewBinder<D, V> iFastPayBaseViewBinder = this;
        this.f21607a.addViewBinder(iFastPayBaseViewBinder);
        this.f21608b = v;
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onViewBind: ", getClass()), (Throwable) null, "com.didi.global.fintech.cashier.fastpay.viewbinder.FastPayBaseVB", 22);
        return iFastPayBaseViewBinder;
    }

    public void setupView(D d) {
        this.f21609c = d;
        V v = this.f21608b;
        if (v != null) {
            v.updateVisible(validate(d));
        }
    }
}
