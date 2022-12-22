package com.didi.component.floatbar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.floatbar.impl.FloatBarContainerView;
import com.didi.component.floatbar.impl.FloatBarPresenter;

@ComponentRegister(product = "ride", type = "float_bar")
public class FloatBarComponent extends BaseComponent<IFloatBarContainerView, AbsFloatBarPresenter> {
    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        super.init(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsFloatBarPresenter onCreatePresenter(ComponentParams componentParams) {
        return new FloatBarPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IFloatBarContainerView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new FloatBarContainerView(componentParams.bizCtx.getContext(), viewGroup);
    }
}
