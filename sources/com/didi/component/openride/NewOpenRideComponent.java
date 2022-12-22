package com.didi.component.openride;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "new_open_ride")
public class NewOpenRideComponent extends BaseComponent<INewOpenRideView, AbsNewOpenRidePresenter> {
    /* access modifiers changed from: protected */
    public INewOpenRideView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new NewOpenRideView(componentParams.bizCtx.getContext(), (ViewGroup) null, componentParams.bizCtx);
    }

    /* access modifiers changed from: protected */
    public AbsNewOpenRidePresenter onCreatePresenter(ComponentParams componentParams) {
        return new NewOpenRidePresenter(componentParams);
    }
}
