package com.didi.component.payment;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.payment.proxy.ViewProxy;

public abstract class AbsPayComponent extends BaseComponent<ViewProxy, IPresenter> {
    /* access modifiers changed from: protected */
    public ViewProxy onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ViewProxy(componentParams.bizCtx.getContext());
    }
}
