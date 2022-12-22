package com.didi.component.bubbleLayout;

import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IViewContainer;

public abstract class AbsBubbleLayoutPresenter extends AbsLoadingPresenter<IBubbleLayoutView> {
    public abstract void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator);

    public AbsBubbleLayoutPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
