package com.didi.soda.customer.base.lazycomponent;

import android.content.Context;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.lazycomponent.ILazyView;
import com.didi.soda.customer.base.lazycomponent.LazyComponent;

public abstract class ILazyPresenter<V extends ILazyView> implements ILive {
    private static final String TAG = "ILazyPresent";
    private LazyComponent.InitializedCallback mInitCallback;
    private V mLogicView;
    private ScopeContext mScopeContext;

    /* access modifiers changed from: package-private */
    public void setInitCallback(LazyComponent.InitializedCallback initializedCallback) {
        this.mInitCallback = initializedCallback;
    }

    /* access modifiers changed from: package-private */
    public void initialized() {
        LazyComponent.InitializedCallback initializedCallback = this.mInitCallback;
        if (initializedCallback != null) {
            initializedCallback.onInitialized();
        }
    }

    /* access modifiers changed from: package-private */
    public void attachView(V v) {
        this.mLogicView = v;
    }

    private void attachScopeContext(ScopeContext scopeContext) {
        this.mScopeContext = scopeContext;
    }

    public final V getLogicView() {
        if (!this.mLogicView.isInitialized()) {
            this.mLogicView.load();
        }
        return this.mLogicView;
    }

    public final ScopeContext getScopeContext() {
        return this.mScopeContext;
    }

    public final Context getContext() {
        V v = this.mLogicView;
        if (v != null) {
            return v.getContext();
        }
        throw new IllegalStateException("View not attach to this view of " + getClass().getName());
    }

    /* access modifiers changed from: package-private */
    public void innerAttach(ScopeContext scopeContext) {
        attachScopeContext(scopeContext);
        onAttach();
    }

    /* access modifiers changed from: package-private */
    public void innerDetach() {
        onDetach();
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onAttach");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onCreate");
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onResume");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onPause");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onStop");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onDetach");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onDestroy");
        }
    }

    public boolean isActive() {
        ScopeContext scopeContext = this.mScopeContext;
        if (scopeContext != null) {
            return scopeContext.getLiveHandler().isActive();
        }
        return false;
    }

    public boolean isDestroyed() {
        ScopeContext scopeContext = this.mScopeContext;
        if (scopeContext != null) {
            return scopeContext.getLiveHandler().isDestroyed();
        }
        return true;
    }
}
