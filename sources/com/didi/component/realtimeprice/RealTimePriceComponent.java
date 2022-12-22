package com.didi.component.realtimeprice;

import android.view.ViewGroup;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.realtimeprice.impl.RealTimePricePresenter;
import com.didi.component.realtimeprice.impl.RealTimePriceViewV2;

@ComponentRegister(product = "ride", type = "real_time_price")
public class RealTimePriceComponent extends SelfControlComponent<IRealTimePriceView, AbsRealTimePricePresenter, RealTimePriceInflateController> {
    /* access modifiers changed from: protected */
    public IRealTimePriceView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new RealTimePriceViewV2(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsRealTimePricePresenter onCreatePresenter(ComponentParams componentParams) {
        return new RealTimePricePresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public void bind(ComponentParams componentParams, IRealTimePriceView iRealTimePriceView, AbsRealTimePricePresenter absRealTimePricePresenter) {
        super.bind(componentParams, iRealTimePriceView, absRealTimePricePresenter);
        iRealTimePriceView.setOnActionListener(absRealTimePricePresenter);
    }

    /* access modifiers changed from: protected */
    public RealTimePriceInflateController createInflateController() {
        return new RealTimePriceInflateController();
    }
}
