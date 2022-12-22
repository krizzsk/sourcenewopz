package com.didi.component.confirmupdateaddress;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.confirmupdateaddress.presenter.ConfirmUpdateAddressPresenter;
import com.didi.component.confirmupdateaddress.view.ConfirmUpdateAddressView;
import com.didi.component.confirmupdateaddress.view.IConfirmUpdateAddress;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "confirm_update_address")
public class ConfirmUpdateAddressComponent extends BaseComponent<IConfirmUpdateAddress, ConfirmUpdateAddressPresenter> {
    /* access modifiers changed from: protected */
    public IConfirmUpdateAddress onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ConfirmUpdateAddressView(componentParams.bizCtx, viewGroup);
    }

    /* access modifiers changed from: protected */
    public ConfirmUpdateAddressPresenter onCreatePresenter(ComponentParams componentParams) {
        return new ConfirmUpdateAddressPresenter(componentParams);
    }
}
