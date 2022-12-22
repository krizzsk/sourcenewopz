package com.didi.component.expectation;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.expectation.impl.ExpectationPresenter;
import com.didi.component.expectation.view.ExpectationView2;

@ComponentRegister(product = "ride", type = "xpcard_progressManagement_card")
public class ExpectationComponent extends BaseComponent<IExpectationView, AbsExpectationPresenter<IExpectationView>> {
    /* access modifiers changed from: protected */
    public IExpectationView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ExpectationView2(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsExpectationPresenter<IExpectationView> onCreatePresenter(ComponentParams componentParams) {
        return new ExpectationPresenter(componentParams);
    }
}
