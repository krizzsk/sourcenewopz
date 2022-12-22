package com.didi.component.estimatepass;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "estimate_pass")
public class EstimatePassComponent extends BaseComponent<IEstimatePassView, EstimatePassPresenter> {
    /* access modifiers changed from: protected */
    public IEstimatePassView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EstimateView(componentParams.bizCtx, viewGroup);
    }

    /* access modifiers changed from: protected */
    public EstimatePassPresenter onCreatePresenter(ComponentParams componentParams) {
        return new EstimatePassPresenter(componentParams);
    }
}
