package com.didi.component.floatbar;

import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.floatbar.IFloatBarContainerView;

public abstract class AbsFloatBarPresenter<V extends IFloatBarContainerView> extends AbsLoadingPresenter<V> {
    public abstract void onFloatBarClicked();

    public AbsFloatBarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
