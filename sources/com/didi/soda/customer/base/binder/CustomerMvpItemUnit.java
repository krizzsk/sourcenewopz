package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemUnit;
import com.didi.soda.customer.base.binder.CustomerMvpItemPresenter;
import com.didi.soda.customer.base.binder.CustomerMvpItemView;

public abstract class CustomerMvpItemUnit<V extends CustomerMvpItemView<P, T, VH>, P extends CustomerMvpItemPresenter<V, T, L>, T, VH extends ItemViewHolder<T>, L extends Repo> extends MvpItemUnit<V, P, T, VH> {

    /* renamed from: a */
    private ScopeContext f40346a;

    /* renamed from: b */
    private ComponentLogicUnit f40347b;

    /* renamed from: c */
    private Class<L> f40348c;

    /* access modifiers changed from: protected */
    public void setupPresenter(CustomerMvpItemPresenter customerMvpItemPresenter) {
        customerMvpItemPresenter.mo101815a(this.f40346a);
        customerMvpItemPresenter.mo101816a(this.f40347b);
        customerMvpItemPresenter.mo101817a(this.f40348c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo101820a(ScopeContext scopeContext) {
        this.f40346a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo101821a(ComponentLogicUnit componentLogicUnit) {
        this.f40347b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo101822a(Class<L> cls) {
        this.f40348c = cls;
    }
}
