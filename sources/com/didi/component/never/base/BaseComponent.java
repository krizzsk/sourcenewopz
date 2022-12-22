package com.didi.component.never.base;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.ComponentProxy;
import com.didi.component.never.core.IComponentEx;
import com.didi.component.never.core.IView;

public abstract class BaseComponent<V extends IView, P extends ComponentPresenter> implements IComponentEx {
    private Bundle mExtendedBundle;
    private ComponentParams mParams;
    private P mPresenter;
    private V mView;
    private ComponentProxy<V, P> proxy = null;

    /* access modifiers changed from: protected */
    @Deprecated
    public void bind(ComponentParams componentParams, V v, P p) {
    }

    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        return null;
    }

    public boolean needInflate(ComponentParams componentParams) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter(ComponentParams componentParams);

    /* access modifiers changed from: protected */
    public abstract V onCreateView(ComponentParams componentParams, ViewGroup viewGroup);

    public boolean recreateWhenNodeChange(ComponentParams componentParams) {
        return false;
    }

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        V v;
        assembleExtendedBundle(componentParams);
        this.mParams = componentParams;
        ComponentProxy<V, P> componentProxy = this.proxy;
        this.mView = componentProxy == null ? onCreateView(componentParams, viewGroup) : componentProxy.onCreateView(componentParams, viewGroup);
        ComponentProxy<V, P> componentProxy2 = this.proxy;
        P onCreatePresenter = componentProxy2 == null ? onCreatePresenter(componentParams) : componentProxy2.onCreatePresenter(componentParams);
        this.mPresenter = onCreatePresenter;
        if (!(onCreatePresenter == null || (v = this.mView) == null)) {
            onCreatePresenter.setIView(v);
            this.mView.setPresenter(this.mPresenter);
        }
        bind(componentParams, this.mView, this.mPresenter);
    }

    public void setComponentProxy(ComponentProxy componentProxy) {
        this.proxy = componentProxy;
    }

    public void setExtras(Bundle bundle) {
        this.mExtendedBundle = bundle;
    }

    public <T> T getExtra(String str) {
        Bundle bundle = this.mExtendedBundle;
        if (bundle == null) {
            return null;
        }
        return bundle.get(str);
    }

    public V getView() {
        return this.mView;
    }

    public P getPresenter() {
        return this.mPresenter;
    }

    public ComponentParams getParams() {
        return this.mParams;
    }

    private void assembleExtendedBundle(ComponentParams componentParams) {
        Bundle bundle;
        if (componentParams != null && (bundle = this.mExtendedBundle) != null && !bundle.isEmpty()) {
            componentParams.extras.putAll(this.mExtendedBundle);
        }
    }
}
