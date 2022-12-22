package com.didi.component.payentrance;

import android.view.ViewGroup;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.payentrance.presenter.AbsPayEntrancePresenter;
import com.didi.component.payentrance.presenter.impl.GlobalPayEntrancePresenter;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;

@ComponentRegister(product = "ride", type = "pay_entrance")
public class PayEntranceComponent extends AbsPayEntranceComponent {
    private static final String UNIFIED_PAY_KEY = "unified_cashier_travel_scene";

    /* access modifiers changed from: protected */
    public AbsPayEntrancePresenter onCreatePresenter(ComponentParams componentParams) {
        return new GlobalPayEntrancePresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IPayEntranceViewContainer onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return super.onCreateView(componentParams, viewGroup);
    }
}
