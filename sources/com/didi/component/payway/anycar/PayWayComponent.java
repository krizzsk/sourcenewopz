package com.didi.component.payway.anycar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.anycar.presenter.AbsPayWayPresenter;
import com.didi.component.payway.anycar.presenter.AnyCarPayWayPresenter;
import com.didi.component.payway.anycar.view.AnycarPayWayView;
import com.didi.component.payway.anycar.view.IAnycarPayWayView;

@ComponentRegister(product = "ride", type = "anycar_payway")
public class PayWayComponent extends BaseComponent<IAnycarPayWayView, AbsPayWayPresenter> {
    /* access modifiers changed from: protected */
    public IAnycarPayWayView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new AnycarPayWayView(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsPayWayPresenter onCreatePresenter(ComponentParams componentParams) {
        return new AnyCarPayWayPresenter(componentParams);
    }
}
