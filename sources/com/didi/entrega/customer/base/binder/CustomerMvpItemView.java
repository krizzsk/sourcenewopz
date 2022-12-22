package com.didi.entrega.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemView;
import com.didi.entrega.customer.base.binder.CustomerMvpItemPresenter;

public abstract class CustomerMvpItemView<P extends CustomerMvpItemPresenter, T, VH extends ItemViewHolder<T>> extends MvpItemView<P, VH> {
    /* access modifiers changed from: protected */
    public final ScopeContext getScopeContext() {
        if (getItemPresenter() != null) {
            return ((CustomerMvpItemPresenter) getItemPresenter()).getScopeContext();
        }
        throw new IllegalStateException("Presenter not callAttach to this view of " + getClass().getName());
    }
}
