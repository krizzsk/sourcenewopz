package com.didi.component.never.core.container;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentProxy;
import com.didi.component.never.core.IComponentEx;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.container.ContainerPresenter;

public abstract class ContainerComponent<P extends ContainerPresenter> implements IComponentEx {

    /* renamed from: a */
    private P f14649a;

    /* renamed from: b */
    private ComponentParams f14650b;

    /* renamed from: c */
    private ComponentProxy<IView, P> f14651c = null;

    public <T> T getExtra(String str) {
        return null;
    }

    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        return null;
    }

    public IView getView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter(ComponentParams componentParams);

    public boolean recreateWhenNodeChange(ComponentParams componentParams) {
        return true;
    }

    public void setExtras(Bundle bundle) {
    }

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f14650b = componentParams;
        ComponentProxy<IView, P> componentProxy = this.f14651c;
        this.f14649a = componentProxy == null ? onCreatePresenter(componentParams) : (ContainerPresenter) componentProxy.onCreatePresenter(componentParams);
    }

    public void setComponentProxy(ComponentProxy componentProxy) {
        this.f14651c = componentProxy;
    }

    public P getPresenter() {
        return this.f14649a;
    }

    public ComponentParams getParams() {
        return this.f14650b;
    }
}
