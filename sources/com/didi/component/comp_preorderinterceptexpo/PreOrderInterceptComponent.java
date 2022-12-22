package com.didi.component.comp_preorderinterceptexpo;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_preorderinterceptexpo.presenter.PreOrderInterceptPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;

@ComponentRegister(product = "ride", type = "pre_order_intercept_expo")
public class PreOrderInterceptComponent extends BaseComponent<IView, AbsPreOrderInterceptPresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsPreOrderInterceptPresenter onCreatePresenter(ComponentParams componentParams) {
        return new PreOrderInterceptPresenter(componentParams.bizCtx);
    }
}
