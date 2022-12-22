package com.didi.component.payentrance;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.core.ComponentParams;
import com.didi.component.payentrance.presenter.AbsPayEntrancePresenter;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.component.payentrance.view.impl.PayEntranceView;

public abstract class AbsPayEntranceComponent extends BaseComponent<IPayEntranceViewContainer, AbsPayEntrancePresenter> {
    /* access modifiers changed from: protected */
    public void bind(ComponentParams componentParams, IPayEntranceViewContainer iPayEntranceViewContainer, AbsPayEntrancePresenter absPayEntrancePresenter) {
        iPayEntranceViewContainer.setOnPayListener(absPayEntrancePresenter);
        iPayEntranceViewContainer.setOnJumpableClickListener(absPayEntrancePresenter);
        iPayEntranceViewContainer.setOnErrorListener(absPayEntrancePresenter);
        iPayEntranceViewContainer.setOnCancelRuleClickListener(absPayEntrancePresenter);
    }

    /* access modifiers changed from: protected */
    public IPayEntranceViewContainer onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new PayEntranceView(componentParams.bizCtx.getContext());
    }
}
