package com.didi.soda.customer.biz.activity;

import com.appsflyer.internal.referrer.Payload;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.SkeletonActivity;
import com.didi.app.nova.skeleton.internal.ScopeContextActivityImpl;
import com.didi.soda.customer.base.rxdux.SkeletonStore;
import com.didi.soda.jadux.Reducer;
import com.didi.soda.jadux.Store;

public abstract class RxduxActivity<StateT> extends SkeletonActivity {
    /* access modifiers changed from: protected */
    public abstract Reducer<StateT> createReducer();

    /* access modifiers changed from: protected */
    public abstract StateT initState();

    /* access modifiers changed from: protected */
    public ScopeContextBase onCreateScopeContext() {
        ScopeContextActivityImpl scopeContextActivityImpl = new ScopeContextActivityImpl(this);
        connect(scopeContextActivityImpl);
        m28655a();
        return scopeContextActivityImpl;
    }

    /* access modifiers changed from: protected */
    public void connect(ScopeContextBase scopeContextBase) {
        Store createStore = new Store().createStore(createReducer(), initState());
        scopeContextBase.attach(scopeContextBase.alias() + Payload.TYPE_STORE, createStore);
    }

    /* renamed from: a */
    private void m28655a() {
        SkeletonStore.createStore(getPageInstrument());
    }
}
