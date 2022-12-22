package com.didi.entrega.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemUnit;
import com.didi.entrega.customer.base.binder.CustomerMvpItemPresenter;
import com.didi.entrega.customer.base.binder.CustomerMvpItemView;

public abstract class CustomerMvpItemUnit<V extends CustomerMvpItemView<P, T, VH>, P extends CustomerMvpItemPresenter<V, T, L>, T, VH extends ItemViewHolder<T>, L extends Repo> extends MvpItemUnit<V, P, T, VH> {

    /* renamed from: a */
    private ScopeContext f19803a;

    /* renamed from: b */
    private ComponentLogicUnit f19804b;

    /* renamed from: c */
    private Class<L> f19805c;

    /* access modifiers changed from: protected */
    public void setupPresenter(CustomerMvpItemPresenter customerMvpItemPresenter) {
        customerMvpItemPresenter.mo59653a(this.f19803a);
        customerMvpItemPresenter.mo59654a(this.f19804b);
        customerMvpItemPresenter.mo59655a(this.f19805c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo59658a(ScopeContext scopeContext) {
        this.f19803a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo59659a(ComponentLogicUnit componentLogicUnit) {
        this.f19804b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo59660a(Class<L> cls) {
        this.f19805c = cls;
    }
}
