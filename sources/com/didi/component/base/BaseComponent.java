package com.didi.component.base;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.config.IComponentEx;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;

public abstract class BaseComponent<V extends IView, P extends IPresenter> implements IComponentEx {
    private Bundle mExtendedBundle;
    private ComponentParams mParams;
    private P mPresenter;
    private V mView;

    /* access modifiers changed from: protected */
    @Deprecated
    public void bind(ComponentParams componentParams, V v, P p) {
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter(ComponentParams componentParams);

    /* access modifiers changed from: protected */
    public abstract V onCreateView(ComponentParams componentParams, ViewGroup viewGroup);

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        V v;
        assembleExtendedBundle(componentParams);
        this.mParams = componentParams;
        this.mView = onCreateView(componentParams, viewGroup);
        P onCreatePresenter = onCreatePresenter(componentParams);
        this.mPresenter = onCreatePresenter;
        if (!(onCreatePresenter == null || (v = this.mView) == null)) {
            onCreatePresenter.setIView(v);
            this.mView.setPresenter(this.mPresenter);
        }
        bind(componentParams, this.mView, this.mPresenter);
        if (XRay.m7426a()) {
            XRay.m7425a(this);
        }
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
            componentParams.bid = ((Integer) getExtra("BUNDLE_KEY_BID")).intValue();
            componentParams.comboType = ((Integer) getExtra("BUNDLE_KEY_COMBO_TYPE")).intValue();
        }
    }
}
