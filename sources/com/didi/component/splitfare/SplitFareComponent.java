package com.didi.component.splitfare;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.splitfare.presenter.AbsSplitFarePresenter;
import com.didi.component.splitfare.presenter.impl.SplitFareHomePresenter;
import com.didi.component.splitfare.presenter.impl.SplitFareOnServicePresenter;
import com.didi.component.splitfare.view.ISplitFareView;
import com.didi.component.splitfare.view.impl.onservice.SplitFareOnServiceView;

@ComponentRegister(product = "ride", type = "split_fare")
public class SplitFareComponent extends BaseComponent<ISplitFareView, AbsSplitFarePresenter> {
    /* access modifiers changed from: protected */
    public ISplitFareView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (componentParams.pageID == 1010 || componentParams.pageID == 1015 || componentParams.pageID == 1040) {
            return new SplitFareOnServiceView(viewGroup);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsSplitFarePresenter onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.pageID == 1001) {
            return new SplitFareHomePresenter(componentParams);
        }
        return new SplitFareOnServicePresenter(componentParams);
    }
}
