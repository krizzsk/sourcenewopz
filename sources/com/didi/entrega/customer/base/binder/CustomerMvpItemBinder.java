package com.didi.entrega.customer.base.binder;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.RvLifecycleObservable;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.RvLifecycleObserver;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.entrega.customer.app.ComponentLogicProvider;
import com.didi.entrega.customer.app.ScopeContextProvider;
import com.didi.entrega.customer.base.binder.CustomerMvpItemUnit;

public abstract class CustomerMvpItemBinder<T, VH extends ItemViewHolder<T>, U extends CustomerMvpItemUnit, L extends Repo> extends MvpItemBinder<T, VH, U> implements ComponentLogicProvider, ScopeContextProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RvLifecycleObserver f19799a;

    public abstract Class<L> bindItemLogicType();

    public CustomerMvpItemBinder() {
        m14671a();
    }

    public CustomerMvpItemBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    /* access modifiers changed from: protected */
    public void setupItemUnit(U u) {
        u.mo59658a(provideScopeContext());
        u.mo59659a(provideComponentLogicUnit());
        u.mo59660a(bindItemLogicType());
    }

    /* access modifiers changed from: protected */
    public RvLifecycleObservable onCreateRvContainerLifecycle() {
        return new RvLifecycleObservable() {
            public void subscribe(RvLifecycleObserver rvLifecycleObserver) {
                RvLifecycleObserver unused = CustomerMvpItemBinder.this.f19799a = rvLifecycleObserver;
            }
        };
    }

    /* renamed from: a */
    private void m14671a() {
        provideScopeContext().addObserver(new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onPause(ILive iLive) {
            }

            public void onResume(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
                if (CustomerMvpItemBinder.this.f19799a != null) {
                    CustomerMvpItemBinder.this.f19799a.onDestroy();
                }
                RvLifecycleObserver unused = CustomerMvpItemBinder.this.f19799a = null;
            }

            public void onStart(ILive iLive) {
                if (CustomerMvpItemBinder.this.f19799a != null) {
                    CustomerMvpItemBinder.this.f19799a.onAttach();
                }
            }

            public void onStop(ILive iLive) {
                if (CustomerMvpItemBinder.this.f19799a != null) {
                    CustomerMvpItemBinder.this.f19799a.onDetach();
                }
            }
        });
    }
}
