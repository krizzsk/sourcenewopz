package com.didi.entrega.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;
import com.didi.entrega.customer.base.binder.CustomerMvpItemView;

public class CustomerMvpItemPresenter<V extends CustomerMvpItemView, T, L extends Repo> extends MvpItemPresenter<V, T> {

    /* renamed from: a */
    private ScopeContext f19800a;

    /* renamed from: b */
    private ComponentLogicUnit f19801b;

    /* renamed from: c */
    private Class<L> f19802c;

    public final L getItemLogic() {
        ComponentLogicUnit componentLogicUnit = this.f19801b;
        if (componentLogicUnit != null) {
            return componentLogicUnit.getLogic(this.f19802c);
        }
        throw new IllegalStateException("If you call getItemLogic in Binder, componentLogicUnit cannot be null!");
    }

    public final ScopeContext getScopeContext() {
        return this.f19800a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo59653a(ScopeContext scopeContext) {
        this.f19800a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo59654a(ComponentLogicUnit componentLogicUnit) {
        this.f19801b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo59655a(Class<L> cls) {
        this.f19802c = cls;
    }
}
