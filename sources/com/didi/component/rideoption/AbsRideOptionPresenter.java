package com.didi.component.rideoption;

import android.view.View;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsRideOptionPresenter extends BaseExpressPresenter<IRideOptionView> {
    public abstract void onClickable(View view);

    public AbsRideOptionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
