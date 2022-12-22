package com.didi.component.driverbar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.driverbar.impl.DriverBarV2LockScreenPresenter;
import com.didi.component.driverbar.impl.DriverBarV2V2LockScreenView;
import com.didi.component.driverbar.impl.DriverBarV2View;
import com.didi.component.driverbar.presenter.DriverBarV2Presenter;

@ComponentRegister(product = "ride", type = "driver_bar")
public class DriverBarComponent extends BaseComponent<IDriverBarView, AbsDriverBarPresenter> {
    /* access modifiers changed from: protected */
    public IDriverBarView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (componentParams.pageID == 1045) {
            return new DriverBarV2V2LockScreenView(componentParams.getActivity(), viewGroup);
        }
        return new DriverBarV2View(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsDriverBarPresenter onCreatePresenter(ComponentParams componentParams) {
        return createDriverBarPresenter(componentParams);
    }

    private AbsDriverBarPresenter createDriverBarPresenter(ComponentParams componentParams) {
        if (componentParams.pageID != 1045) {
            return new DriverBarV2Presenter(componentParams);
        }
        return new DriverBarV2LockScreenPresenter(componentParams);
    }
}
