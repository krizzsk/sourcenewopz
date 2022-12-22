package com.didi.component.dispatchfee;

import android.view.View;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsDispatchFeePresenter extends BaseExpressPresenter<IDispatchFeeView> {
    public abstract void onClick(View view);

    public AbsDispatchFeePresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
