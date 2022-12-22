package com.didi.component.dispatchfee;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.dispatchfee.impl.DispatchFeePresenter;
import com.didi.component.dispatchfee.impl.DispatchFeeView;

@ComponentRegister(product = "ride", type = "dispatch_fee")
public class DispatchFeeComponent extends BaseComponent<IDispatchFeeView, AbsDispatchFeePresenter> {
    /* access modifiers changed from: protected */
    public IDispatchFeeView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new DispatchFeeView(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsDispatchFeePresenter onCreatePresenter(ComponentParams componentParams) {
        return new DispatchFeePresenter(componentParams);
    }
}
