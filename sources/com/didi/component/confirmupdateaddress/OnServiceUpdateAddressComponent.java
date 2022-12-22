package com.didi.component.confirmupdateaddress;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.confirmupdateaddress.presenter.OnServiceUpdateAddressPresenter;
import com.didi.component.confirmupdateaddress.view.IUpdateAddress;
import com.didi.component.confirmupdateaddress.view.OnServiceUpdateAddressView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "on_service_update_address")
public class OnServiceUpdateAddressComponent extends BaseComponent<IUpdateAddress, OnServiceUpdateAddressPresenter> {
    /* access modifiers changed from: protected */
    public IUpdateAddress onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new OnServiceUpdateAddressView(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public OnServiceUpdateAddressPresenter onCreatePresenter(ComponentParams componentParams) {
        return new OnServiceUpdateAddressPresenter(componentParams.bizCtx.getContext());
    }
}
