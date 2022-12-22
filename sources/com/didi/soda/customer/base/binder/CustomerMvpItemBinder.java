package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.RvLifecycleObservable;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.RvLifecycleObserver;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.ComponentLogicProvider;
import com.didi.soda.customer.app.ScopeContextProvider;
import com.didi.soda.customer.base.binder.CustomerMvpItemUnit;

public abstract class CustomerMvpItemBinder<T, VH extends ItemViewHolder<T>, U extends CustomerMvpItemUnit, L extends Repo> extends MvpItemBinder<T, VH, U> implements ComponentLogicProvider, ScopeContextProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RvLifecycleObserver f40342a;

    public abstract Class<L> bindItemLogicType();

    public CustomerMvpItemBinder() {
        m28595a();
    }

    public CustomerMvpItemBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    /* access modifiers changed from: protected */
    public void setupItemUnit(U u) {
        u.mo101820a(provideScopeContext());
        u.mo101821a(provideComponentLogicUnit());
        u.mo101822a(bindItemLogicType());
    }

    /* access modifiers changed from: protected */
    public RvLifecycleObservable onCreateRvContainerLifecycle() {
        return new RvLifecycleObservable() {
            public void subscribe(RvLifecycleObserver rvLifecycleObserver) {
                RvLifecycleObserver unused = CustomerMvpItemBinder.this.f40342a = rvLifecycleObserver;
            }
        };
    }

    /* renamed from: a */
    private void m28595a() {
        provideScopeContext().addObserver(new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onPause(ILive iLive) {
            }

            public void onResume(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
                if (CustomerMvpItemBinder.this.f40342a != null) {
                    CustomerMvpItemBinder.this.f40342a.onDestroy();
                }
                RvLifecycleObserver unused = CustomerMvpItemBinder.this.f40342a = null;
            }

            public void onStart(ILive iLive) {
                if (CustomerMvpItemBinder.this.f40342a != null) {
                    CustomerMvpItemBinder.this.f40342a.onAttach();
                }
            }

            public void onStop(ILive iLive) {
                if (CustomerMvpItemBinder.this.f40342a != null) {
                    CustomerMvpItemBinder.this.f40342a.onDetach();
                }
            }
        });
    }
}
