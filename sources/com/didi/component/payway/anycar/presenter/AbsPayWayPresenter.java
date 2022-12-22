package com.didi.component.payway.anycar.presenter;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.anycar.view.IAnycarPayWayView;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;

public abstract class AbsPayWayPresenter extends BaseExpressPresenter<IAnycarPayWayView> {
    public abstract void onFormPayWayClicked();

    public abstract void onNewPayWayGuideClicked(BubbleItemModel bubbleItemModel);

    public abstract void onPayWayCloseClicked(int i, int i2);

    public abstract void onPayWayGuideClicked(int i, int i2);

    public AbsPayWayPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
