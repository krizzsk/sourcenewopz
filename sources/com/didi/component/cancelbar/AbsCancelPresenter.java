package com.didi.component.cancelbar;

import com.didi.component.cancelbar.ICancelView;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsCancelPresenter<V extends ICancelView> extends AbsLoadingPresenter<V> {
    public abstract void onClickCancel();

    public AbsCancelPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
