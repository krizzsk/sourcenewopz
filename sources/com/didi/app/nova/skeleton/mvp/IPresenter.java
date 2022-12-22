package com.didi.app.nova.skeleton.mvp;

import android.content.Context;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.soda.nova.skeleton.dsl.DslIPresenter;

public abstract class IPresenter<V extends IView> implements ILive, DslIPresenter {
    private V mLogicView;
    private ScopeContext mScopeContext;

    /* access modifiers changed from: protected */
    public void onCreate() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    /* access modifiers changed from: protected */
    public void onStop() {
    }

    /* access modifiers changed from: package-private */
    public final void attachView(V v) {
        this.mLogicView = v;
    }

    /* access modifiers changed from: package-private */
    public final void attachScopeContext(ScopeContext scopeContext) {
        this.mScopeContext = scopeContext;
    }

    public final V getLogicView() {
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

    /* access modifiers changed from: protected */
    public final void autoRelease(Cancelable cancelable) {
        getScopeContext().getLiveHandler().bind(cancelable);
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
