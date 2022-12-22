package com.didi.component.messagebar;

import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;

public abstract class AbsMessageBarPresenter extends AbsLoadingPresenter<IView> {
    public AbsMessageBarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
