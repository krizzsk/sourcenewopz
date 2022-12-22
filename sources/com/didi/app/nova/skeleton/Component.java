package com.didi.app.nova.skeleton;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.internal.ScopeContextComponentImpl;
import com.didi.app.nova.skeleton.tools.TraceUtil;

public abstract class Component implements ILive {

    /* renamed from: a */
    private volatile boolean f8251a = false;
    protected ViewGroup mContainer;
    protected ScopeContextBase mScopeContext;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    public Component(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    public final ViewGroup getContainer() {
        return this.mContainer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40450a() {
        if (!this.f8251a) {
            onAttach();
            this.f8251a = true;
            return;
        }
        throw new IllegalStateException("Component only allows initial once");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40452b() {
        this.mContainer.removeAllViews();
        this.f8251a = false;
        onDetach();
    }

    public final void attachScopeContext(ScopeContext scopeContext) {
        TraceUtil.trace("Component", this + " attachScopeContext ");
        this.mScopeContext = onCreateScopeContext(scopeContext);
    }

    /* access modifiers changed from: protected */
    public ScopeContextBase onCreateScopeContext(ScopeContext scopeContext) {
        return new ScopeContextComponentImpl(scopeContext, scopeContext != null ? scopeContext.alias() : "");
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        if (this.mScopeContext != null) {
            TraceUtil.trace(this.mScopeContext.alias() + "@Component", this + " onCreate ");
            this.mScopeContext.onCreate(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        if (this.mScopeContext != null) {
            TraceUtil.trace(this.mScopeContext.alias() + "@Component", this + " onStart");
            this.mScopeContext.onStart(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.mScopeContext != null) {
            TraceUtil.trace(this.mScopeContext.alias() + "@Component", this + " onResume ");
            this.mScopeContext.onResume(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.mScopeContext != null) {
            TraceUtil.trace(this.mScopeContext.alias() + "@Component", this + " onPause ");
            this.mScopeContext.onPause(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (this.mScopeContext != null) {
            TraceUtil.trace(this.mScopeContext.alias() + "@Component", this + " onStop ");
            this.mScopeContext.onStop(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.mScopeContext != null) {
            TraceUtil.trace(this.mScopeContext.alias() + "@Component", this + " onDestroy");
            this.mScopeContext.onDestroy(this);
        }
        Skeleton.watchDeletedObject(this);
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        ScopeContextBase scopeContextBase = this.mScopeContext;
        if (scopeContextBase != null) {
            scopeContextBase.detachAll();
        }
    }

    public boolean isActive() {
        ScopeContextBase scopeContextBase = this.mScopeContext;
        if (scopeContextBase != null) {
            return scopeContextBase.getLiveHandler().isActive();
        }
        return false;
    }

    public boolean isDestroyed() {
        ScopeContextBase scopeContextBase = this.mScopeContext;
        if (scopeContextBase != null) {
            return scopeContextBase.getLiveHandler().isDestroyed();
        }
        return true;
    }

    public final ScopeContext getScopeContext() {
        return this.mScopeContext;
    }
}
