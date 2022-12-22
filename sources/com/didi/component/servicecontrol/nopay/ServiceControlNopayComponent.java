package com.didi.component.servicecontrol.nopay;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.servicecontrol.nopay.impl.presenter.ServiceControlNopayPresenter;
import com.didi.component.servicecontrol.nopay.impl.view.IServiceControlNopayView;
import com.didi.component.servicecontrol.nopay.impl.view.ServiceControlNopayView;

@ComponentRegister(product = "ride", type = "service_control_no_pay")
public class ServiceControlNopayComponent extends BaseComponent<IServiceControlNopayView, AbsServiceControlNopayPresenter> {
    /* access modifiers changed from: protected */
    public AbsServiceControlNopayPresenter onCreatePresenter(ComponentParams componentParams) {
        return new ServiceControlNopayPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IServiceControlNopayView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ServiceControlNopayView(componentParams.getActivity(), viewGroup);
    }
}
