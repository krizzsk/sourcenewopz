package com.didi.component.rideoption;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.rideoption.newui.RideOptionNewUIView;

@ComponentRegister(product = "ride", type = "ride_option")
public class RideOptionComponent extends BaseComponent<IRideOptionView, AbsRideOptionPresenter> {
    /* access modifiers changed from: protected */
    public IRideOptionView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new RideOptionNewUIView(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsRideOptionPresenter onCreatePresenter(ComponentParams componentParams) {
        return new RideOptionPresenter(componentParams);
    }
}
