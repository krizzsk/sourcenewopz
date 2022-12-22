package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;
import com.didi.soda.customer.base.binder.CustomerMvpItemView;

public class CustomerMvpItemPresenter<V extends CustomerMvpItemView, T, L extends Repo> extends MvpItemPresenter<V, T> {

    /* renamed from: a */
    private ScopeContext f40343a;

    /* renamed from: b */
    private ComponentLogicUnit f40344b;

    /* renamed from: c */
    private Class<L> f40345c;

    public final L getItemLogic() {
        ComponentLogicUnit componentLogicUnit = this.f40344b;
        if (componentLogicUnit != null) {
            return componentLogicUnit.getLogic(this.f40345c);
        }
        throw new IllegalStateException("If you call getItemLogic in Binder, componentLogicUnit cannot be null!");
    }

    public final ScopeContext getScopeContext() {
        return this.f40343a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo101815a(ScopeContext scopeContext) {
        this.f40343a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo101816a(ComponentLogicUnit componentLogicUnit) {
        this.f40344b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo101817a(Class<L> cls) {
        this.f40345c = cls;
    }
}
